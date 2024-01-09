

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


// Delegation The kotlin way.
// Kotlin requires the left side of the by to be an interface. The right side is an implementor of that interface.
class Manager() : Worker by JavaProgrammer() // It implements the Worker interface by way of or via the JavaProgrammer. Since javaprogrammer is already implementing the Worker Interface
// Upon seeing the by keyword, the Kotlin compiler will implement, at the bytecode level, the methods in the Manager class that belong to Worker, and route the call to the JavaProgrammer instance supplied after the by keyword.
// In other words, the by keyword in this example does at compile time what we painstakingly did manually in the previous example where we implemented delegation by hand

val doe = Manager()
doe.work()
// val coder: JavaProgrammer = doe //ERROR: type mismatch

// delegation basically means this.. I want to implement an interface, but I want the methods the interface to be defined by another class that has already overrided them. that way
// I can use an object to implement them, while being a different class.
// when you see by, just think. give me the methods from the class that implemented the base interface. simple.