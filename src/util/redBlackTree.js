
var MAX_DEPTH = 10

/**
 * The colors that a node can be, note that nil nodes are handled with the NIL color.
 */
export var NODE_COLOR = {
    NIL: -1,
    RED: 0,
    BLACK: 1
}

/**
 * Start up a new red black tree.  This will initially just be a single nil node.
 */
export function newRedBlackTree() {
    return {
        rootNode: {color: NODE_COLOR.NIL},

        insert: function(value) {
            //if there is only a nil node then this is the root.  Add it and make it black.
            if(this.rootNode.color == NODE_COLOR.NIL) {
                this.rootNode = {
                    value : value,
                    parentNode : {color: NODE_COLOR.NIL},
                    leftNode : {color: NODE_COLOR.NIL},
                    rightNode : {color: NODE_COLOR.NIL},
                    color : NODE_COLOR.BLACK
                }
                this.rootNode.leftNode.parentNode = this.rootNode
                this.rootNode.rightNode.parentNode = this.rootNode
                return
            }

            let currNode = this.rootNode
            let depth = 0
            while(depth < MAX_DEPTH) {
                depth++
                if(currNode.color == NODE_COLOR.NIL) {
                    //found location, insert
                    currNode.value = value,
                    currNode.leftNode = {color: NODE_COLOR.NIL},
                    currNode.rightNode = {color: NODE_COLOR.NIL},
                    currNode.color = NODE_COLOR.RED
                    currNode.leftNode.parentNode = currNode
                    currNode.rightNode.parentNode = currNode
                    break
                } else if(currNode.value >= value) {
                    currNode = currNode.leftNode
                } else if(currNode.value < value) {
                    currNode = currNode.rightNode
                } else {
                    console.log("Equal, we need to decide if this is allowed, just break for now and do nothing")
                    break
                }
            }

            console.log("done insert")

        } // insert
    }
}  // function newRedBlackTree()







