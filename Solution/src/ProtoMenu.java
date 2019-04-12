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
        String targetTile = words[2];

        boolean found = false;
        int i;
        for (i = 0; i < map.getGameLogic().getAnimalsOnTheMap().size() && !found; i++){
            if (animalName.equals(map.getGameLogic().getAnimalsOnTheMap().get(i).getName())){
                found = true;
            }
        }
        Panda myPanda = (Panda)map.getGameLogic().getAnimalsOnTheMap().get(i);
        map.getTile(targetTile).receive(myPanda);
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

        boolean run = true;
        while (run) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                words = reader.readLine().split(" ");
                switch (words[0]) {
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
                        run = false;
                        break;
                }
            } catch (IOException e) {

            }
            if (clearMap){
                map = new Map();
                clearMap = false;
            }
        }

    }
}