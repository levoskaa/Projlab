//  @ Project : Projlab
//  @ File Name : ScarablePanda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Ijedos panda specifikus viselkedeset megvalosito osztaly.
 *
 * @author Laurinyecz
 * @see Panda
 */
public class ScarablePanda extends Panda {
    /**
     * Megijesztett panda elengedi a mogotte jovo panda kezet.
     */
    @Override
    public void scare() {
        GameLogic.indent(true);
        System.out.println(">   ScarablePanda::scare()");

        if (!caught) {
            GameLogic.indent(false);
            System.out.println("<   ScarablePanda::scare()");
            return;
        }
        orangutan.releaseBehind(this);

        GameLogic.indent(false);
        System.out.println("<   ScarablePanda::scare()");
        return;
    }
}
