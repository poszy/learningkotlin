
// these are properties not fields, kotlin does not directly epxpose fields of classes.
class Car( val yearOfMake : Int , var color : String) // we can set mutable properties by specifying var

val myCar = Car(20, "Red")

println(myCar.color  + myCar.yearOfMake) // calling car.yearOfMake is actually car.yearOfMake() javabean conventions
myCar.color = "green"

println(myCar.color  + myCar.yearOfMake) // green
