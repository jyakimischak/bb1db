
//***************************************************************************************
// The functions to create and store the database itself.
//***************************************************************************************

const rbt = require("./redBlackTree.js")
const sqlParser = require("./sqlParser.js")

/**
 * Return a new database object with an optional description.
 */
export function newDatabase(description) {
    let dbDesc = typeof description == "string" && description.length > 0 ? description : ""

    return {
        description: dbDesc,
        tables: {},

        execute: function(sql) {
            console.log(sql)
//             var chars = new antlr4.InputStream(sql)
//             var lexer = new sqlLexer.bb1dbSqlLexer(chars)
//             var tokens  = new antlr4.CommonTokenStream(lexer)
//             // var listener = new bb1dbSqlListener.bb1dbSqlListener()
// // console.log(listener)


// console.log(bb1dbSqlListener)


//             var parser = new sqlParser.bb1dbSqlParser(tokens)
// // console.log(parser.prog)
// var tree = parser.prog()
// // console.log(tree)

// // console.log(sqlListener.bb1dbSqlListener.call(this))


// var bla = new SqlPrinter()
// antlr4.tree.ParseTreeWalker.DEFAULT.walk(bla, tree);

//             // parser.buildParseTrees = true
//             // parser.addListener("sdf")
//             // parser
            
// // console.log(parser)


//             // var tree = parser.elements()
//             // console.log("Parsed: "+ tree)            
        }
    }
}



