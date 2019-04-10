import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Az osztaly a szkeleton menujeert felelos,
 * ezen keresztul tudja a felhasznalo kivalasztani
 * a kivant parancsot. A parancs a kivalasztas utan lefutasra kerul.
 *
 * @author Schutz
 */

public class SkeletonMenu {
    /**
     * A Panda steps on empty tile esemenyt szimulalo fuggveny.
     */
    public void pandaStepsOnEmptyTile() {
        Orangutan orangutan = new Orangutan();
        ScarablePanda panda = new ScarablePanda();
        panda.setTile(new Tile());
        panda.setOrangutan(orangutan);
        Tile tile = new Tile();
        tile.receive(panda);
    }

    /**
     * Az Orangutan steps on EntryWardrobe esemenyt szimulalo fuggveny.
     */
    public void orangutanStepsOnEntryWardrobe() {
        Orangutan orangutan = new Orangutan();
        orangutan.setTile(new Tile());
        EntryWardrobe entryWardrobe = new EntryWardrobe();
        entryWardrobe.setDestination(new Tile());
        entryWardrobe.receive(orangutan);
    }

    /**
     * Az Orangutan steps on empty tile esemenyt szimulalo fuggveny.
     */
    public void orangutanStepsOnEmptyTile() {
        Orangutan orangutan = new Orangutan();
        orangutan.setTile(new Tile());
        Tile tile = new Tile();
        tile.receive(orangutan);
    }

    /**
     * Az Orangutan catches panda esemenyt szimulalo fuggveny.
     */
    public void orangutanCatchesPanda() {
        //Valtozok inicializalasa
        Orangutan orangutan = new Orangutan();
        orangutan.setTile(new Tile());
        ScarablePanda panda = new ScarablePanda();
        panda.setTile(new Tile());
        panda.setOrangutan(orangutan);
        Tile tileOfPanda = new Tile();
        Tile tileOfOrangutan = new Tile();

        ArrayList<BaseTile> neighboursOfTileOfPanda = new ArrayList<>();
        neighboursOfTileOfPanda.add(tileOfOrangutan);

        ArrayList<BaseTile> neighboursOfTileOfOrangutan = new ArrayList<>();
        neighboursOfTileOfOrangutan.add(tileOfPanda);

        tileOfOrangutan.setNeighbours(neighboursOfTileOfOrangutan);
        tileOfPanda.setNeighbours(neighboursOfTileOfPanda);
        tileOfPanda.receive(panda);
        tileOfOrangutan.receive(orangutan);

        //Itt kapja el az orangutan a pandat.
        tileOfPanda.receive(orangutan);

    }

    /**
     * Az Orangutan guides panda esemenyt szimulalo fuggveny.
     */
    public void orangutanGuidesPanda() {
        Orangutan orangutan = new Orangutan();
        ScarablePanda panda = new ScarablePanda();
        orangutan.setTile(new Tile());
        panda.setTile(new Tile());
        panda.setOrangutan(orangutan);
        Tile tile1 = new Tile();
        Tile tile2 = new Tile();
        Tile tile3 = new Tile();

        ArrayList<BaseTile> neighboursOfTile1 = new ArrayList<>();
        ArrayList<BaseTile> neighboursOfTile2 = new ArrayList<>();
        ArrayList<BaseTile> neighboursOfTile3 = new ArrayList<>();

        neighboursOfTile1.add(tile2);
        neighboursOfTile2.add(tile1);
        neighboursOfTile2.add(tile3);
        neighboursOfTile3.add(tile2);

        tile1.receive(panda);
        tile2.receive(orangutan);

        ArrayList<Panda> newCaughtPandas = new ArrayList<>();
        newCaughtPandas.add(panda);
        orangutan.setCaughtPandas(newCaughtPandas);

        tile3.receive(orangutan);
    }

    /**
     * Az Orangutan steps on broken tile esemenyt szimulalo fuggveny.
     */
    public void orangutanStepsOnBrokenTile() {
        Orangutan orangutan = new Orangutan();
        GameLogic gl = new GameLogic();
        orangutan.setGameLogic(gl);
        orangutan.setTile(new Tile());
        gl.addAnimal(orangutan);
        BreakableTile breakableTile = new BreakableTile();

        breakableTile.setBroken(true);
        breakableTile.setHealth(0);

        breakableTile.receive(orangutan);
    }

    /**
     * A Panda steps on broken tile esemenyt szimulalo fuggveny.
     */
    public void pandaStepsOnBrokenTile() {
        Orangutan orangutan = new Orangutan();
        ScarablePanda panda = new ScarablePanda();
        panda.setOrangutan(orangutan);
        BreakableTile breakableTile = new BreakableTile();

        GameLogic gl = new GameLogic();
        panda.setGameLogic(gl);
        gl.addAnimal(panda);
        panda.setTile(breakableTile);

        breakableTile.setBroken(true);
        breakableTile.setHealth(0);

        breakableTile.receive(panda);

    }

    /**
     * A Panda falls off (in a queue) esemenyt szimulalo fuggveny.
     */
    public void pandaFallsOff() {
        Orangutan orangutan = new Orangutan();
        orangutan.setTile(new Tile());
        ScarablePanda panda = new ScarablePanda();
        panda.setTile(new Tile());
        panda.setOrangutan(orangutan);
        Tile tile1 = new Tile();
        BreakableTile tile2 = new BreakableTile();
        Tile tile3 = new Tile();

        tile2.setBroken(false);
        tile2.setHealth(2);

        ArrayList<BaseTile> neighboursOfTile1 = new ArrayList<>();
        ArrayList<BaseTile> neighboursOfTile2 = new ArrayList<>();
        ArrayList<BaseTile> neighboursOfTile3 = new ArrayList<>();

        neighboursOfTile1.add(tile2);
        neighboursOfTile2.add(tile1);
        neighboursOfTile2.add(tile3);
        neighboursOfTile3.add(tile2);

        tile1.receive(panda);
        tile2.receive(orangutan);

        ArrayList<Panda> newCaughtPandas = new ArrayList<>();
        newCaughtPandas.add(panda);
        orangutan.setCaughtPandas(newCaughtPandas);

        tile3.receive(orangutan);
    }

    /**
     * A Jumping panda jumps near a ChocoAutomat esemenyt szimulalo fuggveny.
     */
    public void jumpingPandaJumps() {
        GameLogic gl = new GameLogic();
        Orangutan orangutan = new Orangutan();
        JumpingPanda jumpingPanda = new JumpingPanda();
        jumpingPanda.setOrangutan(orangutan);
        BreakableTile breakableTile = new BreakableTile();
        Tile tileOfPanda = new Tile();
        breakableTile.setHealth(2);
        Tile tileOfChocoAutomat = new Tile();
        ChocoAutomat chocoAutomat = new ChocoAutomat(tileOfChocoAutomat);
        jumpingPanda.setGameLogic(gl);
        gl.addAnimal(jumpingPanda);

        ArrayList<BaseTile> neighboursOfTileOfPanda = new ArrayList<>();
        neighboursOfTileOfPanda.add(tileOfChocoAutomat);

        ArrayList<BaseTile> neighboursOfTileOfSlotMachine = new ArrayList<>();
        neighboursOfTileOfSlotMachine.add(breakableTile);

        jumpingPanda.setTile(tileOfPanda);
        tileOfPanda.setAnimal(jumpingPanda);
        breakableTile.receive(jumpingPanda);
        tileOfChocoAutomat.setItem(chocoAutomat);
        breakableTile.setNeighbours(neighboursOfTileOfPanda);
        tileOfChocoAutomat.setNeighbours(neighboursOfTileOfSlotMachine);
        // breakableTile.receive(jumpingPanda);


        for (int i = 0; i < 1; i++) {
            chocoAutomat.countDown();
        }
    }

    /**
     * A Panda gets scared esemenyt szimulalo fuggveny.
     */
    public void pandaGetsScared() {
        Orangutan orangutan = new Orangutan();
        ScarablePanda scarablePanda = new ScarablePanda();
        scarablePanda.setOrangutan(orangutan);
        scarablePanda.setTile(new Tile());
        Tile tileOfSlotMachine = new Tile();
        Tile tileOfPanda = new Tile();
        SlotMachine slotMachine = new SlotMachine(tileOfSlotMachine);

        ArrayList<BaseTile> neighboursOfTileOfPanda = new ArrayList<>();
        neighboursOfTileOfPanda.add(tileOfSlotMachine);

        ArrayList<BaseTile> neighboursOfTileOfChocoAutomat = new ArrayList<>();
        neighboursOfTileOfChocoAutomat.add(tileOfPanda);

        tileOfPanda.receive(scarablePanda);
        tileOfSlotMachine.setItem(slotMachine);
        tileOfSlotMachine.setNeighbours(neighboursOfTileOfChocoAutomat);
        tileOfPanda.setNeighbours(neighboursOfTileOfPanda);

        for (int i = 0; i < 1; i++) {
            slotMachine.countDown();
        }
    }

    /**
     * A Panda steps on EntryWardrobe esemenyt szimulalo fuggveny.
     */
    public void pandaStepsOnEntryWardrobe() {
        Orangutan orangutan = new Orangutan();
        ScarablePanda scarablePanda = new ScarablePanda();
        scarablePanda.setOrangutan(orangutan);
        scarablePanda.setTile(new Tile());
        EntryWardrobe entryWardrobe = new EntryWardrobe();
        entryWardrobe.setDestination(new Tile());
        entryWardrobe.receive(scarablePanda);
    }

    /**
     * Az Orangutan steps on ExitPoint esemenyt szimulalo fuggveny.
     */
    public void orangutanStepsOnExitPoint() {
        Orangutan orangutan = new Orangutan();
        orangutan.setTile(new Tile());
        ExitPoint exitPoint = new ExitPoint();
        exitPoint.setStartingTile(new Tile());
        exitPoint.setGameLogic(new GameLogic());
        exitPoint.receive(orangutan);
    }

    /**
     * A Tired panda takes a rest esemenyt szimulalo fuggveny.
     */
    public void tiredPandaTakesRest() {
        Orangutan orangutan = new Orangutan();
        TiredPanda tiredPanda = new TiredPanda();
        tiredPanda.setOrangutan(orangutan);
        tiredPanda.setTile(new Tile());
        Tile tileOfPanda = new Tile();
        Tile tileOfCouch = new Tile();
        Couch couch = new Couch(tileOfCouch);

        ArrayList<BaseTile> neighboursOfTileOfPanda = new ArrayList<>();
        neighboursOfTileOfPanda.add(tileOfCouch);

        ArrayList<BaseTile> neighboursOfTileOfCouch = new ArrayList<>();
        neighboursOfTileOfCouch.add(tileOfPanda);

        tileOfPanda.receive(tiredPanda);
        tileOfCouch.setItem(couch);
        tileOfPanda.setNeighbours(neighboursOfTileOfPanda);
        tileOfCouch.setNeighbours(neighboursOfTileOfCouch);

        for (BaseTile tile : tileOfCouch.getNeighbours()) {
            tile.tire(tileOfCouch);
        }

    }

    /**
     * Az exit esemenyt szimulalo fuggveny.
     */
    public void exit() {
        GameLogic gameLogic = new GameLogic();
        gameLogic.endGame();
    }

    /**
     * A szkeleton felhasznaloi menujet inicializalo fuggveny.
     */
    public void menuInit() {
        System.out.println("Valassz a kovetkezo lehetosegek kozul:");
        System.out.println("1: Panda steps on empty tile");
        System.out.println("2: Orangutan steps on entry wardrobe");
        System.out.println("3: Orangutan steps on empty tile");
        System.out.println("4: Orangutan catches panda");
        System.out.println("5: Orangutan guides panda");
        System.out.println("6: Orangutan steps on broken tile");
        System.out.println("7: Panda steps on broken tile");
        System.out.println("8: Panda falls off (in a queue)");
        System.out.println("9: Jumping panda jumps near a chocoautomat");
        System.out.println("10: Panda gets scared");
        System.out.println("11: Panda steps on entry wardrobe\t");
        System.out.println("12: Orangutan steps on exit point");
        System.out.println("13: Tired panda takes a rest");
        System.out.println("14: Exit");

        boolean run = true;
        while (run) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String code = reader.readLine();
                switch (code) {
                    case "1":
                        pandaStepsOnEmptyTile();
                        break;
                    case "2":
                        orangutanStepsOnEntryWardrobe();
                        break;
                    case "3":
                        orangutanStepsOnEmptyTile();
                        break;
                    case "4":
                        orangutanCatchesPanda();
                        break;
                    case "5":
                        orangutanGuidesPanda();
                        break;
                    case "6":
                        orangutanStepsOnBrokenTile();
                        break;
                    case "7":
                        pandaStepsOnBrokenTile();
                        break;
                    case "8":
                        pandaFallsOff();
                        break;
                    case "9":
                        jumpingPandaJumps();
                        break;
                    case "10":
                        pandaGetsScared();
                        break;
                    case "11":
                        pandaStepsOnEntryWardrobe();
                        break;
                    case "12":
                        orangutanStepsOnExitPoint();
                        break;
                    case "13":
                        tiredPandaTakesRest();
                        break;
                    case "14":
                        exit();
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