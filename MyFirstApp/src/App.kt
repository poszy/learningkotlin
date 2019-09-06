
fun main (args: Array<String>){


    // var for variables that are mutable
    var x = 3

    // val for variables that are immutable
    val name = "Cormoran"

    // No semi colons required.
    x = x * 10

    // Comments are the same
    // can access variable contents with dollar sign, like bash. no need for string concat.
    print("x is $x");

    //while loops

    while (x > 20){
        x = x -1
        // will print line by line
        println("x is now $x")
    }

    // for loop
    for ( i in 1..10){
        x = x + 1
        // will print everything in one line
        print(" x is now $x" )
    }

    // conditionals

    if (x == 20){println("x must be 20")}else{println("x is not 20")}
    if (name.equals("Cormoran")){println("$name Strike")}

    // REPL
    // Read- Eval- Print- Loop
    // interactive shell Can be used to debug short code snippets similar to ipython
    // JEtBrains Inteliji -> Tools -> Kotlin -> Kotlin REPL

    /*
    * Variables
    *  */

    /// int
    var integerss = 1

    // Long
    var LongNumber = 6L

    // assign a binary number with the prefix 0x
    var BinaryNumber = 0b10

    // float
    var floats = 123.2

    //Booleans
    var t = true
    var f = false

    // char
    var letter = 'D'

    // String
    var na = "Pena"

    // The compile will know when to assign the data type to a var
    // but for smaller numbers like short and byte
    // we have to explicitly declare it
    var smallNumber : Short
    var tinyNum: Byte
    var z: Short = 1

    var zz: Long = LongNumber

    var zx: Long = integerss.toLong()

    //Arrays
    // create using arrayOf function
    // from my understanding everything in kotlin is an object. arrays, variables
    var myArray = arrayOf(223232321,2,3)

    println(myArray[0])
    myArray.size





}