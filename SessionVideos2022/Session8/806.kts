import java.io.BufferedReader
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.FileReader
import java.io.FileWriter
import java.io.FilterWriter
import java.io.Writer

// filter writer is a decorater
class UppercaseWriter(out: Writer?) : FilterWriter(out) {
    override fun write(c: Int) {
        super.write(c.toChar().uppercaseChar().code)
    }
    override fun write(str: String) {
        super.write(str.uppercase())
    }
    override fun write(cbuf: CharArray) {
        write(cbuf.toString())
    }
    override fun write(cbuf: CharArray, off: Int, len: Int) {
        val newBuf = CharArray(len)
        cbuf.copyInto(newBuf, 0, off, off+len)
        newBuf.indices.forEach {
            newBuf[it] = newBuf[it].uppercaseChar()
        }
        super.write(newBuf, off, len)
    }
    override fun write(str: String, off: Int, len: Int) {
        super.write(str.uppercase(), off, len)
    }
}

fun main() {
    UppercaseWriter(FileWriter(File("file6.txt"))).use {
        // the point of decoraters is to change the implementaiton. here we can wrap each thing until
        // it gets to the uppercase.
        it.write("""
            This is a test
            another line
            SOME UPPERCASE TEXT
        """.trimIndent())
    }

    UppercaseWriter(File("file7.txt").writer()).use { // or we can write it as an extension funcitons
        // use makes it better for us to catch exceptions automaticlly. takes away a lot of pain.
        it.write("""
            Hello there!
            General Kenobi!
        """.trimIndent())
    }

    // when we see repetitive code. think template strategy method.

    DataOutputStream(FileOutputStream(File("file8.bin"))).use { dos ->
        dos.writeInt(42)
        dos.writeDouble(50.998)
        dos.writeUTF("Hello there!")
    }
    DataInputStream(FileInputStream(File("file8.bin"))).use { dis ->
        println(dis.readInt())
        println(dis.readDouble())
        println(dis.readUTF())
    }

    // what does useLines do?
    BufferedReader(FileReader(File("file7.txt"))).use { br ->
        while(true) {
            val line = br.readLine() ?: break
            println(line)
        }
    }
}
