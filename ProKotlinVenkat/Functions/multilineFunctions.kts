fun max (numbers : IntArray) : Int {
    var large = Int.MIN_VALUE // this will get the smallest value avainle for an int

    for ( number in numbers){
        large = if (number > large) number else large
    }

    return large
}

println(max(intArrayOf(1,4,5,2,13,7,3)))