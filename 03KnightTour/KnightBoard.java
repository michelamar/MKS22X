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

    public void solve(){
	solveH(0, 0, 1);

    }

    private boolean solveH(int row, int col, int number){
	if (number == board.length * board[0].length){ 
	    board[row][col] = number;
	    return true;
	}
	else{
	    board[row][col] = number;
	    for (Integer[] coordinate : spotGenerator(row, col)){
		//board[coordinate[0]][coordinate[1]] = number;
		if (solveH(coordinate[0], coordinate[1], number+1)){
		    return true;
		}
		else{
		    board[coordinate[0]][coordinate[1]] = 0;	
		}
	    }
	    board[row][col] = 0;
	    return false;
	}
    }

    private ArrayList<Integer[]> spotGenerator (int row, int col){
	ArrayList<Integer[]> spots = new ArrayList<Integer[]>();
	if (row + 2 < board.length && col + 1 < board[0].length &&
		 board[row+2][col+1] == 0){
	    spots.add(new Integer[]{row+2, col+1});
	}
	if (row + 2 < board.length && col - 1 >= 0 &&
		 board[row+2][col-1] == 0){
	    spots.add(new Integer[]{row+2, col-1});
	}
	if (row - 2 >= 0 && col + 1 < board[0].length &&
		 board[row-2][col+1] == 0){
	    spots.add(new Integer[]{row-2, col+1});
	}
	if (row - 2 >= 0 && col - 1 >= 0 &&
		 board[row-2][col-1] == 0){
	    spots.add(new Integer[]{row-2, col-1});
	}
	if (row + 1 < board.length && col + 2 < board[0].length &&
		 board[row+1][col+2] == 0){
	    spots.add(new Integer[]{row+1, col+2});
	}
	if (row - 1 >= 0 && col + 2 < board[0].length &&
		 board[row-1][col+2] == 0){
	    spots.add(new Integer[]{row-1, col+2});
	}
	if (row + 1 < board.length && col - 2 >= 0 &&
		 board[row+1][col-2] == 0){
	    spots.add(new Integer[]{row+1, col-2});
	}
	if (row - 1 >= 0 && col - 2 >= 0 &&
		 board[row-1][col-2] == 0){
	    spots.add(new Integer[]{row-1, col-2});
	}
	return spots;
    }

    public String toString(){
    	String toPrint = "" ;
	for (int row = 0; row < board.length; row++){
	    for (int col = 0; col < board[row].length; col++){
		toPrint+=board[row][col] + "\t";
	    }
	    toPrint += "\n";
	}
	return toPrint;
    }

    

    public static void main(String[]args){
	KnightBoard a = new KnightBoard(6, 6);
	a.solve();
	System.out.println(a);
    }
}
