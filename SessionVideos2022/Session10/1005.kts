// domain specific languages


// external DSL - separate text file - not compiled by the nrmal language compiler (custom processing)
// internal DSL - using nifty language constructs inside a normal compiled language
//  can also make a domain experts life easier


// our focus is internal DSL

class Person(
        var name : String? = null ,
        var age : Int = 0,
        var address : String? = null,
        var friend : Person? = null,
)

// one way to do things
val person1 = Person()
person1.name="He"
person1.age=54
person1.address="123 se"

val person2 = Person()
person2.name="Hesds"
person2.age=4
person2.address="21212121 se"
person1.friend=person2

// better way to do this with constructor
// but we dont know what the parameters are called
val person3( "Lu" , 22, "my addres", Person("Lus", 32, "friend addres"))

//best way to do this is with named parameters
val person4(  name ="Lu" , age = 22, address = "my addres", friend = Person("Lus", 32, "friend addres"))

        // even better way. this is more readable and shows the structure
val person4(
    name ="Lu" ,
    age = 22,
    address = "my addres",
    friend = Person(
            name = "Lus",
            age = 32,
            address ="friend address"
    )
)

// take advantages of whitespace and lines.

