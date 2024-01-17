import kotlin.math.min

// composite patterns, we have a base type Employee, that the subtype Manager implements . and the subtype has a list of base types
interface Employee {
    val name: String
    fun generateOrgChart() = name
}

interface Manager: Employee {
    val minions: List<Employee>
    override fun generateOrgChart(): String {
        val minionInfo = minions.joinToString { it.generateOrgChart() }
        return "$name ($minionInfo)"
    }
    // more terse version
//    override fun generateOrgChart() =
//        "$name (${minions.joinToString { it.generateOrgChart() }})"
//    }
}

data class CEO(
        override val name: String,
        override val minions: List<Employee>
) : Manager

data class Boss(
        override val name: String,
        override val minions: List<Employee>
) : Manager

data class Henchman(
        override val name: String
) : Employee

fun visit(employee: Employee) {
    when (employee) {
        is CEO -> {
            println("CEO: ${employee.name}")
            employee.minions.forEach {
                visit(it)
            }
        }
        is Boss -> {
            println("Boss: ${employee.name}")
            employee.minions.forEach {
                visit(it)
            }
        }
        is Henchman -> println("Henchman: ${employee.name}")
//        is Manager -> {
//            val minionInfo = employee.minions.joinToString { visit(it) }
//            "${employee.name} #$minionInfo#"
//        }
//        else -> employee.name
    }
}


/*
(15 points)  The Composite Pattern allows us to create a (recursive) tree of heterogeneous nodes: which means different types of nodes.
homogeneous , means nodes are the same.

Some nodes have children, others do not
All nodes have a common base type (the "base type")
A subtype of that base contains pointers to other items of that base (the "composite type")
We'll define an Employee (base type) and Manager (composite type). A base employee can't have children; a Manager can.

We'll implement this using two interfaces: Employee and Manager, then create data classes for the actual tree nodes:

-Define an Employee interface that
-requires an immutable string called "name"
-has a generateOrgChart() function with default implementation that just returns the name

Define a Manager interface that
-extends the Employee interface
-requires a "minions" property that is a List<Employee>
-overrides generateOrgChart() to join all of the direct minions' org charts
-note that you must call generateOrgChart() for each minion separated by commas.
-For example, if you have a Manager named "Boss 1" who has minions "Thing 1" and "Thing 2", the output should look like:
-    Boss 1 (Thing 1, Thing 2)
-Eventually this becomes a bigger tree (when called from a parent) like:
-   Mr Big (Boss 1 (Thing 1, Thing 2), Boss 2 (Thing 3, Thing 4))
- */



// output of this main should be
//   Mr. Big: (Boss 1: (Thing 1, Thing 2), Boss 2: (Thing 3, Thing 4))
//   CEO: Mr. Big
//   Boss: Boss 1
//   Henchman: Thing 1
//   Henchman: Thing 2
//   Boss: Boss 2
//   Henchman: Thing 3
//   Henchman: Thing 4
fun main() {
    val ceo =
            CEO(
                    name = "Mr. Big",
                    minions = listOf(
                            Boss(name = "Boss 1",
                                    minions = listOf(
                                            Henchman("Thing 1"),
                                            Henchman("Thing 2"),
                                    )
                            ),
                            Boss(name = "Boss 2",
                                    minions = listOf(
                                            Henchman("Thing 3"),
                                            Henchman("Thing 4"),
                                    )
                            )
                    )
            )
    println(ceo.generateOrgChart())
    visit
