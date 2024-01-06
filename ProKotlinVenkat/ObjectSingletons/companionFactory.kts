class MachineOperator private constructor(val name: String) {
    //...
    fun checkin() = checkedIn++
    fun checkout() = checkedIn--
    companion object {
        //...
        var checkedIn = 0
        fun create(name: String): MachineOperator {
            val instance = MachineOperator(name)
            instance.checkin()
            return instance
        }
    }
}

/*
*     The MachineOperator class has a private constructor, meaning instances of this class cannot be created directly outside the class. This is a common practice to control object creation and enforce certain rules.

    Inside the companion object (which is like a static part of the class in Kotlin), there is a create function. This function serves as a factory method responsible for creating instances of MachineOperator.

    The create function takes a name parameter, uses it to create an instance of MachineOperator, and then calls the checkin method on that instance.

The use of a factory method like create has several advantages:

    Encapsulation: The details of object creation are encapsulated within the factory method. This can hide complex instantiation logic or any other steps that need to be performed during object creation.

    Consistency: By centralizing object creation in a factory method, you can ensure that certain steps are always taken when creating an object. In this case, the checkin method is called after creating an instance.

    Flexibility: If, in the future, you need to change the way MachineOperator instances are created (e.g., adding more initialization steps, using a different constructor, etc.), you can do it in one place - the factory method - without affecting the rest of your code that uses the factory method.

In summary, you might use a factory method when you want to control and encapsulate the process of object creation, providing a clean and consistent way to instantiate objects of a certain class.
* */