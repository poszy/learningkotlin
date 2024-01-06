// Companion objects are singletons defined within a class—they’re singleton companions of classes. In addition, companion objects may implement interfaces and may extend from base classes, and thus are useful with code reuse as well.

class MachineOperator(val name: String) {

    fun checkin() = checkedIn++
    fun checkout() = checkedIn--

    // The property checkedIn within the companion object becomes the class-level property of MachineOperator.
    // Likewise, the method minimumBreak doesn’t belong to any instance; it’s part of the class.
    companion object  { /// companion objects can also implement interfaces
        // we can name the companion object to users can access it more cleanly
        // companion object MachineOperatorFactory
        var checkedIn = 0

        fun minimumBreak() = "15 minutes every 2 hours"
    }
}

// The members of the companion object of a class can be accessed using the class name as reference

MachineOperator("Mater").checkin()
println(MachineOperator.minimumBreak())
println(MachineOperator.checkedIn)

// we can access the companion object itself like this
val ref = MachineOperator.Companion

// val ref = MachineOperator.MachineOperatorFactory