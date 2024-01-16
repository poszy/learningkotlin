import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // do something when button pressed
        }
    }
    private JButton button = new JButton("Press Me");
    public UserInterface() {
        button.addActionListener(new ButtonHandler());

        // anonymous inner class
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // do something when button pressed
            }
        });

        // Java 8 added lambdas - only work for SAM interfaces
        //    SAM interface = SINGLE ABSTRACT METHOD
        button.addActionListener(e -> {
            // do something when button pressed
        });
    }
}
