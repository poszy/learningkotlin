package org.example.Misc

import org.example.Session3.vars1
import kotlin.system.exitProcess
open class AA
class BB : AA()
class CC : AA()

interface A {
    fun foo1() { println("A")}
    fun foo2() : String { return "A"}
    fun foo3() : AA { return BB()}
}
interface B { // interfaces can have implentations
    fun foo1() { println("B")}
    fun foo2() : String { return "B"}
    fun foo3() :BB { return BB() }
}

class C : A, B { // when implementing multiple interfaces, the function has to ovveriddend with the super<> keyword
    override fun foo3(): BB {
        return super<B>.foo3()
    }
    override fun foo1() {
//        super<A>.foo1()
        super<B>.foo1()
    }

    override fun foo2(): String {
        return super<A>.foo2() + super<B>.foo2()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val c = C()
            c.foo1()
            someFun(c)
            println(c.foo2())
        }

        fun someFun(a : A) {
            a.foo1()
        }
    }
}

enum class BloodType (val displayName: String){
    A("A"),
    B("B"),
    AB("AB"),
    O("O"),

} // in enum, all have to have the same definition

// sealed classes are a bit different.
// only classes within the same file are allowed to inherit
// so this is like an enumeration, but each class can have their own functions
sealed class State
class PowerOn : State() { fun turnPowerOff() {}}
class PowerOff : State(){ fun turnPowerOn() {}}
class LightOn : State() {fun turnLightsOn() {}}


// if we dont want to make multiple instances of the sealed class.
// we can make them objects
// this creates a singleton
object OnFire : State() { fun OnFire() {}}

// we can use classes and objects like numerations that can implement different fuctions.
class Test {
    companion object {

        @JvmStatic
        fun main(args: Array<String>) { // need to set args : Array<String> when a main is nested with JVM Static
            val bt = BloodType.A
            bt.displayName

            val s: State = s1
            when (s) {
                is PowerOn -> {
                    println("do something") // is is like instance in java . so this is checking if its an instances
                    // smart casting is knows S is of type State or a subclass. so
                    // we can call functions
                    s.turnPowerOff()
                }

                is LightOn -> {
                    println("do something")
                }

                is PowerOff -> {
                    println("do something")
                }

                OnFire -> {
                    println("on fire")
                } // even if we create a singleton, our when statment will not be exhausted.
            }


            // as is for type casting in kotlin.
            val s2 = s as LightOn

            // we can return null if it cannot typecast
            val s3 = s as? LightOn

            val s4 =
                s as? LightOn ?: PowerOff() // elvis will put a default value if the left side of the condition is false
            val s5 = s as? LightOn ?: s as? PowerOn
            ?: s as? PowerOff // elvis will put a default value if the left side of the condition is false
            val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

            for (i in 0..10) {
                println(list[i])
            }
            for (i in 0 until list.size) {
                println(list[i])
            }
            for (i in 0 until list.size step 2) {
                println(list[i])
            }
            for (i in list.size - 1 downTo 0) {
                println(list[i])
            }

            for ( i in 0..10 ) {
                for (j in 0..10) {
                    if(j == 2){ break} // using brek here, will go to the next iteration of the I loop
                    if(j== 3){ continue} // this will break out of the if statement and proceeed to the next iteration of J
                }
            }

            // we can also label loops
            outer@ for ( i in 0..10 ) {
                for (j in 0..10) {
                    if(j== 3){ continue@outer} // this will break out of the if statement and proceeed to the next iteration of i
                    if(j == 2){ break@outer} // using brek here, will go stop the entire loop of i

                }
            }

            // nest lambdas

            val nl : String? = ""
            val nl2 : String? = ""
            val x = nl?.let foo@ {// if we want to return a value to the outer lambda , we can do this too. in this case x = 42
                nl2?.let { return@foo 42}
                10
            }

            val y= nl?.let  {// if we want to return a value to the outer lambda , we can do this too. in this case x = 42
                nl2?.also { return@let 42}
                10
            }
            val name : String? = ""
            val name2 : String? = ""

            name?.let { name1 -> println("Do something")
                name2?.let { name2 -> ("Do something else")
                } ?: throw IllegalStateException(" Set val2")
                } ?: throw IllegalStateException(" Set val1")

            val p = Person1("Luis")
            if(p.name != null) { println(p.name.length)} // thread issue, where p.name can be changed

            // we can use lets to make code thread safe
            p.name?.let{ // remember that let initilizes variables, makes copies. so it will create a new copy of name instead of modifying the orrigional
                println(it.length) // .let evaluates p.name and stored it into it.
             }

            // this is equivilant to
            // we first create copy of it and then do the test.
            val name3 = p.name
            if(name3 != null) {
                println(name.length)
            }

        }


        // the compiler will know that only the subclasses of State can be initilized\
        // can also have multiple instances
        val s1 = PowerOn()
        val s2 = PowerOff()
        val s3 = PowerOn()
        val s4 = LightOn()


    }



}

class Person1( val name: String?)  {
    fun rname(): String? { return this.name}
}
