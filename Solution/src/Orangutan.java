//  @ Project : Projlab
//  @ File Name : Orangutan.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import java.util.ArrayList;

/**
 * A jatekos altal iranyitott karaktert megvalosito osztaly.
 *
 * @author Laurinyecz
 * @see Animal
 */
public class Orangutan extends Animal {
    /**
     * Az elfogott pandakat tartalmazo lista.
     */
    private ArrayList<Panda> caughtPandas;

    /**
     * Pandalopas utan 3 lepesig nem foghat pandat ez az orangutan.
     * <p>
     * 0 az alapertelmezett ertek, ilyenkor foghat pandat.
     */
    protected int cantCatchPandasUntil;

    /**
     * Konstruktor.
     */
    public Orangutan() {
        caughtPandas = new ArrayList<Panda>();
        cantCatchPandasUntil = 0;
    }

    /**
     * Setter fuggveny a caughtPandas valtozohoz.
     *
     * @param caughtPandas Az uj lista, amely tartalmazza a pandakat.
     */
    public void setCaughtPandas(ArrayList<Panda> caughtPandas) {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::setCaughtPandas(ArrayList<Panda> caughtPandas)");

        this.caughtPandas = caughtPandas;

        GameLogic.indent(false);
        System.out.println("<   Orangutan::setCaughtPandas(ArrayList<Panda> caughtPandas)");
    }

    /**
     * Visszaadja az orangutant koveto pandak listajat.
     *
     * @return Az orangutant koveto pandak listaja.
     */
    public ArrayList<Panda> getCaughtPandas() {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::getCaughtPandas()");
        GameLogic.indent(false);
        System.out.println("<   Orangutan::getCaughtPandas()");
        return caughtPandas;
    }

    /**
     * Pandaval valo utkozes eseten elfogja azt.
     *
     * @param p A panda, amivel az utkozes tortent.
     */
    public void collisionWithPanda(Panda p) {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::collisionWitPanda(Animal a)");

        if (cantCatchPandasUntil == 0)
            p.catchPanda(this);

        GameLogic.indent(false);
        System.out.println("<   Orangutan::collisionWithPanda(Animal a)");
    }

    /**
     * Orangutannal valo utkozes eseten ellopja a masik orangutan pandait.
     * @param o Az orangutan, amivel az utkozes tortent.
     */
    public void collisionWithOrangutan(Orangutan o) {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::collisionWithOrangutan(Animal a)");

        ArrayList<Panda> pandasOfOther = o.getCaughtPandas();
        // Az eredetileg vezetett pandaknak egy helyben kell allniuk, amig az ellopott
        // pandak be nem csatlakoznak a sorba.
        for (Panda panda: caughtPandas) {
            panda.setCantMoveUntil(pandasOfOther.size());
        }
        // Az ellopott pandakat kozvetlen az orangutan utan fuzzuk fel a sorba.
        for (int i = pandasOfOther.size() - 1; i >= 0; i--) {
            caughtPandas.add(0, pandasOfOther.get(i));
        }

        GameLogic.indent(false);
        System.out.println("<   Orangutan::collisionWithOrangutan(Animal a)");
    }

    /**
     * A csempe ezzel a fuggvennyel tud jelezni a rajta allo allatnak,
     * hogy egy masik allat nekiutkozott.
     * @param a Az allat, amivel az utkozes tortent.
     */
    @Override
    public void collideWith(Animal a) {
        a.collisionWithOrangutan(this);
    }

    /**
     * Sor felbomlasa eseten hivodik meg.
     * <p>
     * Elengedi a parameterben kapott es az utana kovetkezo pandakat.
     *
     * @param p A panda amelyik az elngedest kezdemenyezte.
     */
    public void release(Panda p) {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::release(Panda p)");

        releaseBehind(p);
        p.setCaught(false);
        caughtPandas.remove(p);

        GameLogic.indent(false);
        System.out.println("<   Orangutan::release(Panda p)");
    }

    /**
     * Sor felbomlasa eseten hivodik meg.
     * <p>
     * Csak a parameterben panda utan allo pandakat engedi el.
     *
     * @param p A panda amelyik az elengedest kezdemenyezte.
     */
    public void releaseBehind(Panda p) {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::releaseBehind(Panda p)");

        for (int i = caughtPandas.indexOf(p) + 1; i < caughtPandas.size(); i++) {
            caughtPandas.get(i).setCaught(false);
            caughtPandas.remove(i);
        }

        GameLogic.indent(false);
        System.out.println("<   Orangutan::releaseBehind(Panda p)");
    }

    /**
     * Az orangutan halala eseten veget er a jatek.
     */
    public void die() {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::die()");
        gameLogic.endGame();
        GameLogic.indent(false);
        System.out.println("<   Orangutan::die()");
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny, ami hatasara a gep altal vezerelt
     * orangutan mozog.
     * @see GameLogic
     */
    @Override
    public void move() {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::move()");
        super.move();
        if (cantCatchPandasUntil > 0)
            cantCatchPandasUntil--;
        GameLogic.indent(false);
        System.out.println("<   Orangutan::move()");
    }

    /**
     * Megoldja, hogy a panda a sor elejere, rogton az orangutan moge keruljon.
     *
     * @param p A panda akit elfogott az orangutan.
     */
    public void add(Panda p) {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::add(Panda p)");

        // Panda csempeje az elfogas pillanataban.
        BaseTile pandaTile = p.getTile();

        // A panda elhelyezese az orangutan csempejere.
        currentTile.remove();
        currentTile.setAnimal(p);
        p.setTile(currentTile);

        // Az orangutan elhelyezese a panda csempejere.
        pandaTile.remove();
        pandaTile.setAnimal(this);
        setTile(pandaTile);

        // Elfogast jelzo valtozo beallitasa, es felfuzes a sorba.
        p.setCaught(true);
        caughtPandas.add(0, p);

        GameLogic.indent(false);
        System.out.println("<   Orangutan::add(Panda p)");
    }

    //------------------------------------------
    // A polimorfikus viselkedes miatt szukseges fuggvenyek, az oragutan eseten
    // nincs szukseg rajuk.
    @Override
    public int checkPoints() {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::checkPoints()");
        GameLogic.indent(false);
        System.out.println("<   Orangutan::checkPoints()");
        return 0;
    }
    //------------------------------------------
}
