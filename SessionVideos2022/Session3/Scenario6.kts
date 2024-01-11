

sealed interface Tool // sealed interface limits subtypes.
// the only subclasses that can exist. must exist in the module. they must be defined in this Session3 module. module 2 cannot create an implemetnatiopn


class ScrewDriver : Tool
class Saw : Tool // dont need () because its not a class


class ToolBox {

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


val toolbox : ToolBox = ToolBox()
val toolsToAdd = listOf(Saw(), ScrewDriver()) // we can assume this is a list of tools.

// how can we force kotlin to resolve the best thing dynamically?

for (tool in toolsToAdd){
    println("Adding ${tool::class.simpleName} to toolbox")
    when(tool) { // we can make the compile know the
        is Saw -> toolbox.add(tool) // resolves to add(Tool)
        is ScrewDriver -> toolbox.add(tool) // tool is being smarcasted . resolves to add(ScrewDriver)
        // since we made the interface sealed. kitlin knows our when is exhaustive. so we can get rid of the line.

        //else -> throw IllegalArgumentException("no idea what ${tool::class.simpleName} is")
    }


}
