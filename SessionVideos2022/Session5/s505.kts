// objects as anonymous inner class replacements

interface SunListener {
    fun onSunRise()
    fun onSunSet()
}

class WeatherStation {
    var sunListener: SunListener? = null

    fun setupSunListener(sunListener: SunListener) {

    }

    fun setupSunListener(
            onSunRise: () -> Unit,
            onSunSet: () -> Unit,
    ) {
        // set them up
    }
}

fun main() {
    val weatherStation = WeatherStation()
    weatherStation.setupSunListener(object: SunListener {
        override fun onSunRise() {
            TODO("Not yet implemented")
        }
        override fun onSunSet() {
            TODO("Not yet implemented")
        }
    })
    weatherStation.sunListener = object: SunListener {
        override fun onSunRise() {
            TODO("Not yet implemented")
        }
        override fun onSunSet() {
            TODO("Not yet implemented")
        }
    }


    weatherStation.setupSunListener(
            onSunRise = {

            },
            onSunSet = {

            }
    )
