//  @ Project : Projlab
//  @ File Name : Panda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import java.util.ArrayList;

/**
 * Osztaly a Pandak viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a JumpingPanda, TiredPanda es ScarablePanda osztalyok ebbol az osztalybol szarmaznak.
 *
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
		System.out.println(">   Panda(Orangutan orangutan)");
        caught = false;
        this.orangutan = orangutan;
        System.out.println("<   Panda(Orangutan orangutan)");
    }

    /**
     * Setter fuggveny a caught valtozo beallitasara.
     *
     * @param value A caught valtozo uj erteke.
     */
    public void setCaught(boolean value) {
		System.out.println(">   setCaught(boolean value)");
        caught = value;
        System.out.println("<   setCaught(boolean value)");
		return;
    }

    /**
     * Visszaadja a panda pontbeli erteket.
     *
     * @return Mennyi pontot er a panda a kijaratra lepeskor.
     */
    @Override
    public int checkPoints() {
		System.out.println(">   checkPoints()");
        if (caught) {
			System.out.println("<   checkPoints()");
            return 50;
		}
        System.out.println("<   checkPoints()");
        return 0;
    }

    /**
     * A panda halalakor eltavolitja azt a jatekterbol.
     */
    @Override
    public void die() {
		System.out.println(">   die()");
        if (caught) {
            orangutan.release(this);
		}
        currentTile.remove();
        gameLogic.remove(this);
		System.out.println("<   die()");
		return;
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny, ami hatasara a panda mozog.
     *
     * @see GameLogic
     */
    @Override
    public void move() {
		System.out.println(">   move()");
        ArrayList<BaseTile> neighbours = currentTile.getNeighbours();
        // A szomszedos csempek kozul veletlenszeruen valaszt egyet, amire megprobal ralepni.
        // (Lehetseges, hogy egy helyben marad, ha foglalt csempere akar lepni.)
        neighbours.get((int) (Math.random() * neighbours.size())).receive(this);
		System.out.println("<   move()");
		return;
    }

    /**
     * A panda elfogasakor hivodik meg.
     */
    @Override
    public void catchPanda() {
		System.out.println(">   catchPanda()");
        orangutan.add(this);
		System.out.println("<   catchPanda()");
    }

    @Override
    public void collision(Animal a) {
		System.out.println(">   collision(Animal a)");
		System.out.println("<   collision(Animal a)");
    }
}
