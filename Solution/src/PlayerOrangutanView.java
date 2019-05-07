//  @ Project : Projlab
//  @ File Name : Animal.java
//  @ Date : 2019.05.06.
//  @ Author : Laurinyecz

import javax.swing.*;
import java.awt.*;

public class PlayerOrangutanView extends OrangutanView implements IDrawable {
    public PlayerOrangutanView() {
        img = new ImageIcon("./src/images/orangutan(o).png").getImage();
        z_order = 2;
        coordinates = new Point();
    }

    public void draw() {

    }
}
