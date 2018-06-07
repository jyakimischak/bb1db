
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
                    p : {t:NIL},
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
        } // _insert
    }
}  // function newRedBlackTree()







