//  @ Project : Projlab
//  @ File Name : Animal.java
//  @ Date : 2019.05.06.
//  @ Author : Laurinyecz

import javax.swing.*;
import java.awt.*;

public class OrangutanView implements IDrawable {
    protected Image img;
    protected int z_order;
    protected Point coordinates;

    public OrangutanView() {
        img = new ImageIcon("./src/images/orangutan(ai).png").getImage();
        z_order = 2;
        coordinates = new Point();
    }

    public void draw() {

    }
}
