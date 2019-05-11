import javax.swing.*;

/**
 * Az ItemView specializalasa a jatekgep esetere.
 *
 * @author Cynotler
 */
public class SlotMachineView extends ItemView {

    /**
     * Konstruktor, amelyben a fuggeseket, poziciokat beallithatjuk.
     *
     * @param x  A kanape x koordinataja.
     * @param y  A kanape y koordinataja.
     * @param sm Referencia a jatekgepre.
     */
    public SlotMachineView(int x, int y, SlotMachine sm) {
        coordinates.x = x;
        coordinates.y = y;
        item = sm;
        img = new ImageIcon("./src/images/slotmachine.png").getImage();
        z_order = 1;
    }
}
