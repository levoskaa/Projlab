//  @ Project : Projlab
//  @ File Name : Orangutan.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import javax.imageio.ImageIO;
import java.io.IOException;
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
        try {
            image = ImageIO.read(getClass().getResource( "images/orangutan_ai.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Setter fuggveny a caughtPandas valtozohoz.
     *
     * @param caughtPandas Az uj lista, amely tartalmazza a pandakat.
     */
    public void setCaughtPandas(ArrayList<Panda> caughtPandas) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::setCaughtPandas(ArrayList<Panda> caughtPandas)");
        }


        this.caughtPandas = caughtPandas;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::setCaughtPandas(ArrayList<Panda> caughtPandas)");
        }

        return;
    }

    /**
     * Visszaadja az orangutant koveto pandak listajat.
     *
     * @return Az orangutant koveto pandak listaja.
     */
    public ArrayList<Panda> getCaughtPandas() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::getCaughtPandas()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::getCaughtPandas()");
        }

        return caughtPandas;
    }

    /**
     * Setter fuggveny a 'cantCatchPandasUntil' mezo beallitasara.
     *
     * @param value A 'cantCatchPandasUntil' mezo uj erteke.
     */
    public void setCantCatchPandasUntil(int value) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::setCantCatchPandasUntil(int value)");
        }


        cantCatchPandasUntil = value;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::setCantCatchPandasUntil(int value)");
        }

        return;
    }

    /**
     * Pandaval valo utkozes eseten elfogja azt.
     *
     * @param p A panda, amivel az utkozes tortent.
     */
    public void collisionWithPanda(Panda p) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::collisionWitPanda(Animal a)");
        }


        if (cantCatchPandasUntil == 0)
            p.catchPanda(this);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::collisionWithPanda(Animal a)");
        }

        return;
    }

    /**
     * Orangutannal valo utkozes eseten ellopja a masik orangutan pandait.
     *
     * @param o Az orangutan, amivel az utkozes tortent.
     */
    public void collisionWithOrangutan(Orangutan o) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::collisionWithOrangutan(Animal a)");
        }


        // Ha vezet pandat, akkor nem rabolhat egy masik orangutantol.
        if (caughtPandas.size() > 0) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::collisionWithOrangutan(Animal a)");
            return;
        }

        if (o.getCaughtPandas().size() == 0)
            return;

        // Orangutanok felcserelese kozben hasznalt segedvaltozo.
        BaseTile tileOfOther = o.getTile();

        // Orangutanok felcserelese 1.
        tileOfOther.setAnimal(this);
        currentTile.setAnimal(o);

        // Orangutanok felcserelese 2.
        o.setTile(currentTile);
        setTile(tileOfOther);

        // Pandak atadasa a rablo orangutannak.
        caughtPandas = o.getCaughtPandas();
        ArrayList<Panda> nullList = new ArrayList<>();
        o.setCaughtPandas(nullList);
        // A feladat szerint 3 korig nem foghat/rabolhat pandat ez az orangutan.
        o.setCantCatchPandasUntil(3);
        // Az elrabolt pandaknak az oket vezeto orangutan atallitasa a rablo orangutanra.
        for (int i = 0; i < caughtPandas.size(); i++) {
            caughtPandas.get(i).setOrangutan(this);
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::collisionWithOrangutan(Animal a)");
        }

        return;
    }

    /**
     * A csempe ezzel a fuggvennyel tud jelezni a rajta allo allatnak,
     * hogy egy masik allat nekiutkozott.
     *
     * @param a Az allat, amivel az utkozes tortent.
     */
    @Override
    public void collideWith(Animal a) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::collideWith(Animal a)");
        }


        a.collisionWithOrangutan(this);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::collideWith(Animal a)");
        }

        return;
    }

    /**
     * Sor felbomlasa eseten hivodik meg.
     * <p>
     * Elengedi a parameterben kapott es az utana kovetkezo pandakat.
     *
     * @param p A panda amelyik az elngedest kezdemenyezte.
     */
    public void release(Panda p) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::release(Panda p)");
        }


        releaseBehind(p);
        p.setCaught(false);
        p.setOrangutan(null);
        caughtPandas.remove(p);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::release(Panda p)");
        }

        return;
    }

    /**
     * Sor felbomlasa eseten hivodik meg.
     * <p>
     * Csak a parameterben panda utan allo pandakat engedi el.
     *
     * @param p A panda amelyik az elengedest kezdemenyezte.
     */
    public void releaseBehind(Panda p) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::releaseBehind(Panda p)");
        }

        ArrayList<Panda> removePandas = new ArrayList<Panda>();
        for (int i = caughtPandas.indexOf(p) + 1; i < caughtPandas.size(); i++) {
            Panda panda = caughtPandas.get(i);
            panda.setCaught(false);
            panda.setOrangutan(null);
            removePandas.add(panda);
        }

        for (int i = 0; i < removePandas.size(); i++) {
            caughtPandas.remove(removePandas.get(i));
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::releaseBehind(Panda p)");
        }

        return;
    }

    /**
     * Az orangutan halala eseten vegbemeno mukodes.
     */
    @Override
    public void die() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::die()");
        }


        // A vezetett pandak elengedese
        if (caughtPandas.size() > 0)
            release(caughtPandas.get(0));

        // Orangutan eltavolitasa a GameLogicbol
        gameLogic.setSecondOrangutan(null);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::die()");
        }

        return;
    }

    /**
     * A GameLogic altal periodikusan meghivott fuggveny, ami hatasara a gep altal vezerelt
     * orangutan mozog.
     *
     * @see GameLogic
     */
    @Override
    public void move() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::move()");
        }

        super.move();

        if (cantCatchPandasUntil > 0)
            cantCatchPandasUntil--;

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::move()");
        }

        return;
    }

    /**
     * Megoldja, hogy a panda a sor elejere, rogton az orangutan moge keruljon.
     *
     * @param p A panda akit elfogott az orangutan.
     */
    public void add(Panda p) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   Orangutan::add(Panda p)");
        }


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

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   Orangutan::add(Panda p)");
        }

        return;
    }

    //------------------------------------------
    // A polimorfikus viselkedes miatt szukseges fuggvenyek, az oragutan eseten
    // nincs szukseg rajuk.
    /*@Override
    public int checkPoints() {
        GameLogic.indent(true);
        System.out.println(">   Orangutan::checkPoints()");

        GameLogic.indent(false);
        System.out.println("<   Orangutan::checkPoints()");
        return 0;
    }*/
    //------------------------------------------

    /**
     * Az allat / orangutan tipusanak lekerdezese.
     *
     * @return Az allat / orangutan tipusa.
     */
    public String getType() {
        return "orangutan";
    }
}
