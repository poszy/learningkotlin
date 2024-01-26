var redundantProperty: Int = 10
    get() { // default getter
        return field
    }
    set(value) { // default setter
        field = value
    }

val simpleGetterProperty1: Int // no backing field
    get() {
        return 10
    }

// ----------------------
val simpleGetterProperty2: Int // no backing field
    get() { // READ ONLY, NOT IMMUTABLE might not be idempotent
        return getValue()
    }

fun getValue(): Int {
    return behindTheScenes
}

var behindTheScenes: Int = 10

// difference between read-only and immutable
// simpleGetterProperty2 = 10 // read only
// ----------------------


var name: String = ""

var nameToLog: String = ""
    get() {
        println("reading nameToLog")
        return field
    }
    set(value) {
        println("writing nameToLog")
        field = value
    }

var nameInDatabase: String
    get() {
        return "value from database" // pretend there was a database call here
    }
    set(value) {
        // store value in database
    }

open class Mammal
class Cat: Mammal()
class Dog: Mammal()

fun main() {
    println(nameToLog)

    nameToLog = "Scott"
    println(nameToLog)

    var x: Int = 42  // property declaration - CAN WRITE
    x = 10
    println(x)

    val y: Int = 15 // property declaration - CANNOT WRITE
//    y = 100 CANNOT DO THIS!!!

    println(y)

    var z = 300 // Kotlin can infer that z is an Int based on the value!

    var mammal1 = Cat() // type of "mammal1" is Cat
    var mammal2: Mammal = Cat() // type of "mammal2" is Mammal
    // mammal1 = Dog() // won't work
    mammal2 = Dog()

    println("Hello, world!")
