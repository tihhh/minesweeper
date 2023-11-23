import java.util.ArrayList;

public class Minefield {
    int width;
    int height;
    private ArrayList<Location> mines = new ArrayList<>();


    public Minefield(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isInBounds(Location location) {
        Location l = location;

            if (!(l == null)) {
                if (l.getCol() > -1) {
                    if (l.getRow() > -1) {
                        if (l.getRow() < height) {
                            if (l.getCol() < width) {
                                return true;
                            }
                                  
                        }
                    }
                }
            }
        return false;
    }
    public void placeMine(Location location) {
        if (isInBounds(location) && !(hasMine(location))) {
            mines.add(location);
        }
    }
    public boolean hasMine(Location location) {
        for (int i=0; i < mines.size(); i++) {
            if (mines.get(i).getRow() == location.getRow() && mines.get(i).getCol() == location.getCol()) {
                return true;
            }
        }
        return false;
    }

    public int getTotalMines() {
        return mines.size();
    }
    public int getAdjacentMines(Location location) {
        int row = location.getRow();
        int col = location.getCol();
        int count = 0;
        
        //Top one
        Location top = new Location(row, col-1);
        if (isInBounds(top)) {
            if (hasMine(top)) {
                count++;
            }
        }

        Location bot = new Location(row, col+1);
        if (isInBounds(bot)) {
            if (hasMine(bot)) {
                count++;
            }
        }
        Location left = new Location(row-1, col);
        if (isInBounds(left)) {
            if (hasMine(left)) {
                count++;
            }
        }

        Location right = new Location(row+1,col);
        if (isInBounds(right)) {
            if (hasMine(right)) {
                count++;
            }
        }
        Location a = new Location(row+1,col+1);
        if (isInBounds(a)) {
            if (hasMine(a)) {
                count++;
            }
        }
        Location b = new Location(row+1,col-1);
        if (isInBounds(b)) {
            if (hasMine(b)) {
                count++;
            }
        }
        Location c = new Location(row-1,col+1);
        if (isInBounds(c)) {
            if (hasMine(c)) {
                count++;
            }
        }
        Location d = new Location(row-1,col-1);
        if (isInBounds(d)) {
            if (hasMine(d)) {
                count++;
            }
        }

        return count;






        /*
        if (col-1 >= 0) {
            
            if (hasMine(top)) {
                count++;
            }
        }
        if (col+1 >= 0) {
            Location top = new Location(row, col+1)
            if (hasMine(top)) {
                count++;
            }
        }
        */
    }
}

