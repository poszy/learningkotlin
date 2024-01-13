// !! expresion


data class Person(val name: String)

class Stuff {
    private var person: Person? = Person("")

    fun foo() {
        if (person != null) {
            println(person!!.name) // trusted but verified at runtime
            // ALMOST NEVER USE THIS!!! Use ?. instead
        }

        // better alt to !!
        println(requireNotNull(person).name)
        println(requireNotNull(person) { "oops - person not set" }.name)
    }
}
