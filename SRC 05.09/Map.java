import java.util.ArrayList;
import java.util.HashMap;

/**
 * A terkepet megvalosito osztaly.
 *
 * @author Konczos
 */
public class Map {
    /**
     * Itt taroljuk a csempeket.
     */
    protected HashMap<String, BaseTile> map = new HashMap<>();

    /**
     *      * Referencia a gameLogicra.
     */
    protected GameLogic gL;

    /**
     * Egy nevrol eldontheto, hogy tartozik-e hozza csempe.
     * @param name A csempe neve amelyet keresunk.
     * @return A map tartalmaz-e name nevu csempet.
     */
    public boolean checkTileName(String name) {
        if (map.containsKey(name))
            return true;
        return false;
    }

    /**
     * Letrehozza a csempeket es feltolti a protohoz tartozo map-ot veluk
     */
    public void fillMap() {

        //entry tile
        map.put("st", new Tile());

        //common tiles
        map.put("t1", new Tile());
        map.put("t2", new Tile());
        map.put("t3", new Tile());
        map.put("t4", new Tile());
        map.put("t5", new Tile());
        map.put("t6", new Tile());
        map.put("t7", new Tile());
        map.put("t8", new Tile());
        map.put("t9", new Tile());
        map.put("t10", new Tile());
        map.put("t11", new Tile());
        map.put("t12", new Tile());
        map.put("t13", new Tile());
        map.put("t14", new Tile());
        map.put("t15", new Tile());

        //tiles for couch
        map.put("c1", new Tile());
        map.put("c2", new Tile());
        map.put("c3", new Tile());

        //tiles for chocoautomat
        map.put("a1", new Tile());
        map.put("a2", new Tile());
        map.put("a3", new Tile());
        map.put("a4", new Tile());

        //tiles for slotmachines
        map.put("s1", new Tile());
        map.put("s2", new Tile());
        map.put("s3", new Tile());

        //breakableTiles
        map.put("b1", new BreakableTile());
        map.put("b2", new BreakableTile());
        map.put("b3", new BreakableTile());

        //entry wardrobes
        map.put("w1", new EntryWardrobe());
        map.put("w2", new EntryWardrobe());

        //exit point
        map.put("e", new ExitPoint());
    }

    /**
     * Beallitja az egyes csempek szomszedait es
     * ha all rajtuk valamilyen item azt is, illetve
     * beallitja a csempeket amelyre az egyes szekrenyek
     * teleportalnak (proto menu).
     */
    public void setElementsOfMap() {

        //set tile st
        map.get("st").setName("st");
        ArrayList<BaseTile> stNeighbours = new ArrayList<>();
        stNeighbours.add(map.get("t1"));
        stNeighbours.add(map.get("t3"));
        stNeighbours.add(map.get("c1"));
        map.get("st").setNeighbours(stNeighbours);

        //set tile t1
        map.get("t1").setName("t1");
        ArrayList<BaseTile> t1Neighbours = new ArrayList<>();
        t1Neighbours.add(map.get("st"));
        t1Neighbours.add(map.get("c1"));
        t1Neighbours.add(map.get("s1"));
        t1Neighbours.add(map.get("t7"));
        t1Neighbours.add(map.get("t2"));
        map.get("t1").setNeighbours(t1Neighbours);

        //set tile t2
        map.get("t2").setName("t2");
        ArrayList<BaseTile> t2Neighbours = new ArrayList<>();
        t2Neighbours.add(map.get("t1"));
        t2Neighbours.add(map.get("a2"));
        t2Neighbours.add(map.get("t8"));
        t2Neighbours.add(map.get("c2"));
        t2Neighbours.add(map.get("t3"));
        map.get("t2").setNeighbours(t2Neighbours);

        //set tile t3
        map.get("t3").setName("t3");
        ArrayList<BaseTile> t3Neighbours = new ArrayList<>();
        t3Neighbours.add(map.get("st"));
        t3Neighbours.add(map.get("t2"));
        t3Neighbours.add(map.get("t9"));
        t3Neighbours.add(map.get("c2"));
        t3Neighbours.add(map.get("b3"));
        map.get("t3").setNeighbours(t3Neighbours);

        //set tile t4
        map.get("t4").setName("t4");
        ArrayList<BaseTile> t4Neighbours = new ArrayList<>();
        t4Neighbours.add(map.get("c1"));
        t4Neighbours.add(map.get("s1"));
        t4Neighbours.add(map.get("t5"));
        map.get("t4").setNeighbours(t4Neighbours);

        //set tile t5
        map.get("t5").setName("t5");
        ArrayList<BaseTile> t5Neighbours = new ArrayList<>();
        t5Neighbours.add(map.get("t4"));
        t5Neighbours.add(map.get("w1"));
        t5Neighbours.add(map.get("t6"));
        map.get("t5").setNeighbours(t5Neighbours);

        //set tile t6
        map.get("t6").setName("t6");
        ArrayList<BaseTile> t6Neighbours = new ArrayList<>();
        t6Neighbours.add(map.get("c1"));
        t6Neighbours.add(map.get("t5"));
        t6Neighbours.add(map.get("b1"));
        t6Neighbours.add(map.get("a1"));
        map.get("t6").setNeighbours(t6Neighbours);

        //set tile t7
        map.get("t7").setName("t7");
        ArrayList<BaseTile> t7Neighbours = new ArrayList<>();
        t7Neighbours.add(map.get("t1"));
        t7Neighbours.add(map.get("a2"));
        t7Neighbours.add(map.get("a3"));
        map.get("t7").setNeighbours(t7Neighbours);

        //set tile t8
        map.get("t8").setName("t8");
        ArrayList<BaseTile> t8Neighbours = new ArrayList<>();
        t8Neighbours.add(map.get("t2"));
        t8Neighbours.add(map.get("c2"));
        t8Neighbours.add(map.get("w2"));
        t8Neighbours.add(map.get("c3"));
        map.get("t8").setNeighbours(t8Neighbours);

        //set tile t9
        map.get("t9").setName("t9");
        ArrayList<BaseTile> t9Neighbours = new ArrayList<>();
        t9Neighbours.add(map.get("t3"));
        t9Neighbours.add(map.get("t10"));
        t9Neighbours.add(map.get("e"));
        map.get("t9").setNeighbours(t9Neighbours);

        //set tile t10
        map.get("t10").setName("t10");
        ArrayList<BaseTile> t10Neighbours = new ArrayList<>();
        t10Neighbours.add(map.get("t9"));
        t10Neighbours.add(map.get("a3"));
        t10Neighbours.add(map.get("b1"));
        t10Neighbours.add(map.get("a1"));
        t10Neighbours.add(map.get("b2"));
        t10Neighbours.add(map.get("s2"));
        map.get("t10").setNeighbours(t10Neighbours);

        //set tile t11
        map.get("t11").setName("t11");
        ArrayList<BaseTile> t11Neighbours = new ArrayList<>();
        t11Neighbours.add(map.get("s3"));
        t11Neighbours.add(map.get("c3"));
        t11Neighbours.add(map.get("s2"));
        t11Neighbours.add(map.get("b2"));
        t11Neighbours.add(map.get("t15"));
        map.get("t11").setNeighbours(t11Neighbours);

        //set tile t12
        map.get("t12").setName("t12");
        ArrayList<BaseTile> t12Neighbours = new ArrayList<>();
        t12Neighbours.add(map.get("t13"));
        t12Neighbours.add(map.get("a4"));
        t12Neighbours.add(map.get("t15"));
        map.get("t12").setNeighbours(t12Neighbours);

        //set tile t13
        map.get("t13").setName("t13");
        ArrayList<BaseTile> t13Neighbours = new ArrayList<>();
        t13Neighbours.add(map.get("s3"));
        t13Neighbours.add(map.get("b3"));
        t13Neighbours.add(map.get("t12"));
        t13Neighbours.add(map.get("a4"));
        map.get("t13").setNeighbours(t13Neighbours);

        //set tile t14
        map.get("t14").setName("t14");
        ArrayList<BaseTile> t14Neighbours = new ArrayList<>();
        t14Neighbours.add(map.get("s2"));
        t14Neighbours.add(map.get("t15"));
        t14Neighbours.add(map.get("e"));
        map.get("t14").setNeighbours(t14Neighbours);

        //set tile t15
        map.get("t15").setName("t15");
        ArrayList<BaseTile> t15Neighbours = new ArrayList<>();
        t15Neighbours.add(map.get("a4"));
        t15Neighbours.add(map.get("t12"));
        t15Neighbours.add(map.get("t11"));
        t15Neighbours.add(map.get("t14"));
        t15Neighbours.add(map.get("e"));
        map.get("t15").setNeighbours(t15Neighbours);

        //set tile c1
        map.get("c1").setName("c1");
        map.get("c1").setItem(new Couch((Tile) map.get("c1")));

        ArrayList<BaseTile> c1Neighbours = new ArrayList<>();
        c1Neighbours.add(map.get("st"));
        c1Neighbours.add(map.get("t1"));
        c1Neighbours.add(map.get("t4"));
        c1Neighbours.add(map.get("t6"));
        map.get("c1").setNeighbours(c1Neighbours);

        //set tile c2
        map.get("c2").setName("c2");
        map.get("c2").setItem(new Couch((Tile) map.get("c2")));

        ArrayList<BaseTile> c2Neighbours = new ArrayList<>();
        c2Neighbours.add(map.get("t3"));
        c2Neighbours.add(map.get("t2"));
        c2Neighbours.add(map.get("t8"));
        c2Neighbours.add(map.get("s3"));
        map.get("c2").setNeighbours(c2Neighbours);

        //set tile c3
        map.get("c3").setName("c3");
        map.get("c3").setItem(new Couch((Tile) map.get("c3")));

        ArrayList<BaseTile> c3Neighbours = new ArrayList<>();
        c3Neighbours.add(map.get("t8"));
        c3Neighbours.add(map.get("t11"));
        map.get("c3").setNeighbours(c3Neighbours);


        //set tile a1
        map.get("a1").setName("a1");
        map.get("a1").setItem(new ChocoAutomat((Tile) map.get("a1")));

        ArrayList<BaseTile> a1Neighbours = new ArrayList<>();
        a1Neighbours.add(map.get("t6"));
        a1Neighbours.add(map.get("b1"));
        a1Neighbours.add(map.get("t10"));
        a1Neighbours.add(map.get("b2"));
        a1Neighbours.add(map.get("e"));
        map.get("a1").setNeighbours(a1Neighbours);

        //set tile a2
        map.get("a2").setName("a2");
        map.get("a2").setItem(new ChocoAutomat((Tile) map.get("a2")));

        ArrayList<BaseTile> a2Neighbours = new ArrayList<>();
        a2Neighbours.add(map.get("t7"));
        a2Neighbours.add(map.get("t2"));
        map.get("a2").setNeighbours(a2Neighbours);

        //set tile a3
        map.get("a3").setName("a3");
        map.get("a3").setItem(new ChocoAutomat((Tile) map.get("a3")));

        ArrayList<BaseTile> a3Neighbours = new ArrayList<>();
        a3Neighbours.add(map.get("t7"));
        a3Neighbours.add(map.get("w1"));
        a3Neighbours.add(map.get("t10"));
        a3Neighbours.add(map.get("t2"));
        map.get("a3").setNeighbours(a3Neighbours);

        //set tile a4
        map.get("a4").setName("a4");
        map.get("a4").setItem(new ChocoAutomat((Tile) map.get("a4")));

        ArrayList<BaseTile> a4Neighbours = new ArrayList<>();
        a4Neighbours.add(map.get("b3"));
        a4Neighbours.add(map.get("t13"));
        a4Neighbours.add(map.get("t12"));
        a4Neighbours.add(map.get("t15"));
        map.get("a4").setNeighbours(a4Neighbours);

        //set tile s1
        map.get("s1").setName("s1");
        map.get("s1").setItem(new SlotMachine((Tile) map.get("s1")));

        ArrayList<BaseTile> s1Neighbours = new ArrayList<>();
        s1Neighbours.add(map.get("t1"));
        s1Neighbours.add(map.get("t4"));
        map.get("s1").setNeighbours(s1Neighbours);

        //set tile s2
        map.get("s2").setName("s2");
        map.get("s2").setItem(new SlotMachine((Tile) map.get("s2")));

        ArrayList<BaseTile> s2Neighbours = new ArrayList<>();
        s2Neighbours.add(map.get("t11"));
        s2Neighbours.add(map.get("t14"));
        s2Neighbours.add(map.get("t10"));
        s2Neighbours.add(map.get("w2"));
        map.get("s2").setNeighbours(s2Neighbours);

        //set tile s3
        map.get("s3").setName("s3");
        map.get("s3").setItem(new SlotMachine((Tile) map.get("s3")));

        ArrayList<BaseTile> s3Neighbours = new ArrayList<>();
        s3Neighbours.add(map.get("t13"));
        s3Neighbours.add(map.get("c2"));
        s3Neighbours.add(map.get("t11"));
        map.get("s3").setNeighbours(s3Neighbours);

        //set breakabletile b1
        map.get("b1").setName("b1");
        map.get("b1").setHealth(20);

        ArrayList<BaseTile> b1Neighbours = new ArrayList<>();
        b1Neighbours.add(map.get("w1"));
        b1Neighbours.add(map.get("t6"));
        b1Neighbours.add(map.get("t10"));
        b1Neighbours.add(map.get("a1"));
        map.get("b1").setNeighbours(b1Neighbours);

        //set breakabletile b2
        map.get("b2").setName("b2");
        map.get("b2").setHealth(20);

        ArrayList<BaseTile> b2Neighbours = new ArrayList<>();
        b2Neighbours.add(map.get("t10"));
        b2Neighbours.add(map.get("a1"));
        b2Neighbours.add(map.get("t11"));
        b2Neighbours.add(map.get("e"));
        map.get("b2").setNeighbours(b2Neighbours);

        //set breakabletile b3
        map.get("b3").setName("b3");
        map.get("b3").setHealth(20);

        ArrayList<BaseTile> b3Neighbours = new ArrayList<>();
        b3Neighbours.add(map.get("t3"));
        b3Neighbours.add(map.get("t13"));
        b3Neighbours.add(map.get("a4"));
        map.get("b3").setNeighbours(b3Neighbours);

        //set entryWardrobe w1
        map.get("w1").setName("w1");
        map.get("w1").setDestination(map.get("t6"));

        ArrayList<BaseTile> w1Neighbours = new ArrayList<>();
        w1Neighbours.add(map.get("t5"));
        w1Neighbours.add(map.get("b1"));
        w1Neighbours.add(map.get("a3"));
        map.get("w1").setNeighbours(w1Neighbours);

        //set entryWardrobe w2
        map.get("w2").setName("w2");
        map.get("w2").setDestination(map.get("t15"));

        ArrayList<BaseTile> w2Neighbours = new ArrayList<>();
        w2Neighbours.add(map.get("t8"));
        w2Neighbours.add(map.get("s2"));
        map.get("w2").setNeighbours(w2Neighbours);

        //set exitPoint
        map.get("e").setName("e");
        //map.get("e").setDestination(map.get("st"));
        map.get("e").setStartingTile((Tile)map.get("st"));
        map.get("e").setGameLogic(gL);

        ArrayList<BaseTile> eNeighbours = new ArrayList<>();
        eNeighbours.add(map.get("t15"));
        eNeighbours.add(map.get("t14"));
        eNeighbours.add(map.get("t9"));
        eNeighbours.add(map.get("b2"));
        eNeighbours.add(map.get("a1"));
        map.get("e").setNeighbours(eNeighbours);
    }


    /**
     * Letrehozza a csempeket es feltolti a a tenyleges jatek map-ot veluk
     */
    public void fillPlayingMap(){

        //entry tile
        map.put("st", new Tile());

        //common tiles
        map.put("t1", new Tile());
        map.put("t2", new Tile());
        map.put("t3", new Tile());
        map.put("t4", new Tile());
        map.put("t5", new Tile());
        map.put("t6", new Tile());
        map.put("t7", new Tile());
        map.put("t8", new Tile());
        map.put("t9", new Tile());
        map.put("t10", new Tile());
        map.put("t11", new Tile());
        map.put("t12", new Tile());
        map.put("t13", new Tile());
        map.put("t14", new Tile());
        map.put("t15", new Tile());
        map.put("t16", new Tile());
        map.put("t17", new Tile());
        map.put("t18", new Tile());
        map.put("t19", new Tile());
        map.put("t20", new Tile());
        map.put("t21", new Tile());
        map.put("t22", new Tile());
        map.put("t23", new Tile());
        map.put("t24", new Tile());
        map.put("t25", new Tile());
        map.put("t26", new Tile());
        map.put("t27", new Tile());
        map.put("t28", new Tile());
        map.put("t29", new Tile());
        map.put("t30", new Tile());
        map.put("t31", new Tile());
        map.put("t32", new Tile());
        map.put("t33", new Tile());

        //tiles for couch
        map.put("c1", new Tile());

        //tiles for chocoautomat
        map.put("a1", new Tile());

        //tiles for slotmachines
        map.put("s1", new Tile());

        //breakableTiles
        map.put("b1", new BreakableTile());
        map.put("b3", new BreakableTile());


        //entry wardrobes
        map.put("w1", new EntryWardrobe());
        map.put("w2", new EntryWardrobe());

        //exit point
        map.put("e", new ExitPoint());

    }

    /**
    * Beallitja az egyes csempek szomszedait es
    * ha all rajtuk valamilyen item azt is, illetve
    * beallitja a csempeket amelyre az egyes szekrenyek
    * teleportalnak (tenyleges jatek).
    */
    void setElementsOfPlayingMap(){

        //set tile st
        map.get("st").setName("st");
        ArrayList<BaseTile> stNeighbours = new ArrayList<>();
        stNeighbours.add(map.get("t1"));
        stNeighbours.add(map.get("t2"));
        stNeighbours.add(map.get("t14"));
        stNeighbours.add(map.get("t15"));
        stNeighbours.add(map.get("t25"));
        stNeighbours.add(map.get("t27"));
        stNeighbours.add(map.get("t26"));
        map.get("st").setNeighbours(stNeighbours);

        //set tile e
        map.get("e").setName("e");
        ArrayList<BaseTile> eNeighbours = new ArrayList<>();
        eNeighbours.add(map.get("t10"));
        eNeighbours.add(map.get("t11"));
        eNeighbours.add(map.get("t12"));
        eNeighbours.add(map.get("t21"));
        eNeighbours.add(map.get("t22"));
        eNeighbours.add(map.get("t33"));
        eNeighbours.add(map.get("w2"));
        map.get("e").setNeighbours(eNeighbours);

        //set tile c1
        map.get("c1").setName("c1");
        map.get("c1").setItem(new Couch((Tile) map.get("c1")));

        ArrayList<BaseTile> c1Neighbours = new ArrayList<>();
        c1Neighbours.add(map.get("t31"));
        c1Neighbours.add(map.get("t32"));
        map.get("c1").setNeighbours(c1Neighbours);

        //set breakabletile b1
        map.get("b1").setName("b1");
        map.get("b1").setHealth(20);

        ArrayList<BaseTile> b1Neighbours = new ArrayList<>();
        b1Neighbours.add(map.get("t25"));
        b1Neighbours.add(map.get("t28"));
        b1Neighbours.add(map.get("w1"));
        b1Neighbours.add(map.get("t24"));
        b1Neighbours.add(map.get("t16"));
        map.get("b1").setNeighbours(b1Neighbours);

        //set breakabletile b3
        map.get("b3").setName("b3");
        map.get("b3").setHealth(20);

        ArrayList<BaseTile> b3Neighbours = new ArrayList<>();
        b3Neighbours.add(map.get("t20"));
        b3Neighbours.add(map.get("t23"));
        b3Neighbours.add(map.get("t31"));
        b3Neighbours.add(map.get("t32"));
        b3Neighbours.add(map.get("t22"));
        map.get("b3").setNeighbours(b3Neighbours);

        //set entryWardrobe w1
        map.get("w1").setName("w1");
        map.get("w1").setDestination(map.get("t6"));

        ArrayList<BaseTile> w1Neighbours = new ArrayList<>();
        w1Neighbours.add(map.get("b1"));
        w1Neighbours.add(map.get("t24"));
        w1Neighbours.add(map.get("t29"));
        map.get("w1").setNeighbours(w1Neighbours);

        //set entryWardrobe w2
        map.get("w2").setName("w2");
        map.get("w2").setDestination(map.get("t15"));

        ArrayList<BaseTile> w2Neighbours = new ArrayList<>();
        w2Neighbours.add(map.get("e"));
        w2Neighbours.add(map.get("t33"));
        map.get("w2").setNeighbours(w2Neighbours);

        //set tile a1
        map.get("a1").setName("a1");
        map.get("a1").setItem(new ChocoAutomat((Tile) map.get("a1")));

        ArrayList<BaseTile> a1Neighbours = new ArrayList<>();
        a1Neighbours.add(map.get("t29"));
        a1Neighbours.add(map.get("t24"));
        a1Neighbours.add(map.get("t17"));
        a1Neighbours.add(map.get("t18"));
        a1Neighbours.add(map.get("t19"));
        a1Neighbours.add(map.get("b23"));
        a1Neighbours.add(map.get("t30"));
        map.get("a1").setNeighbours(a1Neighbours);

        //set tile s1
        map.get("s1").setName("s1");
        map.get("s1").setItem(new SlotMachine((Tile) map.get("s1")));

        ArrayList<BaseTile> s1Neighbours = new ArrayList<>();
        s1Neighbours.add(map.get("t13"));
        s1Neighbours.add(map.get("t5"));
        s1Neighbours.add(map.get("t6"));
        s1Neighbours.add(map.get("t7"));
        s1Neighbours.add(map.get("t12"));
        s1Neighbours.add(map.get("t21"));
        s1Neighbours.add(map.get("t20"));
        s1Neighbours.add(map.get("t19"));
        s1Neighbours.add(map.get("t18"));
        map.get("s1").setNeighbours(s1Neighbours);

        //set tile t1
        map.get("t1").setName("t1");
        ArrayList<BaseTile> t1Neighbours = new ArrayList<>();
        t1Neighbours.add(map.get("st"));
        t1Neighbours.add(map.get("t2"));
        map.get("t1").setNeighbours(t1Neighbours);

        //set tile t2
        map.get("t2").setName("t2");
        ArrayList<BaseTile> t2Neighbours = new ArrayList<>();
        t2Neighbours.add(map.get("t1"));
        t2Neighbours.add(map.get("t14"));
        t2Neighbours.add(map.get("st"));
        map.get("t2").setNeighbours(t2Neighbours);

        //set tile t3
        map.get("t3").setName("t3");
        ArrayList<BaseTile> t3Neighbours = new ArrayList<>();
        t3Neighbours.add(map.get("t14"));
        t3Neighbours.add(map.get("t4"));
        t3Neighbours.add(map.get("t13"));
        map.get("t3").setNeighbours(t3Neighbours);

        //set tile t4
        map.get("t4").setName("t4");
        ArrayList<BaseTile> t4Neighbours = new ArrayList<>();
        t4Neighbours.add(map.get("t3"));
        t4Neighbours.add(map.get("t5"));
        t4Neighbours.add(map.get("t13"));
        map.get("t4").setNeighbours(t4Neighbours);

        //set tile t5
        map.get("t5").setName("t5");
        ArrayList<BaseTile> t5Neighbours = new ArrayList<>();
        t5Neighbours.add(map.get("t4"));
        t5Neighbours.add(map.get("t6"));
        t5Neighbours.add(map.get("t13"));
        t5Neighbours.add(map.get("s1"));
        map.get("t5").setNeighbours(t5Neighbours);

        //set tile t6
        map.get("t6").setName("t6");
        ArrayList<BaseTile> t6Neighbours = new ArrayList<>();
        t6Neighbours.add(map.get("t5"));
        t6Neighbours.add(map.get("t7"));
        t6Neighbours.add(map.get("s1"));
        map.get("t6").setNeighbours(t6Neighbours);

        //set tile t7
        map.get("t7").setName("t7");
        ArrayList<BaseTile> t7Neighbours = new ArrayList<>();
        t7Neighbours.add(map.get("t6"));
        t7Neighbours.add(map.get("s1"));
        t7Neighbours.add(map.get("t8"));
        t7Neighbours.add(map.get("t12"));
        map.get("t7").setNeighbours(t7Neighbours);

        //set tile t8
        map.get("t8").setName("t8");
        ArrayList<BaseTile> t8Neighbours = new ArrayList<>();
        t8Neighbours.add(map.get("t9"));
        t8Neighbours.add(map.get("t11"));
        t8Neighbours.add(map.get("t7"));
        map.get("t8").setNeighbours(t8Neighbours);

        //set tile t9
        map.get("t9").setName("t9");
        ArrayList<BaseTile> t9Neighbours = new ArrayList<>();
        t9Neighbours.add(map.get("t8"));
        t9Neighbours.add(map.get("t10"));
        map.get("t9").setNeighbours(t9Neighbours);

        //set tile t10
        map.get("t10").setName("t10");
        ArrayList<BaseTile> t10Neighbours = new ArrayList<>();
        t10Neighbours.add(map.get("t9"));
        t10Neighbours.add(map.get("t11"));
        t10Neighbours.add(map.get("e"));
        map.get("t10").setNeighbours(t10Neighbours);

        //set tile t11
        map.get("t11").setName("t11");
        ArrayList<BaseTile> t11Neighbours = new ArrayList<>();
        t11Neighbours.add(map.get("t8"));
        t11Neighbours.add(map.get("t10"));
        t11Neighbours.add(map.get("t12"));
        t11Neighbours.add(map.get("e"));
        map.get("t11").setNeighbours(t11Neighbours);

        //set tile t12
        map.get("t12").setName("t12");
        ArrayList<BaseTile> t12Neighbours = new ArrayList<>();
        t12Neighbours.add(map.get("t11"));
        t12Neighbours.add(map.get("t7"));
        t12Neighbours.add(map.get("s1"));
        t12Neighbours.add(map.get("t21"));
        t12Neighbours.add(map.get("e"));
        map.get("t12").setNeighbours(t12Neighbours);

        //set tile t13
        map.get("t13").setName("t13");
        ArrayList<BaseTile> t13Neighbours = new ArrayList<>();
        t13Neighbours.add(map.get("t14"));
        t13Neighbours.add(map.get("t3"));
        t13Neighbours.add(map.get("t4"));
        t13Neighbours.add(map.get("t5"));
        t13Neighbours.add(map.get("s1"));
        t13Neighbours.add(map.get("t18"));
        t13Neighbours.add(map.get("t17"));
        t13Neighbours.add(map.get("t16"));
        t13Neighbours.add(map.get("t15"));
        map.get("t13").setNeighbours(t13Neighbours);

        //set tile t14
        map.get("t14").setName("t14");
        ArrayList<BaseTile> t14Neighbours = new ArrayList<>();
        t14Neighbours.add(map.get("t2"));
        t14Neighbours.add(map.get("t3"));
        t14Neighbours.add(map.get("t13"));
        t14Neighbours.add(map.get("t15"));
        t14Neighbours.add(map.get("st"));
        map.get("t14").setNeighbours(t14Neighbours);

        //set tile t15
        map.get("t15").setName("t15");
        ArrayList<BaseTile> t15Neighbours = new ArrayList<>();
        t15Neighbours.add(map.get("t14"));
        t15Neighbours.add(map.get("t13"));
        t15Neighbours.add(map.get("t16"));
        t15Neighbours.add(map.get("t25"));
        t15Neighbours.add(map.get("st"));
        map.get("t15").setNeighbours(t15Neighbours);

        //set tile t16
        map.get("t16").setName("t16");
        ArrayList<BaseTile> t16Neighbours = new ArrayList<>();
        t16Neighbours.add(map.get("t15"));
        t16Neighbours.add(map.get("t13"));
        t16Neighbours.add(map.get("t17"));
        t16Neighbours.add(map.get("b1"));
        map.get("t16").setNeighbours(t16Neighbours);

        //set tile t17
        map.get("t17").setName("t17");
        ArrayList<BaseTile> t17Neighbours = new ArrayList<>();
        t17Neighbours.add(map.get("t13"));
        t17Neighbours.add(map.get("t16"));
        t17Neighbours.add(map.get("t18"));
        t17Neighbours.add(map.get("a1"));
        t17Neighbours.add(map.get("t24"));
        map.get("t17").setNeighbours(t17Neighbours);

        //set tile t18
        map.get("t18").setName("t18");
        ArrayList<BaseTile> t18Neighbours = new ArrayList<>();
        t18Neighbours.add(map.get("t13"));
        t18Neighbours.add(map.get("s1"));
        t18Neighbours.add(map.get("t19"));
        t18Neighbours.add(map.get("a1"));
        t18Neighbours.add(map.get("t17"));
        map.get("t18").setNeighbours(t18Neighbours);

        //set tile t19
        map.get("t19").setName("t19");
        ArrayList<BaseTile> t19Neighbours = new ArrayList<>();
        t19Neighbours.add(map.get("s1"));
        t19Neighbours.add(map.get("t20"));
        t19Neighbours.add(map.get("t23"));
        t19Neighbours.add(map.get("a1"));
        t19Neighbours.add(map.get("t18"));
        map.get("t19").setNeighbours(t19Neighbours);

        //set tile t20
        map.get("t20").setName("t20");
        ArrayList<BaseTile> t20Neighbours = new ArrayList<>();
        t20Neighbours.add(map.get("s1"));
        t20Neighbours.add(map.get("t21"));
        t20Neighbours.add(map.get("b3"));
        t20Neighbours.add(map.get("t19"));
        map.get("t20").setNeighbours(t20Neighbours);

        //set tile t21
        map.get("t21").setName("t21");
        ArrayList<BaseTile> t21Neighbours = new ArrayList<>();
        t21Neighbours.add(map.get("t12"));
        t21Neighbours.add(map.get("e"));
        t21Neighbours.add(map.get("t22"));
        t21Neighbours.add(map.get("t20"));
        t21Neighbours.add(map.get("s1"));
        map.get("t21").setNeighbours(t21Neighbours);

        //set tile t22
        map.get("t22").setName("t22");
        ArrayList<BaseTile> t22Neighbours = new ArrayList<>();
        t22Neighbours.add(map.get("t21"));
        t22Neighbours.add(map.get("e"));
        t22Neighbours.add(map.get("t33"));
        t22Neighbours.add(map.get("b3"));
        map.get("t22").setNeighbours(t22Neighbours);

        //set tile t23
        map.get("t23").setName("t23");
        ArrayList<BaseTile> t23Neighbours = new ArrayList<>();
        t23Neighbours.add(map.get("t19"));
        t23Neighbours.add(map.get("b3"));
        t23Neighbours.add(map.get("t30"));
        t23Neighbours.add(map.get("a1"));
        map.get("t23").setNeighbours(t23Neighbours);

        //set tile t24
        map.get("t24").setName("t24");
        ArrayList<BaseTile> t24Neighbours = new ArrayList<>();
        t24Neighbours.add(map.get("t17"));
        t24Neighbours.add(map.get("a1"));
        t24Neighbours.add(map.get("t29"));
        t24Neighbours.add(map.get("w1"));
        t24Neighbours.add(map.get("b1"));
        map.get("t24").setNeighbours(t24Neighbours);

        //set tile t25
        map.get("t25").setName("t25");
        ArrayList<BaseTile> t25Neighbours = new ArrayList<>();
        t25Neighbours.add(map.get("t15"));
        t25Neighbours.add(map.get("b1"));
        t25Neighbours.add(map.get("t27"));
        t25Neighbours.add(map.get("st"));
        map.get("t25").setNeighbours(t25Neighbours);

        //set tile t26
        map.get("t26").setName("t26");
        ArrayList<BaseTile> t26Neighbours = new ArrayList<>();
        t26Neighbours.add(map.get("st"));
        t26Neighbours.add(map.get("t27"));
        map.get("t26").setNeighbours(t26Neighbours);

        //set tile t27
        map.get("t27").setName("t27");
        ArrayList<BaseTile> t27Neighbours = new ArrayList<>();
        t27Neighbours.add(map.get("t25"));
        t27Neighbours.add(map.get("t28"));
        t27Neighbours.add(map.get("t26"));
        t27Neighbours.add(map.get("st"));
        map.get("t27").setNeighbours(t27Neighbours);

        //set tile t28
        map.get("t28").setName("t28");
        ArrayList<BaseTile> t28Neighbours = new ArrayList<>();
        t28Neighbours.add(map.get("t27"));
        t28Neighbours.add(map.get("b1"));
        map.get("t28").setNeighbours(t28Neighbours);

        //set tile t29
        map.get("t29").setName("t29");
        ArrayList<BaseTile> t29Neighbours = new ArrayList<>();
        t29Neighbours.add(map.get("t24"));
        t29Neighbours.add(map.get("a1"));
        t29Neighbours.add(map.get("w1"));
        map.get("t29").setNeighbours(t29Neighbours);

        //set tile t30
        map.get("t30").setName("t30");
        ArrayList<BaseTile> t30Neighbours = new ArrayList<>();
        t30Neighbours.add(map.get("t23"));
        t30Neighbours.add(map.get("t31"));
        t30Neighbours.add(map.get("a1"));
        map.get("t30").setNeighbours(t30Neighbours);

        //set tile t31
        map.get("t31").setName("t31");
        ArrayList<BaseTile> t31Neighbours = new ArrayList<>();
        t31Neighbours.add(map.get("b3"));
        t31Neighbours.add(map.get("c1"));
        t31Neighbours.add(map.get("t30"));
        map.get("t31").setNeighbours(t31Neighbours);

        //set tile t32
        map.get("t32").setName("t32");
        ArrayList<BaseTile> t32Neighbours = new ArrayList<>();
        t32Neighbours.add(map.get("b3"));
        t32Neighbours.add(map.get("t33"));
        t32Neighbours.add(map.get("c1"));
        map.get("t32").setNeighbours(t32Neighbours);

        //set tile t33
        map.get("t33").setName("t33");
        ArrayList<BaseTile> t33Neighbours = new ArrayList<>();
        t33Neighbours.add(map.get("e"));
        t33Neighbours.add(map.get("w2"));
        t33Neighbours.add(map.get("t32"));
        t33Neighbours.add(map.get("t22"));
        map.get("t33").setNeighbours(t33Neighbours);
    }

    /**
     * A fuggveny visszaadja a hash kodja alapjan azonositott
     * csempe nevet.
     *
     * @param name Annak csempenek a hash kodja amely nevet szeretnenk tudni.
     * @return Visszaadja a csempe nevet.
     */
    public BaseTile getTile(String name) {
        return map.get(name);
    }

    /**
     * A fuggveny visszaadja az osztalyban tarolt GameLogic objektumot.
     *
     * @return Visszaadja a GameLogic objektumot.
     */
    public GameLogic getGameLogic() {
        return gL;
    }

    /**
     * A fuggveny beallitja az osztalyban tarolt GameLogic objektumot.
     *
     * @return Beallitja a GameLogic objektumot.
     */
    public void setGameLogic(GameLogic gl) {
        gL = gl;
        return;
    }

    /**
     * Incializalja az egesz palyat(proto, illetve a vegleges jatek).
     */
    public Map(GameLogic gameLogic, boolean proto) {
        gL = gameLogic;
        if (proto)
        {
            fillMap();
            setElementsOfMap();
        }
        else
        {
            fillPlayingMap();
            setElementsOfPlayingMap();
        }
    }
}
