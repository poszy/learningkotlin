// classes are all final by default
// need to be open for inheritance
// sealed interfaces can only be inherited from within the same module or file

//  in java interfaces can have default methods, static and private
// so what makes kotlin interfaces beter?

// they are mainly the same, but the syntax is different.

interface Remote { // interfaces cannot have any fields, but a class can implement many interfaces
    fun up() // these are abstract by default. no need for keyword
    fun down()

    fun doubleUp() {
        up()
        up()
    }


}

class TV{
    var volume = 0
}

class TVRemote ( val tv : TV) : Remote{ // Implement Remote and its methods
    // and pass in a TV object
    override fun up() {
        tv.volume++ // with this TV object passed in. the interface method up and down are utilized to increment the only property in the TV object
    }

    override fun down() {
        tv.volume--
    }

}

val tv = TV()
val remote : Remote = TVRemote(tv) // interesting


println("Volume: ${tv.volume}") //Volume: 0
remote.up()
println("After increasing: ${tv.volume}") //After increasing: 1
remote.doubleUp()
println("After doubleUp: ${tv.volume}")

// to have static methods in an interface, we have to use a companion object
class Test { // companion object needs to be inside of a class.
    companion object Remotes {
        fun combine(first : Remote, second: Remote) : Remote = object : Remote{
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()

            }

        }
    }

}

val anotherTV = TV()

val combinedRemote =  Test.Remotes.combine(remote, TVRemote(anotherTV))

combinedRemote.up()
println(tv.volume)
println(anotherTV.volume)

// When implementing an interface, you must implement all the abstract methods. When implementing multiple interfaces, any methods that collide—that is, have the same name and signature—must be implemented in the class as well