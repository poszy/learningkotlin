fun createPerson(name: String, age : Int = 1, height : Int, weight : Int){
    println("$name $age $height $weight")
}

// dont invoke like this
createPerson("Lu", 22, 5, 120)

// invoke with named parametres
// named parameters can be placed in any order.
createPerson(name = "Lu", age = 122, weight = 432, height = 1152)

// named parameters can be placed in any order.
createPerson("Jake", age = 12, weight = 43, height = 152)

// can be used interchangeably. but has to be in order.
createPerson("Jake", 12, weight = 43, height = 152)

// since age has a default value, we can omit it
createPerson(weight = 43, height = 152, name = "Jake")

createPerson("Jake", weight = 43, height = 152)
