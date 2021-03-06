
//***************************************************************************************
// This handles the sql statement object produced by the parser.
//***************************************************************************************


export const STATEMENT_TYPE = {
    NONE: "NONE",
    CREATE_TABLE: "CREATE_TABLE",
    DROP_TABLE: "DROP_TABLE",
    ALTER_TABLE: "ALTER_TABLE",
    INSERT: "INSERT",
    SELECT: "SELECT"
}


export function newStatement() {
    return {
        statementType: STATEMENT_TYPE.NONE,

        createTable: function(isAutoPk) {
            this.statementType = STATEMENT_TYPE.CREATE_TABLE
            this.tableName = ""
            this.columns = []
            this.isAutoPk = isAutoPk
        },

        dropTable: function() {
            this.statementType = STATEMENT_TYPE.DROP_TABLE
            this.tableName = ""
        },

        /**
         * Setup an alter table, are the columns add or drop (only 1 or the other is allowed per statement).
         */
        alterTable: function() {
            this.statementType = STATEMENT_TYPE.ALTER_TABLE
            this.tableName = ""
            this.columns = []
        },

        alterTableIsAddColumn: function(isAddColumn) {
            this.isAddColumn = isAddColumn
        },

        insert: function() {
            this.statementType = STATEMENT_TYPE.INSERT
            this.columns = []
            this.values = []
        },

        setTableName: function(tableName) {
            this.tableName = tableName
        },

        addColumn: function(columnName) {
            this.columns.push(columnName)
        },

        addValue: function(value) {
            this.values.push(value)
        },

        select: function() {
            this.statementType = STATEMENT_TYPE.SELECT
            this.selectColumns = []
        },

        addSelectColumn: function(selectColumn) {
            this.selectColumns.push(selectColumn)
        },

        setSelectFromTableName: function(selectFromTableName) {
            this.selectFromTableName = selectFromTableName
            this.selectJoins = []
        },

        addSelectJoinTable: function(selectJoinTableName) {
            this.selectJoins.push({tableName: selectJoinTableName})
        }


    }
}




