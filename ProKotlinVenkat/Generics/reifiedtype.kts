// old way in java to find the type of object when a mix of classes are in the same list
abstract class Book( val name : String)
class Fiction(name : String) : Book(name)
class NonFiction(name:String) : Book(name)

val books : List<Book> = listOf(Fiction("MobyDick"), NonFiction("Learn to code"), Fiction("LOTR")) // why is this possible? maybe listOf is immutable? and covariance?

fun <T> findFirst(books : List<Book>, ofClass : Class <T>) : T {

    val selected = books.filter { book -> ofClass.isInstance(book) }

    if (selected.isEmpty()) { throw RuntimeException("Not Found")}

    return ofClass.cast(selected[0])
}

println(findFirst(books, NonFiction::class.java).name) //Learn to Code ... there is a better way to do this in kotlin.

// do it the kotlin way
inline fun <reified T > findFirst(books: List<Book>) : T {
    val selected = books.filter { book -> book is T}
    if (selected.isEmpty()) { throw RuntimeException("Not Found")}
    return selected[0] as T // as is the keyword to cast.
}

println(findFirst<NonFiction>(books).name) //Learn to Code​

// a good explanation is here
// https://stackoverflow.com/questions/45949584/how-does-the-reified-keyword-in-kotlin-work