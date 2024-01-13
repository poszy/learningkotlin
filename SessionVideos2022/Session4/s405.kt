// scopping functions
//
class PersonWithoutConstructorParams {
    var name: String = ""
    var age: Int = 0
}


class Stuff {
    var name: String? = null

    // apply is a SCOPING function
    //    capture receiver as "this"
    //    return receiver
    //    mostly used for initialization



    val person = PersonWithoutConstructorParams().apply {
        name = "Scott"
        age = 55
    }

    fun doStuff() {
        val length = name?.length ?: 0

        val nameSnapshot = name
        if (nameSnapshot != null) {
            val x = nameSnapshot + "aaaa"
            val y = nameSnapshot.length
            val z = "$x$y"
            println(z)
        }

        doStuffIfNotNull(name) { name ->
            val x = name + "aaaa"
            val y = name.length
            val z = "$x$y"
            println(z)
        }

        name?.doStuff { name ->
            val x = name + "aaaa"
            val y = name.length
            val z = "$x$y"
            println(z)
        }

        val zLength = name?.let { name ->
            val x = name + "aaaa"
            val y = name.length
            val z = "$x$y"
            z
        }

        // let is a SCOPING function
        //    captures the current value of receiver as parameter to the lambda
        //    returns last expression in the lambda
        //    most often used for "if not null" capturing the value being tested

        val result = name?.run { // the reciver is the "name?" before .run
            if (first() == 'a') {
                42
            } else {
                length
            }
        } ?: 0

        // run is a SCOPING function
        //    captures the current value of receiver as "this" in the lambda
        //    returns last expression in the lambda
        //    most often used for just do some stuff in an expression context

        val thing = Person("Thing").also {
            // add to data structure or database
            // THEN return this
        }

        // also is a SCOPING function
        //    captures the current value of receiver as "it" in the lambda
        //    returns receiver for the lambda
        //    not used often; sometimes used to do "extra" things in the middle of chain

        // with DOES NOT take receiver - passes value as "this" to lambda
        with(thing) {
            if (name != "Thing") {

            } else {

            }
            name = "Hondo"
        }

    }
}

fun doStuffIfNotNull(string: String?, action: (String) -> Unit) {
    if (string != null) {
        action(string)
    }
}

// also similar to let
fun String.doStuff(action: (String) -> Unit) {
    action(this)
}
