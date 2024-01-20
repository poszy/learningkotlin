import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.WindowConstants
import kotlin.system.exitProcess

// coroutines - cooperative multitasking
// suspend functions
//    extra implicit param - Continuation
//    suspend fun foo() {
//       do x
//       do y
//       call suspend fun z
//       do a
//       do b
//       call suspend fun c
//    }
//    suspend fun foo(continuation: Continuation) {
//       when(continuation.label) {
//          1 -> {
//             load data from continuation
//             do x
//             do y
//             save data in continuation
//          }
//          2 -> {
//             load data from continuation
//             call suspend fun z
//             do a
//             do b
//             save data in continuation
//          }
//          3 -> {
//             load data from continuation
//             call suspend fun c
//             save data in continuation
//          }
//    }
//
// coroutines run on Dispatchers
//    Main - UI thread
//    IO - Good for blocking IO
//    Default - general worker threads
//
// suspend fun foo() {
//    withContext(Dispatchers.Main) {
//       do stuff on UI thread
//    }
//    withContext(Dispatchers.IO) {
//       do blocking IO
//    }
//    withContext(Dispatchers.Default) {
//       do general background work
//    }
//    withContext(Dispatchers.Default) {
//       withContext(Dispatchers.Main) {
//            update UI "loading"
//       }
//       do general background work
//       withContext(Dispatchers.Main) {
//            update UI progress
//       }
//       do general background work
//       withContext(Dispatchers.IO) {
//          do blocking IO
//       }
//       do general background work
//       withContext(Dispatchers.Main) {
//            update UI "done"
//       }
//    }
// }
//
// coroutine context = indexed set of elements
//    name - explicit name for debugging
//    dispatcher - default dispatcher to use when launching
//
// coroutine scope - holds a context

// often some common contexts/scopes defined by platform
//    GlobalScope - DO NOT USE THIS!!!
//    MainScope() - sets up basic scope to run on UI Thread
//    Android has a bunch - viewModelScope, lifecycleScope


fun main() {
    //set up the two things corotines need
    val context = CoroutineName("worker") + Dispatchers.Default // the add function here appends the type of dispatches to the context. its a list.
    val scope = CoroutineScope(context)

    // everytime scope.launch is ran, it creates a job.
    var job: Job? = null

    JFrame().apply {
        layout = FlowLayout()
        val label = JLabel("")
        val button = JButton("Press Me").apply {
            addActionListener {
                job?.cancel()
                job = scope.launch {
                    try {
                        (1..100).forEach {
                            withContext(Dispatchers.Main) {
                                label.text = it.toString() // swing allows UI property updates on other threads
                            }
                            if (it == 57) {
                                throw RuntimeException()
                            }
                            delay(50) // delay is a suspend function. do not use thread.sleep. delay is non blocking. so something else can use
                        }
                        job = null
                    } catch(e: RuntimeException) {
                        exitProcess(1)
                    }
                }
            }
        }
        val cancelButton = JButton("Cancel").apply {
            addActionListener {
                job?.cancel()
            }
        }
        add(button)
        add(label)
        add(cancelButton)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setSize(300, 200)
        isVisible = true
    }
}

