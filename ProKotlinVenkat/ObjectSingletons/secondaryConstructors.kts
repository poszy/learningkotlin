// without a primary constructor, kotlin creates a default no argument constructor.

// if you have a constructor with arguments, then kotlin creates a no argument constructor
// but we can defined as much as we need.


class Person(val first: String, val last : String){

    // secondary constructors must call the primary constroctur or one of the other secondary constructors
    // secondary construtores paramerts cant be declared with val or var. onlyt he primary constructor

    var fulltime = true
    var location : String = "-"
    constructor(first: String, last: String, fte: Boolean) : this (first, last){
        fulltime = fte
    }

    constructor(first: String, last: String, loc: String): this(first, last, false) {
            location = loc
    }

    // using this, the second constructor calles the frist constructor, this(parameters) and then addes the third.

}

println(Person("Jane", "Doe"))
println(Person("John", "Doe", false))
println(Person("Baby", "Doe", "home"))