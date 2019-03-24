//  @ Project : Projlab
//  @ File Name : JumpingPanda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Ugros panda specifikus viselkedeset megvalosito osztaly.
 * @author Laurinyecz
 * @see Panda
 */
public class JumpingPanda extends Panda {
    /**
     * Konstruktor.
     */
    public JumpingPanda(Orangutan orangutan) {
        super(orangutan);
    }

    /**
     * Ugras eseten csokkenti a csempe elettartamat.
     */
    @Override
    public void jump() {
		System.out.println(">   JumpingPanda::jump()");
        currentTile.decraseHealth();
        System.out.println("<   JumpingPanda::jump()");
		return;
    }
}
