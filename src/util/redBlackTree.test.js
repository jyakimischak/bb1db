const bb1db = require("../../dist/bb1db")

test("newRedBlackTree Created", () => {
    expect(bb1db.redBlackTree.newRedBlackTree().rootNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
})

test("Insert a value into an empty tree", () => {
    let rbt = bb1db.redBlackTree.newRedBlackTree()
    rbt.insert(10)

    expect(rbt.rootNode.value).toBe(10)
    expect(rbt.rootNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.BLACK)
    expect(rbt.rootNode.parentNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
    expect(rbt.rootNode.leftNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
    expect(rbt.rootNode.rightNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
})

test("Insert a lower value", () => {
    let rbt = bb1db.redBlackTree.newRedBlackTree()
    rbt.insert(10)
    rbt.insert(0)

    expect(rbt.rootNode.leftNode.value).toBe(0)
    expect(rbt.rootNode.leftNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.RED)
    expect(rbt.rootNode.leftNode.leftNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
    expect(rbt.rootNode.leftNode.rightNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)

    expect(rbt.rootNode.leftNode.parentNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.BLACK)
    expect(rbt.rootNode.leftNode.parentNode.value).toBe(10)
})

test("Insert 2 lower values", () => {
    let rbt = bb1db.redBlackTree.newRedBlackTree()
    rbt.insert(10)
    rbt.insert(5)
    rbt.insert(0)

    expect(rbt.rootNode.leftNode.leftNode.value).toBe(0)
    expect(rbt.rootNode.leftNode.leftNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.RED)
    expect(rbt.rootNode.leftNode.leftNode.leftNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
    expect(rbt.rootNode.leftNode.leftNode.rightNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.NIL)
    
    expect(rbt.rootNode.leftNode.leftNode.parentNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.RED)
    expect(rbt.rootNode.leftNode.leftNode.parentNode.value).toBe(5)

    expect(rbt.rootNode.leftNode.leftNode.parentNode.parentNode.color).toBe(bb1db.redBlackTree.NODE_COLOR.BLACK)
    expect(rbt.rootNode.leftNode.leftNode.parentNode.parentNode.value).toBe(10)
})
