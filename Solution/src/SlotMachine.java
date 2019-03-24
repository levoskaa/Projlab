//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : SlotMachine.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//


/**
 * A játékgépet megvalósító osztály.
 *
 * @author Cynolter
 */
public class SlotMachine extends Item {

    /**
     * A countDown függvény csökkenti a Counter attribútumát az osztálynak, amint az eléri a 0-t,
     * akkor csörög és reszetelődik a Counter.
     */
    @Override
    public void countDown() {
        System.out.println(">   countDown()");
        --Counter;
        if (Counter <= 0) {
            onTile.ring();
            // TODO ezt randomizalni, csak atirtam 1-re debug miatt
            Counter = 1;
        }
        System.out.println("<   countDown()");
    }

    /**
     * A konstruktor, amelyikben meg kell adni, melyik csempére kerül a gép, és kezdőállapotba állítjuk a Counter attribútumot.
     *
     * @param t A csempe, amelyiken a játékgép található.
     */
    public SlotMachine(Tile t) {
        System.out.println(">   SlotMachine(Tile t)");
        onTile = t;
        Counter = 100;
        System.out.println("<   SlotMachine(Tile t)");
    }
}
