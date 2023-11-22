package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.mvc.api.SimpleController;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame(TITLE);

    public SimpleGUIWithFileChooser(SimpleController controller) {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        final JButton save = new JButton("Save");
        panel.add(save, BorderLayout.SOUTH);

        final JPanel browsePanel = new JPanel();
        browsePanel.setLayout(new BorderLayout()); 
        final JButton browse = new JButton("Browse...");
        browsePanel.add(browse, BorderLayout.LINE_END);
        final JTextField textField = new JTextField(controller.getPath());
        textField.setEditable(false);
        browsePanel.add(textField, BorderLayout.CENTER);
        panel.add(browsePanel, BorderLayout.NORTH);
        final JTextArea textArea = new JTextArea();
        panel.add(textArea);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                int returnVal = chooser.showSaveDialog(frame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    controller.setFile(chooser.getSelectedFile());
                    textField.setText(chooser.getSelectedFile().getPath());
                } else if (returnVal != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(textField, e, TITLE, returnVal);
                }
            }
        });

        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeContent(textArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }            
        });
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
        SimpleController controller = new Controller();
        new SimpleGUIWithFileChooser(controller).display();
    }
}
