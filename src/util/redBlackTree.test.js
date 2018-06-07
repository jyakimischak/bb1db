const bb1db = require("../../dist/bb1db")

test("newrbt Created", () => {
    expect(bb1db.rbt.newRedBlackTree().root.t).toBe(bb1db.rbt.NIL)
})

test("_insert non-array", () => {
    expect(() => {
        bb1db.rbt.newRedBlackTree()._insert(10)
    }).toThrow()
})

test("_insert with no 0th element", () => {
    expect(() => {
        bb1db.rbt.newRedBlackTree()._insert([])
    }).toThrow()
})

test("_insert duplicate 0th element", () => {
    expect(() => {
        bb1db.rbt.newRedBlackTree()._insert([10])._insert([10])
    }).toThrow()
})

test("_insert into an empty tree", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])

    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.p.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.r.t).toBe(bb1db.rbt.NIL)
})

test("_insert a lower value", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([0])

    expect(tree.root.l.t[0]).toBe(0)
    expect(tree.root.l.c).toBe(bb1db.rbt.RED)
    expect(tree.root.l.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.l.r.t).toBe(bb1db.rbt.NIL)

    expect(tree.root.l.p.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.l.p.t[0]).toBe(10)
})

test("_insert a higher value", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([20])

    expect(tree.root.r.t[0]).toBe(20)
    expect(tree.root.r.c).toBe(bb1db.rbt.RED)
    expect(tree.root.r.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.r.r.t).toBe(bb1db.rbt.NIL)

    expect(tree.root.r.p.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.r.p.t[0]).toBe(10)
})

test("_insert 2 lower values", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([5])
    tree._insert([0])

    expect(tree.root.l.l.t[0]).toBe(0)
    expect(tree.root.l.l.c).toBe(bb1db.rbt.RED)
    expect(tree.root.l.l.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.l.l.r.t).toBe(bb1db.rbt.NIL)
    
    expect(tree.root.l.l.p.c).toBe(bb1db.rbt.RED)
    expect(tree.root.l.l.p.t[0]).toBe(5)

    expect(tree.root.l.l.p.p.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.l.l.p.p.t[0]).toBe(10)
})

test("_insert 2 higher values", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([20])
    tree._insert([30])

    expect(tree.root.r.r.t[0]).toBe(30)
    expect(tree.root.r.r.c).toBe(bb1db.rbt.RED)
    expect(tree.root.r.r.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.r.r.r.t).toBe(bb1db.rbt.NIL)
    
    expect(tree.root.r.r.p.c).toBe(bb1db.rbt.RED)
    expect(tree.root.r.r.p.t[0]).toBe(20)

    expect(tree.root.r.r.p.p.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.r.r.p.p.t[0]).toBe(10)
})

test("_insert 1 lower and 1 higher values", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([20])
    tree._insert([0])

    expect(tree.root.r.t[0]).toBe(20)
    expect(tree.root.r.c).toBe(bb1db.rbt.RED)
    expect(tree.root.r.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.r.r.t).toBe(bb1db.rbt.NIL)

    expect(tree.root.l.t[0]).toBe(0)
    expect(tree.root.l.c).toBe(bb1db.rbt.RED)
    expect(tree.root.l.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.l.r.t).toBe(bb1db.rbt.NIL)
    
    expect(tree.root.r.p.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.r.p.t[0]).toBe(10)

    expect(tree.root.l.p.c).toBe(bb1db.rbt.BLACK)
    expect(tree.root.l.p.t[0]).toBe(10)
})
