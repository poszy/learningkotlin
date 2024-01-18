
interface Comparable<TYPE> {
    operator fun compareTo(other: TYPE): Int
}

// added "in"
interface Comparator<in TYPE> {
    fun compare(a: TYPE, b: TYPE): Int
}

interface Sortable<TYPE> {
    fun compare(a: TYPE, b: TYPE): Int
}

interface RandomAccess<ITEM_TYPE> {
    val size: Int
    operator fun get(index: Int): ITEM_TYPE
    operator fun set(index: Int, item: ITEM_TYPE)
}

fun main() {
    val x = object: Comparator<Mammal> {
        override fun compare(a: Mammal, b: Mammal): Int {
            return a.name.compareTo(b.name)
        }
    }
    val y = object: Comparator<Cat> {
        override fun compare(a: Cat, b: Cat): Int {
            return a.name.compareTo(b.name)
        }
    }

    // If we want to use a comparator during a sort of a list of cats,
    //    we could use a specific "Cat" comparator, or we could use a
    //    comparator of some superclass of Cat (if we really wanted to).
    // For example, perhaps a Mammal comparator were written to compare
    //    Mammal names, and a Cat comparator compares names and breaks ties
    //    using numberOfMiceSlain. Either comparator would work, because
    //    you can pass a Cat into either Comparator.
    // The other direction doesn't work
    var z: Comparator<Cat> = y
    z = x
}


fun <ITEM_TYPE: Comparable<ITEM_TYPE>> RandomAccess<ITEM_TYPE>.sort() {
    (0 until size).forEach { i ->
        (i+1 until size).forEach { j ->
            if (this[i] > this[j]) {
                // don't recommend you write this
                // I like to talk about it because you'll likely see it
                this[i] = this[j].also { this[j] = this[i] }


            }
        }
    }
}

fun <ITEM_TYPE: Comparable<ITEM_TYPE>, COLLECTION: RandomAccess<ITEM_TYPE>> COLLECTION.sort2() {
    (0 until size).forEach { i ->
        (i+1 until size).forEach { j ->
            if (this[i] > this[j]) {
                // don't recommend you write this
                // I like to talk about it because you'll likely see it
                this[i] = this[j].also { this[j] = this[i] }


            }
        }
    }
}

fun <ITEM_TYPE, COLLECTION> COLLECTION.sort3()
        where
        COLLECTION: RandomAccess<ITEM_TYPE>,
        COLLECTION: Sortable<ITEM_TYPE>
{
    (0 until size).forEach { i ->
        (i+1 until size).forEach { j ->
            if (compare(this[i], this[j]) > 0) {
                // don't recommend you write this
                // I like to talk about it because you'll likely see it
                this[i] = this[j].also { this[j] = this[i] }


            }
        }
    }
}


class MyLinkedList<ITEM_TYPE>(
        val comparator: (ITEM_TYPE, ITEM_TYPE) -> Int
): RandomAccess<ITEM_TYPE>, Sortable<ITEM_TYPE> {
    class Node<ITEM_TYPE>(
            val value: ITEM_TYPE,
            var next: Node<ITEM_TYPE>? = null
    )

    private var head: Node<ITEM_TYPE>? = null
    override var size: Int = 0
        private set

    fun insert(value: ITEM_TYPE) {
        head = Node(value, head)
        size++
    }

    override operator fun get(index: Int): ITEM_TYPE {
        var temp = head
        repeat(index) {
            temp = temp?.next
        }
        return temp?.value ?: throw IndexOutOfBoundsException()
    }

    override fun set(index: Int, item: ITEM_TYPE) {
        TODO("Left as exercise for interested reader")
    }

    override fun compare(a: ITEM_TYPE, b: ITEM_TYPE): Int {
        return comparator(a, b)
    }
}
