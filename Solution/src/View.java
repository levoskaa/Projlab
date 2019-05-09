//  @ Project : Projlab
//  @ File Name : View.java
//  @ Date : 2019.05.07.
//  @ Author : Laurinyecz

import javax.swing.*;
import java.awt.*;

public class View {

    private GameWindow mainWindow;

    int maxWidth;
    int maxHeight;

    public void init() {
        buildFrame();
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

    private JFrame buildFrame() {
        mainWindow = new GameWindow("Game");
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //mainWindow.setSize(600, 600);

        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Rectangle bounds = env.getMaximumWindowBounds();
        int maxWidth = bounds.width;
        int maxHeight = bounds.height;
        mainWindow.setSize(new Dimension(maxWidth, maxHeight));
        mainWindow.setResizable(false);

        mainWindow.setVisible(true);

        JPanel pane = new JPanel();
        mainWindow.add(pane);
        mainWindow.setVisible(true);


        return mainWindow;
    }
}
