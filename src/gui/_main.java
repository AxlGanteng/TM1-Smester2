package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class _main {

    public static void main(String[] args) {

        gui content = new gui();
        JFrame frame = new JFrame();
        frame.setContentPane(content.getPanel1());

        content.getMinimize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setExtendedState(frame.getExtendedState()| frame.ICONIFIED);
            }
        });

        frame.setUndecorated(true);
        frame.pack();
        frame.setVisible(true);
    }
}