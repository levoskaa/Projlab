public class PlayerOrangutan extends Orangutan {
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


        // TODO

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
