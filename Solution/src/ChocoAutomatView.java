import javax.swing.*;

/**
 * Az ItemView specializalasa a csokiautomata esetere
 * @author Cynolter
 */
public class ChocoAutomatView extends ItemView {

    /**
     * Konstruktor, amelyben a fuggeseket, poziciokat beallithatjuk.
     * @param x A kanape x koordinataja.
     * @param y A kanape y koordinataja.
     * @param ca Referencia a csokiautomatara.
     */
    public ChocoAutomatView(int x, int y, ChocoAutomat ca){
        coordinates.x = x;
        coordinates.y = y;
        item = ca;
        img = new ImageIcon("./src/images/automat.png").getImage();
        z_order = 1;
    }
}
