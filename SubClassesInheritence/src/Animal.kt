
// before a class can be superclassed you have to explicitly set it.
// you have to add the prefix to the class and any property with "open"

open class Animal(){

    // if these variables were "var" they would not need to be overridden.
    open val image   = ""
    open val food    = ""
    open val habitat = ""

    open fun makeNoise(){println("The Animal is making a noise")}
    open fun eat(){println("The Animal is eating")}
    open fun roam(){println("The Animal is roaming")}


}

// use the colon operator to "extends the class"
// if the class has a primary constructor "arguments" you must also call them in the params
// If you want to stop a function or property from being overridden further down the class hierarchy,
// you can prefix it with final
class Hipppo : Animal(){

    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "hippo.jpg"

    override fun makeNoise(){println("The Animal is making a noise")}
    override fun eat(){println("The Hip is eating")}

}

open class Canine: Animal(){
    override fun roam(){ println("The Canine is roaming")}

}

class Hippo:Animal(){

    override val image = "hippo.jpg"
    override val food  =  "grass"
    override val habitat = "water"

    override fun makeNoise(){println("Grunt!")}
    override fun eat(){println("The Hippo is eating $food")}
}

class Wolf:Canine(){

    override val image = "wolf.jpg"
    override val food  =  "meat"
    override val habitat = "forests"

    override fun makeNoise(){println("Hooooooowl!")}
    override fun eat(){println("The Wolf is eating $food")}

}

class Vet {

    fun giveShot(animal:Animal){
        animal.makeNoise()
    }
}

fun main(){
    // Animal and Wolf are differnt types
    // but because Wolf IS-A type of animal, the code will compile.
    var animal: Animal = Wolf()

    // the eat() function in wolf gets ran
    animal.eat()


    val animals = arrayOf(Hippo(), Wolf())

    for ( i in animals){
        i.roam()
        i.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()

    // Polymorphism, vet takes in an animal object,
    // because wolf and hippo extend or IS-A type of animal object, the code compiles
    //Polymorphism is the ability to use any subtype object in place of its supertype.
    // As different subclasses can have different implementations of the same function,
    // it allows each object to respond to function calls in the way that’s most appropriate for each object.
    vet.giveShot(wolf)
    vet.giveShot(hippo)


}