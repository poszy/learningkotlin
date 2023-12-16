fun max (vararg numbers : Int) : Int{
    var large = Int.MIN_VALUE

    for (number in numbers){
        large = if (number > large) number else large

    }

    return large
}

val values = intArrayOf(1,21,4)

// obv cant do this
// println(max(values))

// dont do this anymore. its not the "kotlin way"
println(max(values[1], values[2], values[0]))

// instead use the spread operator. this only works
// when the parameter is specified as vararg
println(max(*values))

// you can also do insane things like this
// cast here, because list of is generic List<t>
println(max(*listOf(1,4,18,12).toIntArray()))