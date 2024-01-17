import java.io.File

// file class - abstract file name. is not the file on disk. it is the library
val file = File("hello1.txt")

// write text - opens writes and closes the file. all in one time
// takes a single string. should only use if limited input.
// writes using utf8
// this overwrites all data. does not append.
// dont do this with a bunch of data. it can blow everything up.
file.writeText("""
    Line1
    Line1
    Line1
    Line1
    Line1
    Line1
    Line2
""".trimIndent())
file.appendText("""
    
    line 6
    line 7
    line8
""".trimIndent())

val text = file.readText()
println(text)

// if we want to write a bunch of data, work in chunks

// two types of file inputs and outputs.
//   binary - inputStream and OutputStream .. uses binary
//   text - Reader and Writer ... uses a character decoder and encorder

// can use the Decorator and Adapter pattersn to modify in put and output
// these are wrappers. it modifies data coming in or out of a funciton


// Coffee Pot = file
// Coffee Filter = tweaks your data

// THE FOLLOWING EXAMPLES ARE ALL EVIL!!!
// IF EXCEPTION DURING WRITES, WE'LL SKIP THE CLOSE!!!
// only a limited number of file handlers on a system can run out, if the this code fails
val file1 = File("File1.txt")
val fw1 = FileWriter(file1)
(1..100).forEach {
    fw1.write(it.toString())
    fw1.write("\n")
}
fw1.close()

val file2 = File("File2.txt")
val fw2 = FileWriter(file2)
val pw2 = PrintWriter(fw2)
(1..100).forEach {
    pw2.println(it.toString())
}
pw2.close()

val file3 = File("File3.bin")
val fos3 = FileOutputStream(file3)
(1..100).forEach {
    fos3.write(it)
}
fos3.close()

val fis3 = FileInputStream(file3)
(1..100).forEach { _ ->
    println(fis3.read())
}
fis3.close()
