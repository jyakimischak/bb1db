
//***************************************************************************************
// This handles parsing SQL and creating action objects that will be executed on the database.
//***************************************************************************************

const antlr4 = require("../node_modules/antlr4/index.js")
const bb1dbSqlLexer = require("../sqlParser/outJs/bb1dbSqlLexer.js")
const bb1dbSqlParser = require("../sqlParser/outJs/bb1dbSqlParser.js")
const bb1dbSqlListener = require("../sqlParser/outJs/bb1dbSqlListener.js")

var SqlActionCreator = function() {
    bb1dbSqlListener.bb1dbSqlListener.call(this)
    return this
}
SqlActionCreator.prototype = Object.create(bb1dbSqlListener.bb1dbSqlListener.prototype)
SqlActionCreator.prototype.constructor = SqlActionCreator
SqlActionCreator.prototype.exitCTab = function(ctx) {      
  console.log("Oh, a key!")
}


export function parse(sql) {
    var chars = new antlr4.InputStream(sql)
    var lexer = new bb1dbSqlLexer.bb1dbSqlLexer(chars)
    var tokens  = new antlr4.CommonTokenStream(lexer)
    var parser = new bb1dbSqlParser.bb1dbSqlParser(tokens)
    var tree = parser.prog()
    var sqlActionCreator = new SqlActionCreator()
    antlr4.tree.ParseTreeWalker.DEFAULT.walk(sqlActionCreator, tree)
}

