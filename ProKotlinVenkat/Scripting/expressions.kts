fun canVote (name : String, age: Int) : String {
    var status : String


    if(age > 17){
        status = "yes, please vote"
    }else {
        status = "nope, please come back"
    }
    return "$name, $status"
}

println(canVote("Eve", 12))

// Instead of having a funciton definition, we can have a one liner,
val age = 18
val name = "Luis"
val status = if (age > 17 ) "Yes , $name please vote" else "nope, please come back" // this can also be placed into the funciton
//return "$name, $status"
println(status)

fun canVote2 (name : String, age : Int) : String {
    // here we use val instead of var and we dont have to mutate the var or set it explicitly.
    // makes the code more readable.
    val status = if (age > 17 ) "Yes , $name please vote" else "nope, please come back"
    return "$name, $status"
}
println(canVote2("Eevee", 100))

fun tryBlock ( tf : Boolean) : Int {
    return try {
        if(tf){
            throw RuntimeException("Fail")
        }
        2

    } catch (ex: Exception){
        4
    } finally {
        println("HMMM") // always gets printed first.
    }

}

println(tryBlock(false)) // 2
println(tryBlock(true)) // 4