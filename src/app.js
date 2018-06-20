
// var rbt = 
var db = require("./database.js")
// // db.linkRbt(rbt)
// const antlr4 = require("../node_modules/antlr4/index.js")
// db.linkAntlr4(antlr4)
// const sqlLexer = require("../sqlParser/outJs/bb1dbSqlLexer.js")
// db.linkSqlLexer(sqlLexer)
// const sqlParser = require("../sqlParser/outJs/bb1dbSqlParser.js")
// db.linkSqlParser(sqlParser)
// const sqlListener = require("../sqlParser/outJs/bb1dbSqlListener.js")
// db.linksqlListener(sqlListener)

module.exports = {
    rbt: require("./redBlackTree.js"),
    sqlParser: require("./sqlParser.js"),
    db: db,
    newDatabase: db.newDatabase
}

// require.context(".", true, /^.*\.html$/)

