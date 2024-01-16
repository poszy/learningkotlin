
data class Person(val name: String, val age: Int)

fun main() {
    val people1 = listOf(
            "Scott" to Person("Scott", 55),
            "Mike" to Person("Mike", 15),
            "Claire" to Person("Claire", 25),
    ).toMap()

    val people2 =
            listOf(
                    Person("Scott", 55),
                    Person("Mike", 15),
                    Person("Claire", 25),
            )
                    .map { it.name to it } // it is the object here. b
                    .toMap()

    val people3 =
            listOf(
                    Person("Scott", 55),
                    Person("Mike", 15),
                    Person("Claire", 25),
            ).associateBy { it.name }

    val scottAge = people3["Scott"]?.age ?: -1

    people3.values.forEach { println(it.name) }
    people3.keys.forEach { println(it) }
    people3.forEach { (key, value) ->
        println("$key: $value")
    }
    people3.forEach { (key, value) ->
        println("$key: $value")
    }
