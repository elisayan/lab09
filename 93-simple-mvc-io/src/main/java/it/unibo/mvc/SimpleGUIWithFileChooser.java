package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUIWithFileChooser() {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JButton button = new JButton("Save");
        panel.add(button, BorderLayout.SOUTH);

        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout()); 
        final JButton browse = new JButton("Browse...");
        browsePanel.add(browse, BorderLayout.LINE_END);
        final JTextField textField = new JTextField();
        browsePanel.add(textField, BorderLayout.CENTER);

        panel.add(browsePanel, BorderLayout.NORTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUIWithFileChooser().display();
    }
}
