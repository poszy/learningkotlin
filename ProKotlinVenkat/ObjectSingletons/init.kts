class Car(yearOfMake : Int, theColor : String ){

    var fuelLevel = 100
        private set

    var color = theColor
        set(value){
            if (value.isBlank()){
                throw RuntimeException("No empty please")
            }
            field = value
        }

    // initblocks should be avoided but can be used and should be limited to 1 block
    // htough the init block requires access to fuelLevel and it cant be earlier that the declared ration of fuelLevel
    init {
        if (yearOfMake > 1940 ){ fuelLevel - 90}
    }
}

class Car2(yearOfMake : Int, theColor : String ){

    // a better way to code. we can get rid of the init block enterily. and use a condition right inside fuelLevel
    var fuelLevel = if(yearOfMake < 2020) 90 else 100
        private set

    var color = theColor
        set(value){
            if (value.isBlank()){
                throw RuntimeException("No empty please")
            }
            field = value
        }


}