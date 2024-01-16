
interface Named {
    var firstName: String
    var lastName: String
    val fullName: String
}

class NameHelper1: Named {
    override var firstName: String = ""
    override var lastName: String = ""
    override val fullName: String
        get() = "$firstName $lastName"
}

class NameHelper2(
        override var firstName: String,
        override var lastName: String
): Named {
    override val fullName: String
        get() = "$firstName $lastName"
}

enum class DegreeLevel {
    Bachelor, Master, PhD
}

sealed interface Degree {
    val level: DegreeLevel
    val concentration: String

    class MastersDegree(override val concentration: String) : Degree {
        override val level: DegreeLevel
            get() = DegreeLevel.Master
    }
    class BachelorsDegree(override val concentration: String) : Degree {
        override val level: DegreeLevel
            get() = DegreeLevel.Bachelor
    }
    class PhD(override val concentration: String) : Degree {
        override val level: DegreeLevel
            get() = DegreeLevel.PhD
    }
}

// explicit delegation - use the helper object to manage the names
// all calls to the "Named" interface functions are passed to the helper
//    helper is called a "delegate"
class Person1a: Named, Degree by Degree.MastersDegree("Computer Science") {
    private val nameHelper1 = NameHelper1()
    override var firstName: String
        get() = nameHelper1.firstName
        set(value) {
            nameHelper1.firstName = value
        }
    override var lastName: String
        get() = nameHelper1.lastName
        set(value) {
            nameHelper1.lastName = value
        }
    override val fullName: String
        get() = nameHelper1.fullName
}

// this is a interface delegation
// does exactly the same as above, but you don't need to explicitly
//    write delegation functions
class Person1b: Named by NameHelper1()

class Person2(
        firstName: String,
        lastName: String,
): Named by NameHelper2(firstName, lastName), Degree by Degree.MastersDegree("Computer Science") {
    init {
        require(firstName.isNotBlank())
        require(lastName.isNotBlank())
    }
}

fun main() {
    val person2 = Person2("Scott", "Stanchfield")
    println("${person2.level} in ${person2.concentration}")
}
