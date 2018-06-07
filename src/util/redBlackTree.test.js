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
    expect(tree.root.p.t).toBe(bb1db.rbt.ROOT)
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

test("_rotateLeft root pivot", () => {

    //         100                     150
    //        /   \     becomes       /   \
    //      50    150               100    160
    //     /  \   /  \             /  \        
    //    30  60 140 160          50  140
    //                           /  \
    //                          30  60

    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([100]) // P and root
    tree._insert([50]) // L
    tree._insert([30]) // Ll
    tree._insert([60]) // Lr
    tree._insert([150]) // R
    tree._insert([140]) // Rl
    tree._insert([160]) // Rr

    tree._rotateLeft(tree.root)

    expect(tree.root.t[0]).toBe(150)
    expect(tree.root.p.t).toBe(bb1db.rbt.ROOT)

    expect(tree.root.l.t[0]).toBe(100)
    expect(tree.root.l.p.t[0]).toBe(150)

    expect(tree.root.l.l.t[0]).toBe(50)
    expect(tree.root.l.l.p.t[0]).toBe(100)

    expect(tree.root.l.l.l.t[0]).toBe(30)
    expect(tree.root.l.l.l.p.t[0]).toBe(50)

    expect(tree.root.l.l.r.t[0]).toBe(60)
    expect(tree.root.l.l.r.p.t[0]).toBe(50)

    expect(tree.root.l.r.t[0]).toBe(140)
    expect(tree.root.l.r.p.t[0]).toBe(100)

    expect(tree.root.r.t[0]).toBe(160)
    expect(tree.root.r.p.t[0]).toBe(150)
})

test("_rotateLeft left node pivot", () => {
    //           500                    500
    //           /                      /
    //         100                     150
    //        /   \     becomes       /   \
    //      50    150               100    160
    //     /  \   /  \             /  \        
    //    30  60 140 160          50  140
    //                           /  \
    //                          30  60

    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([500]) // root
    tree._insert([100]) // P
    tree._insert([50]) // L
    tree._insert([30]) // Ll
    tree._insert([60]) // Lr
    tree._insert([150]) // R
    tree._insert([140]) // Rl
    tree._insert([160]) // Rr

    tree._rotateLeft(tree.root.l)

    expect(tree.root.l.t[0]).toBe(150)
    expect(tree.root.l.p.t[0]).toBe(500)

    expect(tree.root.l.l.t[0]).toBe(100)
    expect(tree.root.l.l.p.t[0]).toBe(150)

    expect(tree.root.l.l.l.t[0]).toBe(50)
    expect(tree.root.l.l.l.p.t[0]).toBe(100)

    expect(tree.root.l.l.l.l.t[0]).toBe(30)
    expect(tree.root.l.l.l.l.p.t[0]).toBe(50)

    expect(tree.root.l.l.l.r.t[0]).toBe(60)
    expect(tree.root.l.l.l.r.p.t[0]).toBe(50)

    expect(tree.root.l.l.r.t[0]).toBe(140)
    expect(tree.root.l.l.r.p.t[0]).toBe(100)

    expect(tree.root.l.r.t[0]).toBe(160)
    expect(tree.root.l.r.p.t[0]).toBe(150)
})

test("_rotateLeft right node pivot", () => {
    //       -500                    -500
    //          \                       \
    //         100                     150
    //        /   \     becomes       /   \
    //      50    150               100    160
    //     /  \   /  \             /  \        
    //    30  60 140 160          50  140
    //                           /  \
    //                          30  60

    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([-500]) // root
    tree._insert([100]) // P
    tree._insert([50]) // L
    tree._insert([30]) // Ll
    tree._insert([60]) // Lr
    tree._insert([150]) // R
    tree._insert([140]) // Rl
    tree._insert([160]) // Rr

    tree._rotateLeft(tree.root.r)

    expect(tree.root.r.t[0]).toBe(150)
    expect(tree.root.r.p.t[0]).toBe(-500)

    expect(tree.root.r.l.t[0]).toBe(100)
    expect(tree.root.r.l.p.t[0]).toBe(150)

    expect(tree.root.r.l.l.t[0]).toBe(50)
    expect(tree.root.r.l.l.p.t[0]).toBe(100)

    expect(tree.root.r.l.l.l.t[0]).toBe(30)
    expect(tree.root.r.l.l.l.p.t[0]).toBe(50)

    expect(tree.root.r.l.l.r.t[0]).toBe(60)
    expect(tree.root.r.l.l.r.p.t[0]).toBe(50)

    expect(tree.root.r.l.r.t[0]).toBe(140)
    expect(tree.root.r.l.r.p.t[0]).toBe(100)

    expect(tree.root.r.r.t[0]).toBe(160)
    expect(tree.root.r.r.p.t[0]).toBe(150)
})

test("_rotateRight root pivot", () => {

    //         100                      50
    //        /   \     becomes       /    \
    //      50    150               30     100
    //     /  \   /  \                    /   \
    //    30  60 140 160                 60   150
    //                                        /  \
    //                                      140  160

    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([100]) // P and root
    tree._insert([50]) // L
    tree._insert([30]) // Ll
    tree._insert([60]) // Lr
    tree._insert([150]) // R
    tree._insert([140]) // Rl
    tree._insert([160]) // Rr

    tree._rotateRight(tree.root)

    expect(tree.root.t[0]).toBe(50)
    expect(tree.root.p.t).toBe(bb1db.rbt.ROOT)

    expect(tree.root.l.t[0]).toBe(30)
    expect(tree.root.l.p.t[0]).toBe(50)

    expect(tree.root.r.t[0]).toBe(100)
    expect(tree.root.r.p.t[0]).toBe(50)

    expect(tree.root.r.l.t[0]).toBe(60)
    expect(tree.root.r.l.p.t[0]).toBe(100)

    expect(tree.root.r.r.t[0]).toBe(150)
    expect(tree.root.r.r.p.t[0]).toBe(100)

    expect(tree.root.r.r.l.t[0]).toBe(140)
    expect(tree.root.r.r.l.p.t[0]).toBe(150)

    expect(tree.root.r.r.r.t[0]).toBe(160)
    expect(tree.root.r.r.r.p.t[0]).toBe(150)
})

test("_rotateRight left node pivot", () => {

    //          500                      500
    //          /                        /
    //         100                      50
    //        /   \     becomes       /    \
    //      50    150               30     100
    //     /  \   /  \                    /   \
    //    30  60 140 160                 60   150
    //                                        /  \
    //                                      140  160

    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([500]) // root
    tree._insert([100]) // P
    tree._insert([50]) // L
    tree._insert([30]) // Ll
    tree._insert([60]) // Lr
    tree._insert([150]) // R
    tree._insert([140]) // Rl
    tree._insert([160]) // Rr

    tree._rotateRight(tree.root.l)

    expect(tree.root.l.t[0]).toBe(50)
    expect(tree.root.l.p.t[0]).toBe(500)

    expect(tree.root.l.l.t[0]).toBe(30)
    expect(tree.root.l.l.p.t[0]).toBe(50)

    expect(tree.root.l.r.t[0]).toBe(100)
    expect(tree.root.l.r.p.t[0]).toBe(50)

    expect(tree.root.l.r.l.t[0]).toBe(60)
    expect(tree.root.l.r.l.p.t[0]).toBe(100)

    expect(tree.root.l.r.r.t[0]).toBe(150)
    expect(tree.root.l.r.r.p.t[0]).toBe(100)

    expect(tree.root.l.r.r.l.t[0]).toBe(140)
    expect(tree.root.l.r.r.l.p.t[0]).toBe(150)

    expect(tree.root.l.r.r.r.t[0]).toBe(160)
    expect(tree.root.l.r.r.r.p.t[0]).toBe(150)
})

test("_rotateRight right node pivot", () => {

    //       -500                    -500
    //          \                       \
    //         100                      50
    //        /   \     becomes       /    \
    //      50    150               30     100
    //     /  \   /  \                    /   \
    //    30  60 140 160                 60   150
    //                                        /  \
    //                                      140  160

    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([-500]) // root
    tree._insert([100]) // P
    tree._insert([50]) // L
    tree._insert([30]) // Ll
    tree._insert([60]) // Lr
    tree._insert([150]) // R
    tree._insert([140]) // Rl
    tree._insert([160]) // Rr

    tree._rotateRight(tree.root.r)

    expect(tree.root.r.t[0]).toBe(50)
    expect(tree.root.r.p.t[0]).toBe(-500)

    expect(tree.root.r.l.t[0]).toBe(30)
    expect(tree.root.r.l.p.t[0]).toBe(50)

    expect(tree.root.r.r.t[0]).toBe(100)
    expect(tree.root.r.r.p.t[0]).toBe(50)

    expect(tree.root.r.r.l.t[0]).toBe(60)
    expect(tree.root.r.r.l.p.t[0]).toBe(100)

    expect(tree.root.r.r.r.t[0]).toBe(150)
    expect(tree.root.r.r.r.p.t[0]).toBe(100)

    expect(tree.root.r.r.r.l.t[0]).toBe(140)
    expect(tree.root.r.r.r.l.p.t[0]).toBe(150)

    expect(tree.root.r.r.r.r.t[0]).toBe(160)
    expect(tree.root.r.r.r.r.p.t[0]).toBe(150)
})

test("_delete root", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._delete(tree.root)
    expect(tree.root.t).toBe(bb1db.rbt.NIL)
})

test("_delete simple left", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([0])
    tree._delete(tree.root.l)

    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.p.t[0]).toBe(10)
    expect(tree.root.r.p.t[0]).toBe(10)
})

test("_delete simple right", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([20])
    tree._delete(tree.root.r)

    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.p.t[0]).toBe(10)
    expect(tree.root.r.p.t[0]).toBe(10)
})
