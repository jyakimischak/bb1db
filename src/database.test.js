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

test("Database description", () => {
    let db = bb1db._db.newDatabase()
    expect(db.description).toBe("")
    db = bb1db._db.newDatabase("My database")
    expect(db.description).toBe("My database")
    db = bb1db._db.newDatabase({bla:"bla"})
    expect(db.description).toBe("")
})

test("Bad SQL", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("This is not SQL")
    expect(Object.keys(db._tables).length).toBe(0)
    enableOutput()
})

test("Create table 1 column no auto", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one)")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.pkSequence).toBe(undefined)
    expect(db._tables.test.columns[0]).toBe("one")
    enableOutput()
})

test("Create table 3 columns auto", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one auto, two, three)")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.pkSequence).toBe(1)
    expect(db._tables.test.columns[0]).toBe("one")
    expect(db._tables.test.columns[1]).toBe("two")
    expect(db._tables.test.columns[2]).toBe("three")
    enableOutput()
})

test("Create table then drop it", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one)")
        .execute("drop table test")
    expect(Object.keys(db._tables).length).toBe(0)
    enableOutput()
})

test("Create table then add a column", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one)")
        .execute("alter table test add two")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.columns[0]).toBe("one")
    expect(db._tables.test.columns[1]).toBe("two")
    enableOutput()
})

test("Create table then drop a column", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one, two)")
        .execute("alter table test drop two")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.columns[0]).toBe("one")
    expect(db._tables.test.columns.length).toBe(1)
    enableOutput()
})

test("Create table then try to add an existing column", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one, two)")
        .execute("alter table test add two")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.columns[0]).toBe("one")
    expect(db._tables.test.columns[1]).toBe("two")
    expect(db._tables.test.columns.length).toBe(2)
    enableOutput()
})

test("Create table then try to drop a non existant column", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one, two)")
        .execute("alter table test drop doesnotexist")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.columns[0]).toBe("one")
    expect(db._tables.test.columns[1]).toBe("two")
    expect(db._tables.test.columns.length).toBe(2)
    enableOutput()
})

test("Create table then try to drop the PK column", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one, two)")
        .execute("alter table test drop one")
    expect(db._tables.test.tableName).toBe("test")
    expect(db._tables.test.columns[0]).toBe("one")
    expect(db._tables.test.columns[1]).toBe("two")
    expect(db._tables.test.columns.length).toBe(2)
    enableOutput()
})
