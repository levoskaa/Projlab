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

import java.awt.*;
import java.util.*;

/**
 * Osztaly a csempek viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a Tile (BreakableTile), EntryWardrobe (ExitPoint) osztalyok ebbol az osztalybol szarmaznak.
 *
 * @author Kalai
 */
public abstract class BaseTile {

    /**
     * Nev, amivel a teszteles soran azonositani lehet az objektumot.
     */
    private String name;

    private Point center;

    protected Image image;

    public Image getImage() {
        return image;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

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
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BaseTile::getNeighbours()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BaseTile::getNeighbours()");
        }
        return neighbours;
    }

    /**
     * Amennyiben egy allat a csempere akar lepni, ez a fuggveny hivodik meg.
     *
     * @param a Az allat, amely a csempere akar lepni.
     */
    public void receive(Animal a) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BaseTile::receive(Animal a)");
        }

        BaseTile tempTile = a.getTile();
        if (this.getItem() != null) {
            return;
        }

        if (localAnimal == null) {
            a.getTile().remove();
            localAnimal = a;
            localAnimal.setTile(this);
            localAnimal.setCenter(center);
            ArrayList<Panda> a1 = localAnimal.getCaughtPandas();
            if (a1 != null) {
                for (int i = 0; i < a1.size(); i++) {
                    BaseTile tempTile2 = a1.get(i).getTile();
                    tempTile.receive(a1.get(i));
                    tempTile = tempTile2;
                }
            }
        } else {
            localAnimal.collideWith(a);
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BaseTile::receive(Animal a)");
        }
        return;
    }

    /**
     * Ha egy allat ellep a csemperol, ez a fuggveny tavolitja el.
     */
    public void remove() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BaseTile::remove()");
        }

        localAnimal = null;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BaseTile::remove()");
        }
        return;
    }

    /**
     * Fuggveny a csempen levo allat leultetesere.
     *
     * @param t a csempe, amire az allat leulhet.
     */

    public void sitAnimal(Tile t) {
        if (localAnimal != null) {
            localAnimal.sit(t);
        }
        return;
    }

    public void setAnimal(Animal a) {
    }

    public void setItem(Item i) {
    }

    /**
     * Getter fuggveny a name valtozo lekerdezesere.
     *
     * @return A csempe neve.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter fuggveny a name valtozo beallitasara.
     *
     * @param n a csempe neve.
     */
    public void setName(String n) {
        name = n;
        return;
    }

    /**
     * Getter fuggveny az Item valtozo lekerdezesere.
     * A BaseTile-on nem lehet allat, ezert null a visszateresi ertek.
     *
     * @return A csempen levo Item.
     */
    public Item getItem() {
        return null;
    }

    /**
     * Getter fuggveny a localAnimal valtozo lekerdezesere.
     *
     * @return A csempen levo allat.
     */
    public Animal getAnimal() {
        return localAnimal;
    }

    public void decreaseHealth() {
    }

    public void setHealth(int newHealth) {
    }

    public void setDestination(BaseTile t) {
    }

    public void setStartingTile(Tile sT) {
    }

    public void ring() {
    }

    public void beep() {
    }

    public void tire(Tile t) {
    }

    /**
     * Setter fuggveny a neighbours valtozo megvaltoztatasara.
     *
     * @param nb A szomszedos csempek listaja.
     */
    public void setNeighbours(ArrayList<BaseTile> nb) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   BaseTile::setNeighbours(ArrayList<BaseTile> nb)");
        }

        neighbours = nb;
        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   BaseTile::setNeighbours(ArrayList<BaseTile> nb)");
        }
        return;
    }

    /**
     * Megadja, hogy az adott Item szekreny-e vagy sem.
     *
     * @return Ha az Item szekreny, true (leszarmazottban override), amugy false;
     */
    public boolean isWardrobe() {
        return false;
    }

    public void setGameLogic(GameLogic gameLogic) {
    }
}
