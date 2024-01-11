
open class Mammal
open class Person {
    var name : String = ""
    var age : Int = 0
}



// do not write constructors like this

open class Person2 (name : String, age : Int){ // since parameters are vals, they cannot be reassigned. so you are forced to rename them.
    var name : String
    var age : Int

    // since the param names and the variable names are the same, we have to initilize them in the init block
    init { // constructor body
        // cannot do this, its ambigous. so we have to rename the vars in the parameter. which adds complexity to the code
        // name = name
        // age = age

        //  name = namex
        //  age = agex

        // or we can se this
        this.name = name
        this.age = 55

    }
}

open class Person3(var name : String, var age : Int) // this does the same thing as Person2. primary constructor defines all the set and get methods. but it cannot override get/set.

open class Person4( var name : String, var age : Int){
    override fun toString(): String {
        return "Person4(name='$name', age=$age)"
    }
}

// data classes will genereate toString() hjasCode() equals() copy(). no need to override
// also componentN() ... componentN(), where each N is a parameter. in order
data class Person5(val name: String, val age : Int) // in this case Component 1= name

open class Mammal (var name : String)
open class Cat (name : String) : Mammal(name)


abstract class Mammal (var name : String) // cannot create instances of abstract classes.
open class Cat (name : String) : Mammal(name)



open class someFoosubclass : Foo1 (){}
// abstract class - cannot create instances
//    if class has abstract functions or properties, class MUST be abstract
abstract class Foo1 {
    abstract fun foo()
    abstract val name: String
}

open class SomeFooSubclass1(override val name: String) : Foo1() {
    override fun foo() {
        TODO("Not yet implemented")
    }
}

fun main(args : Array<String>){
    // Person person = new Person()
    val person = Person()// with val, the reference to this person objec will never change
    person.name = "Luis"
    person.age  = 55

    println(person.name)
    println(person.age)
    println("-------------------------")


    val person4 = Person4()// with val, the reference to this person objec will never change
    person4.name = "Luis"
    person4.age  = 55

    println(person4)
    println("-------------------------")


    // so we can use deconstruction like this with componentN()
    val person5 = Person5("luis", 30)
    val (name,age ) = person5


    // can use dconstruction like this too.
    val string = "a:b:c"
    val (letter1, letter2,l letter3) = string.split(":")




    var b = Mammal("wubby")
    println(b.name)

    var bb = Cat("tubby")
    println(bb.name)
    println(b.name)
}

interface Terminator { // an interface is an even more 100% abstract class
    // all functions by default are abstract
    fun sayIllBeBack()
    fun sayAreYouSarahConnor()
}

class Ahnold: Terminator { // must override all methods in the interface. a contract
    override fun sayIllBeBack() {
        println("Ahh be bach")
    }
    override fun sayAreYouSarahConnor() {
        println("ah yew sa-aa conn-uh")
    }
}

class PeeWee: Terminator {
    override fun sayIllBeBack() {
        println("Ahhhhhhhh")
    }
    override fun sayAreYouSarahConnor() {
        println("Ahhhhhhhh")
    }
}

fun terminatorScript(
        terminator: Terminator
) {
    terminator.sayAreYouSarahConnor()
    terminator.sayIllBeBack()
}

