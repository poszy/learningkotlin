
val arr : List<String> = listOf("90" ,"200", "232323233")

println(arr.javaClass) // this will print out that its a java class
//class java.util.Arrays$ArrayList

// but we can print out the values much easier than in java.
for ((index, value) in arr.withIndex()){
    print("$index , $value \n")

}

// kotlin provides two views for each list, set and map
// for example list and mutable list are two different interfaces but both map to ArrayList in java
// immutable collections does not guarantee thread saftey.