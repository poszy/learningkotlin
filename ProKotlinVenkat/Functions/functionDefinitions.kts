// caveat.kts


fun f1 () = 2
fun f2 () = {2} // dont do this
fun f3 ( factor : Int) = {n: Int -> n * factor}

println(f1())  // valid
println(f2()) // () -> kotlin.int returns the type. kotlin cannot infer the type if its wrapped in brackets. a lambda is returned that takes in zero parameters.
println(f2()())  // 2
println(f3(2)) // kotlin.int -> kotlin.Int. this takes in a parameter factor. and also the lambda takes in another parameter called n. since only one parameter is specified, it will return the kotlin type int and the lambda type.
println(f3(2)(3)) // 6

// do not use = when defining a function with a block body {}
// You will not have any friend this way.