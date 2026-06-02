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
        boolean running = true;

        while (running) {
            board.print();
            System.out.println("Current Player: " + currentPlayer.getMarker());

            int row = -1;
            int col = -1;
            boolean validMove = false;

            while (!validMove) {
                try {
                    // Anzeige auf (1-3) geändert
                    System.out.print("row (1-3): ");
                    int inputRow = Integer.parseInt(scanner.nextLine().trim());

                    System.out.print("column (1-3): ");
                    int inputCol = Integer.parseInt(scanner.nextLine().trim());

                    // Transformation: Menschen-Eingabe (1-3) zu Array-Index (0-2)
                    row = inputRow - 1;
                    col = inputCol - 1;

                    if (board.isCellEmpty(row, col)) {
                        board.place(row, col, currentPlayer.getMarker());
                        validMove = true;
                    } else {
                        System.out.println("Dieses Feld ist bereits besetzt oder ungültig! Versuche es erneut.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Bitte gib eine gültige Zahl zwischen 1 und 3 ein.");
                }
            }

            if (hasWinner()) {
                board.print();
                System.out.println("Spieler " + currentPlayer.getMarker() + " hat gewonnen! 🎉");
                running = askForNewGame();
            } else if (board.isFull()) {
                board.print();
                System.out.println("Unentschieden! Das Spielfeld ist voll. 🤝");
                running = askForNewGame();
            } else {
                switchCurrentPlayer();
            }
        }
        System.out.println("Danke fürs Spielen!");
    }

    public void switchCurrentPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public boolean hasWinner() {
        char[][] cells = board.getCells();
        char marker = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if ((cells[i][0] == marker && cells[i][1] == marker && cells[i][2] == marker) ||
                    (cells[0][i] == marker && cells[1][i] == marker && cells[2][i] == marker)) {
                return true;
            }
        }

        if ((cells[0][0] == marker && cells[1][1] == marker && cells[2][2] == marker) ||
                (cells[0][2] == marker && cells[1][1] == marker && cells[2][0] == marker)) {
            return true;
        }

        return false;
    }

    private boolean askForNewGame() {
        System.out.print("Möchtest du ein neues Spiel starten? (ja/nein): ");
        String answer = scanner.nextLine().trim().toLowerCase();
        if (answer.equals("ja") || answer.equals("j")) {
            board.clear();
            currentPlayer = player1;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }
}
