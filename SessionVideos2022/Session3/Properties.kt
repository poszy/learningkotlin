
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


}