const bb1db = require("../../dist/bb1db")

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

test("_rotateLeft empty left subtree", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([100]) // root
    tree._insert([200])

    tree._rotateLeft(tree.root)

    expect(tree.root.t[0]).toBe(200)
    expect(tree.root.l.t[0]).toBe(100)
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

test("_rotateRight empty right subtree", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([200]) // root
    tree._insert([100])

    tree._rotateRight(tree.root)

    expect(tree.root.t[0]).toBe(100)
    expect(tree.root.r.t[0]).toBe(200)
})

test("_hasViolations red root", () => {
    disableOutput()
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree.root.c = bb1db.rbt.RED
    expect(tree._hasViolations()).toBe(true)
    enableOutput()
})

test("_hasViolations 2 reds", () => {
    disableOutput()
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._insert([20])
    tree._insert([30])
    expect(tree._hasViolations()).toBe(true)
    enableOutput()
})

test("_hasViolations black counts", () => {
    disableOutput()
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree.root.l = {
        t : [9],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.BLACK,
        p : tree.root
    }
    tree.root.l.l.p = tree.root.l
    tree.root.l.r.p = tree.root.l
    tree.root.l.l = {
        t : [8],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.BLACK,
        p : tree.root.l
    }
    tree.root.l.l.l.p = tree.root.l.l
    tree.root.l.l.r.p = tree.root.l.l
    tree.root.r = {
        t : [11],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.BLACK,
        p : tree.root
    }
    tree.root.r.l.p = tree.root.r
    tree.root.r.r.p = tree.root.r

    expect(tree._hasViolations()).toBe(true)
    enableOutput()
})

test("_hasViolations simple w/ no violations", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree.root.l = {
        t : [8],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.RED,
        p : tree.root
    }
    tree.root.l.l.p = tree.root.l
    tree.root.l.r.p = tree.root.l
    tree.root.l.l = {
        t : [7],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.BLACK,
        p : tree.root.l
    }
    tree.root.l.l.l.p = tree.root.l.l
    tree.root.l.l.r.p = tree.root.l.l
    tree.root.l.r = {
        t : [9],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.BLACK,
        p : tree.root.l
    }
    tree.root.l.r.l.p = tree.root.l.r
    tree.root.l.r.r.p = tree.root.l.r
    tree.root.r = {
        t : [11],
        l : {t:bb1db.rbt.NIL},
        r : {t:bb1db.rbt.NIL},
        c : bb1db.rbt.BLACK,
        p : tree.root
    }
    tree.root.r.l.p = tree.root.r
    tree.root.r.r.p = tree.root.r
        
    expect(tree._hasViolations()).toBe(false)
})

/**
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Math/random
 */
function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min)) + min; //The maximum is exclusive and the minimum is inclusive
}

test("_insertFixViolations 1000 random inserts", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    let min = -100000
    let max = 100000

    for(let i = 0; i < 1000; i++) {
        tree._insertFixViolations(tree._insert([getRandomInt(min, max)]))
    }
    expect(tree._hasViolations()).toBe(false)
})

test("_delete root", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._delete(tree.root)
    expect(tree.root.t).toBe(bb1db.rbt.NIL)
})

test("_delete leaf left", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._delete(tree._insert([0]))
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.l.p.t[0]).toBe(10)
    expect(tree.root.r.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.r.p.t[0]).toBe(10)
})

test("_delete leaf right", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    tree._delete(tree._insert([20]))
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.l.p.t[0]).toBe(10)
    expect(tree.root.r.t).toBe(bb1db.rbt.NIL)
    expect(tree.root.r.p.t[0]).toBe(10)
})

test("_delete left 1 left child", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    let toDelete = tree._insert([9])
    tree._insert([8])
    tree._delete(toDelete)
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.t[0]).toBe(8)
    expect(tree.root.l.p.t[0]).toBe(10)
})

test("_delete left 1 right child", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    let toDelete = tree._insert([5])
    tree._insert([6])
    tree._delete(toDelete)
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.t[0]).toBe(6)
    expect(tree.root.l.p.t[0]).toBe(10)
})

test("_delete right 1 left child", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    let toDelete = tree._insert([20])
    tree._insert([15])
    tree._delete(toDelete)
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.r.t[0]).toBe(15)
    expect(tree.root.r.p.t[0]).toBe(10)
})

test("_delete right 1 right child", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    let toDelete = tree._insert([20])
    tree._insert([25])
    tree._delete(toDelete)
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.r.t[0]).toBe(25)
    expect(tree.root.r.p.t[0]).toBe(10)
})

test("_delete left 2 children", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([10])
    let toDelete = tree._insert([5])
    tree._insert([6])
    tree._insert([4])
    tree._delete(toDelete)
    expect(tree.root.t[0]).toBe(10)
    expect(tree.root.l.t[0]).toBe(6)
    expect(tree.root.l.p.t[0]).toBe(10)
    expect(tree.root.l.l.t[0]).toBe(4)
})

test("_delete right 2 children", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    tree._insert([0])
    let toDelete = tree._insert([5])
    tree._insert([6])
    tree._insert([4])
    tree._delete(toDelete)
    expect(tree.root.t[0]).toBe(0)
    expect(tree.root.r.t[0]).toBe(6)
    expect(tree.root.r.p.t[0]).toBe(0)
    expect(tree.root.r.l.t[0]).toBe(4)
})

test("_delete_getInOrderSuccessor", () => {
    let tree = bb1db.rbt.newRedBlackTree()
    let testNode = tree._insert([50])
    tree._insert([40])
    tree._insert([70])
    tree._insert([60])
    tree._insert([80])
    let ios = tree._delete_getInOrderSuccessor(testNode.r, 0)
    expect(ios.t[0]).toBe(60)
})

test("_deleteFixViolations 100 random inserts, delete 5, 10 times", () => {
    let min = -1000000
    let max = 1000000

    for(let timesCtr = 0; timesCtr < 10; timesCtr++) {
        let tree = bb1db.rbt.newRedBlackTree()
        let toDelete = []

        for(let insertCtr = 0; insertCtr < 100; insertCtr++) {
            let node = tree._insert([getRandomInt(min, max)])
            tree._insertFixViolations(node)
            if(insertCtr % 20 == 0) {
                toDelete.push(node)
            }
            toDelete.forEach(e => {
                tree._deleteFixViolations(tree._delete(e))
                expect(tree._hasViolations()).toBe(false)
            })
        }
    }
})

