data class Person(var name: String, var father: Person? = null)

class Nullability {
    var person1: Person = Person("")
    var person2: Person? = null // ? means nullable
}

fun mainX() {
    val nullability: Nullability = Nullability()
//    nullability.person1 = null // won't work
    nullability.person2 = null

    println(nullability.person1.name)
    println(nullability.person2?.name)
    // null-safe accessor ?.
    //   if left side is null, STOP and return null
    //   otherwise, keep going

    println(nullability.person2?.father?.name)
    // feels similar to:
    //    if (nullability.person2 != null) {
    //        if (nullability.person2.father != null) {
    //            println(nullability.person2.father.name)
    //        }
    //    }

    //        if (nullability.person2 != null) {
    //            // some other thread may have changed person2 at this point!!!
    //            if (nullability.person2.father != null) {
    //                println(nullability.person2.father.name)
    //            }
    //        }

    // but really is similar to:
    val person2 = nullability.person2 // grab a snapshot
    if (person2 != null) {
        val father = person2.father // snapshot
        if (father != null) {
            println(father.name)
        }
    }

    // ?: is the "Elvis" operator
    //     if left hand side is NOT null, use that value
    //     otherwise, use the right side
    println(nullability.person2?.father?.name ?: "no father name available")

    val person3 = getSomeValueFromSomewhere() ?: throw IllegalStateException("Cannot get value")
    println(person3.name)
}

class BinaryTree3 {
    fun printValue(value: Int) {
        println(value)
    }
    private var root: Node? = null

    private inner class Node(
            val value: Int,
            var left: Node? = null,
            var right: Node? = null,
    ) {
        // inner classes have an implicit pointer to the containing instance
        fun inorder() {
            left?.inorder()
            printValue(value)
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

    fun insert(value: Int) {
        root?.insert(Node(value)) ?: run { root = Node(value) }
    }

    fun inorder() { root?.inorder() }
}

fun main() {
    val tree = BinaryTree3()
    tree.insert(42)
    tree.insert(100)
    tree.insert(10)
    tree.insert(60)
    tree.insert(4)
    tree.insert(12)
    tree.insert(10000)
    tree.insert(437)

    tree.inorder()
}

