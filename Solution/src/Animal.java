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

    //public abstract int checkPoints();

    public abstract void collisionWithPanda(Panda p);

    public abstract void collisionWithOrangutan(Orangutan o);

    public abstract void collideWith(Animal a);

    public void catchPanda(Orangutan orangutan) {}

    public void die() {}

    public void sit(Tile t) {}

    public void scare() {}

    public void jump() {}

    public void setCaughtPandas(ArrayList<Panda> caughtPandas) { }

    public ArrayList<Panda> getCaughtPandas() {
        gameLogic.indent(true);
        System.out.println(">   Animal::getCaughtPandas()");

        gameLogic.indent(false);
        System.out.println("<   Animal::getCaughtPandas()");
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
        gameLogic.indent(true);
        System.out.println(">   Animal::getTile()");

        gameLogic.indent(false);
        System.out.println("<   Animal::getTile()");
        return currentTile;
    }

    /**
     * Setter fuggveny a csempe beallitasara.
     *
     * @param t Az uj csempe, amelyikre athelyezzuk az allatot.
     */
    public void setTile(BaseTile t) {
        GameLogic.indent(true);
        System.out.println(">   Animal::setTile(BaseTile t)");

        currentTile = t;

        GameLogic.indent(false);
        System.out.println("<   Animal::setTile(BaseTile t)");
        return;
    }

    /**
     * Setter fuggveny a gameLogic beallitasara.
     * @param gameLogic A jatek logikaert felelos objektum referenciaja.
     */
    public void setGameLogic(GameLogic gameLogic) {
        GameLogic.indent(true);
        System.out.println(">   Animal::setGameLogic(GameLogic gameLogic)");

        this.gameLogic = gameLogic;

        GameLogic.indent(false);
        System.out.println("<   Animal::setGameLogic(GameLogic gameLogic)");
        return;
    }

    public void move() {
        GameLogic.indent(true);
        System.out.println(">   Animal::move()");

        ArrayList<BaseTile> neighbours = currentTile.getNeighbours();
        // A szomszedos csempek kozul veletlenszeruen valaszt egyet, amire megprobal ralepni.
        // (Lehetseges, hogy egy helyben marad, ha foglalt csempere akar lepni.)
        neighbours.get((int) (Math.random() * neighbours.size())).receive(this);

        GameLogic.indent(false);
        System.out.println("<   Animal::move()");
        return;
    }
}
