// anon objects can be changed to be useful as implementors of interfaces

// this is equivilant to an anonymous innner class in java

// an anon inner class implements an interface on the fly.

// we do this with the object keyword and the {} block.
// also mention the names of hte interfaces we want to implement.

// my function creatRunnable returns a runable
fun createRunnable(): Runnable{
    // runable is a functional interface
    val runnable = object : Runnable{ // holds a reference to an instance of hte anonyous inner class the type of this cariabel is Runnable

        override fun run() {
            println("You called ...")
        }


    }
    return runnable
}

val aRunnable = createRunnable()
aRunnable.run() /// "you called"

//if the functional interface implemented is a single abstract method interface. then we can
// directly provide the implmentation without the need to specify the method name
fun cRunnable(): Runnable = Runnable { println("you called again")}
val aCRunnable = cRunnable()
aCRunnable.run()

// but if it has more than one interface, you have to specify the type of the instance should represent upon return
fun createRunnable1() : Runnable = object : Runnable, AutoCloseable { // implement more than one interface.
    // but kotlin will only access the return type. which is runnable.
    override fun run() { println("You called a third time")}
    override fun close() { println("You called closed")}

}

val cRun = createRunnable1()
cRun.run()

