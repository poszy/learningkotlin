

interface Comparable<TYPE> { // we have an interface that takes in a type.
    operator fun compareTo(other: TYPE) : Int // using operator to override, can be used in if and else statments now.  
}

interface Sortable<TYPE> {
    fun compare(a: TYPE, b: TYPE): Int
}

interface RandomAccess<ITEM_TYPE> {
    val size: Int
    operator fun get(index: Int): ITEM_TYPE
    operator fun set(index: Int, item: ITEM_TYPE)
}

// <ITEM_TYPE: Comparable<ITEM_TYPE>> is an upper bound constraint.
fun <ITEM_TYPE: Comparable<ITEM_TYPE>> RandomAccess<ITEM_TYPE>.sort() { // extension functions
    (0 until size).forEach { i ->
        (i+1 until size).forEach { j ->
            if (this[i] > this[j]) {
                // don't recommend you write this
                // I like to talk about it because you'll likely see it
                this[i] = this[j].also { this[j] = this[i] }

                // equivalent to
//                val temp = this[i]
//                this[i] = this[j]
//                this[j] = temp
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

fun <ITEM_TYPE: Comparable<ITEM_TYPE>, COLLECTION: RandomAccess<ITEM_TYPE>> COLLECTION.sort2() {
    (0 until size).forEach { i ->
        (i+1 until size).forEach { j ->
            if (this[i] > this[j]) {

                this[i] = this[j].also { this[j] = this[i] } // the reciever holds the value of [j]. then also gets executed. so [j] gets set to [i].. now after that is done. the left side of the period gets executed and [i] gets set to the origional value of [j] that one that was snapshooted before it was changed.

            }
        }
    }
}

fun <ITEM_TYPE, COLLECTION> COLLECTION.sort3()
        where // use where to define constraints.
        COLLECTION: RandomAccess<ITEM_TYPE>,
        COLLECTION: Sortable<ITEM_TYPE>
{
    (0 until size).forEach { i ->
        (i+1 until size).forEach { j ->
            if (compare(this[i], this[j]) > 0) {

                this[i] = this[j].also { this[j] = this[i] }


            }
        }
    }
}


//class Card : Comparable<Card>{ // here the <Card> is the type we want to compare to. thats it. dont get confused on why th
//    override fun compareTo(other: Card): Int {
//        TODO("Not yet implemented")
//    }
//
//}