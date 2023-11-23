
public class Renderer {

    public static final char DEFAULT = '·' ;
    public static final char MINE = 'X' ;
    public static final char[] DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private static final char[] ALPHABET = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};

    private static int cellCol2GridCol(int cellCol) {
        return 2 + (2*cellCol);
    }

    private static int cellRow2GridRow(int cellRow) {
        return 1 + cellRow ;
    }

    //Implement the rest of the Renderer class here

    public static char[][] render(int width, int height) {
        char[][] board = new char[height+1][2*width+2];

        for (int row = 0; row <= height; row++) {
            for (int col = 0; col < 2 * width + 2; col++) {
                board[row][col] = ' ';
            }
        }
        for (int col = 0; col < 2 * width+2; col++) {
            if (col%2==0 && col != 0) {
                board[0][col] = DIGITS[col/2];
                }
            }
        for (int row = 0; row <= height; row++) {
            board[row][0] = ALPHABET[row];
            }
        
        for (int row = 0; row <= height; row++) {
            for (int col = 0; col < 2 * width + 2; col++) {
                if (row != 0 && col !=0 && col%2==0) {
                    board[row][col] = '·';
                }
            }
        }

        return board;
    }

        
    
    public static char[][] render(Minefield minefield, Guesses guess) {
        char[][] board = render(minefield.getWidth(), minefield.getHeight());

        for (int row = 0; row < minefield.getHeight(); row++) {
            for (int col = 0; col < minefield.getWidth(); col++) {
                Location l = new Location(row, col);
                if (guess.isGuessed(l)) {
                    if (minefield.hasMine(l)) {
                        board[cellRow2GridRow(row)][cellCol2GridCol(col)] = MINE; // Guessed and a mine is present
                    } else {
                        int adjacentMines = minefield.getAdjacentMines(l);
                        board[cellRow2GridRow(row)][cellCol2GridCol(col)] = DIGITS[adjacentMines]; // Guessed, show adjacency count
                    }
                }
            }
    }

        return board;

    }
    public static char[][] render(Minefield minefield) {
        char[][] board = render(minefield.getWidth(), minefield.getHeight());
            

        for (int row = 0; row < minefield.getHeight(); row++) {
            for (int col = 0; col < minefield.getWidth(); col++) {
                Location l = new Location(row, col);
                if (minefield.hasMine(l)) {
                        board[cellRow2GridRow(row)][cellCol2GridCol(col)] = MINE; // Guessed and a mine is present
                    } else {
                        int adjacentMines = minefield.getAdjacentMines(l);
                        board[cellRow2GridRow(row)][cellCol2GridCol(col)] = DIGITS[adjacentMines]; // Guessed, show adjacency count
                    }
            }
        }
        return board;

    }

    public static void display(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

}