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

        // TODO itt ezt átgondolni

        if (a.getType().equals("orangutan")){
            startingTile.receive(a);
            int i = 0;
            for (Panda p : a.getCaughtPandas()) {
                p.getTile().setAnimal(null);
                gameLogic.remove(p);
                ++i;
            }
            gameLogic.addPoints(i);

            a.release(a.getCaughtPandas().get(0));


        }
        else {
            a.getTile().remove();

            if (localAnimal == null) {
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
