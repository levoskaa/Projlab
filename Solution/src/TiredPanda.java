//  @ Project : Projlab
//  @ File Name : TiredPanda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Faradt panda specifikus viselkedeset megvalosito osztaly.
 * @author Laurinyecz
 * @see Panda
 */
public class TiredPanda extends Panda {
    /**
     * Konstruktor.
     */
    public TiredPanda(Orangutan orangutan) {
		System.out.println(">   TiredPanda(Orangutan orangutan)");
        super(orangutan);
        System.out.println("<   TiredPanda(Orangutan orangutan)");
    }

    /**
     * Ha nincs elfogva a panda, akkor ennek a fuggvenyne a hatasara leul a kanapera.
     * @param t Az a csempe, amelyiken a kanape talalhato.
     */
    @Override
    public void sit(Tile t) {
        System.out.println(">   sit(Tile t)");
        if (!caught) {
            t.getItem().receive(this);
		}
        System.out.println("<   sit(Tile t)");
		return;
    }
}
