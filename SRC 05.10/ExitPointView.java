import javax.swing.*;

/**
 * Az ExitPoint osztalyu objektumokhoz tartozo View osztaly.
 *
 * @author schutz
 */
public class ExitPointView extends EntryWardrobeView {
    private ExitPoint exitPoint;

    public ExitPointView(){this(0,0,null);}

    public ExitPointView(int x, int y, ExitPoint e){
        exitPoint = e;
        coordinates = new Point(x,y);
        img = new ImageIcon("./src/images/exitpoint.png").getImage();
        z_order = 0;
    }

    @Override
    public void draw() {

    }
}
