package org.example.Misc

data class Person2( // at least one param is needed for the constructor
    var name : String,
    var age : Int,
    var bloodType: BloodType
){
    // data classes cannot be extended. final class.
    // this creates an equal(), copy() component1.2.3 . tosTring()

    // variables inside body, will not have methods generated
    var address : String? = null
}

data class Result(val x : Int, val y : Int)
fun getPoint() = Result(10,220)
// Tripple is a built in dataclass.
fun getTripple() = Triple(10,20,30)

class Test2{
    companion object{
        @JvmStatic
        fun main( args : Array<String>){
            // what are component functions? it has to do with decompisition
            // the params can be extraced in order
            val p = Person2("name", 51, BloodType.O)
            val (name, age) = p  // so each param becomes a component.
            println(name)
            print(age)

            val(x,y) = getPoint()
            val(x1,y1,z1) = getTripple()

            // we can also copy with built in function. this will copy all the data and only ovverride was is passed in as named arguments
            val p2 = p.copy(name = "new name/")
            val p3 = p.copy(name = "new name/")

            println(p2 == p3) // this is .equals() , checks values
            println(p2 === p3) // this is checks if its the same object
        }
    }
}