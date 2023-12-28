
// first thing to do when creating a list is speficying is if its mutable
// use listOf() for immutability and mutableListOf() for mutability

val fruits : List<String>  = listOf("apple", "banannas", "strawberries")
println(fruits)

// to get a value we can use get() or we can use the [] syntax. only if its immutable
println(" ${fruits[0]}")

// contain methods are available
println(fruits.contains("apple")) // true
println("apple" in fruits) // true

// since we have an immutable list
// we can create another list and append the old list to it.
val fruits2 = fruits + "orange"
println(fruits2)

// we can also remove items from a list to a new list
val noOrange = fruits2 - "orange" // this is insna.e
println(noOrange)

println(fruits::class) // class java.util.Arrays$ArrayList
println(fruits.javaClass) // class java.util.Arrays$ArrayList

// mutable lists , try to avoid as much as possible for som reason.
// adding stuff to list can lead to bugs. its better to create a new list with the old data in it.
val fruits4 : MutableList<String> = mutableListOf("new,","old", "whatever")
println(fruits4::class) // class java.util.ArrayList

// now we can add to the list
fruits4.add("newitem")

for ((index, value) in fruits.withIndex()){ println( "${index} and ${value}")}

/*
* while both lists and arrays can be used to store collections of elements, lists offer a more functional and high-level approach with many built-in functions,
* whereas arrays provide more direct access and mutability.
* The choice between them depends on your specific use case and requirements
*
*   List: Lists are generally more suitable when you need to perform operations like mapping, filtering, and transforming data. However, since lists are immutable, creating a new list involves copying the existing elements.
    Array: Arrays can be more efficient for situations where you need to modify the elements frequently, as they allow direct access to elements and in-place modification.
    * Instead of interacting with the ArrayList<T> through the MutableList<T> interface, obtained using the mutableListOf() function,
    * you may directly obtain a reference of type ArrayList<T> using the arrayListOf() function.
    * Where possible, use listOf() instead of mutableListOf() and arrayListOf()—only reluctantly bring in mutability.
* */