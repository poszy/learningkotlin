// sealed classes are more flexiable thatn enum classes, because our methods and vars can vary instead of
// them all having the same properties.


// this is problematic - cannot have data class subtypes with the shared properties
//sealed class Mammal1(
//    val name: String
//)
//
//data class Human1(name: String) : Mammal1(name)


sealed interface Mammal {
    val name: String
}

object Seymour: Mammal {
    override val name = "Seymour"
    fun sing() {
        println("Poor! All my life I've always been poor!")
    }
}


data class Human(
        override val name: String,
        val nickname: String
): Mammal

data class Cat(
        override val name: String
): Mammal {
    fun meow() {
        println("meow")
    }
}

data class Dog(
        override val name: String
): Mammal {
    fun bark() {
        println("le woof")
    }
}

// data class DataPlatypus: DataMammal // Error! Cannot extend sealed class/interface from diff module

fun main() {
    // pretend we're not using the data module
    //    just used it as an example of trying to extend a sealed interface from a different module
    //    val dataHuman = DataHuman("Scott")

    // using sealed classes/interfaces

    val mammal = Human("Scott", "Scooter")


}

//var mammal: Mammal = Human("A", "B")

fun useMammal(mammal: Mammal) {
    val result = when (mammal) {
        is Cat -> {
            mammal.meow()
            42
        }
        is Dog -> {
            mammal.bark()
            10
        }
        is Human -> {
            println(mammal.nickname)
            5
        }
        Seymour -> {
            Seymour.sing() // TODO look at this - why not smart cast???
            9
        }
    }
}
