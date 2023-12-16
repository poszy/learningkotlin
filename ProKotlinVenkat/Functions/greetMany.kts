fun greetMany(msg: String, vararg names : String){
    println("$msg ${names.joinToString(", ")}")

}

greetMany("hello","a","b","c",)