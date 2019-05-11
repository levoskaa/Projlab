//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Projlab
//  @ File Name : EntryWardrobe.java
//  @ Date : 2019.03.23.
//  @ Author : Kalai
//
//

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Osztaly a bemeneti szekrenyek viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * az ExitPoint osztaly ebbol az osztalybol szarmazik.
 *
 * @author Kalai
 * @see BaseTile
 */
public class EntryWardrobe extends BaseTile {

    /**
     * Referencia a kimeneti szekrenyre, vagyis egy specialis csempere.
     */
    protected BaseTile destination;

    public EntryWardrobe() {
        try {
            image = ImageIO.read(getClass().getResource( "images/wardrobe.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setter fuggveny a destination valtozo megvaltoztatasara.
     *
     * @param t A kimeneti szekreny.
     */
    public void setDestination(BaseTile t) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   EntryWardrobe::setDestination(Tile t)");
        }

        destination = t;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   EntryWardrobe::setDestination(Tile t)");
        }
        return;
    }

    /**
     * Getter fuggveny a destination valtozo lekerdezesere.
     *
     * @return A kimeneti szekreny.
     */
    public BaseTile getDestination() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   EntryWardrobe::getDestination()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   EntryWardrobe::getDestination()");
        }
        return destination;
    }

    /**
     * Amennyiben egy allat a bemeneti szekrenyre akar lepni, ez a fuggveny hivodik meg.
     *
     * @param a Az allat, amely a szekrenyre akar lepni.
     */
    public void receive(Animal a) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   EntryWardrobe::receive(Animal a)");
        }

        destination.receive(a);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   EntryWardrobe::receive(Animal a)");
        }
        return;
    }

    /**
     * Megadja, hogy az adott Item szekreny-e vagy sem.
     *
     * @return Ha az Item szekreny, true (leszarmazottban override), amugy false;
     */
    public boolean isWardrobe() {
        return true;
    }
}
