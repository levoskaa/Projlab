//  @ Project : Projlab
//  @ File Name : ScarablePanda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Ijedos panda specifikus viselkedeset megvalosito osztaly.
 * @author Laurinyecz
 * @see Panda
 */
public class ScarablePanda extends Panda {
    /**
     * Konstruktor.
     */
    public ScarablePanda(Orangutan orangutan) {
        super(orangutan);
    }

    /**
     * Megijesztett panda elengedi a mogotte jovo panda kezet.
     */
    @Override
    public void scare() {
		System.out.println(">   ScarablePanda::scare()");
        if (!caught){
			System.out.println("<   ScarablePanda::scare()");
            return;
		}
        orangutan.releaseBehind(this);
        System.out.println("<   ScarablePanda::scare()");
		return;
    }
}
