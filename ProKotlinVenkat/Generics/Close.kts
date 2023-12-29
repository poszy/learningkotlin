// Generics lack some support methods

fun <T> useAndClose(input : T) { //input.close()
     } // lacks a close method

// we have to extend.

fun <T : AutoCloseable> useAndClose(input : T) {
    input.close() // LGTM
}
val writer = java.io.StringWriter()
writer.append("hello ")
useAndClose(writer)
println(writer) // hello

