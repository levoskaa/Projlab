//  @ Project : Projlab
//  @ File Name : Panda.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import com.sun.org.apache.xpath.internal.operations.Or;

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
     * Referencia az orangutanra, amelyik vezeti a pandat.
     */
    protected Orangutan orangutan;

    /**
     * Konstruktor.
     */
    public Panda() {
        caught = false;
        this.orangutan = null;
    }

    /**
     * Setter fuggveny az 'orangutan' mezo beallitasara.
     *
     * @param orangutan Az 'orangutan' mezo uj erteke.
     */
    public void setOrangutan(Orangutan orangutan) {
        GameLogic.indent(true);
        System.out.println(">   Panda::setOrangutan(Orangutan orangutan)");

        this.orangutan = orangutan;

        GameLogic.indent(false);
        System.out.println("<   Panda::setOrangutan(Orangutan orangutan)");
        return;
    }

    /**
     * Setter fuggveny a caught valtozo beallitasara.
     *
     * @param value A caught valtozo uj erteke.
     */
    public void setCaught(boolean value) {
        GameLogic.indent(true);
		System.out.println(">   Panda::setCaught(boolean value)");

        caught = value;

        GameLogic.indent(false);
        System.out.println("<   Panda::setCaught(boolean value)");
		return;
    }

    /**
     * Visszaadja a panda pontbeli erteket.
     *
     * @return Mennyi pontot er a panda a kijaratra lepeskor.
     */
    /*@Override
    public int checkPoints() {
        GameLogic.indent(true);
		System.out.println(">   Panda::checkPoints()");

        if (caught) {
            GameLogic.indent(false);
			System.out.println("<   Panda::checkPoints()");
            return 50;
		}

        GameLogic.indent(false);
        System.out.println("<   Panda::checkPoints()");
        return 0;
    }*/

    /**
     * A panda halalakor eltavolitja azt a jatekterbol.
     */
    @Override
    public void die() {
        GameLogic.indent(true);
		System.out.println(">   Panda::die()");

        if (caught) {
            orangutan.release(this);
		}
        currentTile.remove();
        gameLogic.remove(this);

        GameLogic.indent(false);
		System.out.println("<   Panda::die()");
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
        System.out.println(">   Panda::move()");

        super.move();

        GameLogic.indent(false);
        System.out.println("<   Panda::move()");
        return;
    }

    /**
     * A panda elfogasakor hivodik meg.
     */
    @Override
    public void catchPanda(Orangutan orangutan) {
        GameLogic.indent(true);
		System.out.println(">   Panda::catchPanda()");

        // Csak akkor kapja el a pandat, ha az meg nem vezetett
		if (!caught) {
            orangutan.add(this);
            this.orangutan = orangutan;
        }

        GameLogic.indent(false);
		System.out.println("<   Panda::catchPanda()");
		return;
    }

    /**
     * A csempe ezzel a fuggvennyel tud jelezni a rajta allo allatnak,
     * hogy egy masik allat nekiutkozott.
     * @param a Az allat, amivel az utkozes tortent.
     */
    @Override
    public void collideWith(Animal a) {
        GameLogic.indent(true);
        System.out.println(">   Panda::collideWith(Animal a)");

        a.collisionWithPanda(this);

        GameLogic.indent(false);
        System.out.println("<   Panda::collideWith(Animal a)");
        return;
    }

    /**
     * A pandanak utkozes eseten nincs specifikus mukodese.
     * @param p A panda, amivel az utkozes tortent.
     */
    @Override
    public void collisionWithPanda(Panda p) {
        GameLogic.indent(true);
		System.out.println(">   Panda::collisionWithPanda(Animal a)");

        GameLogic.indent(false);
		System.out.println("<   Panda::collisionWithPanda(Animal a)");
		return;
    }

    /**
     * A pandanak utkozes eseten nincs specifikus mukodese.
     * @param o Az orangutan, amivel az utkozes tortent.
     */
    @Override
    public void collisionWithOrangutan(Orangutan o) {
        GameLogic.indent(true);
        System.out.println(">   Panda::collisionWithOrangutan(Animal a)");

        GameLogic.indent(false);
        System.out.println("<   Panda::collisionWithOrangutan(Animal a)");
        return;
    }
}
