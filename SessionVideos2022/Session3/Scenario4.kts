

interface Tool

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


for (tool in toolsToAdd){
    println("Adding ${tool::class.simpleName} to toolbox")
    toolbox.add(tool)

    // again because at compile time, the items inside the list are of type tool.
    // at runtime, they will be looked up with the tools add method.
    // this is called. not supporting full dynamic resolutio of the signarures.
}
