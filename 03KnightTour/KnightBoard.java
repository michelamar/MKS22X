import java.util.ArrayList;

public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	board = new int[startingRows][startingCols];
	for (int row = 0; row < startingRows; row++){
	    for (int col = 0; col < startingCols; col++){
		board[row][col] = 0;
	    }
	}
    }

    private boolean solveH(int row, int col, int number){
	if (number == board.length * board[0].length){ 
	    return true;
	}
	else{
	    for (	
	}

    }

    private ArrayList<Integer[]> spotGenerator (int row, int col){
	ArrayList<Integer[]> spots = new ArrayList<Integer[]>();
	if (row + 2 < board.length && col + 1 < board[0].length &&
		 board[row+2][col+1] == 0){
	    spots.add([row+2, col+1]);
	}
	if (row + 2 < board.length && col - 1 < board[0].length &&
		 board[row+2][col-1] == 0){
	    spots.add([row+2, col-1]);
	}
	if (row - 2 < board.length && col + 1 < board[0].length &&
		 board[row-2][col+1] == 0){
	    spots.add([row-2, col+1]);
	}
	if (row - 2 < board.length && col - 1 < board[0].length &&
		 board[row-2][col-1] == 0){
	    spots.add([row-2, col-1]);
	}
	if (row + 1 < board.length && col + 2 < board[0].length &&
		 board[row+1][col+2] == 0){
	    spots.add([row+1, col+2]);
	}
	if (row - 1 < board.length && col + 2 < board[0].length &&
		 board[row-1][col+2] == 0){
	    spots.add([row-1, col+2]);
	}
	if (row + 1 < board.length && col - 2 < board[0].length &&
		 board[row+1][col-2] == 0){
	    spots.add([row+1, col-2]);
	}
	if (row - 1 < board.length && col - 2 < board[0].length &&
		 board[row-1][col-2] == 0){
	    spots.add([row-1, col-2]);
	}
	return spots;
}
