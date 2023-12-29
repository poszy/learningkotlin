import javax.print.attribute.standard.MediaSize.Other

// checking for runtime type is useful and unavoidable in two situations. One is in the implementation of the equals()
// method—we need to know if the instance at hand is of the current class.
// The other is within when, if the path to take depends on the type of an instance.

// again all kotlin classes extend form the Any class and the kotlin == operator maps to the equals() function.

// ovveride the equal method. wants to treat all Animal instances as being equal. but the parameter is Any? .
// due to the signature of the method being ovveridden from any, since any is not an instance oof animal it will return false
class Animal{
    // any type of object goes into the parameter and then is checked if it is of type animal.
    override operator fun equals(other: Any?) = other is Animal
}

// the is operator is used to check if the object pointed to by a reference, "other in this case" is of a particular type
// "animal in this case"

val greet : Any = "hello"
val odie : Any = Animal()
val toto: Any = Animal()

println(odie == greet) // false
println(odie == toto) // true
