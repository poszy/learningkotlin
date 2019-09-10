import kotlin.test.assertTrue

fun main (args: Array<String>){

    val options    = arrayOf("Rock", "Paper","Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)

    // for-loop in a single statement
    // for (x in 1..100) println(x)

    printResult(userChoice, gameChoice)

}

fun getGameChoice(options: Array<String>) = options[(Math.random() * options.size).toInt()]




fun getUserChoice(options: Array<String>): String {

    var isValidChoice = false;
    var userChoice = ""


    while (!isValidChoice) {

        print("Please enter one of the following:")
        for (i in options) print(" $i")
        println(".")

        val userInput = readLine()

        if (userInput != null && userInput in options) {
            isValidChoice = true
            userChoice = userInput
        }

        if (!isValidChoice) {
            println("You must enter a valid choice")
        }
    }

    return userChoice
}

fun printResult(userChoice: String, gameChoice: String){

    val result : String

    // Figure the result

    if(userChoice == gameChoice){result = "Tie!"}
    else if (
        (userChoice == "Rock" && gameChoice =="Scissors") ||
        (userChoice == "Paper" && gameChoice =="Rock") ||
        (userChoice == "Scissors" && gameChoice =="Paper")
    ){ result = "You win!"}

    else{result = "You lose!"}

    println("You Chose $userChoice. I Chose $gameChoice. $result")

}

