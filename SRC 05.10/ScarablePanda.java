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
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   ScarablePanda::scare()");
        }

        if (!caught) {
            if (SkeletonMenu.indent) {
                GameLogic.indent(false);
                System.out.println("<   ScarablePanda::scare()");
            }
            return;
        }
        orangutan.releaseBehind(this);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   ScarablePanda::scare()");
        }

        return;
    }

    /**
     * A panda tipusanak lekerdezese.
     *
     * @return A panda tipusa.
     */
    @Override
    public String getType() {
        return "scarable";
    }
}
