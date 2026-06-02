package dagla.at;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testIsCellEmpty_Positive() {
        assertTrue(board.isCellEmpty(0, 0), "Ein unbesetztes Feld im Raster (0-2) muss true zurückgeben.");
    }

    @Test
    void testIsCellEmpty_Negative_Occupied() {
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1), "Ein mit einem Marker belegtes Feld muss false zurückgeben.");
    }

    @Test
    void testIsCellEmpty_Negative_OutOfBounds() {
        assertFalse(board.isCellEmpty(3, 1), "Koordinaten außerhalb des Rasters müssen false liefern.");
    }

    @Test
    void testPlace_Positive() {
        board.place(0, 2, 'O');
        assertEquals('O', board.getCells()[0][2], "Der Marker 'O' muss korrekt im Array liegen.");
    }

    // =========================================================================
    // NEUE TESTS FÜR US-02: Spielstatus / Spielfeld zurücksetzen & Dimensionen
    // =========================================================================

    @Test
    void testClearBoard_Positive() {
        // POSITIVTEST: Board befüllen und leeren. Danach müssen alle Felder wieder ' ' sein.
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');

        board.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCells()[i][j], "Nach clear() müssen alle Felder leer sein.");
            }
        }
    }

    @Test
    void testBoardDimensions_Positive() {
        // POSITIVTEST: Prüft, ob das Array exakt die Spielfeldgröße 3x3 besitzt
        char[][] cells = board.getCells();
        assertEquals(3, cells.length, "Das Spielfeld muss 3 Zeilen haben.");
        assertEquals(3, cells[0].length, "Das Spielfeld muss 3 Spalten haben.");
    }
}