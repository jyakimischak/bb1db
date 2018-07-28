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

test("Insert in order valid", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    expect(
        db.execute("create table test(one, two)")
            .execute("insert into test(one, two) values (123, 'testString')").lastPk
    ).toBe(123)
    expect(db._tables["test"].rows.root.t[0]).toBe(123)
    expect(db._tables["test"].rows.root.t[1]).toBe("testString")
    enableOutput()
})

test("Insert in order valid auto pk", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    expect(
        db.execute("create table test(one auto, two)")
            .execute("insert into test(two) values ('testString')").lastPk
    ).toBe(1)
    expect(db._tables["test"].rows.root.t[0]).toBe(1)
    expect(db._tables["test"].rows.root.t[1]).toBe("testString")
    enableOutput()
})

test("Insert out of order valid", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    expect(
        db.execute("create table test(one, two)")
            .execute("insert into test(two, one) values ('testString', 123)").lastPk
    ).toBe(123)
    expect(db._tables["test"].rows.root.t[0]).toBe(123)
    expect(db._tables["test"].rows.root.t[1]).toBe("testString")
    enableOutput()
})

test("Insert invalid unknown column", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    expect(
        db.execute("create table test(one, two)")
            .execute("insert into test(one, two, invalid) values (123, 'testString', 345)").lastPk
    ).toBe(undefined)
    enableOutput()
})

test("Insert invalid pk when auto", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    expect(
        db.execute("create table test(one auto, two)")
            .execute("insert into test(one, two) values (123, 'testString')").lastPk
    ).toBe(undefined)
    enableOutput()
})

test("Insert invalid no pk when not auto", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    expect(
        db.execute("create table test(one, two)")
            .execute("insert into test(two) values ('testString')").lastPk
    ).toBe(undefined)
    enableOutput()
})

test("Batch insert", () => {
    disableOutput()
    let db = bb1db._db.newDatabase()
    db.execute("create table test(one, two)")
        .executeBatch([
            "insert into test(one, two) values (1, 'testString')",
            "insert into test(one, two) values (2, 'testString')",
            "insert into test(one, two) values (3, 'testString')",
            "insert into test(one, two) values (4, 'testString')",
            "insert into test(one, two) values (5, 'testString')",
            "insert into test(one, two) values (6, 'testString')",
            "insert into test(one, two) values (7, 'testString')",
            "insert into test(one, two) values (8, 'testString')",
            "insert into test(one, two) values (9, 'testString')",
            "insert into test(one, two) values (10, 'testString')",
        ])
    expect(db._rowsModified).toBe(10)
    enableOutput()
})

test("select star from a table", () => {
    let db = bb1db._db.newDatabase()
    db.execute("create table test(col1, col2)")
        .execute("insert into test(col1, col2) values (1, 'Test Value 1')")
        .execute("insert into test(col1, col2) values (2, 'Test Value 2')")
        .execute("insert into test(col1, col2) values (3, 'Test Value 3')")
        .execute("select * from test inner join bla on test.id = bla.id")

})


