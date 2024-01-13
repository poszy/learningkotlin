package org.example.Session3

open class Mammal(override val name: String) : Named
class Cat(name : String) : Mammal(name) // pasing in name to cat will send it to the superclass mammal. remeber we can send parameters to parent classes directly int the default constructor.

class List {
    fun get (n : Int) : Any? {return null} // ? means it can return a null. Any keyword is like object, which is the super super class. its what all objects are
    fun add(item : Any) { } // this list is a good start, but there is no type saftey and you can add any objects into this list. which will need more code that involves type casting

}

fun listTest() {
    val list = List()

    // example of adding multiple object types
   // list.add(Cat())
    //list.add(Mammal())

    val cat = list.get(0)
    cat as Cat // This is how we type cast. this is not useful.
}

// so we can create a generic

// the name inside <> is not limited to T or anything. it can be whateever you want
class GList <ITEM> {
    fun get (n: Int) : ITEM? {return null}
    fun add (item : ITEM){}
}

fun listTest2() {
    // when making an instnace of GList, you have to specify which object you have
    val catList = GList<Cat>()
    val mammalList = GList<Mammal>()

    // now we dont have to cast type
    //catList.add(Cat())
    //mammalList.add(Mammal())
    val cat = catList.get(0)



}

// a generic list if not a subtype of another list.
// just because cat is a subtupe of mammal, a generic cat list is not a sublist of a generic mammal list
fun vars1(){
    var list : GList<Mammal>? = null
    val catList = GList<Cat>()
    val mammalList = GList<Mammal>()

    // this works fine because they are the same type of generic
    list = mammalList

    // this will not work list is just a mammal list.
    // list = catList

    // we want to be able to pass in a list of objects as long as the subtype is a mammal

}

// we can define an interface to help us assume what is in the generic.
// if we have the mammal class implement this interface,
// we force the generic to take in a string.
interface Named { val name : String}

class NameGList <ITEM : Named> { // the Named in <ITEM : Named> is called an upperbound
    // this means. whatever I pass in this parameter must implement that named interface.


    fun get(m : Int) : ITEM ? { return null }
    fun add (item : ITEM) {}
    fun getName( n : Int)  : String ? { return get(n)?.name}
}

class List2<ITEM> {
    val data = mutableListOf<ITEM>()
    fun get(n : Int) : ITEM = data[n]
    fun add ( item : ITEM ) {data.add(item)}

}

// here we are only using the fun next and ITEM as output. so we can let the compiler know
//  this called variance in type parameters, specifically covariance (out modifier) and contravariance (in modifier).
// covariance does not allow going in the opposite direction a more specific type (cat) cannot be assigned to a less specific type (mammal)
interface Source< out ITEM> { // this lets the compiler know about the subtypes. so if I have a cat. I can assume the superclass mamal will also come out. I am promissing the compiler, I will only use this as return types
    // anything that implements souce can call next
    fun next(): ITEM
}


fun sourceTest( cats : Source<Cat>)  {

    val objects: Source<Any> = cats // Covariant: Source<Cat> can be assigned to Source<Any>
    val mammals: Source<Mammal> = cats // Covariant: Source<Cat> can be assigned to Source<Mammal>
    val cat : Source<Cat> = cats

}

fun sourceTest2( mammals : Source<Mammal>)  {

    val objects: Source<Any> = mammals // Covariant: Source<Mammal> can be assigned to Source<Any>
    val mammals: Source<Mammal> = mammals
    // The following line won't work because Source is covariant, and you cannot assign a less specific type to a more specific type.
    // val cat: Source<Cat> = mammals
    // n this case, you can assign Source<Mammal> to Source<Any> because of covariance. However, you cannot assign Source<Mammal> to Source<Cat> because covariance doesn't work in the opposite direction. You cannot assign a more specific type to a less specific type.
    // covariance allows you to use a more specific type (Cat) where a less specific type (Mammal) is expected, but it doesn't allow the opposite. This helps ensure type safety in certain scenarios.


}

// In Kotlin, the in modifier on a type parameter in a generic class or interface makes it contravariant.
// Contravariance allows you to use a less specific type (Any in this case) where a more specific type (Cat or Mammal) is expected.
// The direction of assignment follows the reverse subtyping relationship compared to covariance
interface Transporter < in ITEM> { fun transport(item : ITEM)} // for in, I promise the compiler I am only using this as parameters or inputs . with in, I can take in a super class and get back the subclass
fun tTest(){
    var mammalTransporter : Transporter<Mammal>? = null
    var catTransporter : Transporter<Cat> ? = null
    var anyTransporter : Transporter<Any>? = null

    // In this case, Transporter<Any> can be assigned to both Transporter<Cat> and Transporter<Mammal> because the Transporter interface is contravariant in its type parameter ITEM.
    // Contravariance allows you to use a less specific type (Any) where a more specific type (Cat or Mammal) is expected.

    catTransporter = anyTransporter // Contravariant: Transporter<Any> can be assigned to Transporter<Cat>
    mammalTransporter = anyTransporter // Contravariant: Transporter<Any> can be assigned to Transporter<Mammal>
    catTransporter = mammalTransporter // Contravariant: Transporter<Mammal> can be assigned to Transporter<Cat>

    //Contravariance is useful when you want to represent a consumer of items. In the Transporter example,
    // the transport function consumes items of type ITEM. Contravariance allows you to pass a transporter of Any to a variable of type Transporter<Cat> or Transporter<Mammal>,
    // as you can safely transport any type of item to a more general transporter. The reverse assignment from more specific to less specific types is allowed in contravariant contexts
}

// using in and out lets the compiler know what is legal to assign variables to and also what methods we can use
// The out modifier on from makes it a producer (read-only), and the in modifier on to makes it a consumer (write-only).

fun <T> copy(from : List2<out T>, to : List2<in T>){
    // The following line won't work because 'from' is marked with 'out' which means it can only produce values, not consume them. read only
    // from.add(...) // Compilation error: Cannot infer type parameter T

    // Inside the copy function, you can only use methods that produce values from from (e.g., get).
    // You cannot use methods that consume values (e.g., add). This ensures that you only read from from and write to to, preserving type safety.
    // from.add(") this wont work

    val n = to.get(1)
}

fun <TO, FROM : TO> copy2(from : List2<FROM>, to : List2<TO>){

    // <TO, FROM : TO>: This declares two generic type parameters, TO and FROM. The FROM type parameter is constrained with : TO, meaning that FROM must be a subtype of or equal to TO.
    // This constraint ensures that the items in the from list can be safely cast to the type TO

    //from: List2<FROM>: This parameter represents the source list from which items will be copied. The list is of type FROM, which is a subtype of or equal to TO.

    // to: List2<TO>: This parameter represents the destination list to which items will be copied. The list is of type TO


    //Type Constraint: The constraint FROM : TO ensures that the type FROM is a subtype of or equal to TO.
    //This means that you can safely copy items from a list of type FROM to a list of type TO because FROM is either the same type or a more specific type

    // Covariance: Since FROM is a subtype of or equal to TO, the List2<FROM> is covariant in its type parameter.
    // This allows you to use a more specific type (FROM) where a less specific type (TO) is expected. In other words, you can use a list of FROM where a list of TO is required. (OUT)

}

// the copyTest function, catList1 is a List2<Cat>, and catList2 is a List2<Cat>.
// Both of these lists can be used as arguments for the copy function because of the out and in modifiers.
// The copy function can copy items from a list that produces (reads) items of type T to a list that consumes (writes) items of type T
fun copyTest(){
    val catList1 = List2<Cat>()
    val catList2 = List2<Cat>()
    val mammalList = List2<Mammal>()

    copy(catList1, catList2) // Works: 'catList1' is List2<out Cat>, and 'catList2' is List2<in Cat>



    // Similarly, catList1 can be copied to mammalList because mammalList is a List2<Mammal> and Cat is a subtype of Mammal.
    // The out modifier allows you to use a more specific type (Cat) where a less specific type (Mammal) is expected.
    copy(catList1, mammalList) // Works: 'catList1' is List2<out Cat>, and 'mammalList' is List2<in Mammal>

    copy2(catList1, mammalList)
}

// remember out . lets the compiler assume we are only going to use return types
interface Source2<out T > { fun next() : T } // out a more specific type (cat) can come out where a less specific type ( mammal) is expected. coveriance
interface Source3<out T : Mammal> { fun next() : T } // type constraint. T must be a subtype or equal to mammal. we can use a cat where a mammal is expected

// with in, the compiler assume we are using parameters.
// this is contravariant. I can use a less specific type Mammal, where a cat is expected.
interface Transporter2<in T> {
    fun transport(item : T)
}
// same thing, only with a type constraint.
interface Transporter3<in T : Mammal> { // the semi colon here extends mammal
    fun transport(item : T)
}

fun starTest( source : Source2<*>) { var a = source.next()} // a is of type any
fun starTest2( source : Source3<*>) { var a = source.next()} // a is of type mammal because we have the upper bound in source3


// The following two functions won't compile due to the limitations of '*' in the 'in' position:


// starTest(source: Source2<*>): Here, source is a Source2 with an unknown type parameter. Because of the wildcard (*),
// you can only safely call methods that produce values (read-only methods) on source. The type of the produced value (a) is inferred as Any
// fun starTest3(t: Transporter2<*>) { t.transport(null) } // Compilation error


// fun starTest4(t: Transporter3<*>) { t.transport(null) } // Compilation error

// the commented-out functions (starTest3 and starTest4) won't compile.
// The reason is that wildcards (*) in the 'in' position of a generic type parameter (in T) do not allow you to call methods that consume values (write-only methods).
// This is because the actual type of the items being transported is unknown, and you could potentially violate type safety by trying to transport inappropriate items.

// now with list, using the wild card also prohibits the use of set or write. we can only use read methods like get.
// and the variable n is considered a Any? object because we do not have an upperbounds on it.

fun listtest( list : List2<*>){
    val a = list.get(0)
    // cannot do this
    // list.add("") because of te * constraints.

}