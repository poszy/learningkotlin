// function programming -- what is needed or what to expect
// focuses a lot on immutability
// makes functions much simpler to understand
// -- no side effects. if you pass in a immutable object and is returned, it should be the same
// strings are immutable by default
// pure functions
//    -- if have same input, always get same output
//    --no side effects.
//    -- allow automated parallelization where possible
// Functional chaining - style
// frequent use of recursion is encouraged
//   -- try to make tail-recursive where possible
//    -- this is important when the call stack of recursion is a lot. tailrec can make this into a loop. which is more optimized . this is caled tail recursion optimization.


var n = 0

class Person(var name : String){ // this parameter is mutable.
    override fun toString(): String {
        return ("$name")
    }

}

class PersonX(val name : String){ // pure function
override fun toString(): String {
    return ("$name  : X")
}

}

fun changeName( person: Person){ // person is immutable. this points to a person object
    // can have functions like

    var nn =  0


    println(person.toString())
    // person = Person()
    person.name = "A ${n++}"
    println(person.toString())
}

//val person = Person("Luis")
//changeName(person)
//changeName(person)
//changeName(person)
//changeName(person) // here our code takes in an argument. changes it and also changes a global variable
// this is not how we want to do functional programming. we want things immutable without side effects so
// its easier for people to read and understadn our progra.

// pure function verison
// this changeName
fun changeNameX( person: PersonX) : Person{
    // person.name = "A ${n++}" cannot change
    return Person("LuisX") // this will never change, even if we change the name

}
val personx = PersonX("Luis2")
changeNameX(personx)
changeNameX(personx)

var list = listOf("a")
list = list + "B"
list = list + "C"
list = list + "CCC"
list = list + "DDD"
list = list + "N"

// chain funcitonal style. is declarative. it kinda describes everything thats gonna happen with
// each statement.
// it is recommeneded to use functional programming style if its supported.
// functional style - desribes what to do.
val newList = list
        .filter{ it.length == 1}
        .map{"x${it}x"} //creates a new list every time
// functional style programing is more memory hungry as it makes a list with each statement.

newList.forEach{println(it)}

// what we can do is set it asSequence() . this will modify the current list instead of making a new list

val newLists = list
        .asSequence()
        .filter{ it.length == 1}
        .map{"x${it}x"} //creates a new list every time

// imperative style - describes steps/actions - how to do something.
// this is more efffiecient.
val list2 = mutableListOf("A", "B", "C")
for ( i in list2.indices){
    list2[i] = "x${list2[i]}"
    println(list2)
}


