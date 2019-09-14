
abstract class Animal {

    // Abstract classes are used when class behaviors don't make sense
    // unless they are implemented by a more specific subclass.

    // you cannot initialize an abstract property (add value)
    abstract val image: String
    abstract val food: String
    abstract val habistat : String

    // Abstract properties and functions don’t need to be marked as open.
    abstract fun makeNoise()
    abstract fun eat()


    // If you mark a property or function as abstract, you must mark the class as abstract too.
    // Abstract properties and functions define a common protocol so that you can use polymorphism.
    // Abstract functions are useful because even though they don’t contain any actual function code,
    // they define the protocol for a group of subclasses which you can use for polymorphism



}

class Hippo : Animal(){

    // Abstract class must have all properties and methods overwritten.
    override val image: String = "hippo"
    override val food: String = "grass"
    override val habistat: String = "water"

    override fun makeNoise() { println("Grunt")}
    override fun eat() { println("The Hippo is eating $food")}

}