//  @ Project : Projlab
//  @ File Name : OrangutanView.java
//  @ Date : 2019.05.06.
//  @ Author : Laurinyecz

import javax.swing.*;
import java.awt.*;

public class OrangutanView implements IDrawable {

    protected Image img;
    protected int z_order;
    protected Point coordinates;
    private Orangutan orangutan;
    private View view;

    public OrangutanView() {
        this(0, 0, null, null);
    }

    public OrangutanView(int x, int y, Orangutan o, View v) {
        img = new ImageIcon("./src/images/orangutan(ai).png").getImage();
        z_order = 2;
        coordinates = new Point(x, y);
        orangutan = o;
        view = v;
    }

    public void setCoordinates(Point p) {
        coordinates.x = p.x;
        coordinates.y = p.y;
    }

    @Override
    public void draw() {
        //view.getFrame().
    }
}
