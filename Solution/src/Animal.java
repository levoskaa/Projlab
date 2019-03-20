//  @ Project : Projlab
//  @ File Name : Animal.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

/**
 * Osztaly az allatok viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * a Panda es Orangutan osztalyok ebbol az osztalybol szarmaznak.
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
    protected GameLogic GL;

    /**
     * Konstruktor.
     */
    public Animal() {
        currentTile = null;
    }

    /**
     * Getter fuggveny a csempe lekerdezesere.
     * @return Csempe(BaseTile objektum) amelyiken az allat eppen all.
     */
    public BaseTile getTile() {
        return currentTile;
    }

    /**
     * Setter fuggveny a csempe beallitasara.
     * @param t Az uj csempe, amelyikre athelyezzuk az allatot.
     */
    public void setTile(BaseTile t) {
        currentTile = t;
    }

    public abstract void move();

    public abstract void sit(Tile t);
    
    public abstract void collision(Animal a);
    
    public abstract void scare();
    
    public abstract void jump();
    
    public abstract int checkPoints();
    
    public abstract void catchPanda();
    
    public void die() {
    }
}
