public class Location implements Comparable<Location>{

    private int row, col;
    private int distToGoal;
    private int distToStart;
    private Location previous;
    private boolean aStar;

    public Location (int r, int c, Location inputPrevious, int inputDistToStart, int inputDistToGoal, boolean isAStar){
	row = r;
	col = c;
	distToGoal = inputDistToGoal;
	distToStart = inputDistToStart;
	previous = inputPrevious;
	aStar = isAStar;
    }

    public int getRow(){
	return row;
    }
    public int getCol(){
	return col;
    }
    public int getDistToGoal(){
	return distToGoal;
    }    
    public int getDistToStart(){
	return distToStart;
    }
    public Location getPrev(){
	return previous;
    }

    public int compareTo(Location other){
	if(aStar){
	    return (distToGoal+distToStart) - (other.getDistToGoal()+other.getDistToStart());
	}
	else{
	    return distToGoal - other.getDistToGoal();
	}
    }

}
