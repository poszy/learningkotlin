val oneToFive : IntRange = 1..5
val aToE : CharRange = 'a' ..'e' // LOL WTF?

// seriously wtf?
val seekHelp : ClosedRange<String> = "hell" .. "Help"
println(seekHelp.contains("helm")) // true
println(seekHelp.contains("helq")) // false
// ahh so it goes from l to p
// basically anything thats inbetween hell and help
// which is helm heln helo
// in lexical order
println(seekHelp)

// forward iteration
for (i in 1 ..5 ) { print("$i")} // is a val

for (ch in 'a' .. 'e'){ print (ch)}

// no iterator method. base classes dont have an iterator
//for (word in "hell" .. "help") {print("$word")}

// reverse iteration
for (i in 5.downTo(1)) {print("$i, ")}

// but you know tihs is kotlin. so theres a less verbose way
for (i in 5 downTo 1){print("$i")}

// skip values
for (i in 1 until 5) {print("$i")}

// no fucking way. what kind of black magic is this?
for (i in 1 until 10 step 3){print("$i")}

// get the last 20 lines of a file and skip every other line
val file : Int = 40
for (i in file until 20 step 2) {print("$i")}


// use filter funciton to skip lines that are not the same

for ( i in (1..9).filter{it %3 == 0 || it % 5 == 0}){
    print("$i")
}