//  @ Project : Projlab
//  @ File Name : Animal.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import java.util.ArrayList;

/**
 * Osztaly az allatok viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a Panda es Orangutan osztalyok ebbol az osztalybol szarmaznak.
 *
 * @author Laurinyecz
 */
public abstract class Animal {
    /**
     * Arra a csempere mutat, amelyiken az allat eppen all.
     */
    protected BaseTile currentTile;

    /**
     * A jatek utemezeseert felelos objektum.
     */
    protected GameLogic gameLogic;

    public abstract void move();

    public abstract int checkPoints();

    public abstract void collision(Animal a);

    public void catchPanda() {
    }

    public void die() {
    }

    public void sit(Tile t) {
    }

    public void scare() {
    }

    public void jump() {
    }

    public void setCaughtPandas(ArrayList<Panda> caughtPandas) {
    }

    public ArrayList<Panda> getCaughtPandas() {
        return null;
    }

    /**
     * Konstruktor.
     */
    public Animal() {
        System.out.println(">   Animal()");
        currentTile = null;
        System.out.println("<   Animal()");
    }

    /**
     * Getter fuggveny a csempe lekerdezesere.
     *
     * @return Csempe(BaseTile objektum) amelyiken az allat eppen all.
     */
    public BaseTile getTile() {
        System.out.println(">   getTile()");
        System.out.println("<   getTile()");
        return currentTile;
    }

    /**
     * Setter fuggveny a csempe beallitasara.
     *
     * @param t Az uj csempe, amelyikre athelyezzuk az allatot.
     */
    public void setTile(BaseTile t) {
        System.out.println(">   setTile(BaseTile t)");
        currentTile = t;
        System.out.println("<   setTile(BaseTile t)");
    }
}
