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
 * A csokiautomatat megvalosito osztaly.
 *
 * @author Cynolter
 */
public class ChocoAutomat extends Item {

    /**
     * A countDown fuggveny csokkenti a Counter attributumat az osztalynak, amint az eleri a 0-t,
     * akkor sipol és reszetelodik a Counter.
     */
    @Override
    public void countDown() {
        GameLogic.indent(true);
        System.out.println(">   ChocoAutomat::countDown()");

        --Counter;
        if (Counter <= 0) {
            for (BaseTile tile : onTile.getNeighbours()) {
               if(tile.localAnimal != null){
                   tile.beep();
                }
            }
            int rn = ThreadLocalRandom.current().nextInt(75,125+1);
            Counter = rn;
        }
        GameLogic.indent(false);
        System.out.println("<   ChocoAutomat::countDown()");
        return;
    }

    /**
     * A konstruktor, amelyikben meg kell adni, melyik csempere kerul az automata,
     * és kezdoallapotba allitjuk a Counter attributumot.
     *
     * @param t A csempe amelyiken a Csokiautomata all.
     */
    public ChocoAutomat(Tile t) {
        GameLogic.indent(true);
        System.out.println(">   ChocoAutomat::ChocoAutomat(Tile t)");
        onTile = t;
        //int rn = ThreadLocalRandom.current().nextInt(75,125+1);
        //Counter = rn;
        Counter = 1;
        GameLogic.indent(false);
        System.out.println("<   ChocoAutomat::ChocoAutomat(Tile t)");
    }

}
