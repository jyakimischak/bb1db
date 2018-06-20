
//***************************************************************************************
// Red black tree used to store tuples from a database.
//
// Note that the 0th item in the tuple is considered the PK and will be used for ordering within the red back tree.
// Note that duplicated are not allowed and will throw an error.
//***************************************************************************************

/**
 * Max path depth for the tree.
 */
const MAX_DEPTH = 1000

/**
 * nil nodes will have their value set to this
 */
export const NIL = "NIL"

/**
 * used for the tuple value in the parent of the root node.
 */
export const ROOT = "ROOT"

/**
 * Color values for nodes.
 */
export const RED = "red"
export const BLACK = "black"
export const DOUBLE_BLACK = "doubleBlack"

/**
 * Start up a new red black tree.  This will initially just be a single nil node.
 * 
 * node fields
 * p - parent
 * c - color
 * l - left node
 * r - right node
 * t - tuple, 0th element used for ordering
 */
export function newRedBlackTree() {
    return {
        root: {t:NIL},

        add: function(tuple) {

        }, // insert

        /**
         * Insert a tuple into the tree.  Return the resulting node if successful.
         */
        _insert: function(tuple) {
            //ensure that the tuple is an array with a 0th element
            if(!(tuple instanceof Array && tuple.length > 0)) {
                throw "Tuple is not an array or does not have a 0th element."
            }

            //if there is only a nil node then this is the root.  Add it and make it black.
            if(this.root.t === NIL) {
                this.root = {
                    t : tuple,
                    p : {t:ROOT},
                    l : {t:NIL, c:BLACK},
                    r : {t:NIL, c:BLACK},
                    c : BLACK
                }
                this.root.l.p = this.root
                this.root.r.p = this.root
                return this.root
            }

            let curr = this.root
            let depth = 0
            while(depth < MAX_DEPTH) {
                depth++
                if(curr.t === NIL) {
                    //found location, insert
                    curr.t = tuple,
                    curr.l = {t:NIL, c:BLACK},
                    curr.r = {t:NIL, c:BLACK},
                    curr.c = RED
                    curr.l.p = curr
                    curr.r.p = curr
                    break
                } else if(curr.t[0] >= tuple[0]) {
                    curr = curr.l
                } else if(curr.t[0] < tuple[0]) {
                    curr = curr.r
                } else {
                    throw `Duplicate key - ${tuple[0]}`
                }
            }
            return curr
        }, // _insert

        /**
         * Fix violations for an insert.
         */
        _insertFixViolations: function(startNode) {
            let curr = startNode

            while(curr.p.t != ROOT) {
                if(curr.p.p.t == ROOT) { //violation fixes can only occur if there is a grandparent
                    curr = this.root
                    break
                }
                
                let parent = curr.p
                let gParent = curr.p.p
                let isLeft = parent.l.t[0] == curr.t[0]
                let isPLeft = gParent.l.t[0] == parent.t[0]
                let uncle = isPLeft ? gParent.r : gParent.l

                if(curr.c == RED && parent.c == RED) { //is this node red and this nodes's parent a red node
                    if(uncle.c == RED) { // red uncle
                        parent.c = BLACK
                        uncle.c = BLACK
                        gParent.c = RED
                        curr = gParent
                    } else { // black uncle
                        if(isPLeft && isLeft) { // left, left
                            this._rotateRight(gParent)
                            curr.c = RED
                            parent.c = BLACK
                            gParent.c = RED
                        } else if(isPLeft && !isLeft) { // left, right
                            this._rotateLeft(parent)
                            this._rotateRight(gParent)
                            curr.c = BLACK
                            parent.c = RED
                            gParent.c = RED
                        } else if(!isPLeft && !isLeft) { // right, right
                            this._rotateLeft(gParent)
                            curr.c = RED
                            parent.c = BLACK
                            gParent.c = RED
                        } else { // right, left
                            this._rotateRight(parent)
                            this._rotateLeft(gParent)
                            curr.c = BLACK
                            parent.c = RED
                            gParent.c = RED
                        }
                    }
                } else {
                    curr = parent
                }
            }
            //root node must always be black, so just set it
            curr.c = BLACK
        }, // _insertFixViolations

        /**
         * Rotates the nodes left using the given node as the pivot.
         * 
         *             P                       R
         *           /   \     becomes       /   \
         *          L     R                 P     Rr
         *         / \   / \               / \        
         *        Ll Lr Rl Rr             L  Rl
         *                               / \
         *                              Ll Lr
         */
        _rotateLeft: function(pivot) {
            if(pivot == undefined || pivot.t == undefined || pivot.t === NIL) {
                console.error("_rotateLeft, the pivot must be a non-nil node.")
                return
            }
            let P = pivot
            let L = pivot.l
            let Ll = pivot.l.l
            let Lr = pivot.l.r
            let R = pivot.r
            let Rl = pivot.r.l
            let Rr = pivot.r.r

            if(P.p.t === ROOT) {
                this.root = R
            } else {
                if(P.p.l.t[0] == P.t[0]) {
                    P.p.l = R
                } else {
                    P.p.r = R
                }
            }
            R.p = P.p
            R.l = P
            P.p = R
            P.r = Rl
            Rl.p = P
        }, // _rotateLeft

        /**
         * Rotates the nodes right using the given node as the pivot.
         * 
         *             P                      L
         *           /   \     becomes       / \
         *          L     R                Ll   P
         *         / \   / \                   / \
         *        Ll Lr Rl Rr                 Lr  R
         *                                       / \
         *                                      Rl Rr
         */
        _rotateRight: function(pivot) {
            if(pivot == undefined || pivot.t == undefined || pivot.t === NIL) {
                console.error("_rotateLeft, the pivot must be a non-nil node.")
                return
            }
            let P = pivot
            let L = pivot.l
            let Ll = pivot.l.l
            let Lr = pivot.l.r
            let R = pivot.r
            let Rl = pivot.r.l
            let Rr = pivot.r.r


            if(P.p.t === ROOT) {
                this.root = L
            } else {
                if(P.p.l.t[0] == P.t[0]) {
                    P.p.l = L
                } else {
                    P.p.r = L
                }
            }
            L.p = P.p
            L.r = P
            P.p = L
            P.l = Lr
            Lr.p = P
        }, // _rotateRight

        /**
         * Delete the node from the tree, set the color of the resulting node and return it.
         */
        _delete: function(node) {
            if(node.p.t == ROOT && node.l.t == NIL && node.r.t == NIL) {
                this.root = {t:NIL}
                return this.root
            }
            let u = node // the node to return that rebalancing needs to start from
            if(node.l.t == NIL && node.r.t == NIL) { // this is a leaf
                let parent = node.p
                let isLeft = parent.l.t[0] == node.t[0]
                if(isLeft) {
                    parent.l = {
                        t:NIL,
                        p:parent
                    }
                    u = parent.l
                } else {
                    parent.r = {
                        t:NIL,
                        p:parent
                    }
                    u = parent.r
                }
                if(node.c == RED) {
                    u.c = BLACK
                } else {
                    u.c = DOUBLE_BLACK
                }
            } else if(node.l.t != NIL && node.r.t != NIL) { // 2 children
                let ios = this._delete_getInOrderSuccessor(node.r, 0)
                node.t = ios.t
                u = this._delete(ios)
            } else { // 1 child
                let childIsLeft = node.l.t != NIL && node.r.t == NIL
                let child = childIsLeft ? node.l : node.r
                node.t = child.t
                if(childIsLeft) {
                    node.l = {
                        t:NIL,
                        p:node,
                        c:BLACK
                    }
                } else {
                    node.r = {
                        t:NIL,
                        p:node,
                        c:BLACK
                    }
                }
                u = node
                if(u.c == RED) {
                    u.c = BLACK
                } else {
                    if(child.c == RED) {
                        u.c = BLACK
                    } else {
                        u.c = DOUBLE_BLACK
                    }
                }
            }
            return u
        },

        /**
         * Get the next highest node, this should be the leftmost node of the right subtree.
         */
        _delete_getInOrderSuccessor: function(curr, depth) {
            if(depth == MAX_DEPTH) {
                console.error("getInOrderSuccessor - max recurse depth reached!")
                return
            }

            if(curr.t != NIL && curr.l.t == NIL) { // we found it, remove it from the tree and return the node
                if(curr.r.t == NIL) {
                    curr.p.r = {t:NIL, p:curr.p, c:BLACK}
                } else {
                    curr.p.r = curr.r
                    curr.r.p = curr.p
                }
                return curr
            }
            return this._delete_getInOrderSuccessor(curr.l, depth+1)
        },
        

        /**
         * Balance and recolor the tree.
         * https://www.youtube.com/watch?v=CTvfzU_uNKE
         * 
         * 6 double black cases that we must handle (and ther mirror cases), left cases shown
         * ----------------------------------------------------------------------------------
         * r - red, b - black, db - double black, a - any, [] subtree
         * 
         * 1) - terminating case
         * root->R(db)          R(b)
         *        /  \   =>     / \
         *       []  []        [] []
         * 2)
         *       P(b)                     S(b)               
         *     /    \                   /     \
         *  N(db)   S(r)             P(r)      Y(b)
         *   / \    /   \     =>    /   \       /\
         *  [] []  X(b) Y(b)      N(db)  X(b)  [][]
         *          /\   /\         /\    /\
         *         [][] [][]       [][]  [][]
         * 3)
         *     P(b)                      P(db)
         *    /    \                   /      \
         *  N(db)   S(b)            N(b)      S(r)
         *   /\     /   \     =>   / \       /   \
         *  [][]   X(b) Y(b)      [] []    X(b)  Y(b)
         *          /\   /\                 /\    /\
         *         [][] [][]               [][]  [][]
         * 4) - terminating case
         *      P(r)                   P(b)
         *    /     \                 /    \
         *  N(db)    S(b)           N(b)    S(r)
         *   /\      /   \     =>   /\      /   \
         *  [][]    X(b) Y(b)      [][]    X(b) Y(b)
         *           /\   /\               /\    /\
         *          [][] [][]             [][]  [][]
         * 5)
         *     P(a)                    P(a)
         *    /    \                  /    \
         *  N(db)  S(b)             N(db)   X(b)
         *   /\    /   \       =>    /\    /  \
         *  [][]  X(r) Y(b)         [][]  []  S(r)
         *         /\   /\                    /  \
         *        [][] [][]                  []  Y(b)
         *                                        /\
         *                                       [][]
         * 6) - terminating case
         *      P(a)                         S(a)
         *    /     \                      /     \
         *   N(db)   S(b)                P(b)    y(b)
         *   /\     /   \      =>       /  \      /\
         *  [][]   X(a) Y(r)          N(b) X(a)  [][]
         *          /\   /\            /\   /\
         *         [][] [][]          [][] [][]
         */
        _deleteFixViolations: function(node) {
            let N = node
            let depth = 0
            while(N.c == DOUBLE_BLACK && depth < MAX_DEPTH) {
                if(N.p.t == ROOT) { // case 1
                    N.c = DOUBLE_BLACK
                } else {
                    let P = N.p
                    let leftCase = P.l.t[0] == N.t[0]
                    let S = leftCase ? P.r : P.l
                    let X = S.l
                    let Y = S.r
                    let case2RotateFunc = leftCase ? this._rotateLeft : this._rotateRight
                    let case5RotateFunc = leftCase ? this._rotateRight : this._rotateLeft
                    let case6RotateFunc = leftCase ? this._rotateLeft : this._rotateRight
                    let xIsBlackOrNil = S.t == NIL || X.c == BLACK
                    let yIsBlackOrNil = S.t == NIL || Y.c == BLACK

                    if(P.c == BLACK && S.c == RED && xIsBlackOrNil && yIsBlackOrNil) { // case 2
                        case2RotateFunc(P)
                    } else if(P.c == BLACK && S.c == BLACK && xIsBlackOrNil && yIsBlackOrNil) { // case 3
                        N.c = BLACK
                        P.c = DOUBLE_BLACK
                        S.c = RED
                        N = P // new N
                    } else if(P.c == RED && S.c == BLACK && xIsBlackOrNil && yIsBlackOrNil) { // case 4
                        N.c = BLACK
                        P.c = BLACK
                        S.c = RED
                    } else if(S.c == BLACK && X.c == RED && yIsBlackOrNil) { // case 5
                        case5RotateFunc(S)
                        X.c = BLACK
                        S.c = RED

                    } else if(Y.c == RED) { // case 6 
                        case6RotateFunc(P)
                        N.c = BLACK
                        S.c = P.c
                        P.c = BLACK
                        Y.c = BLACK
                    } else {
                        console.error("_deleteFixViolations - unreachable case")
                        return
                    }
                }
                depth++
            }
            if(depth == MAX_DEPTH) {
                console.warn("_deleteFixViolations - max depth reached")
            }
        },

        /**
         * Returns true if there are violations, false otherwise.
         * 
         * properties:
         * 1) every node is either red or black
         * 2) Root node is black
         * 3) No 2 adjacent nodes are red
         * 4) Every path from root to a nil leaf has the same number of black nodes
         */
        _hasViolations: function() {
            if(this.root.t == NIL) {
                return false
            }
            if(this.root.c != BLACK) {
                console.warn(`violation - root node is not black it is ${this.root.c}`)
                return true
            }
            let blackCountAtPathEnd = -1 // once we hit the end of the first path set this, then use it to compare afterwards
            return violationsRecurse(0, this.root, 0)

            function violationsRecurse(depth, curr, blackCount) {
                if(depth == MAX_DEPTH) { // if we hit max recurse depth say the tree is in violation
                    return true 
                }
                if(curr.t == NIL) {
                    if(blackCountAtPathEnd == -1) {
                        blackCountAtPathEnd = blackCount
                    }
                    if(blackCountAtPathEnd != blackCount) { // black count violation
                        console.warn(`violation - black count violation at ${curr.p.t}, black count:${blackCount} blackCountAtPathEnd:${blackCountAtPathEnd}`)
                        return true
                    } else {
                        return false
                    }
                }
                if(curr.p.t != ROOT && curr.p.c == RED && curr.c == RED) { // 2 reds violation
                    console.warn(`violation - 2 reds violation at ${curr.p.t}`)
                    return true
                }
                if(!(curr.c == RED || curr.c == BLACK)) { // node color violation
                    console.warn(`violation - node color violation at ${curr.p.t}, color:${curr.p.c}`)
                    return true
                }

                return violationsRecurse(depth+1, curr.l, curr.c == BLACK ? blackCount+1 : blackCount) ||
                    violationsRecurse(depth+1, curr.r, curr.c == BLACK ? blackCount+1 : blackCount)

            }
        }, // _hasViolations

        _debugPrintTree: function() {
            let out = "_debugPrintTree\n===============\n\n"
            if(this.root.t == NIL) {
                out += "The Tree is empty"
            } else {
                printRecurse(0, this.root)
            }
            console.log(out)

            function printRecurse(depth, curr) {
                if(depth == MAX_DEPTH) {
                    console.warn("_debugPrintTree, max depth reached")
                    return
                }
                if(curr.t != NIL) {
                    out += `   t:${curr.t} c:${curr.c} l.t:${curr.l.t} r.t:${curr.r.t}\n`
                    printRecurse(depth+1, curr.l)
                    printRecurse(depth+1, curr.r)
                }
            }
        } // _debugPrintTree

    }
}  // function newRedBlackTree()







