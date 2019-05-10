//  @ Project : Projlab
//  @ File Name : PandaView.java
//  @ Date : 2019.05.06.
//  @ Author : Laurinyecz

import javax.swing.*;
import java.awt.*;

public class PandaView implements IDrawable {

    protected Image img;
    protected int z_order;
    protected Point coordinates;
    private Panda panda;

    public PandaView() {
        this(0, 0, null);
    }

    public PandaView(int x, int y, Panda p) {
        img = new ImageIcon("./src/images/panda.png").getImage();
        z_order = 2;
        coordinates = new Point(x, y);
        panda = p;
    }

    public void setCoordinates(Point p) {
        coordinates.x = p.x;
        coordinates.y = p.y;
    }

    @Override
    public void draw() {

    }
}
