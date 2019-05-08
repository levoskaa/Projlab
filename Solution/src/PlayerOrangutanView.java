//  @ Project : Projlab
//  @ File Name : PlayerOrangutanView.java
//  @ Date : 2019.05.06.
//  @ Author : Laurinyecz

import javax.swing.*;

public class PlayerOrangutanView extends OrangutanView {

    private PlayerOrangutan playerOrangutan;

    public PlayerOrangutanView() {
        this(0, 0, null);
    }

    public PlayerOrangutanView(int x, int y, PlayerOrangutan po) {
        img = new ImageIcon("./src/images/orangutan(o).png").getImage();
        z_order = 2;
        coordinates = new Point(x, y);
        playerOrangutan = po;
    }

    // ide lehet kell egy draw()
}
