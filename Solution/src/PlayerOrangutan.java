public class PlayerOrangutan extends Orangutan {
    /**
     * A GameLogic altal periodikusan meghivott fuggveny ...
     * @see GameLogic
     */
    @Override
    public void move() {
        GameLogic.indent(true);
        System.out.println(">   PlayerOrangutan::move()");
        // TODO
        GameLogic.indent(false);
        System.out.println("<   PlayerOrangutan::move()");
    }
}
