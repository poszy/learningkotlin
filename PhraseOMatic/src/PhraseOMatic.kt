fun main(){




    val wordArray1 = arrayOf("24/7","multi-tier","B-to-b", "Dynamic", "persuasive");
    val wordArray2 = arrayOf("empowered","leveraged","aligned", "targeted", "yup");
    val wordArray3 = arrayOf("process","bike","swimmer", "boat", "car");

    val arraySize1 = wordArray1.size
    val arraySize2 = wordArray2.size
    val arraySize3 = wordArray3.size


    val rand1 = (Math.random() * arraySize1).toInt()
    val rand2 = (Math.random() * arraySize2).toInt()
    val rand3 = (Math.random() * arraySize3).toInt()

    val phrase = "${wordArray1[rand1]} ${wordArray2[rand2]} ${wordArray3[rand3]}"
    println(phrase)

    var myArray = arrayOf(1,2,3)
    myArray[1] = 15

    //explicit byte array
    //uses Array<> like array list
    var lArray: Array<Byte> = arrayOf(1,2,3)


}