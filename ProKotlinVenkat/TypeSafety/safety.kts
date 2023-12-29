// kotlin adds saftey time at compile time. no extra bytecode is added
// this is done by adding a ? in front or a property just in case it might be null.
// this is calle design by contract. this makes a function or method that may return a null reference  to do a null check
// kotlins inherift from the Any class, similar to java object class.

// Any the base class. the purpose is to privide us with methods like equals hasCode and toString, to(). can be called on any type in kotlin.
// Any maps to Object in java. they are not identicle.
// Any has extension functions like let(), run(), apply(), and also()

// in java we use void to when a function does not return a value
// in kotlin, we use Unit
// Nothing in kotlin, return nothing. ithas no instances and represents a value or result that will never exist.

// if returns a double
// else throws and exception
// the exception part is represented by the type Nothing.
// the compiler can determine the return type of the if expression, to be a double type.
// so the sole purpose of Nothing is to eb able to help the compiler verify that the integrity of the program is okay.
fun compute( n : Double) : Double {
    if ( n >= 0){
        return Math.sqrt(n)
    }else{
        throw RuntimeException("NO negatives")
    }
}

