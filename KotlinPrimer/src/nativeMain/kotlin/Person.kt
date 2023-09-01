

class Person { // all classes in kotlin are public by default, properties and variables as well

    // this class is equivalent to the Person class in java.
    // Kotlin automatically assigns getters and setters for each property (name, age ) etc..
    // everything in kotlin if final by default. so we cannot subclass this.
    // so to subclass we would have to change the class definition to "open class person {}

    // Properties
    var name: String ="" // VAR - has a setter and getter - can be requested to be changed "MUTABLE"
    var age : Int = 0

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }
    // Other ways to set up properties



    // however these are the implicit definitions of set and getters // notice the yellow warning is saying redundant get and set, because it automatically does it
    var nameX: String  = ""
        get(){ return field} // "backing field" is magic variable that will return nameX in this case. field returns the vars name
        // with a backing field, the variable has to be initialized, which is why we set nameX to an empty string
        set(value){ field = value} // this will set field (nameX) = value


    // properties without backing fields are called "derived properties" because you get the data from somewhere else.

    var nameY : String // has no backing field and does not have to be initialized
        get(){ return "foo"} // implicit getter look like this
        set(value) { } // do nothing , no backing field mentioned

    var ageX : Int = 0



}