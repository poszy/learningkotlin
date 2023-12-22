// Access Modifiers in kotlin are

// public
// private
// protected : gives permisison to the methods of the derived class to access that property
// internal : gives permission for any code in the same module to access the property or method.


// the access permission for the getter is the same as that for the property.
class Car ( val yearOfMake : Int, theColor : String ){

    var fuelLevel = 100
        private set // make

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
 // car.fuelLevel-- CANNOT CHANGE fuellevel now

print(car.fuelLevel) ///99

try {
    car.color = ""
} catch (ex: Exception){
    println(ex.message) // no empty, please
}

println(car.color) // Green