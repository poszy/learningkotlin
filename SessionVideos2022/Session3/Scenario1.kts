

interface Tool

class ScrewDriver : Tool
class Saw : Tool // dont need () because its not a class


class ToolBox {

    var tools = emptyList<Tool>()
        private set // this means no one can ovverride or directly edit it. from the outside.

    fun add (tool : Tool) {
        println("Toolbox.add(tool)")
        tools = tools + tool
    }
}

val toolbox : ToolBox = ToolBox()
val saw : Tool = Saw()
val screDriver : Tool = ScrewDriver()
toolbox.add(saw)
toolbox.add(screDriver)

val ssaw = Saw()
val ssDriver = ScrewDriver()
toolbox.add(ssaw) // at compile time - resolves to add(Tool)... at runtime - which tupe is toolbox - look for add toolbox
toolbox.add(ssDriver)
