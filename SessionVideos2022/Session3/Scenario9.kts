
// sealed interface limits subtypes
sealed interface Tool
class ScrewDriver: Tool
class Saw: Tool

open class Toolbox {
    var tools = emptyList<Tool>()
        private set

    fun add(tool: Tool) { // A
        println("    Toolbox.add(Tool)")
        tools = tools + tool
    }
    fun add(tool: ScrewDriver) { // B
        println("    Toolbox.add(ScrewDriver)")
        tools = tools + tool
    }
    open fun add(tool: Saw) { // C
        // since we added an overload function of adding a saw. we must override it in the subclass
        println("    Toolbox.add(Saw)")
        tools = tools + tool
    }
}

class SafeToolbox: Toolbox() {
    override fun add(tool: Saw) {
        // now that we have an overriten function ->1)
        println("    SafeToolbox.add(Saw)")
        super.add(tool) // calls C
    }
}

fun main() {
    // 1) we can declare the safetoolbox as type toolbox and the overrride method will resolve the saw method
    val safeToolbox: Toolbox = SafeToolbox()
    val toolsToAdd = listOf(Saw(), ScrewDriver())

    for(tool in toolsToAdd) {
        println("adding ${tool::class.simpleName} to safe toolbox")
        when(tool) {
            is Saw -> safeToolbox.add(tool)
            // compile: add(Saw) - resolved from Toolbox ... because all we care about runtime is the method signature.
            // runtime: SafeToolbox.add(Saw)
            is ScrewDriver -> safeToolbox.add(tool)
            // compile: add(ScrewDriver) - resolved from Toolbox
            // runtime: Toolbox.add(ScrewDriver)
        }
    }
}


