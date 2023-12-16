fun greet(
    name:String,
    msg : String="Hello")
    : String = "$msg $name" // returning string

// having default argument makes the code flexable. since there is no reason to
// overload functions.
println(greet("Eevee")) // hellow eevee
println(greet("Eevee", "howdy")) // howdy eevee

// use lambdas as the last parameter.

// the proper way to do it

fun gree(
    name : String,
    msg: String = "hi ${name.length}")
    = "$msg $name" // setting function to a string.


println(gree("Luis", "Howdy")) // howdy luis
println(gree("Luis")) // hi 4 Luis
