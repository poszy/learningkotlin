import kotlin.system.measureTimeMillis

// how can we use parrelization to make things more efficient?

/*
* suspend - can only be ran inside a rorotine. and the contents inside can also code other suspend functions.
* or corotines.and the corotine runtime will allow other corotines or threads to take over this funciton execution
* <A,B> two type parameters, data of the incoming list and outgoing list
* and get passed into the mapping function  (mapper : suspend (A) -> B). which means it takes a functional argument and executes that function with B. in this case it
* Then it returns a List<B>
* Iterator : next() , hasNext()
* Amything thats Iterable<A> we can call pMap
* structured corotines
* **/
suspend fun <A,B> Iterable<A>.pmap(mapper : suspend (A) -> B) : List<B> = corotineScope{
    map {
        async{
            mapper(it)
        }
    }.awaitAll()
}


val list1 = listOf(1,2,3,4,5,6,7,8,9,10)

runBlocking{ // calling run blocking because this is a corotine. and delay is a suspend function that needs to ran in a corotine because its a delay function. or another delay function
    println(

            measureTimeMillis {
                println(
                        list1.map {
                            delay(500) // takes 5 seconds for each iteratoin. we can break this down
                            it * 2
                        }
                )
            }
    )
}

// this is how we break it down
// when running the dispatchers.default. whenever something is ran,
// it will pool from the Default thread pool and use a thread to run it

runBlocking(Dispatchers.Default){ //

    println(

            measureTimeMillis {
                println(
                        list1.pmap { // this should be atomic. if one thread fails to execute. all other threads should stop. but we should not stop the runblocking scope or any other parent scope.
                            delay(500) // takes 5 seconds for each iteratoin. we can break this down
                            it * 2
                        }
                )
            }
    )

}

// parrellization is only worth doing with pure functions.