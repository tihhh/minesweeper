import java.util.Random;
import java.util.Scanner;

public class GenerateMinefield {
    public static Random rand = new Random();

    public GenerateMinefield() {

    }

    public static Location randomLocation(int width, int height) {
        int row = rand.nextInt(height);
        int column = rand.nextInt(width);
        return new Location(row, column);
    }

    public static Minefield generateMines(Scanner sc) {
        System.out.println("Width: ");
        int width = sc.nextInt();
        sc.nextLine();
        System.out.println("Height: ");
        int height = sc.nextInt();
        sc.nextLine();
        System.out.println("Amount of Mines: ");
        int mines = sc.nextInt();
        sc.nextLine();

        Minefield field = new Minefield(width, height);
        
        while(field.getTotalMines() < mines) {
            Location randomloc = randomLocation(width, height);
            field.placeMine(randomloc);
         }

         return field;
    }
}
