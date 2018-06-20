
//***************************************************************************************
// This handles parsing SQL and creating action objects that will be executed on the database.
//***************************************************************************************

const antlr4 = require("../node_modules/antlr4/index.js")
const bb1dbSqlLexer = require("../sqlParser/outJs/bb1dbSqlLexer.js")
const bb1dbSqlParser = require("../sqlParser/outJs/bb1dbSqlParser.js")
const bb1dbSqlListener = require("../sqlParser/outJs/bb1dbSqlListener.js")


var inCTab = false;
var cTabData = {}


var SqlActionCreator = function() {
    bb1dbSqlListener.bb1dbSqlListener.call(this)
    return this
}
SqlActionCreator.prototype = Object.create(bb1dbSqlListener.bb1dbSqlListener.prototype)
SqlActionCreator.prototype.constructor = SqlActionCreator
SqlActionCreator.prototype.enterProg = function(ctx) {
}
SqlActionCreator.prototype.exitProg = function(ctx) {
}
SqlActionCreator.prototype.enterCTab = function(ctx) {
    inCTab = true
    cTabData = {
        tableName: "",
        auto: false,
        columns: []
    }
    cTabData.auto = ctx.AUTO_KW() != undefined
}
SqlActionCreator.prototype.exitCTab = function(ctx) {
    inCTab = false
    console.log(cTabData)
}
SqlActionCreator.prototype.enterDTab = function(ctx) {
}
SqlActionCreator.prototype.exitDTab = function(ctx) {
}
SqlActionCreator.prototype.enterATab = function(ctx) {
}
SqlActionCreator.prototype.exitATab = function(ctx) {
}
SqlActionCreator.prototype.enterATabColumn = function(ctx) {
}
SqlActionCreator.prototype.exitATabColumn = function(ctx) {
}
SqlActionCreator.prototype.enterTableName = function(ctx) {
    if(inCTab) {
        cTabData.tableName = ctx.IDENTIFIER().getText()
    }
}
SqlActionCreator.prototype.exitTableName = function(ctx) {
}
SqlActionCreator.prototype.enterColumnName = function(ctx) {
    if(inCTab) {
        cTabData.columns.push(ctx.IDENTIFIER().getText())
    }
}
SqlActionCreator.prototype.exitColumnName = function(ctx) {
}




// SqlActionCreator.prototype.exitCTab = function(ctx) {      
// //   console.log(ctx)
// //   console.log(ctx.children[3].symbol)


//     console.log(ctx.CREATE_KW().getText())
//     console.log(ctx.TABLE_KW().getText())
//     console.log(ctx.IDENTIFIER(0).getText())
//     console.log(ctx.IDENTIFIER(1).getText())
//     // console.log(ctx.AUTO_KW().getText())


// }


export function parse(sql) {
    var chars = new antlr4.InputStream(sql)
    var lexer = new bb1dbSqlLexer.bb1dbSqlLexer(chars)
    var tokens  = new antlr4.CommonTokenStream(lexer)
    var parser = new bb1dbSqlParser.bb1dbSqlParser(tokens)
    var tree = parser.prog()
    var sqlActionCreator = new SqlActionCreator()
    antlr4.tree.ParseTreeWalker.DEFAULT.walk(sqlActionCreator, tree)
}


