import java.util.*;


public class TicTacToe {

    public static void main(String args[]){
        System.out.println("Welcome to 3X3 Tic Tac Toe!!");
        System.out.println("Enter 1: To play with another Player");
        System.out.println("Enter 2: To play with Computer");

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        if(option==1) {
            HumanVsHuman game = new HumanVsHuman();
            game.printBoard();

            Player player1 = new Player("X");
            Player player2 = new Player("O");

            boolean keepPlaying = true;
            int turn = 0;

            Player currentPlayer;
            while (keepPlaying) {
                if (turn == 9) {
                    System.out.println("Draw!!!!");
                    break;
                }

                if (turn % 2 == 0) {
                    System.out.println("Player1..Enter a position between 1-9");
                    currentPlayer = player1;
                } else {
                    System.out.println("Player2..Enter a position between 1-9");
                    currentPlayer = player2;
                }


                int position = input.nextInt();

                while (game.board[position - 1].equals("X") || game.board[position - 1].equals("O")) {
                    System.out.println("Re-enter  a position.This is already taken.");
                    position = input.nextInt();
                }

                game.board[position - 1] = currentPlayer.sign;
                game.printBoard();
                turn++;

                String winner = game.checkWinner();

                if ("X".equals(winner)) {
                    winner = "Player1";
                } else if ("O".equals(winner)) {
                    winner = "Player2";
                } else {
                    continue;
                }
                keepPlaying = false;
                System.out.println("Congratulations!! " + winner + " wins... ");
            }
        }
        else{
            int turn =0;
            HumanVsComputer game = new HumanVsComputer();
            game.printBoard();

            Player player = new Player("X");
            boolean keepPlaying  = true;

            while(keepPlaying){
                if(turn==9 ) {
                    System.out.println("Draw!!!!");
                    break;
                }
                if(turn%2==0){
                    System.out.println("Player,Enter a position between 1-9");
                    Scanner in = new Scanner(System.in);
                    int position = in.nextInt();
                    while(game.board[position-1].equals("X") || game.board[position-1].equals("O")){
                        System.out.println("Re-enter  a position.This is already taken.");
                        position = in.nextInt();
                    }
                    game.board[position-1] = player.sign;
                }
                else{
                    game.computerTurn();
                    game.printBoard();
                }

                turn++;

                String winner = game.checkWinner();
                if("X".equals(winner)){
                    winner="You";
                    System.out.println( "Congratulations!! " + winner + " wins... " );
                }
                else if("O".equals(winner)){
                    winner="Computer";
                    System.out.println( winner + " wins... " );
                }
                else{
                    continue;
                }
                keepPlaying = false;

            }
        }
    }

}