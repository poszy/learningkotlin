package org.example.Functions

// extention functions and standard functions and streams

class Person {
    var name: String? = null
    private var name2: String? = null
    internal var name3: String? = null // variables are available inside the same module.
    var age: Int = 0
    var address: Address? = null

    // here we can create a new person object and assign values to it, without needing to use the obj syntax
//    val father = Person().apply {
//        name = " dad"
//        age = 32
//    } // this will be recursive forever, to fix this, we can use lazy

    val father by lazy {
        Person().apply {
            name = " dad"
            age = 32
        }
    } // this makes sure father gets initlized only when it gets called.

    inner class Nickname {
        var name : String ? =null
        fun foo() { this@Person.name = "this"}
    }

}

class Address {
    var street : String ? = null
    var city : String ? = null
    var state : String ? = null
}

// to create an extension function, set the class name infront of the function name
fun Person.introduceSelf(){ // resolved at compile time. no polymorphism these methods get called on the Person class not the subclasses.

    println(name) // this name comes from the person class. the function has an implied this passed into it
    // from the reciever, aka the Person class
    // cannot access private vars
    //println(name2)
    println(name3)


}

// The Person.() -> Unit syntax denotes an extension function type with a receiver.
//It means that the lambda expression (f) can be called as an extension function on an instance of the Person class
fun doSomething( person : Person, f : Person.() -> Unit) {
    person.f()
}
// this makes more sense, remember, when we pass the function, it gets implemented in the method
// his function is similar to doSomething but with a different lambda syntax.
//It takes two parameters:
//
//    person: An instance of the Person class.
//    f: A lambda expression that takes a single parameter of type Person and has a return type of Unit.
//
//Inside the function, the lambda f is called with the person object as an argument.
fun doSomething2(person : Person, f : (Person) -> Unit) { // the lambda is basically a function f(param) that gets called.
    f(person)
}

fun main () {
    val person = Person()
    person.introduceSelf()

    doSomething(person) {
        println(name)
    }

    doSomething2(person) {
        println(it.name) // since there is only one parameter, we can use it. it = person,
    }

    // or we can rename the parameter
    doSomething2(person) { person ->
        println(person.name) // since there is only one parameter, we can use it.
    }

    // we use a with block to avoid writting code like this.
    /* person.name = "Scott"
    person.age = 51
    person.address = Address()
    person.address?.street = "asd"
    person.address?.city = "ann arbor"
    person.address?.state = "ca"*/
    with(person) {
        name = "Scott"
        age = 51
        address = Address()
        with(address) {// since an address was not initialized before, we have to add nulltype safey .. we can also add !! to address
            this!!.street = "asd" // we can set !! on the top var and the rest get smart casted.
            this.city = "ann arbor"
            this.state = "ca"

            /*
            * !! tells the compiler I am certain the expression is non-null.
            * since we set This!!.city directly we know its not null.
            * */
        }

        with(address!!) {
            street = "asd" // even more smart casting.
            city = "ann arbor"
            state = "ca"
        }

        // an extention function that takes in the object as a reciever. since its an extension funciton we can add a ?
        // when we have a reciever on a lambda, it means we can use this, to access the members of the class.
        person.apply {
            name = "Scott"
            age = 51
            address = Address()
            address!!.apply {
                street = "123 sesame"
                city = "Thjis"
                state = "sadsa"
            }
        }

        /*
        * Differences
        *  Return Type:
        with: Returns the result of the lambda expression.
        apply: Returns the receiver object itself.

        Usage:
        with: Used to operate on an object within a block. It doesn't change the receiver object; it's just a way to avoid repeating the object's name.
        apply: Used to configure properties of an object. It allows concise and idiomatic initialization of an object.
        * */
    }

    // we can initialize variables at the same time.
    // apply takes in a reciever and returns the same reciever using this
    person.apply {
        name = "Scott"
        age = 51
        address = Address().apply {
            street = "123 sesame"
            city = "Thjis"
            state = "sadsa"

        }
    }

    // The run extension function in Kotlin is used to execute a block of code on an object and return the result of that block. It is similar
    // to the let extension function but with the receiver object as the context for the lambda expression. it returns this instead of it
    person.run {
        name = "Scott"
        age = 51
        address = Address().apply {
            street = "123 sesame"
            city = "Thjis"
            state = "sadsa"
            this@run.name = "" // can access person members this way.


        }
    }
    val person2: Person? = Person()


    /* In this block, the person2?.name expression is checked for nullability. However, even if it's not null at the time of the check, there is no guarantee that it won't become null before foo(person2.name) is executed. This is due to the possibility of another thread modifying the person2 object concurrently, leading to a race condition.

    The smart cast to 'String' is impossible because the Kotlin compiler is not able to guarantee the safety of the cast when dealing with mutable properties that could be modified by other threads between the null check and the usage
    */
//    if (person2?.name != null) {
//        foo(person2.name) //Smart cast to 'String' is impossible, because 'person2.name' is a mutable property that could have been changed by this time
//        // this means this is not thread safe.
//    } else {
//        fee()
//    }

    // In this block, the name property is assigned to a local variable before performing the null check. This ensures that even if another thread modifies the person2 object concurrently, it won't affect the local variable name.
    // The smart cast to 'String' is possible because the compiler can now track the local variable and its nullability throughout the block.
    //By assigning the property to a local variable, you create a snapshot that is stable within the scope of the block, making it thread-safe.
    val name = person2?.name // this points to person2 name and assigning it to a new variable. so even if person2.name is changed. name will not change.
    if (name !== null){
        foo(name)
    } else{ fee()} // this is equvilant to the elvis operator down below

    // or what we can do is use let. let will grab the variable if its not null and create a local copy via it
    // let, unlike run, returns it.
    person2?.name?.let{// if person not null, if name not null. if there is a name. copy it to it.
        foo(it)
    }

    // this is thread safe
    person2?.name?.let { n->
        foo(n)
    }

    // combine with elvis operator. for maximum kotlin experience
    person2?.name?.let { n->
        foo(n)
    } ?: fee()

    val x = person2?.name?.run{
        foo(this)
    } ?: fee()

    val y = person2?.name?.run{
        foo(this)
    } ?: fee2()

    println(y) // when a lambda has an option to return multiple types, a Any object will return. so Y is of type Any

    val z = if(person2 != null) {
        b()
    } else {
        c()
    }

    println(z) // of type AAA . it will be of type superclass

    // also is like run, except you can rename it to a prefix. it also returns the reciver objects which is person2
    person2?.also { p->
        fee()
    }

    val foo = person2?.also {
       b()
    }.also {
        c()
    }

    val f1 : (Person) -> Unit ={ b()}
    val f2 : (Person) -> Unit ={ c()}

    person2?.also(f1)?.also(f2)

}

fun fee2(): Int { return 23}
fun foo ( name : String): String { return "thjis"}
fun fee(): String { return "thssaldsk"}

open class AAA // class must be open to inherit from
open class BBB : AAA()
class CCC : BBB()
fun b() = BBB()
fun c () = CCC()