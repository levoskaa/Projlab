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
     * A piheno panda ennyi idot tolt a kanapen.
     */
    private int restingUntil;

    /**
     * Azt jelzi, mikor pihen a panda.
     */
    private boolean resting;

    /**
     * Konstruktor.
     */
    public TiredPanda() {
        restingUntil = 0;
    }

    /**
     * Setter fuggveny a 'resting' mezo beallitasara.
     * @param value A 'resting' mezo uj erteke;
     */
    public void setResting(boolean value) {
        resting = value;
    }

    /**
     * Setter fuggveny a 'setRestingUntil' mezo beallitasara.
     * @param value A 'setRestingUntil' mezo uj erteke;
     */
    public void setRestingUntil(int value) {
        restingUntil = value;
    }

    /**
     * Ha nincs elfogva a panda, akkor ennek a fuggvenyne a hatasara leul a kanapera.
     * @param t Az a csempe, amelyiken a kanape talalhato.
     */
    @Override
    public void sit(Tile t) {
        GameLogic.indent(true);
        System.out.println(">   TiredPanda::sit(Tile t)");
        if (!caught) {
            t.getItem().receive(this);
		}
        GameLogic.indent(false);
        System.out.println("<   TiredPanda::sit(Tile t)");
		return;
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny, ami hatasara a panda mozog.
     *
     * @see GameLogic
     */
    @Override
    public void move() {
        GameLogic.indent(true);
        System.out.println(">   TiredPanda::move()");

        // A panda pihen.
        if (resting && restingUntil > 0)
            restingUntil--;
        else {
            // A panda itt fejezi be a pihenest.
            if (resting) {
                currentTile.getItem().standUp();
            }
            // A panda nem pihen, mozoghat.
            super.move();
        }

        GameLogic.indent(false);
        System.out.println("<   TiredPanda::move()");
    }
}
