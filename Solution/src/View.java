//  @ Project : Projlab
//  @ File Name : View.java
//  @ Date : 2019.05.07.
//  @ Author : Laurinyecz

import javax.swing.*;

public class View {

    private GameWindow mainWindow;

    public void init() {

    }

    public void drawAll() {

    }

    public void pandaRemoved() {

    }

    public void orangutanRemoved() {

    }

    public JFrame getFrame() {
        return  mainWindow;
    }

    private static JFrame buildFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        pane = new JPanel();
        frame.add(pane);
        return frame;
    }
}
