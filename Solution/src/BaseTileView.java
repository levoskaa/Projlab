import javax.swing.*;
import java.awt.*;

/**
 * A BaseTile osztalyu objektumokhoz tartozó View osztaly.
 *
 * @author schutz
 */
public class BaseTileView implements IDrawable {

    protected Image img;
    protected int z_order;
    protected Point coordinates;
    private BaseTile baseTile;
    private View view;


    public void setCoordinates(Point point){
       coordinates = point;
    }

    @Override
    public void draw() {

    }
}
