val name = "Eve"

val mem = """
    Dear $name, a quick reminer about the
    party we have scheduled next Tuesday at 
    the 'low ceromony cafe' at noon. | please plan to...""".trimIndent()

println(mem)


fun createMemo ( name : String) : String {
    if (name == "Eve"){
        val memo = """Dear $name, a quick reminder about the
        |party we have scheduled next Tuesday at
        |the 'Low Ceremony Cafe' at Noon. | Please plan to..."""

        return memo.trimMargin()
    }
    return ""
} // the | or the ~ can be used as delimiters to see how to trim the margin. 

println(createMemo("Eve"))