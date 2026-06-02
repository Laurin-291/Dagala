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
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmpty_Negative_Occupied() {
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    // =========================================================================
    // NEUE TESTS FÜR US-04: Spielfeld zurücksetzen (Neustart-Logik)
    // =========================================================================

    @Test
    void testClearBoard_Positive() {
        // POSITIVTEST: Board befüllen und zurücksetzen. Danach müssen alle Felder leer sein.
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');

        board.clear(); // Die Neustart-Methode

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCells()[i][j], "Nach dem Reset müssen alle Zellen leer sein.");
            }
        }
    }
}