import java.util.Scanner ;

public class Minesweeper {

    
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Minefield field = GenerateMinefield.generateMines(input);
        Guesses guess = new Guesses(field.getWidth(), field.getHeight());

        while (true) {
            Renderer.display(Renderer.render(field, guess));
            System.out.println("Guess a location: ");

            Location l = Location.fromString(input.nextLine());

            while (l==null) {
                System.out.println("Invalid location, please try again.");
                System.out.println("Guess a location: ");
                l = Location.fromString(input.nextLine());
            }
            guess.addGuess(l);

            if (field.hasMine(l)) {
                Renderer.display(Renderer.render(field));
                System.out.println("BOOM! Game over.");
                break;
            }
           
           if (field.getWidth()*field.getHeight() - field.getTotalMines() == guess.getTotalGuesses()) {
                Renderer.display(Renderer.render(field));
                System.out.println("Minefield cleared. Well done!");
                break;
           }
        }
    }

}


