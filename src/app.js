
var rbt = require("./util/redBlackTree.js")
var db = require("./util/database.js")
db.linkRbt(rbt)

module.exports = {
    api: require("./api.js"),
    rbt: rbt,
    db: db

    // db: require("./util/database.js")
//     c : require("./js/functionExports.js"),
//     init : require("./js/init.js"),
//     const : require("./js/constants.js"),
//     pa : require("./js/paintArea.js")
}

// require.context(".", true, /^.*\.html$/)

