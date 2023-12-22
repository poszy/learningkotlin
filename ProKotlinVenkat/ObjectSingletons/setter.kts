class Car ( val yearOfMake : Int, theColor : String ){

    var fuelLevel = 100

    var color = theColor
        set(value){
            if(value.isBlank()){
                throw RuntimeException("No empty, please")
            }
        field = value // the field value is var color = theColor, which is the parameter.
        }


}

val car = Car(2019, "Red")
car.color="Green"
car.fuelLevel--

print(car.fuelLevel) ///99

try {
    car.color = ""
} catch (ex: Exception){
    println(ex.message) // no empty, please
}

println(car.color) // Green