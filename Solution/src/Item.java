//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Item.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//


import java.awt.*;

/**
 * A poliformizmust tamogato ososztaly a jatekban megtalalhato targyakhoz.
 *
 * @author Cynolter
 */
public abstract class Item extends BaseTile {
    /**
     * Nev, amivel a teszteles soran azonositani lehet az objektumot.
     */
    private String name;

    /**
     * Az item kozepenek koordinatai.
     */
    protected Point center;

    /**
     * A kep ami az adott targyat jeloli a grafikus feluleten
     */
    protected Image image;

    /**
     * Visszaadja a targy kinezetet tartalmazo mezot
     *
     * @return A kep
     */
    public Image getImage() {
        return image;
    }

    /**
     * Visszaadja a targy kozeppontjainak a koordinatait
     *
     * @return A koordinatak
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Beallitja a targy kozeppontjanak a koordinatait
     *
     * @param center A kozeppont koordinatai
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * A szamlalo, amely ha lejar akkor a csokiautomata sipolhat és a jatekgep csoroghet.
     */
    protected int Counter;
    /**
     * A csempe, amelyiken a targy all.
     */
    protected Tile onTile;

    /**
     * Leszarmazott specifikus, hogy mit kell csinalnia countDown-ra, a leszarmazottaknal van implementalva.
     */
    public void countDown() {
    }

    /**
     * Lasd a kanapenal.
     */
    public void receive(TiredPanda p) {
    }

    /**
     * Lasd a kanapenal
     */
    public void standUp() {
    }

    /**
     * Lasd leszarmazottak.
     */
    public abstract void doAction();

    /**
     * Visszaadja a targy nevet.
     *
     * @return A targy neve.
     */
    public String getName() {
        return name;
    }

    /**
     * Beallitja a targy nevet.
     *
     * @param n a targy neve.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Az item tipusanak lekerdezese.
     *
     * @return Az item tipusa.
     */
    public String getType() {
        return "";
    }
}
