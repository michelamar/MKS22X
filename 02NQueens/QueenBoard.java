public class QueenBoard{
    private int[][]board;
    private int solutionCount = -1;
    
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
	solveH(0, true);
    }

    private boolean solveH(int col, boolean stop){
	if (col >= board[0].length){
	    if (stop){
		return true;
	    }
	    else{
		solutionCount++;
		return false;
	    }
	}
	else {
	    for (int row = 0; row < board[0].length; row++){
		if (board[row][col] == 0){
		    addQueen(row, col);
		    if (solveH(col+1, stop)){
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

    private boolean addQueen(int row, int col){
	if(board[row][col] != 0){
	    return false;
	}
	board[row][col] = 1;
	int offset = 1;
	while(col+offset < board[row].length){
	    board[row][col+offset]--;
	    if(row - offset >= 0){
		board[row-offset][col+offset]--;
	    }
	    if(row + offset < board.length){
		board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }

    private boolean removeQueen(int row, int col){
	if ( board[row][col] != 1 ) {
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	
	while( col+offset < board[row].length ) {
	    board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		board[row-offset][col+offset]++;
	    }
	    if( row + offset < board.length ) {
		board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }
    

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return solutionCount;
    }

    public void countSolutions(){
	solutionCount++;
	solveH(0, false);
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
    	String toPrint = "" ;
	for (int row = 0; row < board[0].length; row++){
	    for (int col = 0; col < board[row].length; col++){
		// toPrint+=board[row][col] + "\t";
		if(board[row][col] == 1){
		   toPrint += "Q ";
		}
		else{
		   toPrint += "_ ";
		}
	    }
	    toPrint += "\n";
	}
	return toPrint;
    }

    public static void main(String[]args){
	QueenBoard a = new QueenBoard(16);
	a.countSolutions();
	System.out.println(a.getSolutionCount());//.getSolutionCount());
    }
}
