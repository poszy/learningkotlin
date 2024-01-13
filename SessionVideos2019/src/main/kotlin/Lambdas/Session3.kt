package org.example.Lambdas

import Foo
import kotlin.system.measureNanoTime
import kotlin.time.measureTime

fun main() {

    // with a single parameter, when the lambda is called, the value will be represetned by it
    doSomething { (it + 4).toString() }
    doSomething { it.toString() }
    doSomething2 { (it + 200).toString() }

    // the first parameter here is the offset from tehe function decloration
    doSomething3 (10){ offset, value ->
        (offset + value).toString()
    } // can no longer use it, it can only be used with a single parameter.
    doSomething4 (10) { offset, value ->
        (offset + value).toString()
    }

    // we can also hardcode the value. so the offset being passed in is never used, but the 60 is
    doSomething3 (10) { _, value -> (60 + value).toString()  }

    // if we explicitly return a string, we can ommit all values
    doSomething3(10) { _, _ -> "hello" }

    val list = List<String>() // since this is a class we made, we have to put() and set =
    list.add("Me")
    list.add("Me again")
    list.add("Me one more time")
    list.forEach { println(it) }

    logExceptions {
        println("this ")
    }

    // when calling a lambda, the entire block of code that is in the {} is what gets passed into
    // the lambda. in this case the f() inside the start and stop is represented by whats inside time{}
    println( "time" + time {
        for( i in 0 .. 100) {
            println(i)
        }
    })

    println( "time" + measureNanoTime  {
        for( i in 0 .. 100) {
            println(i)
        }
    })

    // high order functions are great when you want to wrap something, basically call a function from a function
    // this is called method templating. its a common design pattern

    walk2(
        preOrder = {println(it)}
    )
    walk2(
        postOrder = {println(it)}
    )
    walk2(
        inOrder = {println(it)}
    )
    walk2(
        inOrder = {println(it)},
        postOrder = {println(it)}
    )

    // pass in method reference instead of a lambda
    val foo = Foo2()
    doSomething3 (10, foo::go)

    // or pass in a variable. better to do variable.
    val stuff = {
        x: Int, y : Int -> "$x"
    }
    doSomething3(10, stuff)

}

// high order functions are functions that take in other functions as parameters
// f is of type int and returns a string
fun doSomething (f : (Int) -> String){

    println(f(10)) // so f will take an initial parameter of 10, when we call it, we can add 4 or leave it alone and have return the default value
}

// if we dont want to use the syntax , we can have a typealias
typealias IntToString = (Int) -> String

// this is basically saying, f will take in a parameter inside of the function call. and that function returns a string.
fun doSomething2( f: IntToString){

    println(f(1000))
}

// if we need more than one paremeter, make sure the lambda is on the last parameter. so you can initilize the
// lambda with {} and dont have to write extra code

fun doSomething3( offset : Int, f: (Int, Int) -> String){

    println(f(5,1332000))
}

fun doSomething4( offset : Int, f: IntToString2){

    println("here")
    println(f(2, 1000)) // these parameters are for the lambda function. so the (Int,Int)
}

typealias IntToString2 = (Int, Int) -> String


class List<ITEM>{
    val data = mutableListOf<ITEM>()
    fun get(n : Int) : ITEM = data[n]
    fun add (item : ITEM) { data.add(item)}
    fun forEach (action : (ITEM) -> Unit) {
        for (item in data ) {
            action(item)
        }

    }

}

fun logExceptions( f: () -> Unit) {
    try{
        f()
    } catch (t : Throwable){
        t.printStackTrace()
        throw t
    }
}

fun time(f : () -> Unit ) : Long {
    val start = System.nanoTime()
    f()
    val stop = System.nanoTime()
    return stop - start
}

// named parameters
fun walk( preOrder : (String) -> Unit, inOrder: (String) -> Unit, postOrder : (String) -> Unit){
    preOrder("SS/")
    postOrder("ss")
    postOrder("SSS")
}

// we can add default values. lol
fun walk2( preOrder : (String) -> Unit = {_ -> }, inOrder: (String) -> Unit = {_ -> }, postOrder : (String) -> Unit = {_ -> }){
    preOrder("SS/")
    postOrder("ss")
    postOrder("SSS")
}

fun walk3(
    // when we want to set the lambda to null, we wrap the statement over parethenesis.
    preOrder : ((String) -> Unit)? = null,
    inOrder : ((String) -> Unit)? = null,
    postOrder : ((String) -> Unit)? = null)
    {
        preOrder?.invoke("ss")
        postOrder?.invoke("ss")
        inOrder?.invoke("ss") // we have to use invoke

}

// inline functinos are more effieicent because instead of making an object for each lambda,
// the compiler takes whatever is in the parameters and sticks it into the function definition
// named parameters
// similar to the measureNanoTime lambda call, it takes whatever is in the lambda $block
// measureNanoTime { $BLOCK } and replaces it in the actual definition. so objects dont get recreated
// using inline, generates more code. thats why everythign is not default.
/**


     public inline fun measureNanoTime(block: () -> Unit): Long {
     contract {
     callsInPlace(block, InvocationKind.EXACTLY_ONCE)
     }
     val start = System.nanoTime()
     block()
     return System.nanoTime() - start
     }
 */
inline fun ewalk( preOrder : (String) -> Unit, inOrder: (String) -> Unit, postOrder : (String) -> Unit){
    preOrder("SS/")
    postOrder("ss")
    postOrder("SSS")
}

inline fun x (){} // Expected performance impact from inlining is insignificant. Inlining works best for functions with parameters of functional types
inline fun getName() = "Hello" // nothing to inline warning

// main point, consider inlining high order functions.

// method refference
class Foo2 {
    fun go (x : Int, y : Int) : String {

        return (x.toString())
    }
}