//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ChocoAutomat.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//


import java.util.concurrent.ThreadLocalRandom;

/**
 * A csokiautomatát megvalósító osztály.
 *
 * @author Cynolter
 */
public class ChocoAutomat extends Item {

    /**
     * A countDown függvény csökkenti a Counter attribútumát az osztálynak, amint az eléri a 0-t,
     * akkor sípol és reszetelődik a Counter.
     */
    @Override
    public void countDown() {
        System.out.println(">   countDown()");
        --Counter;
        if (Counter <= 0) {
            for (BaseTile tile : onTile.getNeighbours()) {
                tile.beep();
            }
            int rn = ThreadLocalRandom.current().nextInt(75,125+1);
            Counter = rn;
        }
        System.out.println("<   countDown()");
    }

    /**
     * A konstruktor, amelyikben meg kell adni, melyik csempére kerül az automata, és kezdőállapotba állítjuk a Counter attribútumot.
     *
     * @param t A csempe amelyiken a Csokiautomata áll.
     */
    public ChocoAutomat(Tile t) {
        System.out.println(">   ChocoAutomat(Tile t)");
        onTile = t;
        //int rn = ThreadLocalRandom.current().nextInt(75,125+1);
        //Counter = rn;
        Counter = 1;
        System.out.println("<   ChocoAutomat(Tile t)");
    }

}
