class PriorityPair< T: Comparable<T>>(member1 : T , member2 : T){

    val first : T
    val second : T

    init{
        if(member1 >= member2){ // the comparison is possible because we have the generic extending comparable
            first = member1
            second = member2
        } else{
            first = member2
            second = member1
        }
    }

    override fun toString() = "${first} , ${second}"
}

println(PriorityPair(2, 1))      //2, 1​
println(PriorityPair("A", "B"))  //B, A​