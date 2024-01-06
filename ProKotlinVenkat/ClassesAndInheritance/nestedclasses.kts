import java.rmi.Remote

// using inner classes we can get the benfits  offered by having a seperate class
// without compromising efficieny.
// this is weird, but its how iterators are implemented


class TV {

    private var volume = 0

    val remote: Remote
        get() = TVRemote()

    override fun toString(): String = "Volume: ${volume}"


    inner class TVRemote : Remote {
        fun up() {
            volume++
        }

        fun down() {
            volume--
        }

        override fun toString(): String = "Remote: ${this@TV.toString()}" // “this of TV”—that is, this will refer to the TVRemote instance but this@TV refers to the instance of the outer class TV.
    }
}

val tv =TV()

val remote = tv.remote
println("$tv")


