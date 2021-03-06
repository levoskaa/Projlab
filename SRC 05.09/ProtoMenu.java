import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

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
    private Map map = new Map(new GameLogic(), true);

    /**
     * Eltarolja, hogy a terkepet ujra kell-e inicializalni (uj teszt).
     */
    boolean clearMap = false;

    /**
     * A veletlenszeru mukodes allapotat mutatja. Veletlenszeru ha igaz.
     */
    private static boolean random = true;

    /**
     * A tesztek kimenetet tarolja, annak erdekeben, hogy ki lehessen irni file-ba is, ne csak a standart outputra.
     */
    private String saveString;

    public static boolean isRandom() {
        return random;
    }

    public static void setRandom(boolean value) {
        random = value;
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

        String orangutanName = words[1];
        String targetTile = words[2].toLowerCase();
        String controlledBy = words[3].toLowerCase();
        int numberOfFollowingPandas = Integer.parseInt(words[4]);
        ArrayList<String> pandaNames = new ArrayList<>();


        for(int i = 5; i < 5 + numberOfFollowingPandas; i++){
            pandaNames.add(words[i]);
        }


        for (int i = 0; i < map.getGameLogic().getPandasOnTheMap().size(); ++i) {
            if (orangutanName.equals(map.getGameLogic().getPandasOnTheMap().get(i).getName())) {
                System.out.println("Error, ezzel a nevvel mar letezik allat.");
                return;
            }
        }

        boolean found = false;
        for(int j = 0; j < numberOfFollowingPandas; j++){
            for(int k = 0; k < map.getGameLogic().getPandasOnTheMap().size() && !found; k++){
                if(pandaNames.get(j).equals(map.getGameLogic().getPandasOnTheMap().get(k).getName())){
                    found = true;
                }
            }
            if(!found){
                System.out.println("Error, nincs a mapon " + pandaNames.get(j) + " nevu panda.");
                return;
            }
            found = false;
        }


        if (!map.checkTileName(targetTile)) {
            System.out.println("Error, nem letezik ilyen nevu csempe.");
            return;
        }
        if (map.getTile(targetTile).getAnimal() != null){
            System.out.println("Error, ez a csempe jelenleg foglalt.");
            return;
        }
        if(controlledBy.equals("player")){
            PlayerOrangutan playerOrangutan = new PlayerOrangutan();
            playerOrangutan.setName(orangutanName);
            playerOrangutan.setTile(map.getTile(targetTile));
            playerOrangutan.setGameLogic(map.getGameLogic());
            map.getTile(targetTile).setAnimal(playerOrangutan);

            ArrayList<Panda> pandas = new ArrayList<>();

            found = false;
            for(int j = 0; j < numberOfFollowingPandas; j++){
                for(int k = 0; k < map.getGameLogic().getPandasOnTheMap().size() && !found; k++){
                    if(pandaNames.get(j).equals(map.getGameLogic().getPandasOnTheMap().get(k).getName())){
                        found = true;
                        map.getGameLogic().getPandasOnTheMap().get(k).setCaught(true);
                        map.getGameLogic().getPandasOnTheMap().get(k).setOrangutan(playerOrangutan);
                        pandas.add(map.getGameLogic().getPandasOnTheMap().get(k));
                    }
                }
                found = false;
            }
            playerOrangutan.setCaughtPandas(pandas);
            map.getGameLogic().setPlayerOrangutan(playerOrangutan);
        }
        else if(controlledBy.equals("ai")){
            Orangutan orangutan = new Orangutan();
            orangutan.setName(orangutanName);
            orangutan.setTile(map.getTile(targetTile));
            orangutan.setGameLogic(map.getGameLogic());
            map.getTile(targetTile).setAnimal(orangutan);

            ArrayList<Panda> pandas = new ArrayList<>();

            found = false;
            for(int j = 0; j < numberOfFollowingPandas; j++){
                for(int k = 0; k < map.getGameLogic().getPandasOnTheMap().size() && !found; k++){
                    if(pandaNames.get(j).equals(map.getGameLogic().getPandasOnTheMap().get(k).getName())){
                        found = true;
                        map.getGameLogic().getPandasOnTheMap().get(k).setCaught(true);
                        map.getGameLogic().getPandasOnTheMap().get(k).setOrangutan(orangutan);
                        pandas.add(map.getGameLogic().getPandasOnTheMap().get(k));
                    }
                }
                found = false;
            }
            orangutan.setCaughtPandas(pandas);
            map.getGameLogic().setSecondOrangutan(orangutan);
        }
        else{
            System.out.println("Error, az orangutant csak player vagy ai iranyithatja.");
        }
    }

    /**
     * A panda parancsot szimulalo fuggveny.
     */
    private void panda() {
        if (words.length != 4) {
            System.out.println("Error: tul" + (words.length < 4 ? "keves" : "sok")  + "parametert adtal meg.");
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

        for (int i = 0; i < map.getGameLogic().getPandasOnTheMap().size(); ++i) {
            if (pandaName.equals(map.getGameLogic().getPandasOnTheMap().get(i).getName())) {
                System.out.println("Error, ezzel a nevvel mar letezik panda.");
                return;
            }
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
                System.out.println("Error, ilyen tipusu panda nem letezik.");
                return;
        }
        if (map.getTile(targetTile) == null){
            System.out.println("Error, ilyen nevu csempe nem letezik.");
            return;
        }
        if (map.getTile(targetTile).getAnimal() != null){
            System.out.println("Error, ez a csempe jelenleg foglalt.");
            return;
        }
        myPanda.setCaught(false);
        myPanda.setOrangutan(null);
        myPanda.setName(pandaName);
        myPanda.setTile(map.getTile(targetTile));
        myPanda.setGameLogic(map.getGameLogic());
        map.getGameLogic().addPanda(myPanda);
        map.getTile(targetTile).setAnimal(myPanda);
        return;
    }

    /**
     * Az action parancsot szimulalo fuggveny.
     */
    private void action() {
        if (words.length != 2) {
            System.out.println("Error, nincs eleg parameter.");
            return;
        }
        /*
         * words[0] erdektelen
         * words[1] csempe neve, pl s1
         */

        String tileName = words[1].toLowerCase();

        if (!map.checkTileName(tileName)) {
            System.out.println("Error, nem letezik ilyen nevu csempe.");
            return;
        }

        Item i = map.getTile(tileName).getItem();
        if (i == null) {
            System.out.println("Error, ezen a csempen nincsen item.");
            return;
        }

        i.doAction();
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
         */
        String type = words[1].toLowerCase();
        String name = words[2].toLowerCase();
        String attribute = words[3].toLowerCase();
        String newValue = words[4].toLowerCase();

        if (type.compareTo("tile") != 0 && type.compareTo("wardrobe") != 0) {
            System.out.println("Error, nincs ilyen tipus.");
            return;
        }

        if (!map.checkTileName(name)) {
            System.out.println("Error, nincs ilyen nevu csempe.");
            return;
        }

        if (type.compareTo("tile") == 0) {
            BreakableTile t = null;

            if (map.getTile(name) instanceof BreakableTile) {
                t = (BreakableTile) map.getTile(name);
            } else {
                System.out.println("Error, a megadott csempe nem torekeny.");
                return;
            }

            switch (attribute) {
                case "health":
                    t.setHealth(Integer.parseInt(newValue));
                    break;
                case "isbroken":
                    t.setBroken(newValue.compareTo("true") == 0);
                    break;
                default:
                    System.out.println("Error, ennek a tipusnak nincs ilyen tulajdonsaga.");
                    return;
            }
        } else if (type.compareTo("wardrobe") == 0) {
            EntryWardrobe w = null;

            if (map.getTile(name) instanceof EntryWardrobe) {
                w = (EntryWardrobe) map.getTile(name);
            } else {
                System.out.println("Error, a megadott csempe nem szekreny.");
                return;
            }

            if (attribute.compareTo("destinationtile") != 0) {
                System.out.println("Error, ennek a tipusnak nincs ilyen tulajdonsaga.");
                return;
            }

            w.setDestination(map.getTile(newValue));
        }
    }

    /**
     * A step parancsot szimulalo fuggveny.
     */
    private void step() {
        if (words.length != 3) {
            System.out.println("Error: tul" + (words.length < 3 ? "keves" : "sok")  + "parametert adtal meg.");
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
        for (i = 0; i < map.getGameLogic().getPandasOnTheMap().size() && !found; ++i) {
            if (animalName.equals(map.getGameLogic().getPandasOnTheMap().get(i).getName())) {
                found = true;
            }
        }
        --i;
        if (map.getTile(targetTile) == null){
            System.out.println("Error, ilyen nevu csempe nem letezik.");
            return;
        }
        Animal myAnimal = null;
        if (!found) {
            if (map.getGameLogic().getPlayerOrangutan() != null && map.getGameLogic().getPlayerOrangutan().getName() != null){
                if (map.getGameLogic().getPlayerOrangutan().getName().equals(animalName)){
                    myAnimal = map.getGameLogic().getPlayerOrangutan();
                }
            }
            else if (map.getGameLogic().getSecondOrangutan() != null && map.getGameLogic().getSecondOrangutan().getName() != null) {
                if (map.getGameLogic().getSecondOrangutan().getName().equals(animalName)){
                    myAnimal = map.getGameLogic().getSecondOrangutan();
                }
            }
            else {
                System.out.println("Error, ilyen nevu allat nem letezik.");
                return;
            }
        }
        else {
            myAnimal = map.getGameLogic().getPandasOnTheMap().get(i);
        }
        boolean isNeighbour = false;
        for (int j = 0; j < map.getTile(targetTile).getNeighbours().size() && !isNeighbour; j++){
            if (map.getTile(targetTile).getNeighbours().get(j).getName().equals(myAnimal.getTile().getName())){
                isNeighbour = true;
            }
        }
        if (!isNeighbour) {
            System.out.println("Error, az allat jelenlegi csempeje es celcsempeje nem szomszedos.");
            return;
        }
        map.getTile(targetTile).receive(myAnimal);
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
         */

        String newValue = words[1].toLowerCase();

        if (newValue.compareTo("on") == 0) {
            random = true;
        } else if (newValue.compareTo("off") == 0) {
            random = false;
        } else {
            System.out.println("Error, nem ertelmezheto ertek.");
        }
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

        String animalName = words[1];

        if(map.getGameLogic().getPlayerOrangutan().getName().equals(animalName)){
            map.getGameLogic().getPlayerOrangutan().release(map.getGameLogic().getPlayerOrangutan().getCaughtPandas().get(0));
        }
        else if(map.getGameLogic().getSecondOrangutan().getName().equals(animalName)){
            map.getGameLogic().getSecondOrangutan().release(map.getGameLogic().getPlayerOrangutan().getCaughtPandas().get(0));
        }
        else{
            System.out.println("Error, no orangutan with the given name exists.");
        }
    }

    /**
     * A script parancsot szimulalo fuggveny.
     */
    private void script() {
        if (words.length != 2) {
            System.out.println("Error" + (words.length > 2 ? ", túl sok paraméter!" : ", túl kevés paraméter!"));
            return;
        }
        else{
            try {
                BufferedReader br = new BufferedReader(new FileReader("../Tests/" + words[1] + ".txt"));
                while((words = br.readLine().split(" ")).length != 0){
                    switch(words[0].toLowerCase()){
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
                            System.out.println("Hibás script!");
                            break;
                    }
                }
            }
            catch(FileNotFoundException e){
                System.out.println("Hibás file név.");
                return;
            }
            catch(IOException e){
                System.out.println("Script hiba");
                return;
            }
            catch(NullPointerException e){
                return;
            }
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
            System.out.println("Error: tul" + (words.length < 4 ? "keves" : "sok")  + "parametert adtal meg.");
            saveString += "Error: tul" + (words.length < 4 ? "keves" : "sok")  + "parametert adtal meg. \n";
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
                if (myTile == null){
                    System.out.println("Error, ilyen nevu csempe nem letezik.");
                    saveString += "Error, ilyen nevu csempe nem letezik. \n";
                    return;
                }
                switch (attribute) {
                    case "neighbours":
                        for (BaseTile bt : myTile.getNeighbours()) {
                            System.out.println(bt.getName());
                            saveString += bt.getName() +"\n";
                        }
                        break;
                    case "hasitem":
                        System.out.println(myTile.getItem() == null ? "false" : "true");
                        saveString += myTile.getItem() == null ? "false" : "true" + "\n";
                        break;
                    case "haswardrobe":
                        System.out.println(myTile.isWardrobe() ? "true" : "false");
                        saveString += myTile.isWardrobe() ? "true" : "false" + "\n";
                        break;
                    case "currentanimal":
                        if (myTile.getAnimal() == null){
                            System.out.println("null");
                            saveString += "null\n";
                            return;
                        }
                        System.out.println(myTile.getAnimal().getName());
                        saveString += myTile.getAnimal().getName() + "\n";
                        break;
                    default:
                        System.out.println("Error, ilyen tulajdonsaga nincsen az entitasnak.");
                        saveString += "Error, ilyen tulajdonsaga nincsen az entitasnak. \n";
                        return;
                }
                break;
            case "breakabletile":
                BreakableTile myTile2 = (BreakableTile) map.getTile(name);
                if (myTile2 == null){
                    System.out.println("Error, ilyen nevu csempe nem letezik.");
                    saveString += "Error, ilyen nevu csempe nem letezik. \n";
                    return;
                }
                switch (attribute) {
                    case "neighbours":
                        for (BaseTile bt : myTile2.getNeighbours()) {
                            System.out.println(bt.getName());
                            saveString += bt.getName() + "\n";
                        }
                        break;
                    case "isbroken":
                        System.out.println(myTile2.isBroken());
                        saveString += myTile2.isBroken() + "\n";
                        break;
                    case "currentanimal":
                        if (myTile2.getAnimal() == null){
                            System.out.println("null");
                            saveString += "null\n";
                            return;
                        }
                        System.out.println(myTile2.getAnimal().getName());
                        saveString += myTile2.getAnimal().getName() + "\n";
                        break;
                    case "currenthealth":
                        System.out.println(myTile2.getHealth());
                        saveString += myTile2.getHealth() + "\n";
                        break;
                    default:
                        System.out.println("Error, ilyen tulajdonsaga nincsen az entitasnak.");
                        saveString += "Error, ilyen tulajdonsaga nincsen az entitasnak. \n";
                        return;
                }
                break;
            case "orangutan":
                Orangutan o;
                boolean controlledbyAI;
                if (map.getGameLogic().getSecondOrangutan() != null && map.getGameLogic().getSecondOrangutan().getName() != null && map.getGameLogic().getSecondOrangutan().getName().equals(name)) {
                     o = map.getGameLogic().getSecondOrangutan();
                     controlledbyAI = true;
                }
                else if (map.getGameLogic().getPlayerOrangutan() != null && map.getGameLogic().getPlayerOrangutan().getName() != null && map.getGameLogic().getPlayerOrangutan().getName().equals(name)) {
                    o = map.getGameLogic().getPlayerOrangutan();
                    controlledbyAI = false;
                }
                else {
                    System.out.println("Error: ilyen nevu orangutan nem letezik.");
                    saveString += "Error: ilyen nevu orangutan nem letezik. \n";
                    return;
                }

                switch (attribute) {
                    case "ontile":
                        if (o.getTile() == null) {
                            System.out.println("null");
                            saveString += "null\n";
                            return;
                        }
                        System.out.println(o.getTile().getName());
                        saveString += o.getTile().getName() + "\n";
                        break;
                    case "followingpandas":
                        if (o.getCaughtPandas().size() <= 0){
                            System.out.println("null");
                            saveString += "null\n";
                        }
                        else {
                            for (Panda p : o.getCaughtPandas()) {
                                System.out.println(p.getName());
                                saveString += p.getName() + "\n";
                            }
                        }
                        break;
                    case "controlledby":
                        System.out.println(controlledbyAI ? "ai" : "player");
                        saveString += controlledbyAI ? "ai" : "player" + "\n";
                        break;
                    case "points":
                        System.out.println(map.getGameLogic().getPoints());
                        saveString += map.getGameLogic().getPoints() + "\n";
                        break;
                    default:
                        System.out.println("Error, ilyen tulajdonsaga nincsen az entitasnak.");
                        saveString += "Error, ilyen tulajdonsaga nincsen az entitasnak. \n";
                        return;
                }
                break;
            case "panda":
                boolean found = false;
                int i;
                for (i = 0; i < map.getGameLogic().getPandasOnTheMap().size() && !found; ++i) {
                    if (name.equals(map.getGameLogic().getPandasOnTheMap().get(i).getName())) {
                        found = true;
                    }
                }
                --i;
                if (!found) {
                    System.out.println("null");
                    saveString += "null\n";
                    return;
                }
                Panda myPanda = (Panda) map.getGameLogic().getPandasOnTheMap().get(i);
                switch (attribute) {
                    case "ontile":
                        System.out.println(myPanda.getTile().getName());
                        saveString += myPanda.getTile().getName() + "\n";
                        break;
                    case "iscaught":
                        System.out.println(myPanda.caught);
                        saveString += myPanda.caught + "\n";
                        break;
                    case "attribute":
                        System.out.println(myPanda.getType());
                        saveString += myPanda.getType() + "\n";
                        break;
                    default:
                        System.out.println("Error, ilyen tulajdonsaga nincsen az entitasnak.");
                        saveString += "Error, ilyen tulajdonsaga nincsen az entitasnak. \n";
                        return;
                }
                break;
            case "item":
                BaseTile myTile3 = map.getTile(name);
                if (myTile3 == null){
                    System.out.println("Error, ilyen nevu csempe nem letezik.");
                    saveString += "Error, ilyen nevu csempe nem letezik. \n";
                    return;
                }
                Item myItem = myTile3.getItem();
                if (myItem == null) {
                    System.out.println("Error, ezen a csempen nincsen semmilyen targy.");
                    saveString += "Error, ezen a csempen nincsen semmilyen targy. \n";
                    return;
                }
                switch (attribute) {
                    case "ontile":
                        System.out.println(map.getTile(name).getName());
                        saveString += map.getTile(name).getName() + "\n";
                        break;
                    case "type":
                        System.out.println(myItem.getType());
                        saveString += myItem.getType() + "\n";
                        break;
                    case "istaken":
                        if (myItem.getType().equals("couch")) {
                            Couch myCouch = (Couch) myItem;
                            if (myCouch.getActualAnimal() == null){
                                System.out.println("A csempen jelenleg nincsen semmilyen allat.");
                                saveString += "false \n";
                                return;
                            } else {
                                System.out.println(myCouch.getActualAnimal().getName());
                                saveString += myCouch.getActualAnimal().getName() + "\n";
                            }
                        }
                        else {
                            System.out.println("Error, ezen a csempen nem kanape van.");
                            saveString += "Error, ezen a csempen nem kanape van. \n";
                            return;
                        }
                        break;
                    case "valueofcountdown":
                        System.out.println(myItem.Counter);
                        saveString += myItem.Counter + "\n";
                        break;
                    default:
                        System.out.println("Error, ilyen tulajdonsaga nincsen az entitasnak.");
                        saveString += "Error, ilyen tulajdonsaga nincsen az entitasnak. \n";
                        return;
                }
                break;
            case "wardrobe":
                BaseTile myTile4 = map.getTile(name);
                if (myTile4 == null){
                    System.out.println("Error, ilyen nevu csempe nem letezik.");
                    saveString += "Error, ilyen nevu csempe nem letezik. \n";
                    return;
                }
                EntryWardrobe myEntryWardrobe = (EntryWardrobe) myTile4;
                if (myEntryWardrobe == null) {
                    System.out.println("Error, ezen a csempen nincsen semmilyen targy.");
                    saveString += "Error, ezen a csempen nincsen semmilyen targy. \n";
                    return;
                }
                switch (attribute) {
                    case "ontile":
                        System.out.println(map.getTile(name).getName());
                        saveString += map.getTile(name).getName() + "\n";
                        break;
                    case "destinationtile":
                        System.out.println(myEntryWardrobe.getDestination().getName());
                        saveString += myEntryWardrobe.getDestination().getName() + "\n";
                        break;
                    default:
                        System.out.println("Error, ilyen tulajdonsaga nincsen az entitasnak.");
                        saveString += "Error, ilyen tulajdonsaga nincsen az entitasnak. \n";
                        return;
                }
                break;
            default:
                System.out.println("Error, ilyen entitastipus nem letezik.");
                saveString += "Error, ilyen entitastipus nem letezik. \n";
                return;
        }
    }

    /**
     * A save parancsot szimulalo fuggveny.
     */
    private void save() {
        if (words.length != 2) {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
            String newWords[] = new String[2];
            newWords[0] = words[0];
            newWords[1] = sdf.format(cal.getTime()) + ".txt";
            words = newWords;
        }
        try {
            String out[] = saveString.split("\n");
            PrintWriter pw = new PrintWriter(new FileWriter("../Test results/" + words[1] + ".txt"));

            PrintWriter writer = new PrintWriter(new FileWriter("../Test results/" + words[1] + ".txt"));
            writer.print("");
            writer.close();

            for (int i = 0; i < out.length; ++i) {
                pw.println(out[i]);
            }
            pw.close();

            saveString = "";

            System.out.println("Sikeres mentés, a file neve: " + words[1] + ".txt");
        }
        catch (IOException e){
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

        for(String i : map.map.keySet()){
            System.out.println("Attributes of "+ i +":");
            saveString += "Attributes of "+ i +": \n";
            if(i.charAt(0) == 's' || i.charAt(0) == 't' || i.charAt(0) == 'c' || i.charAt(0) == 'a' || i.charAt(0) == 'e' || i.charAt(0) == 'w'){
                BaseTile baseTile = map.getTile(i);
                System.out.println("neighbours:");
                saveString += "neighbours: \n";
                for (BaseTile bt : baseTile.getNeighbours()) {
                    System.out.println(bt.getName());
                    saveString += bt.getName() + "\n";
                }
                System.out.println("hasitem:");
                saveString += "hasitem: \n";
                System.out.println(baseTile.getItem() == null ? "false" : "true");
                saveString += baseTile.getItem() == null ? "false" : "true" + "\n";
                System.out.println("haswardrobe:");
                saveString += "haswardrobe: \n";
                System.out.println(baseTile.isWardrobe() ? "true" : "false");
                saveString += baseTile.isWardrobe() ? "true" : "false" + "\n";
                System.out.println("currentanimal:");
                if(baseTile.getAnimal() == null){
                    System.out.println("No animal on this tile.");
                    saveString += "No animal on this tile. \n";
                }
                else {
                    System.out.println(baseTile.getAnimal().getName());
                    saveString += baseTile.getAnimal().getName() + "\n";
                }

            }
            else if(i.charAt(0) == 'b'){
                BreakableTile breakableTile = (BreakableTile) map.getTile(i);
                System.out.println("neighbours:");
                saveString += "neighbours: \n";
                for (BaseTile bt : breakableTile.getNeighbours()) {
                    System.out.println(bt.getName());
                    saveString += bt.getName() + "\n";
                }
                System.out.println("isbroken:");
                saveString += "isbroken: \n";
                System.out.println(breakableTile.isBroken());
                saveString += breakableTile.isBroken() + "\n";
                System.out.println("currentanimal:");
                saveString += "currentanimal: \n";
                if(breakableTile.getAnimal() == null){
                    System.out.println("No animal on this tile.");
                    saveString += "No animal on this tile. \n";
                }
                else {
                    System.out.println(breakableTile.getAnimal().getName());
                    saveString += breakableTile.getAnimal().getName() + "\n";
                }
                System.out.println("currenthealth:");
                saveString += "currenthealth: \n";
                System.out.println(breakableTile.getHealth());
                saveString += breakableTile.getHealth() + "\n";
            }

            else{
                System.out.println("Unknown type of tile");
                saveString += "Unknown type of tile \n";
            }
        }
    }

    /**
     * Az endtest parancsot szimulalo fuggveny.
     */
    private void endtest() {
        /*
         * words[0] erdektelen
         *
         * */
        clearMap = true;
        System.out.println("A teszt véget ért.");
        saveString = "";
    }

    /**
     * A prototipus felhasznaloi menujet inicializalo fuggveny.
     */
    public void menuInit() {
        System.out.println("Add meg a parancsot:");
        //map.setGameLogic(new GameLogic());
        //map.setGamelogicForExitPoint(new GameLogic());
        boolean run = true;
        saveString = "";

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
                        System.out.println("Error, ilyen parancs nem letezik.");
                        break;
                }
            } catch (IOException e) {

            }
            if (clearMap) {
                map = new Map(new GameLogic(), true);
                //map.setGameLogic(new GameLogic());

                //map.setGamelogicForExitPoint(new GameLogic());
                clearMap = false;
            }
        }
        return;
    }
}