import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.JButton


interface Foo {
    fun go()
    fun go2() : Int
    fun add (item : String )
}
// in classes specifying : means extend or implement or inherit
class Session2 : Foo {
    val list = mutableListOf<String>()
    var n : Int = 0
    fun drive() : Int {return 32}

    fun drive2() = println("Hello")
    override fun go() = println("Hello")
    override fun go2() = 42
    // cannot do
    // override fun add (item: String) = list.add(item)
    // because the add function returns a bloolean
    override fun add(item: String) {
        list.add(item)
    }

    // In java there is a lot of method overriding. you have to specify each function declartion
    fun a (){}
    fun a ( name : String){}
    fun a (name : String, n : Int){}

    // in kotlin, we can have 1 function defnition and can implement it in different ways
    // using named arguments that have default arguments

    fun b (item : String = "", n : Int = 0){}

    fun x () {
        b()
        b("hello")
        b("hello", 42)
        // b(42) not allowed ; cannot skip first parameter without naming/
        b(n = 42) // we can skip the first parameter since there is a default param.
    }

    // kotlin and java interlope a lot but it's important to note that function b does not generate 3 different overload methods.
    // to create three overload methods, use the JVMOverloads
    @JvmOverloads
    fun b2 (item : String = "", n : Int = 0){}

}


// when creating classes. the primary constructor can be inline, which is in the class definition
// class foo(....) {}

// inline constructor are the params here
class Foo1(x: Int, y: Int) {
    var x : Int = 0
    var y : Int = 0

    //Init blocks will execute for all constructors
    init {
        this.x = x
        this.y = y
    }

    // can specify other constructors with keyword.
    // if we have multiple constructors, we have to delegate all constructors to the primary
    // which means call it.

    // this is done by the 'this' keyword
    // this calls the super class constructor
    constructor(x : Int) : this(x, 10) // this gets tricky when deriving from a super class.
}

// so create a class without a primary constructor
open class Super1{

    constructor(x : Int, y : Int)
    constructor(x : Int) : this (x, 10)
}

// if we want a subclass to call a superclass constructor
// the only way to do it is to NOT have a primary constructor. its the only way

class SubClass1 : Super1 {
    constructor(x : Int, y: Int) : super(x,y)
    constructor(x : Int) : super(x, 10)
}

// define y here, and get rid of a constructor
// constructor must be open if a childclass wants to superclass the constructor
open class Foo2(x: Int, y: Int = 10) {
    var x : Int = 0
    var y : Int = 0

    //Init blocks will execute for all constructors
    init {
        this.x = x
        this.y = y
    }

    // we can get rid of the secondary constructor by having default values initialized
    //     constructor(x : Int) : this(x, 10) // this gets tricky when deriving from a super class.
}

class Foo3(x: Int, y: Int = 10) {

    // if all we are doing is setting the value of x and y, we can just access the constructor parameters directly
    // this gets rid of the init block
    var x : Int = x
    var y : Int = y

    //init {
    //this.x = x
    //this.y = y
    //}
}

// Class Foo3, is comlaining that the x,y can be initialized in the constructor
// so we can make it even shorter

class Foo4(var x: Int, var y: Int = 10) { // we can set var x and var y in the default constructor

}

// and we dont need the curly braces
class Foo5(var x: Int, var y: Int = 10) // with one line we can defined a constructor and be able to access the values

// Foo5 shows var x is never used. we can supressed this
class Foo6( @Suppress("unused") var x: Int, @Suppress("unused") var y: Int = 10)

class FooUser{
    fun xxx(){
        Foo6(10) // wtf we can call classes like functions?
    }
}

// superclass constructors will always be initialized
class foo2a : Foo2(10)

// this is a common thing to do
class foo2b(x: Int, y: Int = 10) : Foo2(x, y) // this passes x and y from subclass straight into the super constructor. similar to 'this'


// inner class & anonymous class
class Outer{
    var x : Int = 10
    inner class Inner1 { // the inner class has a pointer to the outer class. implicit pointer to outer class object
        // if the outerclass gets destroyed, it could cause "leaks"
        var x : Int = 42
        fun foo(){
            println(x) // inner x
            println(this@Outer.x)
        }
    }
}

// anonymous inner class
class Button {
    fun go(){
    val button = JButton("Hello")
    button.addActionListener(object : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            println("hi")
        }
    })
    }
}
// anonymous inner class
class Button2 {
    fun go(){
        val button = JButton("Hello")
        button.addActionListener { println("hi") } // we can convert the inner class to a lambda .
    }

    /*
    * is lambda syntax works when dealing with interfaces that have only one abstract method, which is a common scenario in functional programming.
    * If an interface has more than one abstract method,
    * you would need to use an anonymous inner class or find another approach to provide implementations for the additional methods.
    * */

    // if more than one abstract method. the object syntax has to be used.
}

// variable arguments

class VarArg{
    fun doStuff(vararg  values : String){ // values is an array object
        for ( i in values){
            println(i)
        }
    }

    fun doStuffa(vararg  values : String){ // values is an array object
        //  doStuffb(values) cannot call this because stuff B will return an array. when the parameter is expecting a string
        // to fix this use this ( * ) spread operator. it will tokenize the array indecies and convert them to strings
        doStuffb(*values) // this is not a pointer lol
    }

    fun doStuffb(vararg  values : String){ // values is an array object
        for ( i in values){
            println(i)
        }
    }

    fun callDoStuff(){
        doStuff("a","bv", "csas")
    }
}

// deconstruction
class Rectangle( val width : Int, val height : Int) {
    // deconstructing, must use the componentN() syntax
    operator fun component1() = width
    operator fun component2() = height
    // operator is used to override

}

// Method Extensions
// we can add methods to existing classes

class Extends {
    val list = listOf(1,3,4,5)
    fun go(){
        list.myJoin(',') // here my join is my extended function extending the list class
    }

    // here I define my method
    fun <T> List<T>.myJoin(sep : Char) : String {
        var s =""
        for(t in this) { // this, is refering to the list
            s += sep + t.toString()
        }

        return s
    }
    // same thing.
    fun <T> myJoin2(list : List<T> ,sep : Char) : String {
        var s =""
        for(t in list) { // this, is refering to the list
            s += sep + t.toString()
        }

        return s
    }
}

// companion objects
class comp {
    companion object {
        val x = 42 // only one value of this for all instances
        fun getValue () = 10
    }

    fun go(){println(x)}
}

// const are static but cannot be used in classes.
// they must be referenced by package name
// const are also bad when updating software. if the user has an older version they would need to recompile the program to
// see the new costs. since consts are added at compile time.
// its better to use companion objects as statics since the user will not have to recompile
const val MY_NAME = "Luis"
