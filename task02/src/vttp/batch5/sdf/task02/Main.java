package vttp.batch5.sdf.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		if (args.length != 1) {
			System.out.println("Please Provide File to read to begin GOL");
			return;
		}

		String filePath = args[0];
		System.out.println("Processing: " + filePath);

		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);

		String line;

		while ((line = br.readLine()) != null) {

			System.out.println(line); // print board from TTT

		}
		br.close();

	}

	private char[] board;
	private final char EMPTY = ' ';
	private final char PLAYER = 'X';
	private final char AI = 'O';

	public Main() {
		// initializing board to contain max of 9 characters
		board = new char[9];
		// fill up board with EMPTY first
		Arrays.fill(board, EMPTY);
	}

	private boolean checkWin(char player) { // check for win in rows, cols and diagonally
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

	private boolean hasEmptyCell() { // check if the square is empty
		for (char cell : board) {
			if (cell == EMPTY) {
				return true;
			}
		}
		return false;
	}

	public int Utility() {
		if (checkWin(PLAYER)) // if move allows player to win, utility = 1
			return 1;
		if (checkWin(AI)) // if move causes player to lose, utility = -1
			return -1;
		return 0; // if draw, utility = 0
	}

}
