// sets are unordered

/*
*like the methods for creating List<T>, which has both immutable/read-only and mutable/read-write versions,
* you may create instances of Set<T> using setOf() or instances of MutableSet<T> using mutableSetOf().
* You may also use hashSetOf() to get a reference of type java.util.HashSet<T>: linkedSetOf() for LinkedHashSet, and sortedSetOf() for TreeSet<T>.
* */

val fruits : Set<String> = setOf("apple", "pair", "orange", "apple")

// sets gurantee uniquness so the last apple is discarded.

println(fruits)
println(fruits::class)/// class java.util.LinkedHashSet
println(fruits::javaClass) //val T.javaClass: java.lang.Class<T>

for( i in fruits){ if (i == "apple") println(true) else println(i)}

// just like list, set has a bunch of built in helper methods that array does not. this includes size() average() reduce() map()