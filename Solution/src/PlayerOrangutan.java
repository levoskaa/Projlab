import javax.imageio.ImageIO;
import java.io.IOException;

public class PlayerOrangutan extends Orangutan {

    BaseTile destination;

    public PlayerOrangutan() {
        try {
            image = ImageIO.read(getClass().getResource( "images/orangutan_o.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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

        if (destination != null)
            destination.receive(this);

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
