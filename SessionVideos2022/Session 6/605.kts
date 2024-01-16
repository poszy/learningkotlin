// multiple interfaces with same function names

interface IntList {
    var list: List<Int>
    fun add(n: Int) {
        list = list + n
    }
}

interface Calculator {
    var value: Int
    fun add(n: Int) {
        value += n
    }
}

// the above functions have different semantics
// if we implemented BOTH, we've got a problem
// conflict - compiler doesn't know which to use
//    you need to be explicit!
class Stuff: IntList, Calculator {
    override var list = emptyList<Int>()
    override var value = 0

    //    override fun add(n: Int) = super<Calculator>.add(n)
//    override fun add(n: Int) = super<IntList>.add(n)
    override fun add(n: Int) {
        super<Calculator>.add(n)
        super<IntList>.add(n)
    }
}

fun main() {
    val stuff = Stuff()
    stuff.add(4)
    stuff.add(5)
    println(stuff.value)
    println(stuff.list)
}
