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
     * Az endtest parancsot szimulalo fuggveny.
     */
    private void endtest() {
        /*
         * words[0] erdektelen
         *
         * */
    }

    /**
     * A selectmap parancsot szimulalo fuggveny.
     */
    private void selectmap() {
        if (words.length != 2) {
            System.out.println("Error");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] terkep neve (1)
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
     * A sit parancsot szimulalo fuggveny.
     */
    private void sit() {
        /*
         *
         * ???
         * nincs leirva a bemeneti nyelvnel
         *
         *
         */
    }

    /**
     * A ring parancsot szimulalo fuggveny.
     */
    private void ring() {
        /*
         *
         * ???
         * nincs leirva a bemeneti nyelvnel
         *
         *
         */
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
                    case "panda":
                        panda();
                        break;
                    case "orangutan":
                        orangutan();
                        break;
                    case "step":
                        step();
                        break;
                    case "random":
                        random();
                        break;
                    case "stat":
                        stat();
                        break;
                    case "endtest":
                        endtest();
                        break;
                    case "selectmap":
                        selectmap();
                        break;
                    case "release":
                        release();
                        break;
                    case "sit":
                        sit();
                        break;
                    case "ring":
                        ring();
                        break;
                    default:
                        run = false;
                        break;
                }
            } catch (IOException e) {

            }
        }

    }
}