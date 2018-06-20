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
    let db = bb1db.db.newDatabase()
    expect(db.description).toBe("")
    db = bb1db.db.newDatabase("My database")
    expect(db.description).toBe("My database")
    db = bb1db.db.newDatabase({bla:"bla"})
    expect(db.description).toBe("")
})

// test("Create table", () => {
//     db = bb1db.db.newDatabase()
//     db.execute("create table test(one, two)")
// })
