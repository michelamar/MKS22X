public class MazeSolver{

    Maze board;
    boolean animate;

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
	Frontier spaces;
	boolean isAStar = false;
	if(type == 0){
	    spaces = new FrontierStack();
	}
	else if(type == 1){
	    spaces = new FrontierQueue();
	}
	else if(type == 2){
	    spaces == new FrontierPriorityQueue();
	}
	else if(type == 3){
	    spaces == new FrontierPriorityQueue();
	    isAStar = true;
	}
	Location current = board.getStart();
	while(current.getRow() != board.getEnd().getRow() ||
	      current.getCol() != board.getEnd().getCol()){
	    int r = current.getRow();
	    int c = current.getCol();
	    if(r+1 < 


    }

    public String toString(){
	if(animate){
	    retrun board.toString(1);
	}
	else{
	    return board.toString();
	}
    }



}
