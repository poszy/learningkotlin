// Triple and Pair are tuples in kotlin

fun getFullName() = Triple("John", "Quincy", "Adams")

// This is the old way of doing things
val result = getFullName()

val first = result.first
val second = result.second
val third = result.third

println("$first $second $third")

// This is the "kotlin" way. destructuring
val (f, middle, last) = getFullName()
println("$f $middle $last")

val (ff, _, ll) = getFullName()
print("$first $last")

val (_,_,ss) = getFullName()
println("$ss")

val (_, mmm) = getFullName()
println(mmm)

// destructing can only be used with types that have built in
// descrutering helper methods. such as tuples and maps.