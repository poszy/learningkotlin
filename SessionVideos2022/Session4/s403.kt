
// tempalte method and strategy pattern
interface BinaryTree {
    fun insert(value: Int)
}

// traditional OO-style template method pattern
open class BinaryTree1: BinaryTree {
    // hook function
    open fun processValue(value: Int) {
        println(value)
    }
    private var root: Node? = null

    private inner class Node(
            val value: Int,
            var left: Node? = null,
            var right: Node? = null,
    ) {
        // inner classes have an implicit pointer to the containing instance
        fun inorder() {  // TEMPLATE METHOD - algorithm with replaceable steps
            left?.inorder()
            processValue(value) // REPLACEABLE STEPS = "hooks"
            right?.inorder()
        }
        fun insert(node: Node) {
            if (node.value < value) {
                left?.insert(node) ?: run { left = node }
            } else {
                right?.insert(node) ?: run { right = node }
            }
        }
    }

    override fun insert(value: Int) {
        root?.insert(Node(value)) ?: run { root = Node(value) }
    }

    fun inorder() { root?.inorder() }
}

// NOT IDEAL -- need a whole new copy of the data structure to do different action
class BinaryTree1a: BinaryTree1() {
    // override the hook to change replaceable behavior in template method
    override fun processValue(value: Int) {
        println("X${value}X")
    }
}


// strategy-style template method pattern with strategy property
class BinaryTree2: BinaryTree {
    var processValue: (Int) -> Unit = { println(it) }

    private var root: Node? = null

    private inner class Node(
            val value: Int,
            var left: Node? = null,
            var right: Node? = null,
    ) {
        // inner classes have an implicit pointer to the containing instance
        fun inorder() {  // TEMPLATE METHOD - algorithm with replaceable steps
            left?.inorder()
            processValue(value) // REPLACEABLE STEP via property
            right?.inorder()
        }
        fun insert(node: Node) {
            if (node.value < value) {
                left?.insert(node) ?: run { left = node }
            } else {
                right?.insert(node) ?: run { right = node }
            }
        }
    }

    override fun insert(value: Int) {
        root?.insert(Node(value)) ?: run { root = Node(value) }
    }

    fun inorder() { root?.inorder() }
}


// strategy-style template method pattern with strategy parameter
class BinaryTree3: BinaryTree {
    private var root: Node? = null

    private inner class Node(
            val value: Int,
            var left: Node? = null,
            var right: Node? = null,
    ) {
        // inner classes have an implicit pointer to the containing instance
        fun inorder(processValue: (Int) -> Unit = { println(it) }) {  // TEMPLATE METHOD - algorithm with replaceable steps
            left?.inorder(processValue)
            processValue(value) // REPLACEABLE STEP via parameter
            right?.inorder(processValue)
        }
        fun insert(node: Node) {
            if (node.value < value) {
                left?.insert(node) ?: run { left = node }
            } else {
                right?.insert(node) ?: run { right = node }
            }
        }
    }

    override fun insert(value: Int) {
        root?.insert(Node(value)) ?: run { root = Node(value) }
    }

    fun inorder(processValue: (Int) -> Unit = { println(it) }) {
        root?.inorder(processValue)
    }
}





fun main() {
    val tree1 = BinaryTree1()
    insertValues(tree1)
    tree1.inorder()

    val tree1a = BinaryTree1a()
    insertValues(tree1a)
    tree1a.inorder()

    // change behavior without recreating the data structure
    val tree2 = BinaryTree2()
    insertValues(tree2)
    tree2.inorder()
    tree2.processValue = { println("Y${it}Y") }
    tree2.inorder()

    // change behavior without recreating the data structure
    val tree3 = BinaryTree3()
    insertValues(tree3)
    tree3.inorder()
    tree3.inorder {
        println("Z${it}Z")
    }
}

fun insertValues(tree: BinaryTree) {
    tree.insert(42)
    tree.insert(100)
    tree.insert(10)
    tree.insert(60)
    tree.insert(4)
    tree.insert(12)
    tree.insert(10000)
    tree.insert(437)
}




