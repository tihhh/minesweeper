public class Location {

    public static char[] ROW_CHARS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
    public static char[] COL_CHARS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    
    int row;
    int column;


    public Location(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }
    public int getCol() {
        return column;
    }

    public String toString() {
        if (row > ROW_CHARS.length || column > COL_CHARS.length || column < 0 || row < 0) {
            return "INVALID";
        }
        else {
            String turnchartostringpls = String.valueOf(ROW_CHARS[row]);
            String turninttostringpls = String.valueOf(COL_CHARS[column]);
            return turnchartostringpls + turninttostringpls;
        }
    }

    public static Location fromString(String position) {
        if (position.length() != 2) {
            return null;
        }
        position = position.toUpperCase();
        char stringRow = position.charAt(0);
        char stringColumn = position.charAt(1);

        boolean isRowValid = false;
        boolean isColValid = false;

        for (char validRow : ROW_CHARS) {
            if (stringRow == validRow) {
                isRowValid = true;
                break;
            }
        }
        for (char validCol : COL_CHARS) {
            if (stringColumn == validCol) {
                isColValid = true;
                break;
            }
        }

        if (!isColValid || !isRowValid) {
            return null;
        }
    

        int first = 0;
        for (int i=0; i<ROW_CHARS.length; i++) {
            if (stringRow == ROW_CHARS[i]) {
                first = i;
                break;
            }
        }
        int second=Integer.parseInt(String.valueOf(stringColumn));  

        if(second <= 0) {
            return null;
        }

        Location l = new Location(first, second-1);
        return l;


    }
}