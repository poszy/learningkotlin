class MyIntLinkedList {
    class Node(
            val value: Int,
            var next: Node? = null
    )

    private var head: Node? = null
    var size: Int = 0
        private set

    fun insert(value: Int) {
        head = Node(value, head)
        size++
    }

    operator fun get(index: Int): Int? {
        var temp = head
        repeat(index) {
            temp = temp?.next
        }
        return temp?.value
    }
}

class MyStringLinkedList {
    class Node(
            val value: String,
            var next: Node? = null
    )

    private var head: Node? = null
    var size: Int = 0
        private set

    fun insert(value: String) {
        head = Node(value, head)
        size++
    }

    operator fun get(index: Int): String? {
        var temp = head
        repeat(index) {
            temp = temp?.next
        }
        return temp?.value
    }
}



    val list1 = MyIntLinkedList()
    list1.insert(5)
    list1.insert(4)
    list1.insert(3)
    list1.insert(2)
    list1.insert(1)

    (0 until list1.size).forEach {
        println(list1[it])
    }

    val list2 = MyStringLinkedList()
    list2.insert("E")
    list2.insert("D")
    list2.insert("C")
    list2.insert("B")
    list2.insert("A")

    (0 until list1.size).forEach {
        println(list2[it])
    }

