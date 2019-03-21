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
        if (!caught)
            return;

        orangutan.releaseBehind(this);
    }
}
