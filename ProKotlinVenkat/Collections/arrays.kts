// * use arrays only when optimizing low level stuff
// other than that use list.

val friends = arrayOf("yo","yay","Nay","okay")

println(friends::class) // class kotlin.Array of type Array<T>
println(friends.javaClass)
println( "${friends[0]} and ${friends[1]}")

// create an array of integeres in the same way
// but it might not be the best to do this

val numbers = arrayOf(1,2,4)
println(numbers::class)
println(numbers::javaClass) //  in reality even though this is an array<t> its a boxed type of integer class. which creates overhead.

//use the specialized array

val numbers2 = intArrayOf(1,2,3)
println(numbers::class)
println(numbers::javaClass) // this is the same as before. perhaps this got fixed in the latest kotlin version.

// can get the size and average
println(numbers.size)
println(numbers.average())

// The Array constructor takes two parameters, the size of the array and a function that takes the index, starting with 0, and returns the value to be placed at that index.
println(Array(5) {i -> ( i + 1) * (i + 1)}.sum()) // I will never write code like this. wtf?

