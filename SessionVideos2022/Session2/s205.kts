

    val x = 10
    val y = 20

    val result = if (x < 10) {
        "Low"
    } else if (y < 10) {
        "Lower"
    } else {
        "whatevs"
    }

    println( result)

    // simple when with explicit conditions
    //   conditions can be unrelated!
    val result2 = when {
        x < 10 -> {
            // other code
            "Low"
        }
        y < 10 -> "Lower"
        else -> "whatevs"
    }

    println( result2)


    // when with expression
    val results3 = when (x + y) {
        20 -> "foo"
        25 -> "fee"
        else -> "bye"
    }

    println( results3)

    // when with expression assigned to local property
    val results4 = when (val z = x + y) {
        20 -> "foo"
        25 -> "fee"
        else -> "bye: $z"
    }
    println( results4)

    foo(
        when {
            x < 20 -> "hello"
            y < 20 -> "hi"
            else -> "foofoo"
        }
    )


fun foo(string: String) {

    println(string)
}
