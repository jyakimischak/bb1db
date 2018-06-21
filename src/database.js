
//***************************************************************************************
// The functions to create and store the database itself.
//***************************************************************************************

const rbt = require("./redBlackTree.js")
const sqlParser = require("./sqlParser.js")
const sqlStatement = require("./sqlStatement.js")

/**
 * Return a new database object with an optional description.
 */
export function newDatabase(description) {
    let dbDesc = typeof description == "string" && description.length > 0 ? description : ""

    return {
        description: dbDesc,
        _tables: {},

        execute: function(sql) {
            let parseError = sqlParser.parse(sql)
            if(parseError) {
                console.error(`Parse error in - ${sql}`)
                return this
            }
            let stmt = sqlParser.getStmt()

            switch(stmt.statementType) {
                case sqlStatement.STATEMENT_TYPE.CREATE_TABLE:
                    this._createTable(stmt)
                    break;
                case sqlStatement.STATEMENT_TYPE.DROP_TABLE:
                    break;
                case sqlStatement.STATEMENT_TYPE.ALTER_TABLE:
                    break;
                case sqlStatement.STATEMENT_TYPE.NONE: // this should never really happen, should be caught by the parse error above
                default:
                    console.error(`unknown SQL statement - ${sql}`)
            }
            return this
        }, // execute

        /**
         * Create a table and add it to this.tables.
         */
        _createTable: function(stmt) {
            if(this._tables[stmt.tableName] != undefined) {
                console.warn(`Table ${stmt.tableName} already exists`)
                return
            }
            let table = {}
            table.tableName = stmt.tableName
            table.isAutoPk = stmt.isAutoPk
            if(stmt.isAutoPk) {
                //seed the pk sequence to 1 for the table
                table.pkSequence = 1
            }
            table.rows = rbt.newRedBlackTree()
            table.columns = stmt.columns
            this._tables[stmt.tableName] = table
        }
    }
}



