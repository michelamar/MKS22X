import java.lang.Math;

public class MazeSolver{

    private Maze board;
    private boolean animate;
    private Frontier front;
    private boolean isAStar = false;

    public MazeSolver(String filename){
	this(filename, false);
    }
    public MazeSolver(String filename, boolean toAnimate){
	board = new Maze(filename);
	animate = toAnimate;
    }

    public void solve(){
	solve(1);
    }

    public void solve(int type){
        initializeFrontier(type);
	Location start = board.getStart();
	Location end = board.getEnd();
	Location current = board.getStart();
	front.add(current);
	while(current.getRow() != board.getEnd().getRow() ||
	      current.getCol() != board.getEnd().getCol()){
	    int r = current.getRow();
	    int c = current.getCol();
	    if(r+1 < board.maxRows && board.get(r+1, c) != '.'
	       && board.get(r+1, c) != '%'){
		Location toAdd = new Location(r+1, c, current, dist(r+1, c, start), dist(r+1, c, end), isAStar);
		front.add(toAdd);
		board.set(r+1, c, '?');
	    }
	    if(c+1 < board.maxCols && board.get(r, c+1) != '.'
	       && board.get(r, c+1) != '#'){
		Location toAdd = new Location(r, c+1, current, dist(r, c+1,  start), dist(r, c+1, end), isAStar);
		front.add(toAdd);
		board.set(r, c+1, '?');
	    }
	    if(r-1 >= 0 && board.get(r-1, c) != '.'
	        && board.get(r-1, c) != '#'){
		Location toAdd = new Location(r-1, c, current, dist(r-1, c,  start), dist(r-1, c, end), isAStar);
		front.add(toAdd);
		board.set(r-1, c, '?');
	    }
	    if(c-1 >= 0 && board.get(r, c-1) != '.'
	        && board.get(r, c-1) != '#'){
		Location toAdd = new Location(r, c-1, current, dist(r, c-1,  start), dist(r, c-1, end), isAStar);
		front.add(toAdd);
		board.set(r, c-1, '?');
	    }

	    current = front.next();
	}
	
	traceback(board);

    }

    public void traceback (Maze maze){
	Location current = maze.getEnd();
	int currentRow = current.getRow();
	int currentCol = current.getCol();
	while (currentRow != maze.getStart().getRow()
	       && currentCol != maze.getStart().getCol()){
	    maze.set(currentRow, currentCol, '@');
	    current = current.getPrev();
	    currentRow = current.getRow();
	    currentCol = current.getCol();
	}
    }

    public int dist(int r, int c, Location l){
	return Math.abs(r-l.getRow())+Math.abs(c-l.getCol());
    }
	

    public void initializeFrontier(int type){
    	if(type == 0){
	    front = new FrontierStack();
	}
	else if(type == 1){
	    front = new FrontierQueue();
	}
	else if(type == 2){
	    front = new FrontierPriorityQueue();
	}
	else if(type == 3){
	    front = new FrontierPriorityQueue();
	    isAStar = true;
	}
    }
	    

    public String toString(){
	if(animate){
	    return board.toString(1);
	}
	else{
	    return board.toString();
	}
    }



}
