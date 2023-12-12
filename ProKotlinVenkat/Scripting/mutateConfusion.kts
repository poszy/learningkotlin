var factor = 2

fun doubleIt(n : Int) = n * factor

var message = "the factor is $factor"

factor = 0
print(doubleIt(2)) // zero
println(message) // 2 because factor is still 2 when message gets assigned.

/*
* The variable factor within the function doubleIt() binds to the variable outside its immediate scope—that is, in its lexical scope.
* The value of factor at the time of the function call is used. The string template, on the other hand, is evaluated when the variable message is created,
*  not when its value is printed out. These kinds of differences increase cognitive load and makes the code hard to maintain and also error prone.
* No need to torture fellow programmers with code like this. It’s inhumane. Again, as much as possible prefer
*
* */
