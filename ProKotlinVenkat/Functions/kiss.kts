// functions are expressions can be defined as such

// Kotlin can infer the return type of functions with a non-block body—that is, functions without {}. The return type inference happens at compile time
fun greet() = "Hello"

println(greet())

// this is confirmed by trying to change the return type
// val message : Int = greet() // error

// return type can also be set
fun greet2() : String = "Hello2"
println(greet2())