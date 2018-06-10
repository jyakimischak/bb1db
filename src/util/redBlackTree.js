
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
         * Delete the given node from the tree.
         * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
         * https://www.geeksforgeeks.org/red-black-tree-set-3-delete-2/
         * 
         * v - node to be deleted
         * u - node replacing v
         */
        _delete: function(node) {
            if(node.p.t == ROOT) {
                this.root = {t:NIL}
                return
            }

            let curr = node
            let parent = curr.p
            let isLeft = parent.l.t[0] == curr.t[0]

            let u = null
            let v = curr

            if(node.l.t == NIL && node.r.t == NIL) { // this is a leaf
                if(isLeft) {
                    parent.l = {
                        t:NIL,
                        p:parent,
                        c:BLACK
                    }
                    u = parent.l
                } else {
                    parent.r = {
                        t:NIL,
                        p:parent,
                        c:BLACK
                    }
                    u = parent.r
                }
            } else if(curr.l.t != NIL && curr.r.t == NIL) { // only a left child
                if(isLeft) {
                    parent.l = curr.l
                    parent.l.p = parent
                } else {
                    parent.r = curr.l
                    parent.r.p = parent
                }
                u = curr.l
            } else if(curr.l.t == NIL && curr.r.t != NIL) { // only a right child
                if(isLeft) {
                    parent.l = curr.r
                    parent.l.p = parent
                } else {
                    parent.r = curr.r
                    parent.r.p = parent
                }
                u = curr.r
            } else { // 2 children
                let ios = getInOrderSuccessor(curr.r, 0)
                curr.t = ios.t
                ios.p = curr.p
                ios.l = curr.l
                ios.r = curr.r
                u = ios
            }

            //balance tree
            if(u.c == RED || v.c == RED) {
                u.c = BLACK
            } else { // both are black
                u.c = DOUBLE_BLACK
            }

            let depth = 0
            while(u.p.t != ROOT && depth < MAX_DEPTH) {
                let uIsLeft = u.p.l.t[0] == u.t[0]
                let sibling = uIsLeft ? u.p.r : u.p.l
                let sIsLeft = sibling.p.l.t[0] == sibling.t[0]
                let parent = u.p
                let r = null // will be the red child of sibling

                if(sibling.c == BLACK && (sibling.l.c == RED || sibling.r.c == RED)) {
                    r = sibling.l.c == RED ? sibling.l : sibling.r
                    let rIsLeft = sibling.l.c == RED

                    if(uIsLeft && rIsLeft) { //left left
                        this._rotateRight(parent)
                    } else if(uIsLeft && !rIsLeft) { //left right
                        this._rotateRight(sibling)
                    } else if(!uIsLeft && !rIsLeft) { //right right
                        this._rotateLeft(parent)
                    } else { //right left
                        this._rotateLeft(sibling)
                    }
                } else if(sibling.c == BLACK && sibling.l.c == BLACK && sibling.r.c == BLACK) {

                }


                depth++
            }
            //u is now root, color it black (to ensure it's not set to double black)
            u.c = BLACK


            /**
             * Get the next highest node, this should be the leaf from the left path of the right child.
             */
            function getInOrderSuccessor(curr, depth) {
                if(depth == MAX_DEPTH) {
                    console.error("getInOrderSuccessor - max recurse depth reached!")
                    return
                }

                if(curr.l.t == NIL) { // we found it, remove it from the tree and return the node
                    if(curr.r.t == NIL) {
                        curr.p.r = {t:NIL, p:curr.p, c:BLACK}
                    } else {
                        curr.p.r = curr.r
                        curr.r.p = curr.p
                    }
                    return curr
                }
                getInOrderSuccessor(curr.l, depth+1)
            }
        }, // _delete

        _deleteFixViolations: function(startNode) {
            let curr = startNode

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
            if(this.root.c != BLACK) {
                console.warn(`violation - root node is not black it is ${this.root.c}`)
                return true
            }
            let blackCountAtPathEnd = -1 // once we hit the end of the first path set this, then use it to compare afterwards
            return violationsRecurse(0, this.root, 0)

            function violationsRecurse(depth, curr, blackCount) {
// console.log(`${curr.p.t == ROOT ? "root ==> " : ""} t:${curr.t} c:${curr.c} blackCount:${blackCount} depth:${depth}`)
// console.log(curr)
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
        } // _hasViolations

    }
}  // function newRedBlackTree()







