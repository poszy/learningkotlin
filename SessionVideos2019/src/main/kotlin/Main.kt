package org.example
import Foo5
import MY_NAME
import Rectangle
import  Session2
import SubClass1
import VarArg
import comp

fun main() {
    println("Hello World!")

    val mSession = Session2()
    println(mSession.go())

    val noBraces = Foo5(20)
    println(noBraces.x)
    println(noBraces.y)

    val sClass = SubClass1(30)

    val dStuff = VarArg()
    dStuff.callDoStuff()

    // deconstruction
    val r = Rectangle(20,20) // here we override
    val (width, height) = r
    println("$width , $height")

    val co = comp()
    // this will not work
    // co.getValue()
    println(co.go()) // prints kotlin.Unit
    println(comp.getValue())// 10 // directly access static / companion variables or properties
    println(comp.x) // 42

    println(MY_NAME) // referenced by package

}