// abstract classes must be marked abstracted. methods cannot be implemented in the base class


abstract class Musician( val name : String , val activeFrom : Int){ // abstract classes can have many fields, but any class can only extend one abstract class
    abstract fun instrumentType() : String
    abstract fun instrumentType22() // can leave abstract
}

class Cellist(name : String, activeFrom : Int, val someOtherValue : String) : Musician(name, activeFrom) { // the params from Cellist, automatically get sent to the base class musician
    // other params can be passed to Cell list, but have to be decalred val or var
    override fun instrumentType(): String {
        return "string"
    }

    override fun instrumentType22() {
        println(someOtherValue)
    }


}

val ma = Cellist("Yo-Yo Ma", 1961, "someothervalue")

println(ma.instrumentType22())

val d = ma.someOtherValue
println(d)


/**
 *
 *
 *
 *     The properties defined within interfaces don’t have backing fields; they have to rely on abstract methods to get properties from implementing classes. On the other hand, properties within abstract classes can use backing fields.
 *
 *     You may implement multiple interfaces but can extend from at most one class, abstract or not.
 * If you want to reuse state between multiple classes, then an abstract class is a good choice. You can implement the common state in the abstract class and have implementing classes override the methods, while reusing the state provided by the abstract class.
 *
 * If you want multiple classes to abide by one or more contracts or specifications, but you want those classes to choose their own implementations, then interfaces are the better choice. If you choose this route, you may also move some common methods into the interfaces, while still letting the implementing classes choose how they implement the state.
  */


