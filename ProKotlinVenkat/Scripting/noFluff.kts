fun nofluff(){
    println("No fluf here")
}

println("Can call here too: nofluff()" )


try {
    nofluff()

}catch (ex: Exception){
    println("if not this")
    val stackTrace = ex.getStackTrace()
    println(stackTrace[0])
    println(stackTrace[1])
}

