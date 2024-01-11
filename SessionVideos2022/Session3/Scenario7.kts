

sealed interface Tool // sealed interface limits subtypes.
// the only subclasses that can exist. must exist in the module. they must be defined in this Session3 module. module 2 cannot create an implemetnatiopn


class ScrewDriver : Tool
class Saw : Tool // dont need () because its not a class


open class ToolBox { // make open for subclassing.

    var tools = emptyList<Tool>()
        private set // this means no one can ovverride or directly edit it. from the outside.


    fun add (tool : Tool) {
        println("Toolbox.add(tool)") // Function A
        tools = tools + tool
    }

    fun add (tool : ScrewDriver) {
        println("Toolbox.add(ScrewDriver)") // fucntion B
        tools = tools + tool
    }

}

class SafeToolBox : ToolBox () {

    fun add (saw : Saw) {
        println("SafeToolBox.add(saw)")
        super.add(saw) // calls A

    }
}

val safeToolBox = SafeToolBox()
val safeToolBox2 : ToolBox = SafeToolBox()
val toolsToAdd = listOf(Saw(), ScrewDriver()) // we can assume this is a list of tools.


for (tool in toolsToAdd){
    println("Adding ${tool::class.simpleName} to toolbox")
    when(tool) { // we can make the compile know the
        is Saw -> safeToolBox2.add(tool) // compile: add(tool) .
        is ScrewDriver -> safeToolBox2.add(tool) // compile add)screwdriver)
        // this is because when we have safetoolBox2 defined as a Toolbox, the method to add saw, is not defined. its only defiend in the subclass
        else -> println("")
    }}
println("**********************************************")
for (tool in toolsToAdd){ // Scenario 8
    println("Adding ${tool::class.simpleName} to toolbox")
    when(tool) { // we can make the compile know the
        is Saw -> safeToolBox.add(tool) // compile: add(saw) . this also calls the superclass TooldBox.add(tool)
        is ScrewDriver -> safeToolBox.add(tool) // compile add)screwdriver)
        // now at compile time, the Saw is of type safetoolbox
        else -> println("")
    }}