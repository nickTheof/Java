package gr.nikolaostheofanis.books.javabook.ch8.TicTacToeVariousForms;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int moveRow;
        int moveCol;
        int winner = 0;
        int playerIndex = 0;
        int gridSize;
        Symbols playerSymbol = Symbols.X;
        Symbols computerSymbol = Symbols.O;
        System.out.println("Welcome to the Tic Tac Toe Game");
        System.out.println("Do you want to play a 3x3 or 4x4 grid? (Please enter 3 or 4 respectively.)");
        gridSize = in.nextInt();
        TicTacToe game = new TicTacToe(gridSize);
        TicTacToe.displayTable(game);
        System.out.println("Do you want to begin first? (yes/no)");
        String answer = in.next();
        if (answer.equals("no")){
            playerIndex = 1;
            playerSymbol = Symbols.O;
            computerSymbol = Symbols.X;
        }
        while (winner == 0) {
            if (TicTacToe.getTotalMoves() % 2 == playerIndex) {
                System.out.printf("Player chooses his movement: %n");
                System.out.println("Please choose your row.");
                moveRow = in.nextInt();
                System.out.println("Please choose your col.");
                moveCol = in.nextInt();
                while (!TicTacToe.checkMove(game, moveRow - 1, moveCol - 1)) {
                    System.out.printf("Please, player chose an empty cell.%n");
                    System.out.println("Please choose again your row.");
                    moveRow = in.nextInt();
                    System.out.println("Please choose again your col.");
                    moveCol = in.nextInt();
                }
                TicTacToe.movePlayer(game, moveRow - 1, moveCol - 1, playerSymbol);
            } else {
                System.out.println("Computer movement: ");
                TicTacToe.moveComputer(game, computerSymbol, playerSymbol);
            }
            System.out.println("----------------------------------------");
            System.out.printf("Display The Board Game Table%n");
            TicTacToe.displayTable(game);
            System.out.println("----------------------------------------");
            if (TicTacToe.checkWinPlayer(game, playerSymbol)) {
                winner = 1;
            }
            if (TicTacToe.checkWinPlayer(game, computerSymbol)) {
                winner = 2;
            }

            if (((TicTacToe.getTotalMoves() == 9 && gridSize == 3) || (TicTacToe.getTotalMoves() == 16 && gridSize == 4)) && winner == 0) {
                winner = -1;
            }

        }
        if (winner == -1){
            System.out.println("Draw");
        } else if (winner == 1){
            System.out.println("Player won!");
        } else {
            System.out.println("Computer won!");
        }
    }

}
