const bb1db = require("../dist/bb1db")

var consoleError = console.error
var consoleInfo = console.info
var consoleLog = console.log
var consoleTrace = console.trace
var consoleWarn = console.warn
function disableOutput() {
    console.error = function(){}
    console.info = function(){}
    console.log = function(){}
    console.trace = function(){}
    console.warn = function(){}
}
function enableOutput() {
    console.error = consoleError
    console.info = consoleInfo
    console.log = consoleLog
    console.trace = consoleTrace
    console.warn = consoleWarn
}

test("Create table 1 column no auto", () => {
    bb1db._sqlParser.parse("create table myTable(one)")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.CREATE_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAutoPk).toBe(false)
    expect(stmt.columns.length).toBe(1)
    expect(stmt.columns[0]).toBe("one")
})

test("Create table 1 column auto", () => {
    bb1db._sqlParser.parse("create table myTable(one auto)")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.CREATE_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAutoPk).toBe(true)
    expect(stmt.columns.length).toBe(1)
    expect(stmt.columns[0]).toBe("one")
})

test("Create table 3 columns auto", () => {
    bb1db._sqlParser.parse("create table myTable(one auto, two, three)")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.CREATE_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAutoPk).toBe(true)
    expect(stmt.columns.length).toBe(3)
    expect(stmt.columns[0]).toBe("one")
    expect(stmt.columns[1]).toBe("two")
    expect(stmt.columns[2]).toBe("three")
})

test("Drop a table", () => {
    bb1db._sqlParser.parse("drop table myTable")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.DROP_TABLE)
    expect(stmt.tableName).toBe("myTable")
})

test("Alter a table add 1 column", () => {
    bb1db._sqlParser.parse("alter table myTable add one")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.ALTER_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAddColumn).toBe(true)
    expect(stmt.columns[0]).toBe("one")
})

test("Alter a table add 2 columns", () => {
    bb1db._sqlParser.parse("alter table myTable add one, two")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.ALTER_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAddColumn).toBe(true)
    expect(stmt.columns[0]).toBe("one")
    expect(stmt.columns[1]).toBe("two")
})

test("Alter a table drop 1 column", () => {
    bb1db._sqlParser.parse("alter table myTable drop one")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.ALTER_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAddColumn).toBe(false)
    expect(stmt.columns[0]).toBe("one")
})

test("Alter a table drop 2 columns", () => {
    bb1db._sqlParser.parse("alter table myTable drop one, two")
    var stmt = bb1db._sqlParser.getStmt()
    expect(stmt.statementType).toBe(bb1db._sqlStatement.STATEMENT_TYPE.ALTER_TABLE)
    expect(stmt.tableName).toBe("myTable")
    expect(stmt.isAddColumn).toBe(false)
    expect(stmt.columns[0]).toBe("one")
    expect(stmt.columns[1]).toBe("two")
})
