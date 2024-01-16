// method collisions
// when a method inside the delegating class has the same method and signature in the delagte,
// kotlin fovaros the delegating class.

interface Worker {
    fun work()
    fun takeVacation()
    fun fileTimeSheet() = println("why, really?")
}

interface Assistant{
    fun doChores()
    fun fileTimeSheet() = println("no escapre from that. ")
}

class DepartmentAssistant : Assistant {
    override fun doChores() = println("Routine Stuff")
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
class Manager(val staff: Worker, val assistant : Assistant) : Worker by staff, Assistant by assistant { // ahhh give me all the methods from the object being passed in. that way we can pass either JavaProgrammer or CSharpProgrammer. foxes issue #1
    // we can add a new method and access the properties of the delegated. in this case, we can see which type class the object is.
    override fun takeVacation()= println("of course")
    override fun fileTimeSheet() {
       print("Manually forwarding this")
        assistant.fileTimeSheet()
    }
}

val doe = Manager(CSharpProgrammer(), DepartmentAssistant())
doe.work()
doe.takeVacation()
doe.doChores()
doe.fileTimeSheet()

/* The call to the work() method was delegated to the implementation of the Worker interface. The call to takeVacation() wasn’t delegated; it was executed on the Manager instance. The call to doChores() method was delegated to the implementation of the Assistant interface. Finally, the call to fileTimeSheet() method was executed on the Manager instance. Thus, the Manager instance has intercepted the call to fileTimeSheet(), avoiding any conflict or ambiguity to a call on Worker or on an Assistant*/