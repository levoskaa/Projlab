//  @ Project : Projlab
//  @ File Name : Orangutan.java
//  @ Date : 2019.03.20.
//  @ Author : Laurinyecz

import java.util.ArrayList;

/**
 * A jatekos altal iranyitott karaktert megvalosito osztaly.
 * @author Laurinyecz
 * @see Animal
 */
public class Orangutan extends Animal {
    /**
     * Az elfogott pandakat tartalmazo lista.
     */
    private ArrayList<Panda> caughtPandas;

    /**
     * Konstruktor.
     */
    public Orangutan() {
        caughtPandas = new ArrayList<Panda>();
    }

    /**
     * Setter fuggveny a caughtPandas valtozohoz.
     * @param caughtPandas Az uj lista, amely tartalmazza a pandakat.
     */
    public void setCaughtPandas(ArrayList<Panda> caughtPandas) {
        this.caughtPandas = caughtPandas;
    }

    /**
     * Visszaadja az orangutant koveto pandak listajat.
     * @return Az orangutant koveto pandak listaja.
     */
    public ArrayList<Panda> getCaughtPandas() {
        return caughtPandas;
    }

    /**
     * Pandaval valo utkozes eseten elfogja azt.
     * @param a Az allat, amelyikkel az utkozes tortent
     */
    public void collision(Animal a) {
        a.catchPanda();
    }

    /**
     * Sor felbomlasa eseten hivodik meg.
     * <p>
     * Elengedi a parameterben kapott es az utana kovetkezo pandakat.
     * @param p A panda amelyik az elngedest kezdemenyezte.
     */
    public void release(Panda p) {
        releaseBehind(p);
        p.setCaught(false);
        caughtPandas.remove(p);
    }

    /**
     * Sor felbomlasa eseten hivodik meg.
     * <p>
     * Csak a parameterben panda utan allo pandakat engedi el.
     * @param p A panda amelyik az elengedest kezdemenyezte.
     */
    public void releaseBehind(Panda p) {
        for (int i = caughtPandas.indexOf(p) + 1; i < caughtPandas.size(); i++) {
            caughtPandas.get(i).setCaught(false);
            caughtPandas.remove(i);
        }
    }

    /**
     * Az orangutan halala eseten veget er a jatek.
     */
    public void die() {
        gameLogic.endGame();
    }

    /**
     *
     */
    public void move() {
        //TODO kesobb
    }

    /**
     * Megoldja, hogy a panda a sor elejere, rogton az orangutan moge keruljon.
     * @param p A panda akit elfogott az orangutan.
     */
    public void add(Panda p) {
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
    }

    //------------------------------------------
    // A polimorfikus viselkedes miatt szukseges fuggvenyek, az oragutan eseten
    // nincs szukseg rajuk.
    @Override
    public int checkPoints() {
        return 0;
    }
    //------------------------------------------

    // kene egy getCaughtPandas(): ArrayList<Panda> fuggveny, hogy az ExitPoint tudja,
    // hogy kiknek hivja meg a die() fuggvenyet
}
