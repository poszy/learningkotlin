

interface Worker {
    fun work()
    fun takeVacation()
}

open class JavaProgrammer : Worker {
    override fun work() {
        println("Write java")
    }

    override fun takeVacation() {
        println("Code on the beach")
    }

}
open class CSharpProgrammer : Worker {
    override fun work() {
        println("Write C#")
    }
    override fun takeVacation() {
        println("branch at the ranch")
    }

}



// this is where inheritance will fall short.
// though not intentional bye design, when calling Work() on a manager instance, it can only be tied to one baseclass.
// so if a manager needs to get stuff done, and it inherits. in this example, it can only do what the java programmer does
class Manager : JavaProgrammer()

val doe = Manager()

// This works, but this design has a drawback. This Manager class is stuck to the JavaProgrammer class and can’t use what’s offered by a CSharpProgrammer class (or any other classes that implement Worker in the future). That’s not fair, but that’s the consequence of inheritance
doe.work() // "write java"

// another drawback is Manager is now a JavaProgrammer or kind of JavaProgrammer. it is assumed in real life context. a Manager can be anything excluding a JavaProgrammer, we dont know. so its implied by inheritance
val coder: JavaProgrammer = doe // this will work because doe is of type JavaProgrammer

// Even though this wasn’t intended by the design, we can’t stop it. Our real intention here is that Manager should rely upon or use a JavaProgrammer or any worker that can get the tasks done.
// But that’s delegation, not inheritance. We want to be able to delegate work from a Manager instance to the instance of any Worker.