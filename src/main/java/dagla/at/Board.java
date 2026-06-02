package dagla.at;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return cells[x][y] == ' ' || cells[x][y] == '\u0000';
    }

    public void place(int x, int y, char marker) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            cells[x][y] = marker;
        }
    }

    // Leert das Board für den Neustart (Wichtig für US-04)
    public void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public char[][] getCells() {
        return cells;
    }

    public void print() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isFull() {
        return false;
    }
}