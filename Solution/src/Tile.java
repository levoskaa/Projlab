//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Tile.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//

/**
 * Egy csempe viselkedeset megvalosito osztaly.
 * @author Konczos
 */


public class Tile extends BaseTile {
    /**
     * A csempén elhelyezkedo specialis funkcioalitással ellatott tárgy
     * referenciajat tarolo Item.
     */
    private Item localItem;

    /**
     * A fuggveny a csokiautomata sipolasan keresztul ugrasra keszteti az ugro pandakat.
     */
    public void beep() {
        GameLogic.indent(true);
        System.out.println(">   Tile::beep()");
        localAnimal.jump();
        GameLogic.indent(false);
        System.out.println("<   Tile::beep()");

    }

    /**
     * A fuggveny a jatekgep csilingelesen keresztul a szomszedai
     * kezenek elengedesere keszteti az ijedos pandakat.
     */
    public void ring() {
        GameLogic.indent(true);
        System.out.println(">   Tile::ring()");
        localAnimal.scare();
        GameLogic.indent(false);
        System.out.println("<   Tile::ring()");
    }

    /**
     * A fuggveny teszi lehetove a faradt pandak leulteteset egy fotelre.
     * @param t A kanape helye amelyre a faradekony panda leulhet.
     */
    public void tire(Tile t) {
        GameLogic.indent(true);
        System.out.println(">   Tile::tire(Tile t)");
        localAnimal.sit(t);
        GameLogic.indent(false);
        System.out.println("<   Tile::tire(Tile t)");
    }

    /**
     * A fuggvennyel egy targyat helyezunk a csempere.
     * @param i A targy amelyet a csempere helyezunk.
     */
    public void setItem(Item i) {
        GameLogic.indent(true);
        System.out.println(">   Tile::setItem(Item i)");
        localItem = i;
        GameLogic.indent(false);
        System.out.println("<   Tile::setItem(Item i)");
    }


    /**
     * A fuggvennyel lekerdezzuk, milyen targy van a csempen.
     * @return A targy ami a csempen van.
     */
    public Item getItem() {
        GameLogic.indent(true);
        System.out.println(">   Tile::getItem()");
        GameLogic.indent(false);
        System.out.println("<   Tile::getItem()");
        return localItem;
    }

    /**
     * A fuggvennyel egy allatot helyezunk a csempere.
     * @param a Az allat amelyet a csempere helyezunk.
     */
    public void setAnimal(Animal a) {
        GameLogic.indent(true);
        System.out.println(">   Tile::setAnimal(Animal a)");
        GameLogic.indent(false);
        System.out.println("<   Tile::setAnimal(Animal a)");
        localAnimal = a;
    }

}
