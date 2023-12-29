/*
* By default, in Java, generics impose type invariance—that is, if a generic function expects a parametric type T,
* you’re not allowed to substitute a base type of T or a derived type of T; the type has to be exactly the expected type. That’s a good thing,
*
* */

// Type Invariance
/**
 *When a method receives an object of a class T, you may pass an object of any derived class of T. For example, if you may pass an instance of Animal,
 *  then you may also pass an instance of Dog, which is a subclass of Animal
 *
 * howver in generics
 * if a method receives a generic object of type T, for example, List<T>, then you may not pass an object of a generic object of derived type of T.
 * For example, if you may pass List<Animal>,
 * you can’t pass List<Dog> where Dog extends Animal. That’s type invariance—you can’t vary on the type.
 */

open class Fruit
class Bannana : Fruit ()
class Orange : Fruit()

fun recieveFruites(fruits : Array<Fruit>) {
    println("Number of fruits : ${fruits.size}")
}

val bannanas : Array<Bannana> = arrayOf()

// cannot do this , even if the banana extends Fruit
// recieveFruits(bannanas)

// this is because of kotlins type invariance with generic types. a basket of bananas does not inherite form a basket of fruits.
// inheritance means substitutability that is an instance of derived may be passed to any method that expects an instnace of base.

// Even though Banana inherits from Fruit, by disallowing the Array<Banana> to be passed in where Array<Fruit> is expected, Kotlin makes the use of generics type safe. \



fun recieveFruits(fruits : List<Fruit>) {
    println("Number of fruits : ${fruits.size}")
}

val b : List<Bannana> = listOf()
recieveFruits(b) // why does this work?

// listOf is immutable, and ArrayOf is mutable.
// using ArrayOf, we can add oranges to the array of fruits and that causes a mismatch.
// using listOf we cannot add anymore things to the list of fruits.

// how does kotlin tell the differece?
// The answer to that lies in how the two types are defined: class Array<T> vs. interface List<out E>. That out is the secret sauce. out is covariance. covariance is immutable and is used only for returning types.
