import javax.swing.*;

/**
 * A BreakableTile osztalyu objektumokhoz tartozo View osztaly.
 *
 * @author schutz
 */
public class BreakableTileView extends TileView {
    private BreakableTile breakableTile;

    public BreakableTileView(){this(0,0,null);}

    public BreakableTileView(int x, int y, BreakableTile b){
        coordinates = new Point(x, y);
        breakableTile = b;
        img = new ImageIcon("./src/images/breakabletile_notbroken.png").getImage();
        z_order = 0;
    }
    @Override
    public void draw() {

    }
}
