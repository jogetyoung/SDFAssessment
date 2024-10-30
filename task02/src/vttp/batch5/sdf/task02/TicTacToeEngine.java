package vttp.batch5.sdf.task02;

import java.util.Arrays;

public class TicTacToeEngine {

    private char[] board;
    private final char EMPTY = ' ';
    private final char PLAYER = 'X';
    private final char AI = 'O';

    public TicTacToeEngine() {
        // initializing board to contain max of 9 characters
        board = new char[9];
        // fill up board with EMPTY first
        Arrays.fill(board, EMPTY);
    }

    public boolean isGameOver() {
        // return true if player wins or AI wins or there are no more empty cells
        return checkWin(PLAYER) || checkWin(AI) || !hasEmptyCell();
    }

    public String printResult() {
        if (checkWin(PLAYER))
            return "You win!";
        if (checkWin(AI))
            return "AI wins!";
        return "Draw!";
    }

    public boolean isValidMove(int move) {
        return move >= 1 && move <= 9 && board[move - 1] == EMPTY;
    }

    public void makeMove(int move, char player) {
        // player can be PLAYER or AI depending on who makes the move
        //it is move -1 because user input is 1-9 and the board indices are 0-8
        board[move - 1] = player;
    }

    private int minimax (int depth, boolean isMax){
        if (checkWin(PLAYER)) return 10; //if player wins
        if (checkWin(AI)) return -10; //if AI wins
        if (!hasEmptyCell()) return 0; //if board is filled up but no one wins (draw)

        if (!isMax) { 
            //so we initialize int bestScore with the lowest value possible and any score above that will be considered as the new bestScore
            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < board.length; i++) {
                if (board[i] == EMPTY){
                    //if board[i] (the square) is empty, fill it with PLAYER 
                    board[i] = PLAYER;
                    int score = minimax(depth + 1, true); //simulating possible moves and scores by Minimizing player
                    board[i] = EMPTY; //initializing the square to be empty again
                    
                    bestScore = Math.max(score, bestScore); //continuously comparing score and bestScore, the bigger value is always place into bestScore
                }
                
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < board.length; i++) {
                if(board[i] == EMPTY){
                    //if board[i] is empty, fill it with AI
                    board[i] = AI;
                    int score = minimax(depth + 1, false); //simulating possible moves and scores made by Maximizing player
                    board [i] = EMPTY; //initializing the square to be empty again

                    bestScore = Math.min(score, bestScore);//continuously comparing score and bestScore, the smaller value is always placed into bestScore
                }
                
            }
            return bestScore;
        } 
    }

    public int getBestMove() { //getting Best Move for AI
        int bestScore = Integer.MAX_VALUE;
        int bestMove = -1; //just a placeholder, we are just initializing value of bestMove, it can be any value here

        for (int i = 0; i < board.length; i++) {

            if(board[i] == EMPTY) {
                board[i] = AI;
                int score = minimax(0, false); //depth starts at 0, then +1 every time minimax is ran

                board[i] = EMPTY;
                if (score<bestScore) {
                    bestScore = score;
                    bestMove = i + 1; //plus 1 because it will be called into makeMove function, which is board[move -1]
                }
            }
            
        }
        return bestMove;
    }

    private boolean checkWin(char player) {
        // 2D array win conditions
        int[][] winConditions = {
                { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 },
                { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 },
                { 0, 4, 8 }, { 2, 4, 6 }
        };
        for (int[] condition : winConditions) { // for each int array condition, iterate through int 2D array
                                                // winConditions
            if (board[condition[0]] == player && board[condition[1]] == player && board[condition[2]] == player) {
                return true;
            }
        }
        return false;
    }

    public String printBoard() {
        // StringBuilder is a sticky note to contain multiple lines of String

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            // append is to add what you want to the sticky note
            if (board[i] == EMPTY) { // if the square is empty, write a space into it " "
                sb.append(" ");
            } else {// if square isnt empty, write in whatever is in that space/board[i]
                sb.append(board[i]);
            }

            // if else loop to split the board[9] into rows of 3
            // if divisible by 3, add a new line
            if ((i + 1) % 3 == 0)
                sb.append("\n");
            // if not, add in a | to split up the squares
            else
                sb.append("|");
        }
        return sb.toString();
    }

    private boolean hasEmptyCell() {
        for (char cell : board) {
            if (cell == EMPTY) {
                return true;
            }
        }
        return false;
    }

}
