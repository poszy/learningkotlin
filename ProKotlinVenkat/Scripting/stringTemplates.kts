// no need for concatinations

// we can use "$VarName" with one $
// or use ${ $varOne some text inbetween $VarTwo }

val price = 9
val tax = 10

val output = "The amout $price after taxt comes to $${price * (1 + tax)}"
val disclaimer = "the amount is in US$ and \$only"

println(output)
println(disclaimer)

print("The price: $price and the tax: $tax")


// Escaping strings is messy
val name = "luis"
val escaped = "The kid asked, \"How's it going, $name?\""

// instead use raw strings
val raw = """ the kid asked, "hows it going, $name """
println(raw)