// template method & strategy
// template method - algorithm with replaceable steps
// strategy - passing in something to replace step with
//    https://www.youtube.com/watch?v=EWBCy0jWFvc

//   Gilligan's island
//      someone comes to island
//      they do something they're good at
//      Gilligan screwed up
//      they get rescued
//      castaways left behind
//      skipper hits Gilligan with hat


fun printWithXs(string : String){
    println("X${string}X")
}

fun  print(string : String ) {
    println(string)
}
// higher-order function - function that takes other functions as parameters
fun doStuffWithEachItem(
    strings: List<String>,
    thingToDo : (String) -> Unit // funcitonal type aka lambda the syntax is varName : (parametersType) -> ReturnType
){
    for ( string in strings){
        thingToDo(string)
    }
}

typealias ThingDoer = (String) -> Unit

fun doStuffWithEachItem3(
    strings: List<String>,
    thingToDo: ThingDoer // using type alias
) {
    for (string in strings) {
        thingToDo(string)
    }
}

fun doStuffWithEachItem2(
    strings: List<String>,
    thingToDo: (String, String) -> Unit // functional type
) {
    for (string in strings) {
        thingToDo(string, "Maryland")
    }
}


// now we can call thing to do with multiple functions
val list = listOf("A","B","C")
doStuffWithEachItem(list, ::printWithXs) // :: are function references
doStuffWithEachItem(list, ::print) // we can pass a function by using ::

// we can pass inline function definitions aka lambda
doStuffWithEachItem(list, {
    string -> println("Y${string}Y") // lambda, same sytnax as beofre // proper closure
})

val name = "lu"
doStuffWithEachItem(list) { string ->
    println("Y${string}Y") // since the funcitonal type is the last parameter, we can move the lambda definition outside of the parentehesis.
}

doStuffWithEachItem(list) {
    println("$name: $it")
}

doStuffWithEachItem2(list) { string, state ->
    println("$name: $string $state")
}

doStuffWithEachItem2(list) { string, _ ->
    println("$name: $string")
}


