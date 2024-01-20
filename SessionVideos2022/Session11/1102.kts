
import java.awt.FlowLayout
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.WindowConstants

// preemptive multitasking
//    - CPU divides up the process power
// cooperative multitasking
//    - developer must be nice and code "yielding"
fun main() {
    JFrame().apply {
        layout = FlowLayout()
        val label = JLabel("")
        val button = JButton("Press Me").apply { // the problem here is the main thread sleeps. we should do all background tasks in a seperate thread. we shouldent make the user suffer for computations. 
            // in java and kotlin, we can use java objects and create a thread object. put we should use corotines

            addActionListener {
                // DON'T DO THIS - USE COROUTINES
//                val thread = object: Thread() {
//                    override fun run() {
//                        (1..100).forEach {
//                            SwingUtilities.invokeAndWait {
//                                label.text = it.toString() // swing allows UI property updates on other threads
//                            }
//                            sleep(50)
//                        }
//                    }
//                }
//                thread.start()
                thread {
                    (1..100).forEach {
                        SwingUtilities.invokeAndWait {
                            label.text = it.toString() // swing allows UI property updates on other threads
                        }
                        Thread.sleep(50)
                    }
                }

//                (1..100).forEach {
//                    label.text = it.toString()
//                    Thread.sleep(50)
//                }
            }
        }
        add(button)
        add(label)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setSize(300, 200)
        isVisible = true
    }
}


//debouncing is the technique where we prevent two threads from running at the same time while doing the same task. while thats doing nothing or delaying the execution of another thread or canceling current running threads.
// right now this code can execute multiple threads and update the counter at the same time causing mayhem
