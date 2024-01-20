class Sample {
    val flow1 = flow<Int> {
        emit(1)
        emit(2)
        emit(3)
        emit(4)
        emit(5)
        emit(6)
        emitStuff() // same as this.emitStuff()
    }

    suspend fun FlowCollector<Int>.emitStuff() {
        emit(10)
        emit(12)
        (30..50).forEach {
            emit(it) // recursive function for flow collecting will be on assignment
            // flows are cold.
        }
    }
    suspend fun MutableSharedFlow<Int>.emitStuff() {
        emit(10)
        emit(12)
        (30..50).forEach {
            emit(it)
        }
    } // this class is the hint for the assignment.

    fun foo() {
        val list = listOf(1,2,3,4,5,6,7,8,9)
        val flow2 = list.asFlow()
        // generally we don't create a flow and collect it in the same function like this...
        MainScope().launch { // this is a corotine launcher
            flow2.collect { // this is a suspend fucntion so it needs a scope.
                // do stuff with the flow
            }
        }

        val flow3 = flowOf(1,2,3,4,5,6,7,8)

        val flow4 = MutableSharedFlow<Int>()
        // expose as just a Flow<Int> to outsiders
        MainScope().launch {
            flow4.emitStuff()
        }


    }

}
