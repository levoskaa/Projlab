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

import java.util.concurrent.ThreadLocalRandom;


/**
 * A jatekgepet megvalosito osztaly.
 *
 * @author Cynolter
 */
public class SlotMachine extends Item {

    /**
     * A countDown fuggveny csokkenti a Counter attributumat az osztalynak, amint az eleri a 0-t,
     * akkor csorog es reszetelodik a Counter.
     */
    @Override
    public void countDown() {
        GameLogic.indent(true);
        System.out.println(">   SlotMachine::countDown()");
        int rn;
        --Counter;
        if (Counter <= 0) {
            doAction();

            if (ProtoMenu.isRandom()) {
                rn = ThreadLocalRandom.current().nextInt(75, 125 + 1);
            } else {
                rn = 75;
            }

            Counter = rn;
        }
        GameLogic.indent(false);
        System.out.println("<   SlotMachine::countDown()");
        return;
    }

    @Override
    public void doAction() {
        for (BaseTile tile : onTile.getNeighbours()) {
            if (tile.localAnimal != null) {
                tile.ring();
            }
        }
    }

    /**
     * A konstruktor, amelyikben meg kell adni, melyik csempere kerul a gep,
     * es kezdoallapotba allitjuk a Counter attributumot.
     *
     * @param t A csempe, amelyiken a jatekgep talalhato.
     */
    public SlotMachine(Tile t) {
        GameLogic.indent(true);
        System.out.println(">   SlotMachine::SlotMachine(Tile t)");

        onTile = t;
        //int rn = ThreadLocalRandom.current().nextInt(75,125+1);
        //Counter = rn;
        Counter = 1;
        GameLogic.indent(false);
        System.out.println("<   SlotMachine::SlotMachine(Tile t)");
    }

    /**
     * Az item tipusanak lekerdezese.
     *
     * @return Az item tipusa.
     */
    @Override
    public String getType() {
        return "slotmachine";
    }
}
