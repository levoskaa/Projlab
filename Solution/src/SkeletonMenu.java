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
    public void pandaStepsOnEmptyTile(){}
    public void orangutanStepsOnEntryWardrobe(){}
    public void orangutanStepsOnEmptyTile(){}
    public void orangutanCatchesPanda(){}
    public void orangutanGuidesPanda(){}
    public void orangutanStepsOnBrokenTile(){}
    public void pandaStepsOnBrokenTile(){}
    public void pandaFallsOff(){}
    public void jumpingPandaJumps(){}
    public void pandaGetsScared(){}
    public void pandaStepsOnEntryWardrobe(){}
    public void orangutanStepsOnExitPoint(){}
    public void tiredPandaTakesRest(){}
    public void exit(){}

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