

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


// Delegating to a parameter
// Worker by JavaProgrammer(), which says that the Manager instance is delegating to an implicitly created instance of the JavaProgrammer, but that poses two issues
// 1.) First, the instances of Manager class can only route to instances of JavaProgrammer, not to instances of any other Worker implementors.
// 2)  an instance of Manager doesn’t have access to the delegate; that is, if we were to write a method in the Manager class, we can’t access the delegate from that method

// to fix this. delegate to the parameter passed to the constructor instead of to an implicitly created instance
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
