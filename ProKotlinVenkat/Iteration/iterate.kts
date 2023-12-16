
val arr : IntArray = intArrayOf(3,5,2,512,43)
val arr2 = arrayOf(3,2,12,31,53,321,)

for (e in arr) {println("$e")}
for (e in arr2){print("$e, ")}

val names = listOf("tom", "jerry", "spike")

for (index in names.indices){
    println("Position of ${names.get(index)} is $index")
}

//get the index too
for((index, name) in names.withIndex()){
    println("Position of $name is $index")
}