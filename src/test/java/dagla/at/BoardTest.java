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

    // =========================================================================
    // TESTS FÜR US-03: Validierung & Belegungsprüfung
    // =========================================================================

    @Test
    void testIsCellEmpty_Positive() {
        // POSITIVTEST: Ein leeres Feld auf einem neuen Board muss true zurückgeben
        assertTrue(board.isCellEmpty(0, 0), "Ein neues Feld sollte leer sein.");
    }

    @Test
    void testIsCellEmpty_Negative_Occupied() {
        // NEGATIVTEST 1: Ein besetztes Feld darf nicht als leer durchgehen
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1), "Ein besetztes Feld darf nicht leer sein.");
    }

    @Test
    void testIsCellEmpty_Negative_OutOfBounds() {
        // NEGATIVTEST 2: Werte außerhalb des Arrays (0-2) müssen sicher abgefangen werden
        assertFalse(board.isCellEmpty(3, 1), "Koordinaten außerhalb des Rasters (zu groß) müssen abgefangen werden.");
        assertFalse(board.isCellEmpty(-1, 0), "Negative Koordinaten müssen abgefangen werden.");
    }
}