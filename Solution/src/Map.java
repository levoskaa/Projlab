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
    protected HashMap<String,BaseTile> map = new HashMap<>();
    /**
     *
     * Referencia a gameLogicra.
     */
    protected GameLogic gL;

    /**
     * Letrehozza a csempeket es feltolti a map-ot veluk
     */
    public void fillMap(){

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
        map.put("c1",new Tile());
        map.put("c2",new Tile());
        map.put("c3",new Tile());

        //tiles for chocoautomat
        map.put("a1",new Tile());
        map.put("a2",new Tile());
        map.put("a3",new Tile());
        map.put("a4",new Tile());

        //tiles for slotmachines
        map.put("s1",new Tile());
        map.put("s2",new Tile());
        map.put("s3",new Tile());

        //breakableTiles
        map.put("b1", new BreakableTile());
        map.put("b2", new BreakableTile());
        map.put("b3", new BreakableTile());

        //entry wardrobes
        map.put("w1",new EntryWardrobe());
        map.put("w2",new EntryWardrobe());

        //exit point
        map.put("e", new ExitPoint());
    }

    /**
     * Beallitja az egyes csempek szomszedait es
     * ha all rajtuk valamilyen item azt is, illetve
     * beallitja a csempeket amelyre az egyes szekrenyek
     * teleportalnak.
     */
    public void setElementsOfMap(){

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
        map.get("c1").setItem(new Couch((Tile)map.get("c1")));

        ArrayList<BaseTile> c1Neighbours = new ArrayList<>();
        c1Neighbours.add(map.get("st"));
        c1Neighbours.add(map.get("t1"));
        c1Neighbours.add(map.get("t4"));
        c1Neighbours.add(map.get("t6"));
        map.get("c1").setNeighbours(c1Neighbours);

        //set tile c2
        map.get("c2").setName("c2");
        map.get("c2").setItem(new Couch((Tile)map.get("c2")));

        ArrayList<BaseTile> c2Neighbours = new ArrayList<>();
        c2Neighbours.add(map.get("t3"));
        c2Neighbours.add(map.get("t2"));
        c2Neighbours.add(map.get("t8"));
        c2Neighbours.add(map.get("s3"));
        map.get("c2").setNeighbours(c2Neighbours);

        //set tile c3
        map.get("c3").setName("c3");
        map.get("c3").setItem(new Couch((Tile)map.get("c3")));

        ArrayList<BaseTile> c3Neighbours = new ArrayList<>();
        c3Neighbours.add(map.get("t8"));
        c3Neighbours.add(map.get("t11"));
        map.get("c3").setNeighbours(c3Neighbours);


        //set tile a1
        map.get("a1").setName("a1");
        map.get("a1").setItem(new ChocoAutomat((Tile)map.get("a1")));

        ArrayList<BaseTile> a1Neighbours = new ArrayList<>();
        a1Neighbours.add(map.get("t6"));
        a1Neighbours.add(map.get("b1"));
        a1Neighbours.add(map.get("t10"));
        a1Neighbours.add(map.get("b2"));
        a1Neighbours.add(map.get("e"));
        map.get("a1").setNeighbours(a1Neighbours);

        //set tile a2
        map.get("a2").setName("a2");
        map.get("a2").setItem(new ChocoAutomat((Tile)map.get("a2")));

        ArrayList<BaseTile> a2Neighbours = new ArrayList<>();
        a2Neighbours.add(map.get("t7"));
        a2Neighbours.add(map.get("t2"));
        map.get("a2").setNeighbours(a2Neighbours);

        //set tile a3
        map.get("a3").setName("a3");
        map.get("a3").setItem(new ChocoAutomat((Tile)map.get("a3")));

        ArrayList<BaseTile> a3Neighbours = new ArrayList<>();
        a3Neighbours.add(map.get("t7"));
        a3Neighbours.add(map.get("w1"));
        a3Neighbours.add(map.get("t10"));
        a3Neighbours.add(map.get("t2"));
        map.get("a3").setNeighbours(a3Neighbours);

        //set tile a4
        map.get("a4").setName("a4");
        map.get("a4").setItem(new ChocoAutomat((Tile)map.get("a4")));

        ArrayList<BaseTile> a4Neighbours = new ArrayList<>();
        a4Neighbours.add(map.get("b3"));
        a4Neighbours.add(map.get("t13"));
        a4Neighbours.add(map.get("t12"));
        a4Neighbours.add(map.get("t15"));
        map.get("a4").setNeighbours(a4Neighbours);

        //set tile s1
        map.get("s1").setName("s1");
        map.get("s1").setItem(new SlotMachine((Tile)map.get("s1")));

        ArrayList<BaseTile> s1Neighbours = new ArrayList<>();
        s1Neighbours.add(map.get("t1"));
        s1Neighbours.add(map.get("t4"));
        map.get("s1").setNeighbours(s1Neighbours);

        //set tile s2
        map.get("s2").setName("s2");
        map.get("s2").setItem(new SlotMachine((Tile)map.get("s2")));

        ArrayList<BaseTile> s2Neighbours = new ArrayList<>();
        s2Neighbours.add(map.get("t11"));
        s2Neighbours.add(map.get("t14"));
        s2Neighbours.add(map.get("t10"));
        s2Neighbours.add(map.get("w2"));
        map.get("s2").setNeighbours(s2Neighbours);

        //set tile s3
        map.get("s3").setName("s3");
        map.get("s3").setItem(new SlotMachine((Tile)map.get("s3")));

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
        map.get("e").setDestination(map.get("st"));

        ArrayList<BaseTile> eNeighbours = new ArrayList<>();
        eNeighbours.add(map.get("t15"));
        eNeighbours.add(map.get("t14"));
        eNeighbours.add(map.get("t9"));
        eNeighbours.add(map.get("b2"));
        eNeighbours.add(map.get("a1"));
        map.get("e").setNeighbours(eNeighbours);
    }

    /**
     * A fuggveny visszaadja a hash kodja alapjan azonositott
     * csempe nevet.
     *
     * @param name Annak csempenek a hash kodja amely nevet szeretnenk tudni.
     * @return Visszaadja a csempe nevet.
     */
    public BaseTile getTile(String name){
        return map.get(name);
    }

    /**
     * A fuggveny visszaadja az osztalyban tarolt GameLogic objektumot.
     *
     * @return Visszaadja a GameLogic objektumot.
     */
    public GameLogic getGameLogic(){
        return gL;
    }

    /**
     * Incializalja az egesz palyat.
     */
    public Map(){
        fillMap();
        setElementsOfMap();
    }
}
