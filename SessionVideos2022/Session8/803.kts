// Decorater and Adapter patterns
// Decorator - use the same interface, but tweak the implementation
//    can tweak parameters and/or return values

// adapter, use a different interface.
interface Person {
    val name: String
    val age: Int
}

data class RealPerson(
        override val name: String,
        override val age: Int
) : Person

class Doctor(
        private val person: Person
): Person {
    override val name: String
        get() = "Dr. ${person.name}" // this is delegation
    override val age: Int
        get() = person.age

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Doctor

        if (person != other.person) return false

        return true
    }

    override fun hashCode(): Int {
        return person.hashCode()
    }

    override fun toString(): String {
        return "Doctor(name='$name', age=$age)"
    }
}

class YouthPotion(
        private val person: Person
): Person {
    override val name: String
        get() = person.name
    override val age: Int
        get() = person.age - 10

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as YouthPotion

        if (person != other.person) return false

        return true
    }

    override fun hashCode(): Int {
        return person.hashCode()
    }

    override fun toString(): String {
        return "YouthPotion(name='$name', age=$age)"
    }
}

fun main() {
    val person = RealPerson("Scott", 55)
    val doc = Doctor(person)
    val explorer = YouthPotion(person)
    val both = YouthPotion(doc)

    doSomething(person)
    doSomething(doc)
    doSomething(explorer)
    doSomething(both)

    doSomethingWithThing(ThingAdapter(person)) // using a person with an adapter and now its a thing.
    doSomethingWithThing(ThingAdapter(doc))
    doSomethingWithThing(ThingAdapter(explorer))
    doSomethingWithThing(ThingAdapter(both))
}

fun doSomething(person: Person) {
    println(person)
}

interface Thing {
    val identifier: String
}

data class ThingAdapter(
        private val person: Person
): Thing {
    override val identifier: String
        get() = "${person.name}:${person.age}" // basically pass in a person and adapt it to the thing. translate. what a person means in terms of a thing
    // allows us to pass it into methods that take in a thing.
}
fun doSomethingWithThing(thing: Thing) {
    println(thing.identifier)
}
