
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
 * Value for red color.
 */
export const RED = "red"

/**
 * Value for black color.
 */
export const BLACK = "black"

/**
 * Start up a new red black tree.  This will initially just be a single nil node.
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
                    l : {t:NIL},
                    r : {t:NIL},
                    c : BLACK
                }
                this.root.l.p = this.root
                this.root.r.p = this.root
                return
            }

            let curr = this.root
            let depth = 0
            while(depth < MAX_DEPTH) {
                depth++
                if(curr.t === NIL) {
                    //found location, insert
                    curr.t = tuple,
                    curr.l = {t:NIL},
                    curr.r = {t:NIL},
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
        }, // _insert

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
        } // _rotateRight

    }
}  // function newRedBlackTree()







