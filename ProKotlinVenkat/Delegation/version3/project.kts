

interface Worker {
    fun work()
    fun takeVacation()
}

class JavaProgrammer : Worker {
    override fun work() {
        println("Write java")
    }

    override fun takeVacation() {
        println("Code on the beach")
    }

}
class CSharpProgrammer : Worker {
    override fun work() {
        println("Write C#")
    }
    override fun takeVacation() {
        println("branch at the ranch")
    }

}



// delegation the hard way. in java there is no syntax for delgation.
// we can emulate that in kotlin using a reference to refer to another object.
// the drawback here is we have to implement everything manually. this is how java does it.
class Manager(val worker: Worker ){
    fun work() = worker.work()
    fun takeVacation() = worker.work()
}

val doe = Manager(JavaProgrammer())
doe.work() // "write java"

// The benefit this design has over inheritance is that the Manager isn’t tightly coupled to the JavaProgrammer class.
// Thus, we may instead pass to the constructor an instance of CSharpProgrammer class, or just about any class that implements the Worker interface.
// An additional benefit in this solution is that the JavaProgrammer class no longer has to be marked as open since we’re not inheriting from it.

// however this implementation is trash, because it violates software design principles
// 1. the code violates DRY principle. do not repeat yourself. since we are rewriting code that just routes to other functions
// 2. violates Open-Closed OCP.. a software module should be open for extension but closed from modification. to extend a class, we should not have to change it.
//     so if we added another method to Worker(). then we would have to change Manager as well.
// THIS IS THE ONLY WAY TO DO IT IN JAVA