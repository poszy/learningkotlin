
fun foo() {
    val list = MyLinkedList<String>()

}

fun printSize(list: MyLinkedList<*>) {
    println(list.size)
}

fun interface Processor<T:Any> { // decalring functional interface allows you to use it as a lambda.
    fun process(value: T)
}


private val processors = mutableMapOf<KClass<*>, (Any) -> Unit>() // * is the wildcard. it can be anything. KClass<*> .. this means I dont care what it is, its going to be a Key to my value .. (Any) -> Unit() . means for every key value we are going to produce a value


fun register1(kClass: KClass<*>, processor: (Any) -> Unit) {
    processors[kClass] = processor // we are registering a process.
}

fun process(value: Any) {
    // look up a processes and invoke a value on it.
    processors[value::class]?.invoke(value) ?: throw IllegalStateException("No processor registered for type ${value::class.simpleName}")
}

private val processors2 = mutableMapOf<KClass<*>, Processor<*>>()
// setting an upper bound here. this maeks sure T cannot be nullable
fun <T: Any> register2(kClass: KClass<T>, processor: Processor<T>) {
    processors2[kClass] = processor
}

//reified and inline. takes the Processor<T> type and uses it for T::Class. without it the class type gets erased at runtime
// reified makes T::class be understaood at T
// inline can only access whats available to it.
inline fun <reified T: Any> register2a(processor: Processor<T>) =
        register2(T::class, processor)

fun <T: Any> register3(kClass: KClass<T>, processor: (T) -> Unit) {
    processors[kClass] = processor as (Any) -> Unit
}


fun <T:Any> process2(value: T) {
    (processors2[value::class] as? Processor<T>)?.process(value) ?: throw IllegalStateException("No processor registered for type ${value::class.simpleName}")
}

open class View
fun <T: View> findViewById(id: Int): T {
    return View() as T
}

fun main() {
    val view1 = findViewById(42) as View
    val view2 = findViewById<View>(42)

    register2(String::class) {
        println(it.length)
    }

    // with reified, we dont have to add the String::Class because it knows now.
    register2a { s: String ->
        println(s.length)
    }
    register2a<String> { // <String> is passed in as a parameter to the lambda
        println(it.length)
    }
    register3(String::class) {
        println(it.length)
    }
    process("Lu")
    process2("lu")
}

// know what is refied, and how it works at a high level and how you can use it to pass
// passing in generic, upper bounds
// everything up to 903.kts. two types of contrains on generics.
