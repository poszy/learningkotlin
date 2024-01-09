package card
enum class Suit { CLUBS, DIAMONDS, HEARTS, SPADES}

sealed class Card (val suit : Suit)

class Ace (suit : Suit) : Card(suit)

class King(suit: Suit) : Card (Suit){
    override fun toString(): String {
        return "King of $suit"
    }
}


fun main (args : Array<String>) {
    println(process(Ace(Suit.DIAMONDS)))    // Ace of DIAMONDS
    println(process(Queen(Suit.CLUBS)))    // Queen of CLUBS
    println(process(Pip(Suit.SPADES, 2)))   // 2 of SPADES
    println(process(Pip(Suit.HEARTS, 6)))  // 6 of HEARTS
}