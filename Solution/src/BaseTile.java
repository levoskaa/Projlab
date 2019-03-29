//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Projlab
//  @ File Name : BaseTile.java
//  @ Date : 2019.03.23.
//  @ Author : Kalai
//
//

import java.util.*;

/**
 * Osztaly a csempek viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a Tile (BreakableTile), EntryWardrobe (ExitPoint) osztalyok ebbol az osztalybol szarmaznak.
 *
 * @author Kalai
 */
public abstract class BaseTile {
    /**
     * Tarolja, hogy egy csempen van-e allat, es ha van, akkor melyik.
     */
    protected Animal localAnimal;

    /**
     * Tarolja, hogy egy csempenek mely mas csempek a szomszedai.
     */
    protected ArrayList<BaseTile> neighbours;

    /**
     * Getter fuggveny a neighbours valtozo lekerdezesere.
     *
     * @return A csempe szomszedai.
     */
    public ArrayList<BaseTile> getNeighbours() {
        GameLogic.indent(true);
		System.out.println(">   BaseTile::getNeighbours()");
        GameLogic.indent(false);
        System.out.println("<   BaseTile::getNeighbours()");
        return neighbours;
    }

    /**
     * Amennyiben egy allat a csempere akar lepni, ez a fuggveny hivodik meg.
     *
     * @param a Az allat, amely a csempere akar lepni.
     */
    public void receive(Animal a) {
        GameLogic.indent(true);
		System.out.println(">   BaseTile::receive(Animal a)");

		a.getTile().remove();

        if (localAnimal == null) {
            localAnimal = a;
            localAnimal.setTile(this);
        }
        else{
            localAnimal.collideWith(a);
        }
        GameLogic.indent(false);
        System.out.println("<   BaseTile::receive(Animal a)");
        return;
    }

    /**
     * Ha egy allat ellep a csemperol, ez a fuggveny tavolitja el.
     */
    public void remove() {
        GameLogic.indent(true);
		System.out.println(">   BaseTile::remove()");
        localAnimal = null;
        GameLogic.indent(false);
        System.out.println("<   BaseTile::remove()");
        return;
    }

    public void setAnimal(Animal a) {}

    public void setItem(Item i) {}

    public abstract Item getItem();

    public void decreaseHealth() {}

    public void ring() {}

    public void beep() {}

    public void tire(Tile t) {}

    /**
     * Setter fuggveny a neighbours valtozo megvaltoztatasara.
     *
     * @param nb A szomszedos csempek listaja.
     */
    public void setNeighbours(ArrayList<BaseTile> nb) {
        GameLogic.indent(true);
		System.out.println(">   BaseTile::setNeighbours(ArrayList<BaseTile> nb)");
        neighbours = nb;
        GameLogic.indent(false);
        System.out.println("<   BaseTile::setNeighbours(ArrayList<BaseTile> nb)");
        return;
    }

}
