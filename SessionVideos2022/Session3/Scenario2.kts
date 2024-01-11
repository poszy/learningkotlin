

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

// if I specifically define them like this, they will also be expliclity set to Tool and will always call the tool method
// val saw : Tool = Saw()
//val screDriver : Tool = ScrewDriver()

// this is because val gets evaluated at compile time, since saw and screwdriver get compiled as Tools
// at runtime when the method gets lookedup, it will think the best match for the add method is tool
// this is having the supertype at compile time, will make the variable of supertype.
val toolbox : ToolBox = ToolBox()
val saw  = Saw()
val screDriver = ScrewDriver()

println("Adding saw to toolbox")
toolbox.add(saw)

// during compile time - resolves to add(ScrewDriver)_
// runtime - which actual type is toolbox - look for add (screDriver)
println("Adding screwdriver to toolbox")
toolbox.add(screDriver) // this will call function B since passing in a screwdriver has a better match than just tool


