
var rbt = require("./util/redBlackTree.js")
var db = require("./util/database.js")
db.linkRbt(rbt)
const antlr4 = require("../node_modules/antlr4/index.js")
db.linkAntlr4(antlr4)
const sqlLexer = require("../sqlParser/outJs/bb1dbSqlLexer.js")
db.linkSqlLexer(sqlLexer)
const sqlParser = require("../sqlParser/outJs/bb1dbSqlParser.js")
db.linkSqlParser(sqlParser)

module.exports = {
    api: require("./api.js"),
    rbt: rbt,
    db: db,
    newDatabase: db.newDatabase

    // db: require("./util/database.js")
//     c : require("./js/functionExports.js"),
//     init : require("./js/init.js"),
//     const : require("./js/constants.js"),
//     pa : require("./js/paintArea.js")
}

// require.context(".", true, /^.*\.html$/)

