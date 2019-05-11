//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : GameLogic.java
//  @ Date : 2019.03.20.
//  @ Author : 
//
//


import java.util.ArrayList;

/**
 * Az osztaly amely a jatek motorjat kepezi, inicializalja a jatekot,
 * illetve az allatok lepteteset es a targyak uzemelteteset vegzi.
 *
 * @author Konczos
 */


public class GameLogic {

    /**
     * A jatekos megszerzett pointjait tarolo int.
     */
    private int points;

    /**
     * A program futasat jelzo boolean.
     */
    private boolean running = false;

    /**
     * A mapen levo pandakat tarolo lista.
     */
    private ArrayList<Panda> pandasOnTheMap;

    /**
     * A gep altal vezerelt orangutan referenciaja
     */
    private Orangutan secondOrangutan;

    /**
     * A jatekos altal vezerelt orangutan referenciaja
     */
    private PlayerOrangutan playerOrangutan;

    /**
     * A mapen levo speciális funkcioalitassal ellatott targyakat tarolo lista.
     */
    private ArrayList<Item> itemsOnTheMap;

    /**
     * A mapen levo szekrenyeket tarolo lista.
     */
    private ArrayList<EntryWardrobe> tilesOnMap;

    /**
     * A fuggveny a jatek inicializalasat vegzi.
     */
    public void initGame() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::initGame()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::initGame()");
        }
        running = true;
        return;
    }

    /**
     * A fuggveny visszaadja a gep altal vezetett orangutant.
     *
     * @return Az orangutan.
     */
    public Orangutan getSecondOrangutan() {
        return secondOrangutan;
    }

    /**
     * A fuggveny beallitja a gep altal vezetett orangutant.
     */
    public void setSecondOrangutan(Orangutan o) {
        secondOrangutan = o;
    }

    /**
     * A fuggveny visszaadja a jatekos altal vezetett orangutant.
     *
     * @return Az orangutan.
     */
    public Orangutan getPlayerOrangutan() {
        return playerOrangutan;
    }

    /**
     * A fuggveny beallitja a jatekos altal vezetett orangutant.
     */
    public void setPlayerOrangutan(PlayerOrangutan o) {
        playerOrangutan = o;
    }

    /**
     * A fuggveny visszaadja a pandakat a terkeprol.
     *
     * @return A pandakat tartalmazo lista.
     */
    public ArrayList<Panda> getPandasOnTheMap() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::getPandasOnTheMap()");
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::getPandasOnTheMap()");
        }
        return pandasOnTheMap;
    }

    /**
     * A jatek idoziteset elvegzo fuggveny.
     */
    public void game() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::game()");
        }

        long lastTime = System.nanoTime(); //utolsó mentett rendszeridő nanoszekundumban
        final double amountOfTicks = 2D; //hány ticket akarunk másodpercenként --> 2 tick másodpercenként
        double nanoSec = 1000000000 / amountOfTicks; //hány nanoszekudumonként kell tickelni
        double delta = 0;

        while (running) {
            long now = System.nanoTime(); //aktuális rendszeridő nanoszekundumban
            delta += (now - lastTime) / nanoSec;
            lastTime = now;
            if (delta >= 1) {
                tick(); //az állatok és tárgyak léptetése/üzemeltetése
                delta--;
            }

        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::game()");
        }
        return;
    }

    /**
     * A fuggveny szamolja a jatekos altal a kijaraton atjuttatott pandakat
     * es ez alapjan noveli a pontszamlalot.
     */
    public void addPoints(int p) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::addPoints(int p)");
        }

        points += (p * 50);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::addPoints(int p)");
        }
        return;
    }

    /**
     * A fuggveny visszaadja a megszerzett pontokat.
     */
    public int getPoints() {
        return points;
    }

    /**
     * A fuggveny befejezi a jatekot es kilep belole.
     */
    public void endGame() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::endGame()");
        }

        if (pandasOnTheMap.isEmpty()) {
            //  System.out.println("You caugth all pandas!");
            //  System.out.println("You caugt:" + points + " pandas!");
        } else {
            // System.out.println("You Lost!");
        }

        System.out.println("A jatek veget ert.");

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::endGame()");
        }
        // System.exit(0);
        return;
    }

    /**
     * A fuggveny az allatok lepteteset es targyak üzemeltetest latja el.
     */
    public void tick() {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::tick()");
        }

        secondOrangutan.move();

        for (int i = 0; i != pandasOnTheMap.size(); ++i) {
            pandasOnTheMap.get(i).move();
        }

        for (int j = 0; j != itemsOnTheMap.size(); ++j) {
            itemsOnTheMap.get(j).countDown();
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::tick()");
        }
        return;
    }

    /**
     * Eltavolitja a halott allatot.
     */
    public void remove(Animal a) {
        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::remove(Animal a)");
        }

        pandasOnTheMap.remove(a);
        //a = null;
        if (pandasOnTheMap.size() == 0) {
            endGame();
        }

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::remove(Animal a)");
        }

        return;
    }

    /**
     * Hozza ad egy pandat a GameLogic listajahoz,
     * ezaltal mar ez a panda is mozgatva lesz.
     *
     * @param p a listahoz hozzaadni kivant panda
     */
    public void addPanda(Panda p) {

        if (SkeletonMenu.indent) {
            GameLogic.indent(true);
            System.out.println(">   GameLogic::addPanda(Animal a)");
        }

        pandasOnTheMap.add(p);

        if (SkeletonMenu.indent) {
            GameLogic.indent(false);
            System.out.println("<   GameLogic::addPanda(Animal a)");
        }

        return;
    }

    /**
     * GameLogic konstruktor
     */
    public GameLogic() {
        points = 0;
        pandasOnTheMap = new ArrayList<>();
        tilesOnMap = new ArrayList<>();
        itemsOnTheMap = new ArrayList<>();
        playerOrangutan = new PlayerOrangutan();
        secondOrangutan = new Orangutan();
    }

    private static int tabCounter = 0;

    private static void writeTabs() {
        for (int i = 0; i < tabCounter; i++) {
            System.out.print("\t");
        }
        return;
    }

    public static void indent(boolean deeper) {
        if (!deeper)
            tabCounter--;

        writeTabs();

        if (deeper)
            tabCounter++;

        return;
    }

}
