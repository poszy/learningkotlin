// inline classes are transforemed into primitive types at runtime
// for example, should some classes be classes? or be primitives
// social security number is a good use-case
// but a simple social security number being a full blown class can cause ovehead when creating objects

// wiht inline classes you get the benefit of classes at ocompile time, but you get the benefit of the class being transformed into a primitive.


inline class SSN(val id: String )

fun recieveSSN(ssn: SSN){
    println("Received $ssn")

}

recieveSSN(SSN("111-222-2222"))