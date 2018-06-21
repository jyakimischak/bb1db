
const db = require("./database.js")

module.exports = {
    _rbt: require("./redBlackTree.js"),
    _sqlParser: require("./sqlParser.js"),
    _sqlStatement: require("./sqlStatement.js"),
    _db: db,
    newDatabase: db.newDatabase
}

// require.context(".", true, /^.*\.html$/)

