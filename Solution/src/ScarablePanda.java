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
		System.out.println(">   ScarablePanda(Orangutan orangutan)");
        super(orangutan);
        System.out.println("<   ScarablePanda(Orangutan orangutan)");
    }

    /**
     * Megijesztett panda elengedi a mogotte jovo panda kezet.
     */
    @Override
    public void scare() {
		System.out.println(">   scare()");
        if (!caught){
			System.out.println("<   scare()");
            return;
		}
        orangutan.releaseBehind(this);
        System.out.println("<   scare()");
		return;
    }
}
