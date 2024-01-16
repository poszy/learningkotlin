
// NULL OBJECT PATTERN
// use this pattern instead of checking if an object is null all the time. we can just return an empty object if our chekcs dont return values
data class Person(val name: String, val age: Int)

val nullPerson = Person("", 0)

fun lookupPerson(name: String): Person {
    return nullPerson
}

val emptyList = emptyList<Person>() // VERY useful null object

fun lookupPeopleNamed(name: String): List<Person> {
    return emptyList
}

fun main() {
    when (val person = lookupPerson("Scott")) {
        nullPerson -> { /* report person not found */ }
        else -> { /* do something with the person */ }
    }

    lookupPeopleNamed("Scott")
            .forEach {
                // do something with the people
            }

    when (val people = lookupPeopleNamed("Scott")) {
        EmptyPersonList -> { }
        else -> { }
    }

    lookupPeopleNamed("Scott")
            .takeIf { it != EmptyPersonList }
            ?.let {
                // do something with it
            }
//        ?: run {
//            // do something when empty
//        }


}

object EmptyPersonList: List<Person> by emptyList()

