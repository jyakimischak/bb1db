
//***************************************************************************************
// The functions to create and store the database itself.
//***************************************************************************************

export var rbt = {}

/**
 * Use to link the red black tree module.
 */
export function linkRbt(rbtRef) {
    rbt = rbtRef
}

/**
 * Return a new database object with an optional description.
 */
export function newDatabase(description) {
    let dbDesc = typeof description == "string" && description.length > 0 ? description : ""
    return {
        description: dbDesc,
        tables: {}
    }
}

