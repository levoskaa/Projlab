import javax.swing.*;

/**
 * A Tile osztalyu objektumokhoz tartozo View osztaly.
 *
 * @author schutz
 */
public class TileView extends BaseTileView {

    private Tile tile;

    public TileView(){this(0,0, null);}

    public TileView(int x, int y, Tile t){
        img = new ImageIcon("./src/images/tile.png").getImage();
        z_order = 0;
        coordinates = new Point(x, y);
        tile = t;
    }

    @Override
    public void draw() {

    }
}
