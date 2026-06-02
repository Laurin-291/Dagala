package dagla.at;

import dagla.at.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    // ==========================================
    // Tests für: isCellEmpty(int x, int y)
    // ==========================================

    @Test
    void testIsCellEmpty_Positive() {
        assertTrue(board.isCellEmpty(0, 0), "Ein leeres Feld sollte true zurückgeben.");
    }

    @Test
    void testIsCellEmpty_Negative_Occupied() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Ein belegtes Feld sollte false zurückgeben.");
    }

    @Test
    void testIsCellEmpty_Negative_OutOfBounds() {
        assertFalse(board.isCellEmpty(3, 1), "Koordinaten außerhalb des Feldes sollten false zurückgeben.");
        assertFalse(board.isCellEmpty(-1, 0), "Negative Koordinaten sollten false zurückgeben.");
    }

    // ==========================================
    // Tests für: place(int x, int y, char marker)
    // ==========================================

    @Test
    void testPlace_Positive() {
        board.place(1, 1, 'O');
        char[][] cells = board.getCells();
        assertEquals('O', cells[1][1], "Der Marker sollte korrekt auf dem Feld platziert werden.");
    }

    @Test
    void testPlace_Negative_InvalidCoordinates() {
        assertDoesNotThrow(() -> board.place(5, -2, 'X'),
                "Ungültige Koordinaten dürfen keine Exception auslösen.");
    }


    @Test
    void testClear_Positive() {
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');
        board.clear();

        char[][] cells = board.getCells();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', cells[i][j], "Nach clear() müssen alle Felder ein Leerzeichen enthalten.");
            }
        }
    }

    @Test
    void testClear_Negative_DoesNotAffectDimensions() {
        board.clear();
        char[][] cells = board.getCells();
        assertNotNull(cells, "Das Array darf nach dem Leeren nicht null sein.");
        assertEquals(3, cells.length, "Das Spielfeld muss weiterhin 3 Zeilen haben.");
        assertEquals(3, cells[0].length, "Das Spielfeld muss weiterhin 3 Spalten haben.");
    }

    // ==========================================
    // Tests für: print()
    // ==========================================

    @Test
    void testPrint_Positive() {
        assertDoesNotThrow(() -> board.print(), "Die print() Methode sollte ohne Fehler ausgeführt werden.");
    }

    @Test
    void testPrint_Negative_EmptyStateStillValid() {
        board.clear();
        assertDoesNotThrow(() -> board.print(), "print() darf auch bei einem komplett leeren Board nicht abstürzen.");
    }
}
