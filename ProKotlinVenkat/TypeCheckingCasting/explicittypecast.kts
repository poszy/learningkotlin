// thi sis unsafe, only use explicity type casts, when the compiler cannot determine the smartcast

// for instance this function

fun fetchMessage(id: Int) : Any = if (id == 1) "Record Found" else StringBuilder("Data not found")

// we can type cast using as

//for (id in 1..2){
//    println("Message length : ${(fetchMessage(id) as String).length}")
//}

// for loop results in java.lang.ClassCastException: java.lang.StringBuilder cannot be cast to java.lang.String
//	at Explicittypecast.<init>(explicittypecast.kts:10)

// we can fallback on is. or use as?

val message : String = fetchMessage(1) as String // this will work because of the conditional in the function
val message1 : String? = fetchMessage(1) as? String // i

println(message) // record found
println(message1) // record found
val id : Int = 12
println("Message length: ${(fetchMessage(id) as? String)?.length ?: "---"}")

/*
*
* The safe cast operator as? is better than the unsafe as. Here are some recommendations to take to the office:

    Use smart casts as much as possible.
    Use safe cast only when smart cast isn’t an option.
    Use unsafe cast if you want to see the application crash and burn.
*
* */