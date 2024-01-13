package org.example.Streams

import kotlin.system.measureNanoTime

// eager fetch vs lazy fetch.
// iterable is a eager fetch
// as sequence is a lazy fetch
val list1 = listOf(1,2,3,4,5,6,7,8,9,10)
val iteratorList = CustomList("Iterator", list1)
val sequenceList = CustomList("sequence", list1)
// the by keyword is used for delegation.
// Delegation allows one class to implement an interface by delegating the method calls to another object (the delegate) that actually performs the behavior.
// This class CustomList is implementing the List<Int> interface, and it is delegating the implementation of the interface methods to the baseList provided in the constructor.
// This means that all the methods defined in the List interface will be delegated to the baseList.
class CustomList( val name : String, val baseList : List<Int>) : List<Int> by baseList{ // by is a decorate design pattern
// this is eager by default
    override fun iterator() : Iterator<Int> {
        val baseIterator = baseList.iterator()
        return object : Iterator<Int> {
            override fun hasNext() = baseIterator.hasNext()
            override fun next(): Int {
                val value = baseIterator.next()
                println("$name.next() called : $value")
                return value
            }
        }

    }
}

fun main() {
    var newlist = list1.filter { it % 2 ==0 } // give me all the items that are even
    newlist.forEach{ println(it) }
    println("---------------------")
    newlist = list1.filter{it % 2 == 0}.take(2) // we can just print out the first two 2..4
    newlist.forEach{println(it)} // the way kotlin works is eager. meaning it will iterate through each digit but create a new list every time in the new iteration. this can cause overhead

    println("---------------------")
    println("---------------------")
    newlist = iteratorList.filter{it % 2 == 0} // will call 1 .. 10
    newlist.forEach{println(it)}
    println("*********************")
    println("*********************")

    println("---------------------")
    println("---------------------")
    newlist = iteratorList.filter{it % 2 == 0}.take(2)
    newlist.forEach{println(it)}

    println("*********************")
    println("*********************")

    newlist = iteratorList.asSequence().filter{it % 2 == 0}.toList()
    newlist.forEach{println(it)}

    println("---------------------")
    println("---------------------")

    newlist = iteratorList.asSequence().filter{it % 2 == 0}.take(2).toList() // using sequence will only call the first 4 instead of 1..10
    newlist.forEach{println(it)}

    println("---------------------")
    // sequence can be used to optimize the creation of objects if you know the data well. here we can prevent 1..10 lists being crated and call only the first two.
    println(iteratorList.asSequence().filter { it % 2 == 0 }.first()) // only prints out the frist 2.

    // there are multiple implementations for filter.
    // in the context of using a list, the filter method is an iterator, which will take in a new list every sigle time, thus the creation of a new list every time it is iterated
    // in the context of s being a sequence list. sequence implementation of filter wraps the same list into the parameeters and performs operations on them. thus only needed to create minimal objects
    val s = sequenceList.asSequence() // s is of type sequence and will use the fitler method that is more optmizied.

    // sometimes using sequence is not faster than iterator and can be slower. it depends on the data and lists

    // when createing an empty collection, spcify the type
    val ll1 = listOf<String>()
    val mm1 = mapOf<String, String>()

    val l1 = listOf("1") // immutable
    // l1.add("S") cannot do this.
    val l2 = mutableListOf("1")
    l2.add("c")

    val m1 = mapOf( "a" to "b", "c" to "d")
    val m2 = mutableMapOf( "a" to "b", "c" to "d")

    // adding we can do
    m2.put("e", "f") // kotlin cries that this should be an assignment
    m2["e"] = "f"

    l1.filterNotNull() // give back all things not null
    l1.min() // get min
    l1.max() // get max
    list1.average()
    list1.reversed() // returns a new list with everything in the opposite order
    list1.asReversed() // returns a view ?

    personList.filterNotNull()
    val r = personList.map {it.name}
    println("Person Map : $r")

    val n = personList.mapIndexed{n , item -> n -1}
    println("Person MapIndex : $n")
    personList.drop(1)

    println("Person drop : ${n.drop(1)}") // drops the first index. -1
    personList.drop(2).forEach{ println(it.name)} // drops the first two names.
    println("-----")
    personList.take(2).forEach{ println(it.name)} // drops the last two names.

    println("-----")
    personList.sorted().forEach{ println(it.name)} // will sort alphabetically.
    println("-----")


    words.splitToSequence(" ").map{it.length}.reduce{total, wordLength -> wordLength + total}

    println("--- Map ----")
    println(family.map {it.value}) // [[Steve], [Oliver, Margaret], [Alex, Trevor, Nicole, Claire]] // list of list
    println(family.flatMap {it.value}) // [Steve, Oliver, Margaret, Alex, Trevor, Nicole, Claire]

    println(family2.flatMap { it.value })
    println(family2.flatMap { it.value }.flatMap { it }.joinToString("|", "", "<<<"))
    println(family2.flatMap { it.value }.flatMap { it }.joinToString()) // comma is default.


    println(measureNanoTime {
        println(familyPeople
            .flatMap { it.value }
            .sortedBy(Person::name)
            .joinToString()) // faster
    })
    println(measureNanoTime {
        println(familyPeople
            .flatMap { it.value }
            .asSequence()
            .sortedBy(Person::name) // do the sorting before sequence. this is slower than everything
            .joinToString())
    })
    println(measureNanoTime {
        println(familyPeople
            .flatMap { it.value }
            .sortedBy(Person::name)
            .asSequence() // faster after doing the sort first. faster than everything.
            .joinToString())
    })


}

class Person(val name : String) : Comparable<Person> {
    override fun compareTo(other: Person) = name.compareTo(other.name)
}

val personList = listOf(Person("Scott"), Person("Steve"), Person("Mike"), Person("Chewie"))
val words = "Once upon a time"
val family = mapOf(
    "siblings" to listOf("Steve"),
    "parents" to listOf("Oliver", "Margaret"),
    "children" to listOf("Alex", "Trevor", "Nicole", "Claire")
)
val family2 = mapOf(
    "siblings" to listOf(listOf("Steve")),
    "parents" to listOf(listOf("Oliver"), listOf("Margaret")),
    "children" to listOf(listOf("Alex"), listOf("Trevor"), listOf("Nicole"), listOf("Claire"))
)
val familyPeople = mapOf(
    "siblings" to listOf(Person("Steve")),
    "parents" to listOf(Person("Oliver"), Person("Margaret")),
    "children" to listOf(Person("Alex"), Person("Trevor"), Person("Nicole"), Person("Claire"))
)