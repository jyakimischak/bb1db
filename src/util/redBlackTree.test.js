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