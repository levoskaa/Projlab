//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Projlab
//  @ File Name : ExitPoint.java
//  @ Date : 2019.03.23
//  @ Author : Kalai
//
//

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * Osztaly a kijarat viselkedesenek es tulajdonsagaiknak osszegyujtesere.
 *
 * @author Kalai
 * @see EntryWardrobe
 */
public class ExitPoint extends EntryWardrobe {

    /**
     * A kijarati pont egy referencian kereszul eri el a GameLogicot.
     */
    private GameLogic gameLogic;

    /**
     * Csempe amelyre az orangutan visszater, miutan kivezette a pandakat
     * a kijaraton keresztul.
     */
    private Tile startingTile;

    /**
     * Konstruktor
     */
    public ExitPoint() {
        try {
            image = ImageIO.read(getClass().getResource( "images/exitpoint.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Beallitja a kezdo csempet.
     *
     * @param sT a kezdo csempere vonatkozo referencia.
     */
    public void setStartingTile(Tile sT) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   ExitPoint::setStartingTile(Tile sT)");
        }

        startingTile = sT;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   ExitPoint::setStartingTile(Tile sT)");
        }
        return;
    }

    /**
     * Beallitja a GameLogicot.
     *
     * @param gameLogic a GameLogicra vonatkozo referencia.
     */
    public void setGameLogic(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    /**
     * Az ide lepo allatot a bejaratra teszi, levalasztja a pandakat, es
     * pontot oszt ertuk.
     *
     * @param a Az allat (orangutan) amely a kijaratra lepett.
     */
    public void receive(Animal a) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   ExitPoint::receive(Animal a)");
        }

        if (a.getType().compareTo("orangutan") == 0) {
            while (true) {
                startingTile.receive(a);
                if (a.getTile().getName().compareTo("st") == 0)
                    break;
            }
            int num = a.getCaughtPandas().size();
            if (a.getCaughtPandas().size() > 0) {
                for (Panda p : a.getCaughtPandas()) {
                    p.getTile().remove();
                    gameLogic.remove(p);
                }
                gameLogic.addPoints(10 * num);

                a.release(a.getCaughtPandas().get(0));
            }
        } else {
            if (localAnimal == null) {
                a.getTile().remove();
                localAnimal = a;
                localAnimal.setTile(this);
            } else {
                localAnimal.collideWith(a);
            }
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   ExitPoint::receive(Animal a)");
        }
        return;
    }
}
