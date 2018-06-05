
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
        rootNode: newNilNode(),

        insert: function(value) {
            //if there is only a nil node then this is the root.  Add it and make it black.
            if(this.rootNode.color = NODE_COLOR.NIL) {
                this.rootNode = newNode(
                    value, // value
                    newNilNode(), // parentNode
                    newNilNode(), // leftNode
                    newNilNode() // rightNode
                )
                this.rootNode.color = NODE_COLOR.BLACK
                return
            }
        } // insert


    }
}  // function newRedBlackTree()


/**
 * Create a new node with the given value, parent, left and right nodes.  Color it red.
 * @param {*} value 
 * @param {*} parentNode 
 * @param {*} leftNode 
 * @param {*} rightNode 
 */
function newNode(value, parentNode, leftNode, rightNode) {
    let node = {}
    node.value = value
    node.parentNode = parentNode
    node.leftNode = leftNode
    node.rightNode = rightNode
    node.color = NODE_COLOR.RED
    return node
}

/**
 * Create a new nil node and return it.  Nil nodes have no left or right node.
 */
function newNilNode() {
    let node = {}
    node.color = NODE_COLOR.NIL
    return node
}




