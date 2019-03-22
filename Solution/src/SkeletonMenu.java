import javax.imageio.plugins.tiff.TIFFDirectory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Az osztaly a szkeleton menujeert felelos,
 * ezen keresztul tudja a felhasznalo kivalasztani
 * a kivant parancsot. A parancs a kivalasztas utan lefutasra kerul.
 * @author Schutz
 */

public class SkeletonMenu{
    public void pandaStepsOnEmptyTile(){
        Orangutan orangutan = new Orangutan();
        ScarablePanda panda = new ScarablePanda(orangutan);
        Tile tile = new Tile();
        tile.receive(panda);
    }
    public void orangutanStepsOnEntryWardrobe(){
        Orangutan orangutan = new Orangutan();
        EntryWardrobe entryWardrobe = new EntryWardrobe();
        entryWardrobe.receive(orangutan);
    }
    public void orangutanStepsOnEmptyTile(){
        Orangutan orangutan = new Orangutan();
        Tile tile = new Tile();
        tile.receive(orangutan);
    }
    public void orangutanCatchesPanda(){
        Orangutan orangutan = new Orangutan();
        ScarablePanda panda = new ScarablePanda(orangutan);
        Tile tileOfPanda = new Tile();
        Tile tileOfOrangutan = new Tile();
        tileOfOrangutan.Neighbours.add(tileOfPanda);
        tileOfPanda.Neighbours.add(tileOfOrangutan);
        tileOfPanda.receive(panda);
        tileOfOrangutan.receive(orangutan);

    }
    public void orangutanGuidesPanda(){}
    public void orangutanStepsOnBrokenTile(){
        Orangutan orangutan = new Orangutan();
        BreakableTile breakableTile = new BreakableTile();
        breakableTile.broken = true;
        breakableTile.receive(orangutan);       //a BreakableTile receive-je felul lesz irva,
                                                // ugy hogy megoli a rajtalevo allatot ha broken == true?
                                                // ha igen akkor itt ennyi eleg

    }
    public void pandaStepsOnBrokenTile(){}
    public void pandaFallsOff(){}
    public void jumpingPandaJumps(){
        Orangutan orangutan = new Orangutan();
        JumpingPanda jumpingPanda = new JumpingPanda(orangutan);
        Tile tileOfPanda = new Tile();
        Tile tileOfSlotMachine = new Tile();
        SlotMachine slotMachine = new SlotMachine(tileOfSlotMachine);
        tileOfPanda.receive(jumpingPanda);
        tileOfSlotMachine.setItem(slotMachine);
        tileOfPanda.Neighbours.add(tileOfSlotMachine);
        tileOfSlotMachine.Neighbours.add(tileOfPanda);
        slotMachine.doYourThing();                  //a doYourThing csinalja az adott Item-re jellemzo esemenyt? ha igen akkor igy jo
    }
    public void pandaGetsScared(){
        Orangutan orangutan = new Orangutan();
        ScarablePanda scarablePanda = new ScarablePanda(orangutan);
        Tile tileOfChocoAutomat = new Tile();
        Tile tileOfPanda = new Tile();
        ChocoAutomat chocoAutomat = new ChocoAutomat(tileOfChocoAutomat);
        tileOfPanda.receive(scarablePanda);
        tileOfChocoAutomat.Neighbours.add(tileOfPanda);
        tileOfPanda.Neighbours.add(tileOfChocoAutomat);
        tileOfChocoAutomat.setItem(chocoAutomat);
        chocoAutomat.doYourThing();
    }
    public void pandaStepsOnEntryWardrobe(){
        Orangutan orangutan = new Orangutan();
        ScarablePanda scarablePanda = new ScarablePanda(orangutan);
        EntryWardrobe entryWardrobe = new EntryWardrobe();
        entryWardrobe.receive(scarablePanda);       //az EntryWardrobe receive-je felul lesz irva, ugy hogy atteleportalja az allatot
                                                    //a destination tile-ra?
                                                    // ha igen akkor itt ennyi eleg
    }
    public void orangutanStepsOnExitPoint(){
        Orangutan orangutan = new Orangutan();
        ExitPoint exitPoint = new ExitPoint();
        exitPoint.receive(orangutan);
    }
    public void tiredPandaTakesRest(){}
    public void exit(){
        GameLogic gameLogic = new GameLogic();
        gameLogic.endGame();
    }

    public void menuInit(){
        System.out.println("Valasszon a kovetkezo lehetosegek kozul:");
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String code = reader.readLine();
            switch (code){
                case "1": pandaStepsOnEmptyTile();
                    break;
                case "2": orangutanStepsOnEntryWardrobe();
                    break;
                case "3": orangutanStepsOnEmptyTile();
                    break;
                case "4": orangutanCatchesPanda();
                    break;
                case "5": orangutanGuidesPanda();
                    break;
                case "6": orangutanStepsOnBrokenTile();
                    break;
                case "7": pandaStepsOnBrokenTile();
                    break;
                case "8": pandaFallsOff();
                    break;
                case "9": jumpingPandaJumps();
                    break;
                case "10": pandaGetsScared();
                    break;
                case "11": pandaStepsOnEntryWardrobe();
                    break;
                case "12": orangutanStepsOnExitPoint();
                    break;
                case "13": tiredPandaTakesRest();
                    break;
                case "14": exit();
                    break;
            }
        }
        catch(IOException e){
            
        }

    }
}