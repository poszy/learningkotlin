// we can add constraints to Generics to make sure the function implements those methods.
//place a where clause and list all the constraints, comma separated. Now, we can use both the close() and the append()
fun <T> useAndClose(input : T)
    where T: AutoCloseable,
          T: Appendable {
              input.append("There")
              input.close()
}

val writer = java.io.StringWriter()
writer.append("hello ")
useAndClose(writer)
println(writer) // hello