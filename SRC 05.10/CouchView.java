import javax.swing.*;

/**
 * Az ItemView specializalasa a kanape esetére.
 *
 * @author Cynolter
 */
public class CouchView extends ItemView {

    /**
     * Konstruktor, amelyben a fuggeseket, poziciokat beallithatjuk.
     *
     * @param x A kanape x koordinataja.
     * @param y A kanape y koordinataja.
     * @param c Referencia a kanapera.
     */
    public CouchView(int x, int y, Couch c) {
        coordinates.x = x;
        coordinates.y = y;
        item = c;
        img = new ImageIcon("./src/images/couch.png").getImage();
        z_order = 1;
    }
}
