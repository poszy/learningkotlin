var x = 10
var y = 20

fun main() {
    println(x + y)

    val done = false
    val isPerson = true
    val result1a = done && isPerson // SHORT-CIRCUITING AND
    val result1b = done and isPerson // NON-SHORT-CIRCUITING AND
    // might be useful if side effect is necessary

    val result2a = done || isPerson // SHORT-CIRCUITING OR
    val result2b = done or isPerson // NON-SHORT-CIRCUITING OR

    val xAndYAreEqual = (x == y)
    val xAndYAreNotEqual = (x != y)

    var n = 10
    val m1 = n++ // DO NOT DO THIS - DON'T USE n++ as expression
    // m1 = 10, n = 11
    val m2 = ++n // DO NOT DO THIS - DON'T USE ++n as expression
    // m2 = 12, n = 12

    n++ // use it like a statement
    ++n // use it like a statement

    val m3 = n // m3 = 14

    foo(n++) // don't do this
    // instead: equivalent
    foo(n)
    n++

    n += 2

}

