import java.util.ArrayList;

public class Guesses {
    

    int width;
    int height;
    private ArrayList<Location> guessArray = new ArrayList<>();

    public Guesses(int width, int height) {
        this.width = width;
        this.height = height;
        
    }

    public void addGuess(Location location) {
        Location l = location;
        if (!isGuessed(l)) {
            if (!(l == null)) {
                if (l.getCol() > -1) {
                    if (l.getRow() > -1) {
                        if (l.getRow() < height) {
                            if (l.getCol() < width) {
                                guessArray.add(location); 
                            }
                                  
                        }
                    }
                }
            }
        }

    }
    public boolean isGuessed(Location location) {
        Location l = location;
        if (!(l == null)) {
                if (l.getCol() > -1) {
                    if (l.getRow() > -1) {
                        if (l.getRow() < height) {
                            if (l.getCol() < width) {
                                for (int i=0;i < guessArray.size();i++) {
                                    if (guessArray.get(i).getRow() == location.getRow() && guessArray.get(i).getCol() == location.getCol()) {
                                        return true;
                                    }
                                }
                            }
                                  
                        }
                    }
                }
            }
            /*
        for (int i=0;i < guessArray.size();i++) {
            if (guessArray.get(i).getRow() == location.getRow() && guessArray.get(i).getCol() == location.getCol()) {
                return true;
            }
        }
        */
        return false;


        /*
        Location l = location;
        if (location != null && l.getRow() >= 0 && l.getCol() >= 0 && l.getRow() < width && l.getCol() < height) {
            for (Location x : guessArray) {
            if (x.getRow() == l.getRow() && x.getCol() == l.getCol()) {
                return true;
                }
            }
        }
        return false;
        */
    }

    public int getTotalGuesses() {
        return guessArray.size();
    }
}