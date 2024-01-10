// Tenants of Object-Oriented Programming
// *encapuslation
//     - hidng impementaiton details
//     - protecting implementaiton details
// * Inheritance
//     - create specializations of types to add or extend / replace behavior
// * Polymorphism
//     - "Many forms"
//     - "overloading functions/methods , same name, different parameters types ... that is having  multiple functions with the same name, but are seperable due to their function signature
//     - overriding functions / methods
//     -  in syubclass, same signature different behavior

open class A { // class A constructor is inline here, even though we did not specify it
    open fun foo(n : Int){ println(n)}
}

class B : A(){
    override fun (){ // override funciton to change behavior
        // when an instance of B is called. this funciton will be called

        // if we want to call the foo() from A. we can us super
        super.foo(n + 42)

    }
}



var penutButterAmount = 32
fun spreadPB( amount : Int){
    penutButterAmount -= amount
}