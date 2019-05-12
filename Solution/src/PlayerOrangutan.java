import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Osztaly a jatekos altal iranyitott orangutan viselkedesenek, es mukodesnek implementalasara.
 * Az Animal es az Orangutan osztalyokbol szarmazik le.
 */
public class PlayerOrangutan extends Orangutan {

    /**
     * A jatekos altal kijelolt mezo, ahova az orangutannak lepnie kell, azaz a mezo, amelyre a felhasznalo az egerrel kattint.
     */
    BaseTile destination;

    public PlayerOrangutan() {
        try {
            image = ImageIO.read(getClass().getResource( "images/orangutan_o.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setter fuggveny a destination valtozohoz.
     * @param bt A destination uj erteke.
     */
    public void setDestination(BaseTile bt) {
        destination = bt;
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny ...
     *
     * @see GameLogic
     */
    @Override
    public void move() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   PlayerOrangutan::move()");
        }

        if (currentTile.getName().compareTo("e") == 0) {
            gameLogic.getMap().getTile("st").receive(this);
        } else {
            if (destination != null)
                destination.receive(this);
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   PlayerOrangutan::move()");
        }
    }

    /**
     * A jatekos altal vezetett orangutan halala eseten veget er a jatek.
     */
    @Override
    public void die() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::die()");
        }


        gameLogic.endGame();

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::die()");
        }
    }
}
