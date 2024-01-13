fun main() {
    // in Kotlin's list class, we have the same type of template method w strategy parameter
    val list = listOf(1,2,3,4,5)
    list.forEach {// this is built in
        println(it)
    }
}
