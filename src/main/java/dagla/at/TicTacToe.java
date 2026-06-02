package dagla.at;

import java.util.Scanner;
import dagla.at.Board;
import dagla.at.Player;

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
        System.out.println("--- TicTacToe Spielfeld-Ansicht (US-02) ---");

        // NEU FÜR US-02: Zeigt das leere Board direkt zum Start an
        board.print();

        System.out.println("Current Player: " + currentPlayer.getMarker());

        int row = -1;
        int col = -1;
        boolean validMove = false;

        while (!validMove) {
            try {
                System.out.print("row (1-3): ");
                int inputRow = Integer.parseInt(scanner.nextLine().trim());

                System.out.print("column (1-3): ");
                int inputCol = Integer.parseInt(scanner.nextLine().trim());

                row = inputRow - 1;
                col = inputCol - 1;

                if (board.isCellEmpty(row, col)) {
                    board.place(row, col, currentPlayer.getMarker());
                    validMove = true;
                    System.out.println("Zug erfolgreich registriert!");

                    // NEU FÜR US-02: Zeigt das aktualisierte Board nach dem Zug an
                    board.print();

                } else {
                    System.out.println("Ungültiger Zug! Das Feld ist besetzt oder außerhalb des Rasters (1-3). Versuche es erneut.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Bitte gib eine gültige Zahl zwischen 1 und 3 ein.");
            }
        }
    }

    private void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {
        // Logik zur Überprüfung von Reihen, Spalten und Diagonalen
        // (Im Diagramm als private Methode definiert)
        return false;
    }

    // HIER IST DER EINSTIEGSPUNKT (Main-Methode) zum Starten:
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}