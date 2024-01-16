// when copying lists, we only copy the values or the pointers. it is not a deep copy.

val x = listOf("a")
val y = x + "b" // .. Y will point to A and add B. this is a shallow copy. '



// listOf() -> creates an immmutable list
val list1 = listOf<String>() // empty immutable list of string
var list2 = listOf<String>() // starts as empty immutable list of strings

list2= listOf("a")
list2 = list2 + listOf("a") // creating a new list


// mutableListOf -> creates mutable list
// can add / remove /set

val list3 = mutableListOf(1,2,3)
println(list3)
list3.removeAt(1) // indexes start at 0
println(list3)

list3.add(1) // to end of  list
println(list3)

list3[0] = 42 // adds to index 0
println(list3)

val list4 = mutableListOf(1,23,4,5,5,6,6)

list4.forEachIndexed{
    index, value ->
    println("$index $value")
}

list4.forEach { print(it) }

// we can also method chain like this

list4
        .take(5) // create new list with the first five elements
        .takeLast(2) // grab last two elements of that list. also creates a new list.
        .drop(1) // createa new list without the first element . same thing as "droplast()"

// although we can method chain, kotlin will create a new list every single time. which makes it expensive.
list4.takeWhile{ it < 5} // basically while it is less than five. take away each item. only items greater than 5 will remain.

list4.first() // throws exception iof empty list
list4.firstOrNull() // return if list empty.

// use elvis to initilize a vlaue if it does not exist.
val firstItem = list4.firstOrNull() ?: -1

val oddNumbers = list4.filter{it % 2 == 1}
println (oddNumbers)


abstract class Mammal(val name: String, val age: Int) {
    override fun toString(): String {
        return "$typeName(name='$name', age=$age)"
    }
    abstract val typeName: String
}
class Dog(name: String, age: Int) : Mammal(name, age) {
    override val typeName: String
        get() = "Dog"
}

class Cat(name: String, age: Int) : Mammal(name, age) {
    override val typeName: String
        get() = "Cat"
}
open class Human(name: String, age: Int) : Mammal(name, age) {
    override val typeName: String
        get() = "Human"
}
class Doctor(name: String, age: Int) : Human(name, age) {
    override val typeName: String
        get() = "Doctor"
}


//val list5 = mutableListOf<Mammal>()
//list5.add(Cat("cat"))
//list5.add(Dog("Jerry"))
//list5.add(Human("human"))
//list5.add(Cat(" another cat"))
//list5.add(Human("Another Human"))
//
//list5.filterIsInstance<Human>()
//        .forEach { print(it.name) }
//
//list5.filterIsInstance<Human>()
//        .onEach { println(it.name) }
//        .filterIsInstance<Doctor>()
//        .onEach { println(it.name) }

val mammals = listOf(
        Dog("Fido", 12),
        Cat("Puffball", 4),
        Cat("The Thing", 82),
        Dog("Fifi", 5),
        Human("Scott", 55),
        Doctor("The Doctor", 999),
        Dog("Rex", 2),
)

mammals
        .filterIsInstance<Human>()
        .onEach { println("Human: ${it.name}") }
        .filterIsInstance<Doctor>()
        .onEach { println("Doctor: ${it.name}") }

println("========")
val list5 = listOf("Scott", "Mary", "Zack", "Charlie", "Claire")
list5
        .onEach { println(it) }
        .sorted() // returns a new list with items sorted - only works for Comparable items
        .also {
            println("---------")
        }
        .onEach { println(it) }

println("========")
mammals
        .sortedBy { it.name }
        .onEach { println("${it.name}: ${it.age}") }
        .also {
            println("---------")
        }
        .sortedBy { it.age }
        .onEach { println("${it.name}: ${it.age}") }

list4
        .chunked(3)
        .forEach {
            println(it)
        }
list4
        .windowed(3)
        .forEach {
            println(it)
        }

println(list4.sum())
println(list4.average())
println(list4.minOf { it })
println(list4.maxOf { it })

println(mammals.sumOf { it.age })

println(mammals.any { it.age > 30 })
println(mammals.all { it.age > 30 })
println(mammals.none { it.age > 30 })

println("=======")
list4
        .chunked(3)
        .onEach {
            println(it)
        }
        .flatten()
        .also {
            println("-----")
        }
        .onEach {
            println(it)
        }

val list6 = listOf(
        generateNumbersStartingWith(1),
        generateNumbersStartingWith(10),
        generateNumbersStartingWith(20),
        generateNumbersStartingWith(30),
)

println(list6)

val mappedList4 =
        list4.map {
            generateNumbersStartingWith(it)
        }

println(mappedList4)
println(mappedList4.flatten())

val flatMappedList4 =
        list4.flatMap {
            generateNumbersStartingWith(it)
        }
println(flatMappedList4)


val mammalNames = mammals.map { it.name }
val mammalAges = mammals.map { it.age }

val averageMammalAge =
        mammals
                .map { it.age }
                .average()

val averageCatsAge =
        mammals
                .filterIsInstance<Cat>()
                .map { it.age }
                .average()

println( mammals.sumOf { it.age } )

println(
        mammals
                .map { it.age }
                .reduce { accumulator, value ->
                    accumulator + value
                }
)
println(
        mammals
                .map { it.age }
                .fold(0) { accumulator, value ->
                    accumulator + value
                }
)
println(
        mammals
                .map { it.age }
                .fold(Stats()) { stats, value ->
                    stats.apply {
                        //max = max(max, value)
                        //min = min(min, value)
                        sum += value
                    }
                }
)

println(mammals.find { it.name == "Scott" }?.age ?: -1)

val mammalsByName = mammals.associateBy { it.name }
println(mammalsByName["Scott"]?.age ?: -1)

val mammalsByType = mammals.groupBy { it::class }

println(mammalsByType[Cat::class])
println(mammalsByType[Dog::class])
println(mammalsByType[Human::class])
println(mammalsByType[Doctor::class])


data class Stats(
var min: Int = Int.MAX_VALUE,
var max: Int = Int.MIN_VALUE,
var sum: Int = 0,
)


fun generateNumbersStartingWith(n: Int) =
mutableListOf(n, n+1, n+2)



tailrec fun printStuff(list: List<Int>) {
if (list.isEmpty()) return
println(list.first())
printStuff(list.drop(1)) // similar to rest() or tail() in some other languages
}
