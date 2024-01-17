import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.Writer

fun Writer.ioStuff(block: (Writer) -> Unit) {
    var pendingException: Throwable? = null
    try {
        block(this)
    } catch (e: Throwable) {
        pendingException = e
    } finally {
        try {
            close()
        } catch (e: Exception) {
            throw pendingException ?: e
        }
    }
}

fun main() {
    val file1 = File("File1.txt")
    val fw1 = FileWriter(file1)
    // use .use to make sure the I/O gets closed correctly.
    fw1.use { fw ->
        (1..100).forEach {
            fw.write(it.toString())
            fw.write("\n")
        }
    }

    // for reading lines
    FileReader(file1).useLines { lines ->
        lines
                .filter { it.length < 2 }
                .forEach {
                    println(it)
                }
    }
}

//fun main() { // .use basically uses template strategy to correctly close out the writer.
//    val file1 = File("File1.txt")
//    val fw1 = FileWriter(file1)
//    fw1.ioStuff { writer ->
//        (1..100).forEach {
//            writer.write(it.toString())
//            writer.write("\n")
//        }
//    }
//}
//
//fun main() {
//    val file1 = File("File1.txt")
//    val fw1 = FileWriter(file1)
//    var pendingException: Throwable? = null
//    try {
//        (1..100).forEach {
//            fw1.write(it.toString())
//            fw1.write("\n")
//        }
//    } catch (e: Throwable) {
//        pendingException = e
//    } finally {
//        try {
//            fw1.close()
//        } catch (e: Exception) {
//            throw pendingException ?: e
//        }
//    }
//}
//
// in the olden days before exceptions, we used result codes

fun doA(): Int {
    // if everything ok, return 0
    // else return non-zero
    return 0
}
fun doB(): Int {
    // if everything ok, return 0
    // else return non-zero
    return 0
}
fun doC(): Int {
    // if everything ok, return 0
    // else return non-zero
    return 0
}
fun doD(): Int {
    // if everything ok, return 0
    // else return non-zero
    return 0
}

fun runEverything1() {
    if (doA() == 0) {
        if (doB() == 0) {
            if (doC() == 0) {
                if (doD() == 0) {
                    println("Success!")
                }
            }
        }
    }
}
fun runEverything2() {
    var rc = doA()
    if (rc == 0) {
        rc = doB()
    }
    if (rc == 0) {
        rc = doC()
    }
    if (rc == 0) {
        rc = doD()
    }

    if (rc == 0) {
        println("Success!")
    } else {
        println("Failure!")
    }
}

var x = true

class SomeException: Exception()

fun doAWithExceptions() {
    // do something
    if (!x) {
        throw SomeException()
    }
}
fun doBWithExceptions() {
    // do something
    if (!x) {
        throw SomeException()
    }
}
fun doCWithExceptions() {
    // do something
    if (!x) {
        throw SomeException()
    }
}
fun doDWithExceptions() {
    // do something
    if (!x) {
        throw SomeException()
    }
}

fun doItAllWithExceptions() {
    doAWithExceptions()
    doBWithExceptions()
    doCWithExceptions()
    doDWithExceptions()
}
fun doItAllWithExceptionsWithCatch() {
    try {
        doAWithExceptions()
        doBWithExceptions()
    } catch (e: SomeException) {
        // report error but keep going
    }
    try {
        doCWithExceptions()
    } catch (e: SomeException) {
        // report error but keep going
        throw e
    }
    try {
        doDWithExceptions()
    } catch (e: SomeException) {
        // report error but keep going
    }
}
