import javax.swing.text.AbstractDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Az osztaly a prototipus menujeert felelos,
 * ezen keresztul tudja a felhasznalo kivalasztani
 * a kivant parancsot. A parancs a kivalasztas utan lefutasra kerul.
 *
 * @author Kalai + sokan masok
 */

public class ProtoMenu {

    /**
     * Az aktualis parancsot tarolo String tomb.
     * Benne minden egyes String a parancs kovetkezo, szokozzel elvalasztott szava.
     */
    private String words[];

    /**
     * A terkepet tarolo objektum.
     */
    private Map map = new Map();

    /**
     * Eltarolja, hogy a terkepet ujra kell-e inicializalni (uj teszt).
     */
    boolean clearMap = false;

    /**
     * Az orangutan parancsot szimulalo fuggveny.
     */
    private void orangutan() {
        if (words.length < 5) {
            System.out.println("Error");
            return;
        }
        if (Integer.parseInt(words[4]) + 5 != words.length) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] orangutan neve, pl o2
         * words[2] celmezo, pl t10
         * words[3] ki vezeti, pl ai
         * words[4] pandak szama, pl 3
         * words[>4] pandak neve, pl p2 p3 p4
         *
         * */
    }

    /**
     * A panda parancsot szimulalo fuggveny.
     */
    private void panda() {
        if (words.length != 4) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] panda neve, pl p2
         * words[2] celmezo, pl t10
         * words[3] tulajdonsag, pl tired
         *
         * */

        String pandaName = words[1];
        String targetTile = words[2].toLowerCase();
        String attribute = words[3].toLowerCase();

        boolean found = false;
        int i;
        for (i = 0; i < map.getGameLogic().getAnimalsOnTheMap().size() && !found; ++i) {
            if (pandaName.equals(map.getGameLogic().getAnimalsOnTheMap().get(i).getName())) {
                found = true;
            }
        }
        if (found) {
            System.out.println("Error");
            return;
        }

        Panda myPanda;
        switch (attribute) {
            case "tired":
                myPanda = new TiredPanda();
                break;
            case "jumping":
                myPanda = new JumpingPanda();
                break;
            case "scarable":
                myPanda = new ScarablePanda();
                break;
            default:
                System.out.println("Error");
                return;
        }
        myPanda.setCaught(false);
        myPanda.setOrangutan(null);
        myPanda.setName(pandaName);
        myPanda.setTile(map.getTile(targetTile));
        myPanda.setGameLogic(map.getGameLogic());
        map.getGameLogic().addAnimal(myPanda);
        return;
    }

    /**
     * Az action parancsot szimulalo fuggveny.
     */
    private void action() {
        if (words.length != 2) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] item neve, pl s1
         *
         * */
    }

    /**
     * A configure parancsot szimulalo fuggveny.
     */
    private void configure() {
        if (words.length != 5) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] csempe/szekreny tipusa, pl Tile
         * words[2] csempe/szekreny neve, pl t2
         * words[3] csempe/szekreny tulajdonsaga, pl isBroken
         * words[3] csempe/szekreny tulajdonsaganak erteke, pl true
         *
         * */
    }

    /**
     * A step parancsot szimulalo fuggveny.
     */
    private void step() {
        if (words.length != 3) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] allat neve, pl o2
         * words[2] celmezo, pl t10
         *
         * */
        String animalName = words[1];
        String targetTile = words[2].toLowerCase();

        boolean found = false;
        int i;
        for (i = 0; i < map.getGameLogic().getAnimalsOnTheMap().size() && !found; ++i) {
            if (animalName.equals(map.getGameLogic().getAnimalsOnTheMap().get(i).getName())) {
                found = true;
            }
        }
        --i;
        if (!found) {
            System.out.println("Error");
            return;
        }
        map.getTile(targetTile).receive(map.getGameLogic().getAnimalsOnTheMap().get(i));
        return;
    }

    /**
     * A random parancsot szimulalo fuggveny.
     */
    private void random() {
        if (words.length != 2) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] random allapota, pl on
         *
         * */
    }

    /**
     * A release parancsot szimulalo fuggveny.
     */
    private void release() {
        if (words.length != 2) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] allat neve, pl o2
         *
         * */
    }

    /**
     * A script parancsot szimulalo fuggveny.
     */
    private void script() {
        if (words.length != 2) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] a fajl neve, pl script.txt
         *
         * */
    }

    /**
     * A stat parancsot szimulalo fuggveny.
     */
    private void stat() {
        if (words.length != 4) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] egyed neve, pl t3
         * words[2] egyed tipusa, pl tile
         * words[3] egyed tulajdonsaga (field), pl onTile
         *
         * */
        String name = words[1];
        String type = words[2].toLowerCase();
        String attribute = words[3].toLowerCase();

        switch (type) {
            case "tile":
                BaseTile myTile = map.getTile(name);
                switch (attribute) {
                    case "neighbours":
                        for (BaseTile bt : myTile.getNeighbours()) {
                            System.out.println(bt.getName());
                        }
                        break;
                    case "hasitem":
                        System.out.println(myTile.getItem() == null ? "false" : "true");
                        break;
                    case "haswardrobe":
                        System.out.println(myTile.isWardrobe() ? "false" : "true");
                        break;
                    case "currentanimal":
                        System.out.println(myTile.getAnimal().getName());
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                break;
            case "breakableTile":
                BreakableTile myTile2 = (BreakableTile) map.getTile(name);
                switch (attribute) {
                    case "neighbours":
                        for (BaseTile bt : myTile2.getNeighbours()) {
                            System.out.println(bt.getName());
                        }
                        break;
                    case "isbroken":
                        System.out.println(myTile2.isBroken());
                        break;
                    case "currentanimal":
                        System.out.println(myTile2.getAnimal().getName());
                        break;
                    case "currenthealth":
                        System.out.println(myTile2.getHealth());
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                break;
            case "orangutan":
                Orangutan o = map.getGameLogic().getOrangutan();
                boolean controlledby = true; // ai, gep vezerli
                boolean found = false;
                int i;
                for (i = 0; i < map.getGameLogic().getAnimalsOnTheMap().size() && !found; ++i) {
                    if (name.equals(map.getGameLogic().getAnimalsOnTheMap().get(i).getName())) {
                        found = true;
                    }
                }
                --i;
                if ((!found && o == null) || (!found && !o.getName().equals(name))) {
                    System.out.println("Error");
                    return;
                }
                if (found) {
                    o = (Orangutan) map.getGameLogic().getAnimalsOnTheMap().get(i);
                    controlledby = false;
                }
                switch (attribute) {
                    case "ontile":
                        System.out.println(o.getTile().getName());
                        break;
                    case "followingpandas":
                        for (Panda p : o.getCaughtPandas()) {
                            System.out.println(p.getName());
                        }
                        break;
                    case "controlledby":
                        System.out.println(controlledby ? "ai" : "player");
                        break;
                    case "points":
                        System.out.println(map.getGameLogic().getPoints());
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                break;
            case "panda":
                found = false;
                for (i = 0; i < map.getGameLogic().getAnimalsOnTheMap().size() && !found; ++i) {
                    if (name.equals(map.getGameLogic().getAnimalsOnTheMap().get(i).getName())) {
                        found = true;
                    }
                }
                --i;
                if (!found) {
                    System.out.println("Error");
                    return;
                }
                Panda myPanda = (Panda) map.getGameLogic().getAnimalsOnTheMap().get(i);
                switch (attribute) {
                    case "ontile":
                        System.out.println(myPanda.getTile().getName());
                        break;
                    case "iscaught":
                        System.out.println(myPanda.caught);
                        break;
                    case "attribute":
                        System.out.println(myPanda.getType());
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                break;
            case "item":
                Item myItem = map.getTile(name).getItem();
                switch (attribute) {
                    case "ontile":
                        System.out.println(map.getTile(name).getName());
                        break;
                    case "type":
                        System.out.println(myItem.getType());
                        break;
                    case "istaken":
                        if (myItem.getType().equals("couch")) {
                            Couch myCouch = (Couch) myItem;
                            System.out.println(myCouch.getActualAnimal().getName());
                        }
                        break;
                    case "valueofcountdown":
                        System.out.println(myItem.Counter);
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                break;
            case "wardrobe":
                EntryWardrobe myEntryWardrobe = (EntryWardrobe) map.getTile(name);
                switch (attribute) {
                    case "ontile":
                        System.out.println(map.getTile(name).getName());
                        break;
                    case "destinationTile":
                        System.out.println(myEntryWardrobe.getDestination().getName());
                        break;
                    default:
                        System.out.println("Error");
                        break;
                }
                break;
            default:
                break;
        }
    }

    /**
     * A save parancsot szimulalo fuggveny.
     */
    private void save() {
        if (words.length != 2) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] a fajl neve, pl script.txt
         *
         * */
    }

    /**
     * A mapstat parancsot szimulalo fuggveny.
     */
    private void mapstat() {
        if (words.length != 1) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         *
         * */
    }

    /**
     * Az endtest parancsot szimulalo fuggveny.
     */
    private void endtest() {
        /*
         * words[0] erdektelen
         *
         * */
    }

    /**
     * A prototipus felhasznaloi menujet inicializalo fuggveny.
     */
    public void menuInit() {
        System.out.println("Add meg a parancsot:");
        map.setGameLogic(new GameLogic());
        boolean run = true;

        while (run) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                words = reader.readLine().split(" ");
                /*
                az utasitas minden szava nem teheto lowercase-be, mert
                az egyedek nevei egyedinek kell lenniuk -> a P2 es a p2 NEM AZONOS!
                mindenki a sajat fuggvenyebe kezelje le, hogy pl a StEp, a step, és a STEP
                ugyanazt jelentse.
                for (int i = 0; i < words.length; ++i) {
                    words[i] = words[i].toLowerCase();
                }*/
                switch (words[0].toLowerCase()) {
                    case "orangutan":
                        orangutan();
                        break;
                    case "panda":
                        panda();
                        break;
                    case "action":
                        action();
                        break;
                    case "configure":
                        configure();
                        break;
                    case "step":
                        step();
                        break;
                    case "random":
                        random();
                        break;
                    case "release":
                        release();
                        break;
                    case "script":
                        script();
                        break;
                    case "stat":
                        stat();
                        break;
                    case "save":
                        save();
                        break;
                    case "mapstat":
                        mapstat();
                        break;
                    case "endtest":
                        endtest();
                        break;
                    default:
                        System.out.println("Error");
                        run = false;
                        break;
                }
            } catch (IOException e) {

            }
            if (clearMap) {
                map = new Map();
                clearMap = false;
            }
        }
        return;
    }
}