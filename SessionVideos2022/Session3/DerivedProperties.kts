data class Person42(
        val firstName: String,
        val lastName: String
) {
    val name1: String = "$firstName $lastName"
    // has backing field with value - only good if dependent properties are VALS
    // uses memory, but does not have to recompute each time it is called. since it is never changed.

    val name2: String // no backing field, will recompute each value. but takes up less memory
        get() = "$firstName $lastName"
    // good if dependent properties are VARS
    // for assignment, this is how we want to do derived propertie.9
}

// different implementation of derived property
//    update derived value whenever dependent properties change
//    this is good if the derived value is expensive to compute
class Person43(firstName: String, lastName: String) {
    var firstName: String = "" // default initilizer
        set(value) { // set the name when it changes
            field = value
            name = "$firstName $lastName"
        }
    var lastName: String = ""
        set(value) {
            field = value
            name = "$firstName $lastName"
        }
    var name: String = ""
        private set // set to private so noone can change it directly,

    init {
        this.firstName = firstName
        this.lastName = lastName
    }
}


fun main() {
    val person = Person43("Scott", "Stanchfield")
    println(person.firstName)
    println(person.lastName)
    println(person.name)

    person.firstName = "Steve"
}


main()