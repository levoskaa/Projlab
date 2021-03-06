//  @ Project : Projlab
//  @ File Name : TiredPanda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Faradt panda specifikus viselkedeset megvalosito osztaly.
 *
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
     *
     * @param value A 'resting' mezo uj erteke;
     */
    public void setResting(boolean value) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   TiredPanda::setResting(boolean value)");
        }

        resting = value;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   TiredPanda::setResting(boolean value)");
        }

        return;
    }

    /**
     * Setter fuggveny a 'setRestingUntil' mezo beallitasara.
     *
     * @param value A 'setRestingUntil' mezo uj erteke;
     */
    public void setRestingUntil(int value) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   TiredPanda::setRestingUntil(int value)");
        }

        restingUntil = value;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   TiredPanda::setRestingUntil(int value)");
        }

        return;
    }

    /**
     * Ha nincs elfogva a panda, akkor ennek a fuggvenyne a hatasara leul(het) a kanapera.
     *
     * @param t Az a csempe, amelyiken a kanape talalhato.
     */
    @Override
    public void sit(Tile t) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   TiredPanda::sit(Tile t)");
        }

        if (!caught) {
            if (!ProtoMenu.isRandom() || (ProtoMenu.isRandom() && Math.random() > 0.5))
                t.getItem().receive(this);
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   TiredPanda::sit(Tile t)");
        }

        return;
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny, ami hatasara a panda mozog.
     *
     * @see GameLogic
     */
    @Override
    public void move() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   TiredPanda::move()");
        }

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

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   TiredPanda::move()");
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
        return "tired";
    }
}
