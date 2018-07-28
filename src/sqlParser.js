
//***************************************************************************************
// This handles parsing SQL and creating action objects that will be executed on the database.
//***************************************************************************************

const antlr4 = require("../node_modules/antlr4/index.js")
const bb1dbSqlLexer = require("../sqlParser/outJs/bb1dbSqlLexer.js")
const bb1dbSqlParser = require("../sqlParser/outJs/bb1dbSqlParser.js")
const bb1dbSqlListener = require("../sqlParser/outJs/bb1dbSqlListener.js")
const sqlStatement = require("./sqlStatement.js")

var stmt = {}

var parseError = false

var inSelectColumns = false
var inSelectFrom = false
var inSelectJoin = false

var SqlStatementCreator = function() {
    bb1dbSqlListener.bb1dbSqlListener.call(this)
    return this
}
SqlStatementCreator.prototype = Object.create(bb1dbSqlListener.bb1dbSqlListener.prototype)
SqlStatementCreator.prototype.constructor = SqlStatementCreator
SqlStatementCreator.prototype.enterProg = function(ctx) {
    stmt = sqlStatement.newStatement()
}
SqlStatementCreator.prototype.exitProg = function(ctx) {
}
SqlStatementCreator.prototype.enterCTab = function(ctx) {
    stmt.createTable(ctx.AUTO_KW() != undefined)
}
SqlStatementCreator.prototype.exitCTab = function(ctx) {
}
SqlStatementCreator.prototype.enterDTab = function(ctx) {
    stmt.dropTable()
}
SqlStatementCreator.prototype.exitDTab = function(ctx) {
}
SqlStatementCreator.prototype.enterATab = function(ctx) {
    stmt.alterTable()
}
SqlStatementCreator.prototype.exitATab = function(ctx) {
}
SqlStatementCreator.prototype.enterATabColumn = function(ctx) {
    stmt.alterTableIsAddColumn(ctx.ADD_KW() != undefined)
}
SqlStatementCreator.prototype.exitATabColumn = function(ctx) {
}
SqlStatementCreator.prototype.enterInsert = function(ctx) {
    stmt.insert()
}
SqlStatementCreator.prototype.exitInsert = function(ctx) {
}
SqlStatementCreator.prototype.enterInsertCols = function(ctx) {
}
SqlStatementCreator.prototype.exitInsertCols = function(ctx) {
}
SqlStatementCreator.prototype.enterInsertVals = function(ctx) {
}
SqlStatementCreator.prototype.exitInsertVals = function(ctx) {
}
SqlStatementCreator.prototype.enterSelect = function(ctx) {
    stmt.select()
}
SqlStatementCreator.prototype.exitSelect = function(ctx) {
}
SqlStatementCreator.prototype.enterSelectColumns = function(ctx) {
    inSelectColumns = true
}
SqlStatementCreator.prototype.exitSelectColumns = function(ctx) {
    inSelectColumns = false
}
SqlStatementCreator.prototype.enterSelectFrom = function(ctx) {
    inSelectFrom = true
}
SqlStatementCreator.prototype.exitSelectFrom = function(ctx) {
    inSelectFrom = false
}
SqlStatementCreator.prototype.enterSelectJoin = function(ctx) {
    inSelectJoin = true
}
SqlStatementCreator.prototype.exitSelectJoin = function(ctx) {
    inSelectJoin = false
}
SqlStatementCreator.prototype.enterSelectWhere = function(ctx) {
}
SqlStatementCreator.prototype.exitSelectWhere = function(ctx) {
}
SqlStatementCreator.prototype.enterCondition = function(ctx) {
}
SqlStatementCreator.prototype.exitCondition = function(ctx) {
}
SqlStatementCreator.prototype.enterTableName = function(ctx) {
    if(inSelectFrom && !inSelectJoin) {
        stmt.setSelectFromTableName(ctx.IDENTIFIER().getText())
    } else if (inSelectJoin) {
    } else {
        stmt.setTableName(ctx.IDENTIFIER().getText())
    }
}
SqlStatementCreator.prototype.exitTableName = function(ctx) {
}
SqlStatementCreator.prototype.enterColumnName = function(ctx) {
    stmt.addColumn(ctx.IDENTIFIER().getText())
}
SqlStatementCreator.prototype.exitColumnName = function(ctx) {
}
SqlStatementCreator.prototype.enterValue = function(ctx) {
    if(ctx.NUMBER()) {
        stmt.addValue(Number(ctx.NUMBER().getText()))
    } else {
        stmt.addValue(
            ctx.STRING().getText().replace(new RegExp("^'"), "").replace(new RegExp("'$"), "").replace("''", "'")
        )
    }
}
SqlStatementCreator.prototype.exitValue = function(ctx) {
}
SqlStatementCreator.prototype.enterSelectColumnName = function(ctx) {
    var selectColumn = []
    selectColumn.push(ctx.IDENTIFIER(0).getText())
    if(ctx.IDENTIFIER().length > 1) {
        selectColumn.push(ctx.IDENTIFIER(1).getText())
    }
    if(inSelectColumns) {
        stmt.addSelectColumn(selectColumn)
    }
}
SqlStatementCreator.prototype.exitSelectColumnName = function(ctx) {
}


var ErrorListener = function(errors) {
    antlr4.error.ErrorListener.call(this)
    this.errors = errors
    return this
} 
ErrorListener.prototype = Object.create(antlr4.error.ErrorListener.prototype)
ErrorListener.prototype.constructor = ErrorListener
ErrorListener.prototype.syntaxError = function(rec, sym, line, col, msg, e) {
    parseError = true
}

/**
 * Parse the given sql and put the resulting statement object in stmt.
 * Will return true if the sql was successfully parsed.
 */
export function parse(sql) {
    parseError = false
    var chars = new antlr4.InputStream(sql)
    var lexer = new bb1dbSqlLexer.bb1dbSqlLexer(chars)
    var tokens  = new antlr4.CommonTokenStream(lexer)
    var parser = new bb1dbSqlParser.bb1dbSqlParser(tokens)
    var errorListener = new ErrorListener()
    parser.addErrorListener(errorListener)
    var tree = parser.prog()
    if(!parseError) {
        var sqlStatementCreator = new SqlStatementCreator()
        antlr4.tree.ParseTreeWalker.DEFAULT.walk(sqlStatementCreator, tree)
    }
    return parseError
}

/**
 * Return the stmt object that was created during the call to parse.
 */
export function getStmt() {
    return stmt
}