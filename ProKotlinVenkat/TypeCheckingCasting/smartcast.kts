class Animal(val age: Int){
    override operator fun equals(other: Any?) : Boolean {
        return if (other is Animal) age == other.age else false // we can use other.age without any cast because the if statement confirms other is an instance of animal
    }
}

val butch : Any = Animal(3)
val odie : Any = Animal(2)
val toto: Any = Animal(2)


println(odie == toto) // true
println(odie == butch) // false

class Animal2(val age: Int){
    override operator fun equals(other: Any?) = other is Animal2 && age == other.age  }
