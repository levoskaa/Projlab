//  @ Project : Projlab
//  @ File Name : JumpingPanda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Ugros panda specifikus viselkedeset megvalosito osztaly.
 *
 * @author Laurinyecz
 * @see Panda
 */
public class JumpingPanda extends Panda {
    /**
     * Ugras eseten csokkenti a csempe elettartamat.
     */
    @Override
    public void jump() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   JumpingPanda::jump()");
        }

        currentTile.decreaseHealth();

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   JumpingPanda::jump()");
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
        return "jumping";
    }
}
