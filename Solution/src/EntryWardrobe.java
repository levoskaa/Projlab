//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Projlab
//  @ File Name : EntryWardrobe.java
//  @ Date : 2019.03.23.
//  @ Author : Kalai
//
//

/**
 * Osztaly a bemeneti szekrenyek viselkedesenek es tulajdonsagaiknak osszegyujtesere,
 * az ExitPoint osztaly ebbol az osztalybol szarmazik.
 * @author Kalai
 * @see BaseTile
 */
public class EntryWardrobe extends BaseTile {
    /**
     * Referencia a kimeneti szekrenyre, vagyis egy specialis csempere.
     */
    protected Tile destination;

    /**
     * Setter fuggveny a destination valtozo megvaltoztatasara.
     *
     * @param t A kimeneti szekreny.
     */
    public void setDestination(Tile t){
        System.out.println(">   setDestination(Tile t)");
        destination = t;
        System.out.println("<   setDestination(Tile t)");
        return;
    }

    /**
     * Getter fuggveny a destination valtozo lekerdezesere.
     *
     * @return A kimeneti szekreny.
     */
    public BaseTile getDestination() {
        System.out.println(">   getDestination()");
        System.out.println("<   getDestination()");
        return destination;
    }

    /**
     * Amennyiben egy allat a bemeneti szekrenyre akar lepni, ez a fuggveny hivodik meg.
     *
     * @param a Az allat, amely a szekrenyre akar lepni.
     */
    public void receive(Animal a) {
        System.out.println(">   receive(Animal a)");
        destination.setAnimal(a);
        System.out.println("<   receive(Animal a)");
        return;
    }
}
