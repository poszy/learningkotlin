
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
            addActionListener {
                (1..100).forEach {
                    label.text = it.toString()
                    Thread.sleep(50)
                }
            }
        }
        add(button)
        add(label)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        setSize(300, 200)
        isVisible = true
    }
}

main()