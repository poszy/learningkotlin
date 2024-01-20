import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.awt.BorderLayout
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.WindowConstants

// flow are a pair of threads that are sending and receving data
// homework here.

data class Movie(
        val id: String,
        val title: String,
        val year: Int,
)

class DAO {
    suspend fun getMovie(id: String) = withContext(Dispatchers.IO) {
//        delay(1000) // simulate super slow db access
        when (id) {
            "terminator" -> Movie("terminator", "The Terminator", 1984)
            "transporter" -> Movie("transporter", "The Transporter", 2002)
            "spiderverse" -> Movie("spiderverse", "Into The Spiderverse", 2018)
            else -> null
        }
    }
}

class ViewModel {
    private val dao = DAO()
    private val context = CoroutineName("view model context")
    private val scope = CoroutineScope(context)

    private val _movieFlow = MutableStateFlow<Movie?>(null) // a bucket that is going ot
    val movieFlow: Flow<Movie?> = _movieFlow

    fun loadMovie(id: String) {
        scope.launch {
            val movie = dao.getMovie(id)
            _movieFlow.emit(movie) // emit is general for MutableFlow
//            _movieFlow.value = movie // works as well
        }
    }
}

fun main() {
    val viewModel = ViewModel()

    fun movieButton(id: String, title: String) =
            JButton(title).apply {
                addActionListener {
                    viewModel.loadMovie(id)
                }
            }

    JFrame().apply {
        layout = BorderLayout()
        add(BorderLayout.WEST,
                JPanel().apply {
                    layout = BoxLayout(this, BoxLayout.Y_AXIS)
                    add(movieButton("terminator", "The Terminator"))
                    add(movieButton("transporter", "The Transporter"))
                    add(movieButton("spiderverse", "Into The Spiderverse"))
                }
        )

        val titleLabel = JLabel("Title:")
        val yearLabel = JLabel("Year:")

        add(BorderLayout.CENTER,
                JPanel().apply {
                    layout = BoxLayout(this, BoxLayout.Y_AXIS)
                    add(titleLabel)
                    add(yearLabel)
                }
        )

        val scope = MainScope()
        scope.launch {
            viewModel.movieFlow.collect { movie ->
                titleLabel.text = "Title: ${movie?.title ?: ""}"
                yearLabel.text = "Year: ${movie?.year ?: ""}"
            }
        }

        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setSize(300, 200)
        isVisible = true
    }
}
