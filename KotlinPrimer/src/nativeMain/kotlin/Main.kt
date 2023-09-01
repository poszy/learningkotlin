fun addtwo(a: Int, b: Int): Int {

    return a + b
}

fun sum(a: Int, b: Int) = a + b // the return type here is inferred ; no need for curly braces or return statement. k just knows

fun unitReturn (s: String) : Unit {
    println (s) // with unit the return statement is optional.
}

//Kotlin runs on JVM, JS, Native, Android, IOS, anywhere java runs
// Object Oriented OR Functional
// Pure functions -> parameters immutable, no side effects, idempotent
fun main() {
    println("Hello, Kotlin/Native!")
     val c  = addtwo(1,2)
    println(c)

    val s = sum(2,3)
    println(s) // s

    val str = unitReturn("This will still print out")
    unitReturn("this is valid")

    val person = Person()
    person.name = "luis"
    person.age = 30
    println(person.toString()) // default will print out object
}

