package dagla.at;

import java.util.Scanner;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private Scanner scanner;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean keepPlaying = true;

        // ÄUßERE SCHLEIFE FÜR US-04: Ermöglicht den kompletten Spiel-Neustart
        do {
            System.out.println("\n=== Eine neue Runde TicTacToe beginnt! ===");
            board.print();
            System.out.println("Aktueller Spieler: " + currentPlayer.getMarker());

            int row = -1;
            int col = -1;
            boolean validMove = false;

            while (!validMove) {
                try {
                    System.out.print("Zeile (1-3): ");
                    int inputRow = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("Spalte (1-3): ");
                    int inputCol = Integer.parseInt(scanner.nextLine().trim());

                    row = inputRow - 1;
                    col = inputCol - 1;

                    if (board.isCellEmpty(row, col)) {
                        board.place(row, col, currentPlayer.getMarker());
                        validMove = true;
                        System.out.println("Zug erfolgreich registriert!");
                        board.print();
                    } else {
                        System.out.println("Ungültiger Zug! Feld besetzt. Versuche es erneut.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Bitte gib Zahlen zwischen 1 und 3 ein.");
                }
            }

            // NEU FÜR US-04: Die Abfrage, ob das Spiel neu gestartet werden soll
            System.out.print("Möchtest du das Spiel neustarten? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            if (answer.equals("y")) {
                board.clear();              // Spielfeld komplett leeren
                currentPlayer = player1;     // Spieler zurücksetzen auf X
                keepPlaying = true;
                System.out.println("Spielfeld wurde zurückgesetzt!");
            } else {
                keepPlaying = false;
                System.out.println("Spiel beendet. Vielen Dank fürs Spielen!");
            }

        } while (keepPlaying);
    }

    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public boolean hasWinner() {
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}