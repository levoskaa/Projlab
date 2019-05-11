import javax.swing.*;

/**
 * Az EntryWardrobe osztalyu objektumokhoz tartozo View osztaly.
 *
 * @author schutz
 */
public class EntryWardrobeView extends BaseTileView {
    private EntryWardrobe entryWardrobe;

    public EntryWardrobeView(){this(0,0,null);}

    public EntryWardrobeView(int x, int y, EntryWardrobe e){
        img = new ImageIcon("./src/images/wardrobe.png").getImage();
        z_order = 0;
        entryWardrobe = e;
        coordinates = new Point(x, y);
    }

    @Override
    public void draw() {

    }
}
