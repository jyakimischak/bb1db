
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
                    this._dropTable(stmt)
                    break;
                case sqlStatement.STATEMENT_TYPE.ALTER_TABLE:
                this._alterTable(stmt)
                break;
                case sqlStatement.STATEMENT_TYPE.NONE: // this should never really happen, should be caught by the parse error above
                default:
                    console.error(`unknown SQL statement - ${sql}`)
            }
            return this
        }, // execute

        /**
         * Create a table and add it to this._tables
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
            console.info(`Created table ${stmt.tableName}`)
        }, // _createTable

        /**
         * remove the given table from this._tables
         */
        _dropTable: function(stmt) {
            if(this._tables[stmt.tableName] == undefined) {
                console.warn(`Table ${stmt.tableName} does not exist`)
                return
            }
            delete this._tables[stmt.tableName]
            console.info(`Dropped table ${stmt.tableName}`)
        }, // _dropTable

        /**
         * Either add or drop columns from a table
         */
        _alterTable: function(stmt) {
            if(this._tables[stmt.tableName] == undefined) {
                console.warn(`Table ${stmt.tableName} does not exist`)
                return
            }
            let table = this._tables[stmt.tableName]
            let columnsAltered = 0
            if(stmt.isAddColumn) { // adding columns
                stmt.columns.forEach(col => {
                    if(table.columns.includes(col)) {
                        console.warn(`Column ${table.tableName}.${col} already exists.`)
                    } else {
                        table.columns.push(col)
                        columnsAltered++
                        //TODO, add columns to tuple values in rbt
                    }
                })
                console.info(`Altered table ${table.tableName}, ${columnsAltered} column(s) added`)
            } else { // dropping columns
                stmt.columns.forEach(col => {
                    let colI = table.columns.findIndex(e => e == col)
                    if(colI == -1) {
                        console.warn(`Column ${table.tableName}.${col} does not exist.`)
                    } else {
                        if(colI == 0) {
                            console.warn(`Column ${table.tableName}.${col} cannot be dropped, it is the PK.`)
                        } else {
                            table.columns.pop(colI)
                            columnsAltered++
                            //TODO, remove columns from tuple values in rbt
                        }
                    }
                })
                console.info(`Altered table ${table.tableName}, ${columnsAltered} column(s) dropped`)
            }
        } // _alterTable
    }
}



