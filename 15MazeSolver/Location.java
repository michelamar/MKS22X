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
    

}
