
// this creates a constructor that takes an integer parameter and initialize a read only propery named yearOfMake
// the kotlin compiler will write a constructor, defiend a field and added a getter to reterieve the value of that field
class Car (val yearMakeOfModel : Int) // this is a read only class

// the line above is the same as. just shorthand.
public class Car2 public constructor(public val yearOfMake :Int)

// in kotlin the line that defined hte class isa actually defining the primary constructor

val car = Car(2019) // there is no new keyword needed.
println(car.yearMakeOfModel)

// since val is immutable, this will fail
// car.yearOfMake = 2019 .. that is it cannot be modified.

val car2 = Car2(2022)
println(car2.yearOfMake)