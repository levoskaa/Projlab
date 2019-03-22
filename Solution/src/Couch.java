//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Couch.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//


/**
 * A kanapét megvalósító osztály.
 * @author Cynolter
 */
public class Couch extends Item {

    /**
     * A kanapén éppen ülő pandát reprezentáló attribútum.
     */
    private Panda RestingPanda;

    /**
     * A countDown metódus segítségével tudják majd a szomszédos mezőn állók, hogy itt kanapé van.
     */
    @Override
    public void countDown() {
        onTile.tire();
    }

    /**
     * Ha egy panda le akar ülni, a kanapé megnézi, hogy üres-e (azaz le tud-e ülni a panda), ha üres, akkor leülteti.
     * @param p A panda amelyet leültetünk a kanapére.
     */
    public void receive(Panda p) {
        if(RestingPanda == null){
            RestingPanda = p;
        }
    }

    /**
     * A konstruktor, amelyben beállítjuk, hogy alapból nincs panda a kanapén.
     * @param t A csempe, amelyiken a kanapé található.
     */
    public Couch(Tile t) {
        onTile = t;
        RestingPanda = null;
    }
}
