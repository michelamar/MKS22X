public class QueenBoard{
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
	for (int row = 0; row < size; row++){
	    for (int col = 0; col < size; col++){
		board[row][col] = 0;
	    }
	}
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	//	System.out.println(this);
	solveH(0);
    }

    private boolean solveH(int col){
	if (col >= board[0].length){
	    return false;
	}
	else {
	    for (int row = 0; row < board[0].length; row++){
		if (board[row][col] == 0){
		    addQueen(row, col);
		    if (solveH(col+1)){
			return true;
		    }
		    else{
			removeQueen(row, col);
		    }
		    //		    System.out.println (this);
		}
	    }
	    return false;
	}
    }

    private void addQueen(int row, int col){
	board[row][col] = -1;
	for (int i = 0; i < board[0].length; i++){
	    if (board[row][i] != -1){
		board[row][i] = board[row][i] + 1;
	    }
	}
	for (int i = 0; i < board[0].length; i++){
	    if (board[i][col] != -1){
		board[i][col] = board[i][col] + 1;
	    }
	}
	for (int i = 0; i+row < board[0].length && i+col< board[0].length; i++){
	    if (board[row+i][col+i] != -1){
		board[row+i][col+i] = board[row+i][col+i] + 1;
	    }
	}
       	for (int i = 0; i+col < board[0].length && row-i>=0; i++){
	    if (board[row-i][i+col] != -1){
		board[row-i][i+col] = board[row-i][i+col] + 1;
	    }
	}
	for (int i = 0; row-i >= 0 && col-i >=0; i++){
	    if (board[row-i][col-i] != -1){
		board[row-i][col-i] = board[row-i][col-i] + 1;
	    }
	}
       	for (int i = 0; col-i>= 0 && row+i < board[0].length; i++){
	    if (board[row+i][col-i] != -1){
		board[row+i][col-i] = board[row+i][col-i] + 1;
	    }
	}
    }

    private void removeQueen(int row, int col){
	board[row][col] = 0;
	for (int i = 0; i < board[0].length; i++){
	    if (board[row][i] != 0){
		board[row][i] = board[row][i] - 1;
	    }
	}
	for (int i = 0; i < board[0].length; i++){
	    if (board[i][col] != 0){
		board[i][col] = board[i][col] - 1;
	    }
	}
	for (int i = 0; i+row < board[0].length && i+col< board[0].length; i++){
	    if (board[row+i][col+i] != 0){
		board[row+i][col+i] = board[row+i][col+i] - 1;
	    }
	}
       	for (int i = 0; i+col < board[0].length && row-i >= 0; i++){
	    if (board[row-i][i+col] != 0){
		board[row-i][i+col] = board[row-i][i+col] - 1;
	    }
	}
	for (int i = 0; row-i >= 0 && col-i >= 0; i++){
	    if (board[row-i][col-i] != 0){
		board[row-i][col-i] = board[row-i][col-i] - 1;
	    }
	}
       	for (int i = 0; col-i>=0 && row+i < board[0].length; i++){
	    if (board[row][col-i] != 0){
		board[row][col-i] = board[row][col-i] - 1;
	    }
	}
    }
    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	String toPrint = "" ;
	for (int row = 0; row < board[0].length; row++){
	    for (int col = 0; col < board[row].length; col++){
		toPrint += board[row][col];
	    }
	    toPrint += "\n";
	}
	return toPrint;
    }

    public static void main(String[]args){
	QueenBoard a = new QueenBoard(4);
	a.solve();
	System.out.println(a);
    }
}
