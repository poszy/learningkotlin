import java.awt.datatransfer.StringSelection

// classes can be marked final override, to prevent subclasses from overriding

// val can be overriden in base classes with val and var,
// var can only be overriden with var.
// this is because val only has a getter. so overriding with var adds a setter.
// we shouldent try and remove a setter, by overriding a var with a val


// classes must be set as open for inheritance. kotlin this is called base class, instead of parent
open class Vehicle(val year: Int, open var color: String){ // first parameter year, cannot be overriden, but the second color, can because it is open

    open val km = 0 // can also be overriten

    final override fun toString() = "Year : $year, Color: $color, KM : $km" //  when the km property is accessed within the toString() method, the overridden implementation in Car is used due to polymorphism

    fun repaint(newColor : String){
        color = newColor
    }


}

var v1 = Vehicle(10, "purple")
open class Car( year : Int, color : String) : Vehicle(year,color){ // the two params in Car get added to the base class.
    // class can also be a base class to another class.
    override var km : Int = 0

        set(value){ // this value is set to whatever ovvide var km is set to

            if (value < 1){
                throw RuntimeException("Cant set negative values")
            }

            field = value // then this backing field gets set to whatever value is and is returned
        }

    fun drive(distance : Int) {
        km = km + distance

    }



}

var car = Car(2019, "Orange") // these values are also passed into the vehicle object and stored there
println(car.year)
println(car.color)

car.drive(10) // km is modified in the car class not vehicle
println(car) // this println function is overiden in Vehicle. and is used due to polymorphism

try{
    car.drive(-30)
}catch (ex: RuntimeException) {
    println(ex.message)
}

class FamilyCar(year : Int, color: String) : Car(year, color){

    override var color : String
        get() = super.color
        set(value){ // value is whateverthe get() gets
            if (value.isEmpty()) {
                throw RuntimeException("Color Required")
            }

            super.color = value // we can override the base class value this way. not sure this works.
            println("-------------")
            print(super.color)
            println("-------------")
        }
}


val familyCar = FamilyCar(2019, "Green")

println("Family Color : ${familyCar.color}")
println("Car Color : ${car.color}")

try {
    familyCar.repaint("Yellow")
}catch (ex : RuntimeException) {
    println(ex.message)
}



println(familyCar.color) // yellow
println(car.color) // orange