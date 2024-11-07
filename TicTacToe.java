package gr.nikolaostheofanis.books.javabook.ch8.TicTacToeVariousForms;


import java.util.Arrays;
import java.security.SecureRandom;

public class TicTacToe {
    private final Symbols[][] boardGame;
    private static int totalMoves = 0;
    private final static SecureRandom random = new SecureRandom();

    public TicTacToe(int gridSize){
        this.boardGame = new Symbols[gridSize][gridSize];
        for (Symbols[] row: boardGame){
            Arrays.fill(row, Symbols.E);
        }
    }

    public static void displayTable(TicTacToe game){
        for (int i = 0; i < game.boardGame.length; i++){
            for (int j = 0; j < game.boardGame[0].length; j++){
                System.out.printf("%6s", game.boardGame[i][j] == Symbols.E ? "-" : game.boardGame[i][j]);
                if (j == game.boardGame[0].length - 1){
                    System.out.println();
                }
            }
        }
    }

    public static boolean checkMove(TicTacToe game, int row, int col){
        return game.boardGame[row][col] == Symbols.E;
    }


    public static void movePlayer(TicTacToe game, int row, int col, Symbols playerSymbol){
        if (checkMove(game, row, col)){
            game.boardGame[row][col] = playerSymbol;
            totalMoves++;
        }
    }

    public static boolean checkWinPlayer(TicTacToe game, Symbols playerSymbol) {
        // Check rows and columns
        for (int i = 0; i < game.boardGame.length; i++) {
            boolean rowWin = true;
            boolean colWin = true;
            for (int j = 0; j < game.boardGame.length; j++) {
                // Check rows
                if (!(game.boardGame[i][j] == playerSymbol)){
                    rowWin = false;
                }
                // Check columns
                if (!(game.boardGame[j][i] == playerSymbol)){
                    colWin = false;
                }
            }
            if (rowWin || colWin) {
                return true;
            }
        }

        // Check diagonals
        boolean diagonal1Win = true;
        boolean diagonal2Win = true;
        for (int i = 0; i < game.boardGame.length; i++) {
            if (!(game.boardGame[i][i] == playerSymbol)){
                diagonal1Win = false;
            }
            if (!(game.boardGame[i][game.boardGame.length - 1 - i] == playerSymbol)){
                diagonal2Win = false;
            }
        }
        return diagonal1Win || diagonal2Win;
    }

    public static void moveComputer(TicTacToe game, Symbols computerSymbol, Symbols playerSymbol) {
        // Step 1: Check if the computer can win in the next move
        for (int i = 0; i < game.boardGame.length; i++) {
            for (int j = 0; j < game.boardGame.length; j++) {
                if (checkMove(game, i, j)) {
                    game.boardGame[i][j] = computerSymbol;
                    if (checkWinPlayer(game, computerSymbol)) {
                        totalMoves++;
                        return;
                    }
                    game.boardGame[i][j] = Symbols.E; // Revert the move
                }
            }
        }

        // Step 2: Check if the player can win in the next move, and block them
        for (int i = 0; i < game.boardGame.length; i++) {
            for (int j = 0; j < game.boardGame.length; j++) {
                if (checkMove(game, i, j)) {
                    game.boardGame[i][j] = playerSymbol;
                    if (checkWinPlayer(game, playerSymbol)) {
                        game.boardGame[i][j] = computerSymbol;
                        totalMoves++;
                        return;
                    }
                    game.boardGame[i][j] = Symbols.E; // Revert the move
                }
            }
        }

        // Step 3: Otherwise, pick a random empty cell
        boolean placed = false;
        while (!placed) {
            int row = random.nextInt(game.boardGame.length);
            int col = random.nextInt(game.boardGame.length);
            if (checkMove(game, row, col)) {
                game.boardGame[row][col] = computerSymbol;
                totalMoves++;
                placed = true;
            }
        }
    }

    public static int getTotalMoves() {
        return totalMoves;
    }
}
