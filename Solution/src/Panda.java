//  @ Project : Projlab
//  @ File Name : Panda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Osztaly a Pandak viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a JumpingPanda, TiredPanda es ScarablePanda osztalyok ebbol az osztalybol szarmaznak.
 * @author Laurinyecz
 * @see Animal
 */
public abstract class Panda extends Animal {
    /**
     * Jelzi, ha a pandat az orangutan vezeti.
     */
    private boolean caught;

    /**
     * Setter fuggveny a caught valtozo beallitasara.
     * @param value A caught valtozo uj erteke.
     */
    public void setCaught(boolean value) {
        caught = value;
    }

    /**
     * Konstruktor.
     */
    public Panda() {
        caught = false;
    }

    /**
     * Visszaadja a panda pontbeli erteket.
     * @return Mennyi pontot er a panda a kijaratra lepeskor.
     */
    @Override
    public int checkPoints() {
        if (caught)
            return 50;
        return 0;
    }

    /**
     * A panda halalakor eltavolitja azt a jatekterbol.
     */
    @Override
    public void die() {
        currentTile.remove();
        GL.remove(this);
    }
    
    public abstract void doYourThing();
}
