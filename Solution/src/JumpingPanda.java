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
        GameLogic.indent(true);
        System.out.println(">   JumpingPanda::jump()");

        currentTile.decreaseHealth();

        GameLogic.indent(false);
        System.out.println("<   JumpingPanda::jump()");
        return;
    }
}
