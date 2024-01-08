// varying-length argument lists

fun main() {
    printStrings()
    printStrings("A")
    printStrings("A", "B")
    printStrings("A", "B", "C")

    val strings = arrayOf("A", "B", "C")
    printStrings(*strings) // spread operator. takes each element of the array and splits it up into its own string. 

}

fun printStrings(vararg strings: String) {
    printStringsHelper(*strings)
}

fun printStringsHelper(vararg strings: String) {
    for(string in strings) {
        println(string)
    }
}
