fun main() {
    val list = listOf("A", "B", "C", "D")

    list
            .map { "XXX${it}XXX" } // creates a new list
            .filter { "C" in it } // creates a new list
            .onEach { println(it) } // traverses

    list
            .asSequence() // improves speed. it takes each element each time.
            .map { "XXX${it}XXX" } // grab A ... grab B .. grab C .. grab D
            .filter { "C" in it } // filter C ... filter c .. filter C
            .forEach { println(it) } // no print .. no print .. print c
}
