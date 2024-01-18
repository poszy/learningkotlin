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

    operator fun get(index: Int): TYPE{
        var temp = head
        repeat(index) {
            temp = temp?.next
        }
        return temp?.value ?: throw IndexOutOfBoundsException()
    }
}

fun copy(from: MyLinkedList<Int>, to: MyLinkedList<Int>) {
    (0 until from.size).forEach {
        to.insert(from[it])
    }
}

fun copy2(from: MyLinkedList<Mammal>, to: MyLinkedList<Mammal>) {
    (0 until from.size).forEach {
        to.insert(from[it])
    }
}

fun <ITEM_TYPE> copy3(from: MyLinkedList<ITEM_TYPE>, to: MyLinkedList<ITEM_TYPE>) { // specifying <ITEM_TYPE> here says, this funciton type is takes in <ITEM_TYPE>
    // with this generic copy, we dont have to keep making functions to copy over items for every use case
    (0 until from.size).forEach {
        to.insert(from[it])
    }
}

abstract class Mammal {
    abstract val name: String
}
open class Dog(override val name: String): Mammal()
open class Cat(override val name: String): Mammal()
open class Tabby(name: String): Cat(name)

fun main() {
    val list1 = MyLinkedList<Int>().apply {
        insert(5)
        insert(4)
        insert(3)
        insert(2)
        insert(1)
    }
    val list2 = MyLinkedList<Int>()
    copy(from = list1, to = list2)
    (0 until list2.size).forEach {
        println(list2[it])
    }

    val list3 = MyLinkedList<Mammal>().apply {
        insert(Dog("Fido"))
        insert(Cat("Fluffy"))
        insert(Tabby("Thunderbean"))
        insert(Dog("Rex"))
        insert(Cat("Puffball"))
    }
    (0 until list3.size).forEach {
        println(list3[it].name)
    }
    val list4 = MyLinkedList<Mammal>()
    copy2(from = list3, to = list4)
    (0 until list4.size).forEach {
        println(list4[it].name)
    }
    val list5 = MyLinkedList<Cat>().apply {
        insert(Cat("Fluffy"))
        insert(Tabby("Thunderbean"))
        insert(Cat("Puffball"))
    }
    val list6 = MyLinkedList<Cat>()
    copy3(from = list1, to = list2)
    copy3(from = list3, to = list4)
    copy3(from = list5, to = list6)
    (0 until list6.size).forEach {
        println(list6[it].name)
    }
//    copy3(from = list5, to = list3) this wont work because since we are using the generic function to copy. the
    //generic function can only take one type. it does not know that a cat is a mammal.
}
