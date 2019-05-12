//  @ Project : Projlab
//  @ File Name : Animal.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import java.awt.*;
import java.util.ArrayList;

/**
 * Osztaly az allatok viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a Panda es Orangutan osztalyok ebbol az osztalybol szarmaznak.
 *
 * @author Laurinyecz
 */
public abstract class Animal {
    /**
     * Nev, amivel a teszteles soran azonositani lehet az objektumot.
     */
    private String name;

    /**
     * Arra a csempere mutat, amelyiken az allat eppen all.
     */
    protected BaseTile currentTile;

    /**
     * A jatek utemezeseert felelos objektum.
     */
    protected GameLogic gameLogic;

    /**
     * Az allatot reprezentalo kep a grafikus feluleten.
     */
    protected Image image;

    /**
     * Getter fuggveny az image valtozohoz.
     * @return Az image
     */
    public Image getImage() {
        return image;
    }
    //public abstract int checkPoints();

    /**
     * Pandaval valo utkozes lekezelesere valo fuggveny.
     *
     * @param p A panda, amivel az utkozes tortent.
     */
    public abstract void collisionWithPanda(Panda p);

    /**
     * Orangutanal valo utkozes lekezelesere valo fuggveny.
     *
     * @param o Az orangutan, amivel az utkozes tortent.
     */
    public abstract void collisionWithOrangutan(Orangutan o);

    /**
     * Allattal valo utkozes lekezelesere valo fuggveny.
     *
     * @param a Az allat, amivel az utkozes tortent.
     */
    public abstract void collideWith(Animal a);

    /**
     * Panda elfogasara hasznalando fuggveny.
     *
     * @param orangutan Az orangutan, ami elkapja a pandat.
     */
    public void catchPanda(Orangutan orangutan) {
    }

    /**
     * Az allat halalakor hivodik meg.
     */
    public void die() {
    }

    /**
     * Fotel melle erve hivodik meg ez a fuggveny.
     *
     * @param t A csempe, amin a fotel van.
     */
    public void sit(Tile t) {
    }

    /**
     * Az allat kozepenek a koordinatai.
     */
    protected Point center;

    /**
     * Getter fuggveny a center valtozohoz.
     * @return A center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Setter fuggveny a center valtozohoz.
     * @param center A center valtozo uj erteke.
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Jatekgep csilingelesekor hivodik meg.
     */
    public void scare() {
    }

    /**
     * Csokiautomata sipolasakor hivodik meg.
     */
    public void jump() {
    }

    /**
     * Setter fuggveny a caughtPandas valtozohoz.
     * @param caughtPandas Az uj caughtPanda lista.
     */
    public void setCaughtPandas(ArrayList<Panda> caughtPandas) {
    }

    /**
     * Getter fuggveny a caughtPandas listahoz.
     * @return caughtPandas lista
     */
    public ArrayList<Panda> getCaughtPandas() {
        if (SkeletonMenu.indent) {
            gameLogic.indent(true);
            System.out.println(">   Animal::getCaughtPandas()");
        }

        if (SkeletonMenu.indent) {
            gameLogic.indent(false);
            System.out.println("<   Animal::getCaughtPandas()");
        }

        return null;
    }

    /**
     * Konstruktor.
     */
    public Animal() {
        currentTile = null;
    }

    /**
     * Getter fuggveny a csempe lekerdezesere.
     *
     * @return Csempe(BaseTile objektum) amelyiken az allat eppen all.
     */
    public BaseTile getTile() {
        if (SkeletonMenu.indent) {
            gameLogic.indent(true);
            System.out.println(">   Animal::getTile()");
        }

        if (SkeletonMenu.indent) {
            gameLogic.indent(false);
            System.out.println("<   Animal::getTile()");
        }

        return currentTile;
    }

    /**
     * Setter fuggveny a csempe beallitasara.
     *
     * @param t Az uj csempe, amelyikre athelyezzuk az allatot.
     */
    public void setTile(BaseTile t) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Animal::setTile(BaseTile t)");
        }


        currentTile = t;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Animal::setTile(BaseTile t)");
        }

        return;
    }

    /**
     * Setter fuggveny a gameLogic beallitasara.
     *
     * @param gameLogic A jatek logikaert felelos objektum referenciaja.
     */
    public void setGameLogic(GameLogic gameLogic) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Animal::setGameLogic(GameLogic gameLogic)");
        }


        this.gameLogic = gameLogic;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Animal::setGameLogic(GameLogic gameLogic)");
        }

        return;
    }

    /**
     * Getter fuggveny az allat nevere.
     *
     * @return Az allat neve.
     */
    public String getName() {
        return name;
    }

    public String getType() {
        return "";
    }

    /**
     * Setter fuggveny az allat nevere.
     *
     * @param n Az allat uj neve.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Az allat mozgatasara valo fuggveny.
     */
    public void move() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Animal::move()");
        }

        ArrayList<BaseTile> neighbours = currentTile.getNeighbours();
        // A szomszedos csempek kozul veletlenszeruen valaszt egyet, amire megprobal ralepni.
        // (Lehetseges, hogy egy helyben marad, ha foglalt csempere akar lepni.)
        neighbours.get((int) (Math.random() * neighbours.size())).receive(this);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Animal::move()");
        }

        return;
    }

    public void release(Panda p) {
    }
}
