class Player
{
    String sign;
    public Player(String sign){
        this.sign = sign;
    }
}


class HumanVsHuman
{
    static String [] board;

    public HumanVsHuman(){
        board = new String [9];
        for (int i=0;i<9;i++){
            board[i]=" ";
        }
    }


    public static void printBoard(){

        System.out.println(board[0]+" | "+board[1]+" | "+board[2]);
        System.out.println("---------");
        System.out.println(board[3]+" | "+board[4]+" | "+board[5]);
        System.out.println("----------");
        System.out.println(board[6]+" | "+board[7]+" | "+board[8]);
    }


    public String checkWinner(){
        for(int i=0;i<8;i++){
            String pattern = null;
            switch(i) {
                case 0:
                    pattern = board[0] + board[1] + board[2];
                    break;
                case 1:
                    pattern = board[3] + board[4] + board[5];
                    break;
                case 2:
                    pattern = board[6] + board[7] + board[8];
                    break;
                case 3:
                    pattern = board[0] + board[4] + board[8];
                    break;
                case 4:
                    pattern = board[2] + board[4] + board[6];
                    break;
                case 5:
                    pattern = board[0] + board[3] + board[6];
                    break;
                case 6:
                    pattern = board[1] + board[4] + board[7];
                    break;
                case 7:
                    pattern = board[2] + board[5] + board[8];
                    break;
            }
            if(pattern.equals("XXX")){
                return "X";
            }
            else if(pattern.equals("OOO")){
                return "O";
            }
        }
        return null;
    }
}


class HumanVsComputer extends HumanVsHuman
{
    public HumanVsComputer(){
        board = new String [9];
        for (int i=0;i<9;i++){
            board[i]=" ";
        }
    }


    private boolean movesLeft(){
        for(int i=0;i<9;i++){
            if(board[i]!="X" && board[i]!="O"){
                return true;
            }
        }
        return false;
    }


    private int score(){
        for(int i=0;i<8;i++){
            String pattern = null;
            switch(i) {
                case 0:
                    pattern = board[0] + board[1] + board[2];
                    break;
                case 1:
                    pattern = board[3] + board[4] + board[5];
                    break;
                case 2:
                    pattern = board[6] + board[7] + board[8];
                    break;
                case 3:
                    pattern = board[0] + board[4] + board[8];
                    break;
                case 4:
                    pattern = board[2] + board[4] + board[6];
                    break;
                case 5:
                    pattern = board[0] + board[3] + board[6];
                    break;
                case 6:
                    pattern = board[1] + board[4] + board[7];
                    break;
                case 7:
                    pattern = board[2] + board[5] + board[8];
                    break;
            }
            if(pattern.equals("XXX")){
                return -10;
            }
            else if(pattern.equals("OOO")){
                return 10;
            }
        }
        return 0;
    }


    private int minimax(int depth, boolean isComputer){
        String player = "X";
        String computer = "O";
        int score =  score();

        if(score==10 || score== -10){
            return score;
        }
        if(movesLeft()==false){
            return 0;
        }

        if(isComputer){
            int bestMoveValue = -10000;
            for(int i=0;i<9;i++){
                if(board[i]!="X" && board[i]!="O"){
                    board[i] = computer;
                    bestMoveValue = Math.max(bestMoveValue,minimax(depth+1,!(isComputer)));
                    board[i] = " ";

                }
            }
            return bestMoveValue;
        }
        else{
            int bestMoveValue = 10000;
            for(int i=0;i<9;i++){
                if(board[i]!="X" && board[i]!="O"){
                    board[i] = player;
                    bestMoveValue = Math.min(bestMoveValue,minimax(depth+1,!(isComputer)));
                    board[i] = " ";
                }
            }
            return bestMoveValue;
        }
    }


    public void computerTurn(){
        String computer = "O";
        int bestMoveValue = -10000;
        int bestMove = -1;

        for(int i=0;i<9;i++){
            if(board[i]!="X" && board[i]!="O") {
                board[i] = computer;
                int moveValue = minimax(0, false);
                board[i] = " ";

                if(moveValue>bestMoveValue){
                    bestMoveValue = moveValue;
                    bestMove = i;
                }
            }

        }

        board[bestMove] = computer;
    }
}

