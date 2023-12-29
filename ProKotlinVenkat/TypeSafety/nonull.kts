// if a java method returns an object, ends up returning null, then a null pointerexception happens, if ther eis no null check.

//assigning null to a non-nullable reference or returning null where the reference type is non-nullable will result in a compilation error

fun nickName(name :String) : String {
    if(name == "William"){ return "Bill"}

    // cannot do this
    //return null
    return ""
}

println("Nickname for William is ${nickName("William")}")
println("Nickname for Venkat is ${nickName("Venkat")}")
// cannot do this .. cannot even compile.
//println("Nickname for null is ${nickName(null)}")

// using nullable types
// Where the type is a non-nullable reference, you can pass only a valid reference that is non-null.
// However, you may pass either a valid reference or a null to a nullable reference type.
// we can return null by adding "?" to the end of the return type and the parameter we can return null

fun nickName2( name : String?) : String? {
    if(name == "William"){ return "Bill"}
    return null
}

println("Nickname for William is ${nickName2("William")}")
println("Nickname for Venkat is ${nickName2("Venkat")}")
// can do this
println("Nickname for null is ${nickName2(null)}")

// what we canno do is, perform an operation on the variable without null checking, the method above will only allow the function to accept and return nulls
fun nickName3( name : String?) : String? {
    if(name == "William"){ return "Bill"}

    // cannot do this, since we do not check for null
    // return name.reversed()
    // we can have an if statement
      //if(name != null ){ return name.reversed()}

    // or we can one line it.
    //  return name?.reversed()
    // or even function chain
    return name?.reversed()?.toUpperCase()

    // the ? is called the safe-call operator and will return null if the target is null
}

// elvis operator
fun nickName4( name : String?) : String {
    if(name == "William"){ return "Bill"}


    val result = name?.reversed()?.toUpperCase()

    return if (result == null) "joker" else result // this function always returns a non-null type, so we dont have to add the ? to the return type

}

println("Nickname for William is ${nickName4("William")}")
println("Nickname for Venkat is ${nickName4("Venkat")}")
println("Nickname for null is ${nickName4(null)}")

fun nickName5( name : String?) : String {
    if(name == "William"){ return "Bill"}


    //val result = name?.reversed()?.toUpperCase()
   // return if (result == null) "joker" else result // this function always returns a non-null type, so we dont have to add the ? to the return type
    // we can eliminate the two lines of codes
    return name?.reversed()?.toUpperCase() ?: "Joker"

    // this means, returns whats on the left, if its not null, other wise, if its null. return "joker"
}
