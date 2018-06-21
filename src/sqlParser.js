
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
}
SqlStatementCreator.prototype.exitATab = function(ctx) {
}
SqlStatementCreator.prototype.enterATabColumn = function(ctx) {
}
SqlStatementCreator.prototype.exitATabColumn = function(ctx) {
}
SqlStatementCreator.prototype.enterTableName = function(ctx) {
    stmt.setTableName(ctx.IDENTIFIER().getText())
}
SqlStatementCreator.prototype.exitTableName = function(ctx) {
}
SqlStatementCreator.prototype.enterColumnName = function(ctx) {
    stmt.addColumn(ctx.IDENTIFIER().getText())
}
SqlStatementCreator.prototype.exitColumnName = function(ctx) {
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