class MyLinkedList<TYPE> {
    class Node<TYPE>(
            val value: TYPE,
            var next: Node<TYPE>? = null
    )

    private var head: Node<TYPE>? = null
    var size: Int = 0
        private set

    // consuming the TYPE
    fun insert(value: TYPE) {
        head = Node(value, head)
        size++
    }

    // producing the TYPE
    operator fun get(index: Int): TYPE {
        var temp = head
        repeat(index) {
            temp = temp?.next
        }
        return temp?.value ?: throw IndexOutOfBoundsException()
    }
}

// call-site variance
//    out defines covariance. we are reading the parameters and only using to output. in this case. we are reading cats. this list never changes.
//      out tells us, the list comming in; is of Cat or a subtype of cats. this is fine because, since we are only reading the values. we know the output will be of a superclass.
//    in defines contravariance. write out the list that is of at least cat or its parent / super type. in this case mammals

// so basically:
// out -> reads a list of cats
// in -> returns a list of mammals or a supertype of cats. this makes it possible for cats to be put inside of a mammal list.
fun <ITEM_TYPE> copy4(from: MyLinkedList<out ITEM_TYPE>, to: MyLinkedList<in ITEM_TYPE>) {
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
    val list3 = MyLinkedList<Mammal>().apply {
        insert(Dog("Fido"))
        insert(Cat("Fluffy"))
        insert(Tabby("Thunderbean"))
        insert(Dog("Rex"))
        insert(Cat("Puffball"))
//        TODO("asdasdasdas")
    }
    (0 until list3.size).forEach {
        println(list3[it].name)
    }
    val list4 = MyLinkedList<Mammal>()
    copy4(from = list3, to = list4)
    (0 until list4.size).forEach {
        println(list4[it].name)
    }
    val list5 = MyLinkedList<Cat>().apply {
        insert(Cat("Fluffy"))
        insert(Tabby("Thunderbean"))
        insert(Cat("Puffball"))
    }
    val list6 = MyLinkedList<Cat>()
    copy4(from = list3, to = list4)
    copy4(from = list5, to = list6)
    (0 until list6.size).forEach {
        println(list6[it].name)
    }
    copy4(from = list5, to = list3) // list of cats to list of mammals
//    copy4(from = list3, to = list5) // list of mammals to list of cats
    // covariance and contravariance possibly not on exam.
}

