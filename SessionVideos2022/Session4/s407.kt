
abstract class Mammal

// check typing with
//  is

// use
// as .. for casting

class Dog(val name: String): Mammal() {
    fun bark() { println("woof") }
}
class Cat(val name: String): Mammal() {
    fun annoy() { println("trip the overlord!!!") }
}

fun mammalStuff(mammal: Mammal) { // parameter - it's a val
    if (mammal is Cat) { // similar to instanceof in Java
        mammal.annoy() // smart cast to Cat
    } else if (mammal is Dog) {
        mammal.bark() // smart cast to Dog
    }

    if (mammal !is Cat) {
        println("it's not a Cat")
    }
    if (mammal !is Dog) {
        println("it's not a Dog")
    }

//    mammal as Cat // might not work - blows up if it's not a Cat

    (mammal as? Cat)?.annoy() // if a Cat, it's a non-null Cat, otherwise null
    (mammal as? Dog)?.bark()

    when (mammal) {
        is Cat -> mammal.annoy()
        is Dog -> mammal.bark()
        else -> {}
    }
}
