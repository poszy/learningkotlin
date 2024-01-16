// in kotlin and java, SINGLE superclass
//   (vs C++ which can have multiple superclasses)

// superclass - "is a" relation
//    subtypes ARE a specialization of a supertype

// interfaces define traits
//    "things you can do"  - functions
//    "things you have/describe you"    - properties

interface Actor {
    fun act()
}
interface Driver {
    val make: String
    val model: String // = "Ford" // ERROR! properties cannot have backing fields in interface
    val car: String
        get() = "$make $model"
    fun drive() { // interfaces in kotlin can have default implementations. unlike java. this will allow you not to override this function when implementing. unless it has data parameters.
        println("driving $car using automatic transmission")
    }
}
interface Named {
    val name: String
}

class Person1( // can implement multiple interfaces.
        override var name: String,
        override val make: String,
        override val model: String
) : Actor, Driver, Named {
    override fun act() {
        TODO("Not yet implemented")
    }
}

class StickPerson1(
        override var name: String,
        override val make: String,
        override val model: String
) : Actor, Driver, Named {
    override fun act() {
        TODO("Not yet implemented")
    }

    override fun drive() {
        println("Driving $car using standard transmission")
    }
}

// default implementations in interfaces give us MIX-INS


fun main() {
    val person1 = Person1("Scott", "Honda", "CR-V")
    person1.drive()
    val person2 = StickPerson1("Scott", "Ford", "Probe")
    person2.drive()
}
