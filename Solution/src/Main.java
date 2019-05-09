import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Valassz az alabbi lehetosegek kozul:");
        System.out.println("skeleton: Skeleton tesztelese");
        System.out.println("proto: Prototipus tesztelese");
        System.out.println("game: Jatek");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String code = reader.readLine();
            switch (code) {
                case "skeleton":
                    SkeletonMenu menu1 = new SkeletonMenu();
                    menu1.menuInit();
                    break;
                case "proto":
                    ProtoMenu menu2 = new ProtoMenu();
                    menu2.menuInit();
                    break;
                case "game":
                    View view = new View();
                    view.init();
                    break;
                default:
                    break;
            }
        } catch (IOException e) {

        }
    }
}
