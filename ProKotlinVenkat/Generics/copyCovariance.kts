/*
* Kotlin protects us from passing an Array<Banana> where Array<Fruit> is expected and thus prevents us from inadvertently adding some arbitrary fruit into an array of Banana.
* That’s great, but sometimes we want to tell Kotlin to relax the rules a bit, but without compromising type safety, of course.
* In other words, we want the Kotlin compiler to allow covariance—accept a generic of derived type where a generic of base type is expected.
* This is where type-projections come in. allow a bannna or orance into a fruit list
* OUT - COVARAIANCE - IMMUTABLE - derived where base  -read only - no sets - only gets
* */
open class Fruit
class Bannana : Fruit ()
class Orange : Fruit()

fun copyFromTo(from : Array<Fruit>, to :Array<Fruit>){

    for( i in 0 until from.size){
        to[i] = from[i]
    }
}
//{ _ -> Fruit() }: This is a lambda expression (anonymous function) that is used to initialize the elements of the array. Here's a breakdown of the lambda expression:
//
//    _ is a placeholder for an unused parameter. In this case, it indicates that the lambda takes a parameter but doesn't use it.
//    -> separates the parameter from the body of the lambda.
//    Fruit() is the body of the lambda and represents the expression that will be executed for each element of the array. In this case, it creates a new instance of the Fruit class.
val fruitsBasket1 = Array<Fruit>(3) { _ -> Fruit()}
val fruitsBasket2 = Array<Fruit>(3) { _ -> Fruit()}
copyFromTo(fruitsBasket1, fruitsBasket2) // this works because a base type is expected and got a basetype


val fruitsBasket = Array<Fruit>(3) { _ -> Fruit()}
val bBasket = Array<Bannana>(3) { _ -> Bannana() }

/*
* Kotlin blocks us from passing an Array<Banana> where Array<Fruit> is expected since it’s worried that the method copyFromTo()
* may potentially add a Fruit that’s not a Banana to the Array<Banana>,
* which should be a no-no; as we discussed earlier, Array<T> is type invariant.
* */
//copyFromTo(bBasket, fruitsBasket) // cannot do this.

// we can tell kotlin we only intened to read out the array passed to the "from" parameter
// there’s no risk of passing any Array<T> where T is either of type Fruit or a derived class of Fruit.
// This intent is called covariance on the parametric type—to accept a type itself or any of its derived types in its place.

fun copyFromTo2(from : Array< out Fruit>, to :Array<Fruit>){ // from: Array<out Fruit> is used to convey covariance on the Fruit parametric type. Kotlin will assert that no method call is made on the from reference that would allow data to be passed in.

    for( i in 0 until from.size){
        to[i] = from[i]

        // Kotlin will now verify that within the copyFromTo() function, no call to send in an argument of the parametric type Fruit is made on the parameter with covariance.
        // In other words, the following two calls, if present within the loop in copyFromTo(), will fail compilation:

        //  from[i] = Fruit()  //ERROR , no write
        // 	from.set(i, to[i]) //ERROR, no set
    }
}
/* With only code to read from the from parameter and code to set into the to parameter, we’ll have no trouble passing Array<Banana>, Array<Orange> or Array<Fruit> where Array<Fruit> is expected for the from parameter*/
copyFromTo2(bBasket, fruitsBasket) // now we can do this. we can allow a subtype to be placed where a base type is expected. a banna fruit basket is a fruit basket.

/*
* using covariance, we’re promising to the Kotlin compiler that we’ll not call any method that sends in any value with the given parametric type on Array<T>.
* This act of using covariance at the point of using a generic class is called use-site variance or type projection.

* Using covariance, you tell the compiler to accept a derived parametric type in place of a parametric type. You can ask the compiler to take base types as well.
 */