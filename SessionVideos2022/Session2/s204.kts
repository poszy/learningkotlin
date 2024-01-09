
// statements
//      assignment
//      for
//      while
//      do-while
//      break
//      continue
//      loop labels
//      return
//      code blocks

fun main() {
    val x = 10 // initializer
    val y = 20 // initializer
    var z = x + y // initializer

    z = x + 10 // assignment statement
    z += 10 // same as z = z + 10 also have *=, /=, -=, %= // incremental assignment

    val list = listOf("A", "B", "C")
    for (n in list) {
        println(n)
    }
    for (n in list.indices) {
        println(list[n])
    }
    for (n in list.indices) {
        println(list[n])
    }
    println("-----")
    for (n in 0..10) {
        println(n)
    }
    println("-----")
    for (n in 0 until 10) {
        println(n)
    }
    println("-----")
    for (n in 0 until 10 step 2) {
        println(n)
    }
    println("-----")
    for (n in 0 until 10 step 2) {
        println(n)
    }
    println("-----")
    for (n in 10 downTo 1) {
        println(n)
    }

    println("-----")
    var n = 0
    while (n < 10) {
        println(n)
        n++
    }
    println("-----")
    n = 0
    do {
        println(n)
        n++
    } while (n < 10)

    var line = readLine()

    nextLine@ while(line != "") {
        for(c in line) {
            if (c == '5') {
                // skip the rest of the characters in this line

                line = readLine()
                continue@nextLine // skip everything else in the outer loop - go to next iteration
            }
        }
        // do something else with the line
        line = readLine()
    }
}

fun failFastTest(n: Int, x: Int) {
    if (n == 2) return
    if (x == 17) return
    // do some processing
    // return or just hit end of function to return
}




var lines = 10
fun readLine(): String {
    lines--
    return if (lines > 0) {
        "$lines${lines + 1}$lines"
    } else {
        ""
    }
}