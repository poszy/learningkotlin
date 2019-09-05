
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
}