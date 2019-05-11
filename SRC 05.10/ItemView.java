import java.awt.*;

/**
 * AZ itemekhez tartozo view ososztaly
 *
 * @author Cynolter
 */
public class ItemView implements IDrawable {

    /**
     * A kep, aminek meg kell jelennie, ahol egy targy van.
     */
    protected Image img;
    /**
     * Tarolja, hogy ki elott, vagy ki mogott van a targy.
     */
    protected int z_order;
    /**
     * A targy koordinatait tarolo mezo.
     */
    protected Point coordinates;
    /**
     * Az altalanos targy, a heterogen mukodes vegett.
     */
    protected Item item;

    /**
     * @param p A pont ahova az itemet el szeretnenk helyezni (x,y).
     */
    public void setCoordinates(Point p) {
        coordinates = p;
    }

    /**
     * A kozos draw fuggveny, amivel ki tudjuk rajzolni az adott koordinatakra a targyat.
     */
    @Override
    public void draw() {
        //toDO
    }
}
