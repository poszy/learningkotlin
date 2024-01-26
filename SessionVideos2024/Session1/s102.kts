const val name3 = "Scott"

fun main(args: Array<String>) {
    val name1: String = "lu" // String is redundant
    val name2 = "lu" // can remove it

    val first = "Hello"
    val last = "World"
    val helloWorld = first + ", " + last // basic string concatenation

    println(helloWorld)

    val helloWorldUsingTemplate1 = "$first, $last" // basic string template
    val helloWorldUsingTemplate2 = "${first.substring(0, 2)}, ${last.substring(0, 2)}" // basic string template

    val typeOfThings = "animal"
    val numberOfThings = 10
    val onlyOne = 1
    println(helloWorldUsingTemplate2)

    val message1 = "There are $numberOfThings ${typeOfThings}s"
    val message2 = "There is $onlyOne $typeOfThings"

    println(message1)
    println(message2)

    // RAW Strings
    val message3 = """
        
        Some other license text here
    """.trimIndent()

    println(message3)

    val message4 = """
        |
        |               All Rights Reserved
        |
        |Some other license text here
    """.trimMargin()
    println(message4)

    val message5 = """
        
        
        Some other license text here
    """.trimIndent()
    println(message5)
}

