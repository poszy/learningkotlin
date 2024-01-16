const val SPECIAL_AGE = 10

data class Person1(
        val name: String,
        val age: Int
) {
    fun checkBirthday() {
        if (age == SPECIAL_AGE) {
            println("Woot!")
        }
    }
}


data class Person2(
        val name: String,
        val age: Int
) {
    val SPECIAL_AGE = 10 // have a separate copy of 10 for EVERY Person instance
    fun checkBirthday() {
        if (age == SPECIAL_AGE) {
            println("Woot!")
        }
    }
}

data class Person3(
        val name: String,
        val age: Int
) {
    val SPECIAL_AGE: Int // cannot access OUTSIDE a Person instance
        get() = 10
    fun checkBirthday() {
        if (age == SPECIAL_AGE) {
            println("Woot!")
        }
    }
}

data class Person4(
        val name: String,
        val age: Int
) {
    companion object { // singleton objects
        const val SPECIAL_AGE = 10 // resolved by compiler - not taking up memory
        // try to avoid writing functions like this
        //    use extension functions instead
        fun isOlder(person1: Person4, person2: Person4) =
                person1.age > person2.age
    }
    fun checkBirthday() {
        if (age == SPECIAL_AGE) {
            println("Woot!")
        }
    }
    // member function
    //   can define/add if have access to source aka "own" the class
    fun isOlder1(otherPerson: Person4) =
            age > otherPerson.age

    // if you don't own it, can't tweak it (unless you fork the codebase)
}

// kotlin allows extension functions
//    only have access to whatever the outside world could see in your context
fun Person4.isOlder2(otherPerson: Person4) =
        age > otherPerson.age

//infix functions allow the function to be called in a more readable format
infix fun Person4.isOlder(otherPerson: Person4) =
        age > otherPerson.age

fun Person4.printNameAndReturnMe() = also { // also takes in the reciever "Person4" and returns the value from the method called.
    println(it.name)
}

fun main() {
    println("The special age is: ${Person4.SPECIAL_AGE}")
    val person1 = Person4("Scott", 55)
    val person2 = Person4("Mike", 24)
    println(Person4.isOlder(person1, person2))
    println(person1.isOlder(person2))
    println(person1 isOlder person2) // infix funciton

    person1
            .printNameAndReturnMe()
            .takeIf { it.age > 10 }
            ?.let {
                // do something with the person if old enough
            }
            ?: run {
                // do something with the underaged person
            }
