import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

// java
//   @WorkerThread
//   public Movie getMovie() {
//       get data from database
//   }

// kotlin - withContext guarantees which dispatcher is running the function

class Movie
class Receipt
class Status

suspend fun getMovie(id: String) = withContext(Dispatchers.IO) { // need to be a suspend function because withContext is a suspend function
    delay(1000) // pretend we're calling a webservice
    Movie()
}
suspend fun payForMovie(movie: Movie) = withContext(Dispatchers.IO) {
    delay(1000) // pretend we're calling a webservice
    Receipt()
}
suspend fun addMovieToCollection(movie: Movie) = withContext(Dispatchers.IO) {
    delay(1000) // pretend we're calling a webservice
    Status()
}

suspend fun purchaseMovie(id: String) = withContext(Dispatchers.Default) {
    val movie = getMovie(id)
    val receipt = payForMovie(movie)
}