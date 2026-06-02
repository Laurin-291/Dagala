package dagla.at;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    // Prüft, ob Koordinaten im Raster liegen und der Platz frei (' ') ist
    public boolean isCellEmpty(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false;
        }
        return cells[x][y] == ' ' || cells[x][y] == '\u0000';
    }

    // Speichert den Marker im 3x3-Array
    public void place(int x, int y, char marker) {
        if (x >= 0 && x <= 2 && y >= 0 && y <= 2) {
            cells[x][y] = marker;
        }
    }

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
        // Wird in US-02 eingebaut
    }

    public boolean isFull() {
        return false; // Wird in US-03 eingebaut
    }
}