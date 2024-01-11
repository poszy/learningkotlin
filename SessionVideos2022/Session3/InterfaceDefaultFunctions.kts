interface NamedEntity {
    val firstName: String
    val lastName: String
    val name: String
        get() = "$firstName $lastName"
    fun printHello() { // default implementaitons
        println("Hello")
    }
}

class Person55( // can set in params
        override val firstName: String,
        override val lastName: String
) : NamedEntity

class Person56: NamedEntity { // can also ovveride them inside the body
    override val firstName: String = ""
    override val lastName: String = ""
}

class Doctor: NamedEntity {
    override val firstName: String = ""
    override val lastName: String = ""
    override val name: String
        get() = "Dr. $firstName $lastName"

    override fun printHello() {
        println("Greetings and Salutations!")
    }
}

// better than...
//interface NamedEntity {
//    val firstName: String
//    val lastName: String
//    val name: String
//}
//
//class Person55(
//    override val firstName: String,
//    override val lastName: String
//) : NamedEntity {
//    override val name: String
//        get() = "$firstName $lastName"
//}
//class Person56(
//    override val firstName: String,
//    override val lastName: String
//) : NamedEntity {
//    override val name: String
