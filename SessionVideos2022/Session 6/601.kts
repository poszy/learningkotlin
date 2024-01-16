enum class Suit ( val fancyName : String){ // everything in this class has the same properties. same functions and member vars
    Spades("I a, Spades"),
    Hearts("I am hearsts"),
    Diamonds("I am diamonds"),
    Clubs("I am clubs"); // one of the few times we have to use a semicolon. since we want to seperate the list from the functions

    fun trumps( otherSuit : Suit) =
            ordinal < otherSuit.ordinal // ordinal is built into enum. basically spades is ordinal position 1.. clubs ..4.. we can compare which has a higher value with ordinal.
            // boolean is infered im here

}

data class Card(
        val rank : Int,
        val suit : Suit
)

val card = Card (1, Suit.Clubs)
val card1 = Card(1,Suit.Hearts)

val r = when(card.suit) {
    Suit.Clubs -> 1
    Suit.Hearts -> 2
    Suit.Diamonds -> 3

    Suit.Spades -> 4
} // list must be exhuastive.
println(card)
println(r)


// If I dont want the list to be exhaustive
val r2 = when(card.suit) {

    Suit.Clubs -> card.suit.fancyName
    else-> " I am a lowly card"
}

println(r2)

println(card.suit.trumps(card1.suit))
println(card1.suit.trumps(card.suit))