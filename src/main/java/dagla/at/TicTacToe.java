package dagla.at;


public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        this.player1 = new Player('X');
        this.player2 = new Player('O');
        this.currentPlayer = player1;
        this.board = new Board();
    }

    public void start() {
        System.out.println("Spiel gestartet!");
        // Hier käme die Spielschleife hin
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


    public static void main(String[] args) {


    }
    }
