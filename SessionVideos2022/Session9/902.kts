class MyLinkedList <TYPE> { // <T> anything can be inside of the bracket.
    class Node <TYPE>( // need <TYPE> here because its not marked as an inner class. so it does not have access the the parent class type property
            val value: TYPE, // did not mark as inner class because, we do not need the pointer that each instance of Node will be pointing to the parent linked list
            var next: Node<TYPE>? = null
    )

    private var head: Node<TYPE>? = null
    var size: Int = 0
        private set

    fun insert(value: TYPE) {
        head = Node(value, head)
        size++
    }

    operator fun get(index: Int): TYPE? {
        var temp = head
        repeat(index) {
            temp = temp?.next
        }
        return temp?.value
    }
}
// replace with generics.
//class MyStringLinkedList {
//    class Node(
//            val value: String,
//            var next: Node? = null
//    )
//
//    private var head: Node? = null
//    var size: Int = 0
//        private set
//
//    fun insert(value: String) {
//        head = Node(value, head)
//        size++
//    }
//
//    operator fun get(index: Int): String? {
//        var temp = head
//        repeat(index) {
//            temp = temp?.next
//        }
//        return temp?.value
//    }
//}



    val list1 = MyLinkedList<Int>()
    list1.insert(5)
    list1.insert(4)
    list1.insert(3)
    list1.insert(2)
    list1.insert(1)

    (0 until list1.size).forEach {
        println(list1[it])
    }

    val list2 = MyLinkedList<String>()
    list2.insert("E")
    list2.insert("D")
    list2.insert("C")
    list2.insert("B")
    list2.insert("A")

    (0 until list2.size).forEach {
        println(list2[it])
    }

abstract class Mammal {
    abstract val name: String
}
open class Dog(override val name: String): Mammal()
open class Cat(override val name: String): Mammal()
open class Tabby(name: String): Cat(name)

val list3 = MyLinkedList<Mammal>()
list3.insert(Dog("Fido"))
list3.insert(Cat("Fluffy"))
list3.insert(Tabby("Thunderbean"))
list3.insert(Dog("Rex"))
list3.insert(Cat("Puffball"))

(0 until list3.size).forEach {
    println(list3[it]?.name)
}
