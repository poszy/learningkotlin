
// all functions are public/final by default.
// cannot override


fun createStringOfNumbers2(numberOfThingsToPrint : Int) : String {
    return if (numberOfThingsToPrint == 1) { // can have a single return statement
        "1"
    }
    else {
        createStringOfNumbers2(numberOfThingsToPrint - 1) + " " + numberOfThingsToPrint
    }
}


fun ternary1(){
    val x = 10
    println(if (x < 100) "less" else "more") // if is an expression
}

// we can infer the type and set the function equal to an expression. must be the same thing.
fun createStringOfNumbers2a(numberOfThingsToPrint : Int) =
     if (numberOfThingsToPrint == 1) { // can have a single return statement
        "1"
    } else {
        createStringOfNumbers2(numberOfThingsToPrint - 1) + " " + numberOfThingsToPrint
    }

// if we have more than 1 type that can possibly be returned, it cannot be infered, so it will come back as Any
fun createStringOfNumbers2Bad(numberOfThingsToPrint : Int) =
    if (numberOfThingsToPrint == 1) { // can have a single return statement
        1
    } else {
        createStringOfNumbers2(numberOfThingsToPrint - 1) + " " + numberOfThingsToPrint
    }


tailrec fun createStringOfNumbers3(numberOfThingsToPrint : Int, answerSoFar : String) : String =
    if (numberOfThingsToPrint == 1)
        "1 $answerSoFar".trim()
    else
        createStringOfNumbers3(
            numberOfThingsToPrint -1,
            "$numberOfThingsToPrint $answerSoFar"

        )

fun factorial(n : Int) : Int =
    if(n == 0 || n ==1) {
        1
    }
    else{
        factorial(n-1) * n
    }

fun drawBox10x10(x: Int, y: Int, drawBorder: Boolean, borderWidth: Int, fillBackground: Boolean) {

}



// named parameters for more visibility
drawBox10x10(
    x = 10, y = 10,
    drawBorder = true,
    borderWidth = 2,
    fillBackground = true
)

drawBox10x10( // can be in any order
    borderWidth = 2,
    fillBackground = true,
    x = 10, y = 10,
    drawBorder = true,
)

fun drawBox10x102(x: Int, y: Int, drawBorder: Boolean = true, borderWidth: Int = 2, fillBackground: Boolean = true) { /// default values can save code.

}
drawBox10x102( // can be in any order

    x = 10, y = 10,

)

class foo{

    // jvmoverloads helps java files implementing this kotlin method. Since java needs to overload methods to have a default argument type sitaution. java does not have this. so jvmoverload will create the methods and give them to the java
    @JvmOverloads
    fun drawBox10x102(x: Int, y: Int, drawBorder: Boolean = true, borderWidth: Int = 2, fillBackground: Boolean = true) { /// default values can save code.

    }
}

// now this class can be inherhited or overided
open class foo{

    // jvmoverloads helps java files implementing this kotlin method. Since java needs to overload methods to have a default argument type sitaution. java does not have this. so jvmoverload will create the methods and give them to the java
    @JvmOverloads
    fun drawBox10x102(x: Int, y: Int, drawBorder: Boolean = true, borderWidth: Int = 2, fillBackground: Boolean = true) { /// default values can save code.

    }
}