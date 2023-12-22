
// placing a name inbtween object and {} makes this a statement and not an expression
// ** use a object expression to create an instance of an anonoymouse inner class
// Use object decloration to create a singleton

object Util { // this is an object decoration and can be used as a singleton
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}

// we can call the methods of the singleton objects like static methods.
println(Util.numberOfProcessors())

// object declorations may also implement interfaces or extend from existing classes. like objects expressions do
// if a singleton has a base class or interface, the single instance may be assigned to an interface or passed
// to a parameter of the base type

object Sun : Runnable { // create singleton with return type runnable

    val radiusInKM = 696000
    var coreTemperatureInc = 15000000 // placing mutable vars in a singleton is a bad idea, especially in multithreaded applicatoins

    override fun run() {println("Spin..")}

}

fun moveIt(runnable: Runnable){
    runnable.run()
}

println(Sun.radiusInKM) // we can also access singleton properties directly.
moveIt(Sun) // we can pass singleton Sun to these types of functions since its expecting a runable

