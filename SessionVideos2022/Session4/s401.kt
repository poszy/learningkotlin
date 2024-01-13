// inner classes

class BinaryTree1 {
    private val dummyNode = Node(0)
    private var root = dummyNode
    // class Node {} // default - public final
    private data class Node(val value: Int) // default - public final

    fun insert(value: Int) {
        root = Node(value)
    }
}

class BinaryTree2 {
    fun printValue(value: Int) { // member function of BinaryTree2
        println(value)
    }
    private val dummyNode = Node(0)
    private var root = dummyNode
    // class Node {} // default - public final
    private data class Node(val value: Int) {
        // SEPARATE nested class who happens to live inside BinaryTree2
        //    does not have access to properties/functions in container class
        fun inorder() {
            // printValue(value) // cannot call - does not have access to container instance
        }
    }

    fun insert(value: Int) {
        root = Node(value)
    }
}

class BinaryTree3 {
    fun printValue(value: Int) { // member function of BinaryTree2
        println(value)
    }
    private val dummyNode = Node(0)
    private var root = dummyNode
    // class Node {} // default - public final
    private inner class Node(val value: Int) {
        // inner classes have an implicit pointer to the containing instance
        fun inorder() {
            printValue(value)
        }
    }

    fun insert(value: Int) {
        root = Node(value)
    }
}

fun main() {
    val binaryTree = BinaryTree1()
    binaryTree.insert(42)

//    val node = BinaryTree3.Node() // cannot create instance of inner class from outside containing class
//    val node = BinaryTree.Node() // only works if Node is visible
}


