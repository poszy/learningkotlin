// maps also have two interfaces which are immutable and immutable

// The key-value pairs are created using the to() extension function, available on any object in Kotlin
// mapOf(), which takes a vararg of Pair<K, V>. The size property will tell you the number of entries in the map.
val sites = mapOf("googgle" to "google.com", "yahoo" to "yahoo.com")
println(sites.size)

// can iterate the key value pairs, just like we would do with index and element
for ((k,v) in sites){ println("${k} and ${v}")}

// contains
print(sites.containsKey("googgle")) // true
print(sites.containsValue("google.com")) // true
println("yahoo" in sites) // true
println("yahoo.com" in sites) // false can only do keys
println("yahoo.com" in sites.values) // true

// we can use the get() function but with a catch
// since the value may not exist, the get() functions returns a possible nullable string
val yahoo : String? = sites.get("yahoo")

// we can get around the nullable by creating a default value
// if key yahoo does not exist, then add yahoo.com and that will be the value of yahoood
val yahood = sites.getOrDefault("yahoo", "yahooo.com")

// mapOf functions is immutable but we can create a new map

val newSites = sites + ("new item" to "newsite.coim")
println(newSites)

val withoutAgileDeveloper = sites - "yahoo"

// we can also iterate this way
for (i in sites ){ println("${i.key} and ${i.value}")}

// we can also use a simpler destructing

for ((k,v) in sites){println(" $k ---- $v")}