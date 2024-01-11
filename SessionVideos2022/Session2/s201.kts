

fun main(){

}

fun createNumberOfString(numberOfthingsToPrint : Int) : String {

    var result = ""
    for (n in 1..numberOfthingsToPrint) {
        // .. is inclusive, so it will include the 1 and include the actual number of things to print. .. 1 thorugh 10
        // using UNTIL is exclusive. it will include 1 but exclude the last number of things to print, in this case 1 through 9
        result = "$result$n "
    }

    return result
}

fun printStringOfNumbers(numberOfthingstoPrint : Int) : Unit { // uni tis like void
    val numberString = createNumberOfString(numberOfthingstoPrint)

    println(numberString)

}


fun getNumberOfThingsToPrint() : Int { return 5}

// short hand way in kotlin, its the same as doing the function fun getNumberOfThingsToPrint() : Int { return 5}

fun getNumberOfThingsToPrint2() : Int = 5 // will return five just like fun getNumberOfThingsToPrint() : Int { return 5} . we doing need the brackets or return statement.

fun getNumberOfThingsToPrint3() = 5 // we can even omit the Int, with kotlin inferring. this only works for single expresions.

printStringOfNumbers(getNumberOfThingsToPrint3())


fun createStringOfNumbers2(numberOfThingsToPrint : Int) : String {
    if (numberOfThingsToPrint == 1)
        return "1"
    else
        return createStringOfNumbers2(numberOfThingsToPrint - 1) + " " + numberOfThingsToPrint
}

println(createStringOfNumbers2(10))

fun factorial(n : Int) : Int {
    if(n == 0 || n ==1) { return 1}
    else{ return factorial(n-1) * n}
}
// In Kotlin, the tailrec keyword is used to indicate that a function is tail-recursive.
// Tail recursion is a specific form of recursion where the recursive call is the last operation performed in the function.
// This optimization allows the Kotlin compiler to optimize the recursion into an iterative loop,
// which can result in improved performance and avoids stack overflow errors for deep recursive calls.

tailrec fun factorial2( n : Int, answerSoFar : Int) : Int { // answer so far is an accumulator
    if(n == 0 || n ==1){ return answerSoFar }

    return factorial2( n -1, answerSoFar * n)
}

println(factorial2(3, 1)) //6

tailrec fun factorial3( n : Int, answerSoFar : Int) : Int { // answer so far is an accumulator
    if(n == 0 || n ==1){ return answerSoFar }

    return factorial2( n -1, answerSoFar * n)
}


tailrec fun createStringOfNumbers3(numberOfThingsToPrint : Int, answerSoFar : String) : String {
    if (numberOfThingsToPrint == 1)
        return "1 $answerSoFar".trim()
    else
        return createStringOfNumbers3(
            numberOfThingsToPrint -1,
            "$numberOfThingsToPrint $answerSoFar"

        )
}

println(createStringOfNumbers3(4, ""))

// not a good design for a Location
open class Location private constructor( // with this private constructor, we are forced to call one of the two bottom constructors. its a way
        // of making a class a bit more flexible, but you can use default values instead. user needs to pass lat and lon or the street,city,state,zip
        val lat : Double,
        val lon : Double,
        val street : String,
        val city : String,
        val state : String,
        val zip : String
) {
    constructor(lat: Double, lon: Double): this(lat, lon, "", "", "","")
    constructor(
            street : String,
            city : String,
            state : String,
            zip : String
    ): this(0.0, 0.0, street, city, state, zip)
}



