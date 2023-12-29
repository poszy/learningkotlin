// what if we want to pass a Fruit or one of the derived classes of Fruit into a collection of Fruit or any class that is collection of a base of Fruit.
// IN - CONTRAVARIANCE - MUTABLE -   -write - no get - only sets
// use a super type where a base type is expected.
// I.E Any into Fruit or Fruit into Banana . in this case its the opposite. covariance, lets us use bannana where a fruit is expected. contravariance lets us use Any object where a fruit is expected.
// since we know there is no risk in adding bannaas to an any objects list. we still know its a fruit list of any objects, instead of fruit list of fruit objects
open class Fruit
class Bannana : Fruit ()
class Orange : Fruit()

val things = Array<Any>(3) {_ -> Fruit()}
val b = Array<Bannana>(3) {_ -> Bannana() }
fun copyFromTo0(from : Array<out Fruit>, to :Array< Fruit>){

    for( i in 0 until from.size){
        to[i] = from[i]
    }
}

// cannot do this
// copyFromTo0(b, things)  //ERROR: type mismatch


// the in specification tells Kotlin to permit method calls that set in values on that parameter and not permit methods that read out.
fun copyFromTo(from : Array<out Fruit>, to :Array< in Fruit>){

    for( i in 0 until from.size){
        to[i] = from[i]
    }
}

// This again is a use-site variance, but this time for contravariance (in) instead of covariance (out).
// contravariance—that is, that type can only receive parametric types and can’t return or pass out parametric types.
copyFromTo(b, things) //LGTM