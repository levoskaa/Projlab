//  @ Project : Projlab
//  @ File Name : Panda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import java.util.ArrayList;

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
    protected boolean caught;

    /**
     * Referencia az orangutanra.
     */
    protected Orangutan orangutan;

    /**
     * Konstruktor.
     */
    public Panda(Orangutan orangutan) {
        caught = false;
        this.orangutan = orangutan;
    }

    /**
     * Setter fuggveny a caught valtozo beallitasara.
     * @param value A caught valtozo uj erteke.
     */
    public void setCaught(boolean value) {
        caught = value;
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
        if (caught)
            orangutan.release(this);

        currentTile.remove();
        gameLogic.remove(this);
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny, ami hatasara a panda mozog.
     * @see GameLogic
     */
    @Override
    public void move() {
        ArrayList<BaseTile> neighbours = currentTile.getNeighbours();
        // A szomszedos csempek kozul veletlenszeruen valaszt egyet, amire megprobal ralepni.
        // (Lehetseges, hogy egy helyben marad, ha foglalt csempere akar lepni.)
        neighbours.get((int) (Math.random() * neighbours.size())).receive(this);
    }

    /**
     * A panda elfogasakor hivodik meg.
     */
    @Override
    public void catchPanda() {
        orangutan.add(this);
    }

    @Override
    public void collision(Animal a) {}
}
