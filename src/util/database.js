
//***************************************************************************************
// The functions to create and store the database itself.
//***************************************************************************************

export var rbt = {}
export function linkRbt(rbtRef) {
    rbt = rbtRef
}

export var antlr4 = {}
export function linkAntlr4(antlr4Ref) {
    antlr4 = antlr4Ref
}

export var sqlLexer = {}
export function linkSqlLexer(sqlLexerRef) {
    sqlLexer = sqlLexerRef
}

export var sqlParser = {}
export function linkSqlParser(sqlParserRef) {
    sqlParser = sqlParserRef
}


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
            var chars = new antlr4.InputStream(sql)
            var lexer = new sqlLexer.bb1dbSqlLexer(chars)
            var tokens  = new antlr4.CommonTokenStream(lexer)
            var parser = new sqlParser.bb1dbSqlParser(tokens)
            parser.buildParseTrees = true
console.log(parser)
            var tree = parser.elements()
            console.log("Parsed: "+ tree)            
        }
    }
}

