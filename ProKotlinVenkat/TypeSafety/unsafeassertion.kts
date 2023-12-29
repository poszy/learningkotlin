// the not null assertion operator is "!!"


fun nickName5( name : String?) : String {
    if(name == "William"){ return "Bill"}

    // if we know for sure that there is a non null string we can add !!
    // this will tell the compiler to stand down
    return name!!.reversed().toUpperCase() ?: "Joker"
}

println("Nickname for William is ${nickName5("William")}")
println("Nickname for Venkat is ${nickName5("Venkat")}")
println("Nickname for null is ${nickName5(null)}")

// but what could go wrong? author says to never use it.

// using when. consider using when instead of ? or ?:
// to me this makes the code more readable, if you understand lambdas.
fun nickName (name: String?) = when (name) {
    "william" -> "Bill"
    null -> "Joker"
    else -> name.reversed().toUpperCase()
}
println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
println("Nickname for null is ${nickName(null)}")