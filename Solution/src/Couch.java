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


import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * A kanapet megvalosito osztaly.
 *
 * @author Cynolter
 */
public class Couch extends Item {

    /**
     * A kanapen eppen ulo pandat reprezentalo attributum.
     */
    private TiredPanda restingPanda;

    /**
     * A countDown metodus segítségével tudjak majd a szomszedos mezon allok, hogy itt kanape van.
     */
    @Override
    public void countDown() {
        //GameLogic.indent(true);
        //System.out.println(">   Couch::countDown()");

        onTile.tire();

        //GameLogic.indent(false);
        //System.out.println("<   Couch::countDown()");
        return;
    }

    /**
     * Protomenuhoz szukseges extra metodus.
     */
    @Override
    public void doAction() {
        countDown();
    }

    /**
     * Ha egy panda le akar ulni, a kanape megnezi, hogy ures-e (azaz le tud-e ulni a panda), ha ures, akkor leulteti.
     *
     * @param p A panda amelyet leultetunk a kanapera.
     */

    public void receive(TiredPanda p) {
        //GameLogic.indent(true);
        //System.out.println(">   Couch::receive(Panda p)");

        if (restingPanda == null) {
            restingPanda = p;
            restingPanda.setResting(true);
            restingPanda.setRestingUntil(3);

            restingPanda.getTile().remove();
            restingPanda.setTile(onTile);
            onTile.setAnimal(restingPanda);
            restingPanda.setCenter(onTile.getCenter());
        }

        //GameLogic.indent(false);
        //System.out.println("<   Couch::receive(Panda p)");
        return;
    }

    /**
     * A konstruktor, amelyben beallitjuk, hogy alapbol nincs panda a kanapen.
     *
     * @param t A csempe, amelyiken a kanape talalhato.
     */
    public Couch(Tile t) {
        try {
            image = ImageIO.read(getClass().getResource( "images/couch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //GameLogic.indent(true);
        //System.out.println(">   Couch::Couch(Tile t)");
        onTile = t;
        restingPanda = null;
        //GameLogic.indent(false);
        //System.out.println("<   Couch::Couch(Tile t)");
        onTile = t;
        restingPanda = null;
    }

    /**
     * Amikora felall a panda, eltavolitja azt a kanaperol.
     */
    @Override
    public void standUp() {
        //GameLogic.indent(true);
        //System.out.println(">   Couch::standUp()");

        restingPanda = null;
        restingPanda.setResting(false);

        //GameLogic.indent(false);
        //System.out.println("<   Couch::standUp()");
        return;
    }

    /**
     * Az item tipusanak lekerdezese.
     *
     * @return Az item tipusa.
     */
    @Override
    public String getType() {
        return "couch";
    }

    /**
     * Az aktualis allat lekerdezese.
     *
     * @return Az aktualis allat.
     */
    public TiredPanda getActualAnimal() {
        return restingPanda;
    }
}
