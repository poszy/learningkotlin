// inheritence has tight coupling and is inflexible. most languages dont allow a class to choose between different base classes.
// Design Patterns , advise us to prefer delegation over inheritance.
// delgation is more flexable than inheritance. an objet may delegate or pass some of its repsonsibilities to an instance of another class.
// different instances of a calss may delegate to instances of different classes.


/* when to use delegation over inheritance?*/
// use inheritance if you want an object of a class to be used in place of an object of another class
// use delegation if you want an object of a class to simply make use of an object of another class

/**
 *
 * Use inheritance to specialize the implementation of a class and to substitute an instance of one class in place of another—that is, to design the kind-of relationship, like in Dog is a kind of Animal.
 * To merely reuse an object in the implementation of another, use delegation, like a Manager has an Assistant, to do part of the work.
 */

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

class manager
