

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


// Delegating with method collisions
// The Kotlin compiler creates a wrapper in the delegating class for each method that’s in the delegate. What if there’s a method in the delegating class with the same name and signature as in the delegate?
// Kotlin resolves this conflict in favor of the delegating class. As a consequence, you can be selective and don’t have to delegate every single method of the delegate class
class Manager(val staff: Worker) : Worker by staff { // ahhh give me all the methods from the object being passed in. that way we can pass either JavaProgrammer or CSharpProgrammer. foxes issue #1
    // we can add a new method and access the properties of the delegated. in this case, we can see which type class the object is.
    fun meeting() = println("organizing meeting with ${staff.javaClass.simpleName}")
}

val doe = Manager(CSharpProgrammer())
doe.work() // Write C#

doe.meeting()//organizing meeting with CSharpProgrammer


val roe = Manager(JavaProgrammer())
roe.work() //Write java

roe.meeting() //organizing meeting with JavaProgrammer
