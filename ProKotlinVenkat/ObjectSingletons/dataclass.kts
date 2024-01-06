// data classes create the equals(), hashcode(), toString() and component() methods
// only variables defined in the costructor get these methods

// component methods are used for destructoring

// data class needs at least one param, and must be either val or var. cannot be left ambiguous
data class Task ( val id : Int, val name : String, val completed : Boolean, val assigned : Boolean)

val task1 = Task (1, "Create Project", false , true )
println(task1) // Task(id=1, name=Create Project, completed=false, assigned=true)
println("Name : ${task1.name}")

// a copy() method also is created. which will copy all values of the object and
// we can choose which ones we want to override

val task1Completed = task1.copy(completed = true, assigned = false)
println(task1Completed) // Task(id=1, name=Create Project, completed=true, assigned=false)

// destructuring. this is the old way of doing things. we can achieve the same with destrucuring
val id1 = task1.id
val isAssigned = task1.assigned
println(" ID :: $ id Assigned : $isAssigned")

val (id , _,_, isAssigned1) = task1
println("Id: $id1 Assigned: $isAssigned") //Id: 1 Assigned: true

// the limitations of kotlin destrucuring is it relies on the order of the parameters
// thats why _,_ needs to be specified.
// if users add more parameters, it can be fatal .

// when to use data classes?

/*
*

    You’re modeling data more than behavior.

    You want equals(), hashCode(), toString(), and/or copy() to be generated, knowing that you may override any of these methods if you like.

    It makes sense for the primary constructor to take at least one property—no-argument constructors are not allowed for data classes.

    It makes sense for the primary constructor to take only properties.

    You want to easily extract data from the object using the destructuring facility (be aware that the extraction is based on the order of properties and not their names). 
*
*
* */