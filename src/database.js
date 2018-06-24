
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
        lastPk: undefined,
        _rowsModified: 0,
        _isBatchMode: false,

        /**
         * execute a single sql statement
         */
        execute: function(sql) {
            this._isBatchMode = false
            this._rowsModified = 0
            this._executeSingle(sql)
            return this
        }, // execute

        /**
         * execute a batch of sql statements
         */
        executeBatch: function(sqlArray) {
            this._isBatchMode = true
            this._rowsModified = 0
            sqlArray.forEach(sql => {
                this._executeSingle(sql)
            })
            console.info(`${this._rowsModified} rows modified`)
            this._isBatchMode = false
            return this
        }, // executeBatch

        /**
         * execute and executeBatch call this.
         */
        _executeSingle: function(sql) {
            let parseError = sqlParser.parse(sql)
            if(parseError) {
                console.error(`Parse error in - ${sql}`)
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
                case sqlStatement.STATEMENT_TYPE.INSERT:
                    this._insert(stmt)
                    break;
                case sqlStatement.STATEMENT_TYPE.NONE: // this should never really happen, should be caught by the parse error above
                default:
                    console.error(`unknown SQL statement - ${sql}`)
            }
        }, // _executeSingle

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
                table.isAutoPkOn = true
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
        }, // _alterTable

        /**
         * Insert a value
         * The PK for the inserted row will be placed in this.lastPk (undefined on error).
         */
        _insert: function(stmt) {
            if(stmt.columns.length == 0) {
                console.warn("No columns specifier in insert")
                return
            }
            if(stmt.columns.length != stmt.values.length) {
                console.warn("Insert - must be same number of columns and values")
                return
            }
            if(this._tables[stmt.tableName] == undefined) {
                console.warn(`Table ${stmt.tableName} does not exist`)
                return
            }

            let table = this._tables[stmt.tableName]
            let rowToInsert = new Array(table.columns.length)

            //populate rowToInsert with the values from the insert statement, the order of the columns in rowToInsert matches the order of the columns in the table
            for(let stmtColI = 0; stmtColI < stmt.columns.length; stmtColI++) {
                let colI = table.columns.findIndex(e => e == stmt.columns[stmtColI]) // what is the index for this column
                if(colI == -1) {
                    console.warn(`Columns unknown: ${stmt.tableName}.${stmt.columns[stmtColI]}`)
                    return
                }
                if(colI == 0 && table.isAutoPk && table.isAutoPkOn) {
                    console.warn(`Columns unknown: ${stmt.tableName}.${stmt.columns[stmtColI]}`)
                    return
                }
                rowToInsert[colI] = stmt.values[stmtColI] // set the value into the correct position
            }
            if(
                rowToInsert[0] == undefined &&
                (
                    !table.isAutoPk ||
                    (table.isAutoPk && !table.isAutoPkOn)
                )
            ) {
                console.warn(`PK column ${stmt.tableName}.${table.columns[0]} must be set`)
                return
            }

            if(table.isAutoPk && table.isAutoPkOn) {
                rowToInsert[0] = table.pkSequence
                table.pkSequence++ // if an error occurs later there will be a gap in the sequence for the pk...not a big deal
            }

            this.lastPk = table.rows.add(rowToInsert)
            if(this.lastPk != undefined) {
                this._rowsModified++
                if(!this._isBatchMode) {
                    console.info("row inserted")
                }
            }
        } // _insert

    }
}



