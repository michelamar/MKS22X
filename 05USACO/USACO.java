import java.util.*;
import java.io.*;

public class USACO{
  
    public static int bronze(String filename) {
	int row = 0, col = 0, elevation = 0, steps = 0;
	int[][] lake;
	Scanner scan=null;
    
	try{
	    scan = new Scanner(new File(filename));
	}
	catch(FileNotFoundException e) {
	    System.out.println("File not found");
	}

	row = scan.nextInt();
	col = scan.nextInt();
	elevation = scan.nextInt();
	steps = scan.nextInt();
	//System.out.println (steps);
	lake = new int[row][col];

	for (int r = 0; r < row; r++){
	    for (int c = 0; c < col; c++){
		lake[r][c] = scan.nextInt();
	    }
	}

	//System.out.println (stringOf(lake));

	for (int stepsLeft = steps; stepsLeft > 0; stepsLeft--){
	    int origRow = scan.nextInt();
	    // System.out.println (origRow);
	    int origCol = scan.nextInt();
	    //System.out.println (origCol);
	    int amount = scan.nextInt();
	    // System.out.println (amount);
	    //stomp(lake, origRow, origCol, amount);
	    int highestElevation = 0;

	    for (int r = origRow-1; r < origRow + 2; r++){
		for (int c = origCol-1; c < origCol + 2; c++){
		    if (r < lake.length && c < lake[0].length){
			if (lake[r][c] > highestElevation){
			    highestElevation = lake[r][c];
			}
		    }
		}
	    }
	    //System.out.println(highestElevation);
	    
	    int newElevation = highestElevation - amount;
	
	    for (int r = origRow-1; r < origRow + 2; r++){
		for (int c = origCol-1; c < origCol + 2; c++){
		    if (r < lake.length && c < lake[0].length){
			if (lake[r][c] > newElevation){
			    lake[r][c] = newElevation;
			}
		    }
		}
	    }
	    
	    //System.out.println (stringOf(lake));
	}
	
	finalElevation(lake, elevation);
	//System.out.println(stringOf(lake));
	
	return findVolume(lake);

	
    }


    private static void finalElevation (int[][] grid, int elevation){
	for (int r = 0; r < grid.length; r++){
	    for (int c = 0; c < grid[0].length; c++){
		if (grid[r][c] < elevation){
		    grid[r][c] = elevation - grid[r][c];
		}
		else{
		    grid[r][c] = 0;
		}
	    }
	}
    }

    private static int findVolume (int[][] grid){
	int sum = 0;
	for (int r = 0; r < grid.length; r++){
	    for (int c = 0; c < grid[0].length; c++){
		sum += grid[r][c];
	    }
	}
	
	//System.out.println(grid.length);
	//System.out.println(grid[0].length);
	return sum * 72 * 72;
    }

    public static int silver(String filename){
	Scanner scan = null;
	int[][] pasture;
	int r1, r2, c1, c2, time;
	try{
	    scan = new Scanner(new File(filename));
	}
	catch(FileNotFoundException e) {
	    System.out.println("File not found");
	}

	int rows = scan.nextInt();
	int cols = scan.nextInt();
	time = scan.nextInt();
	pasture = new int[rows][cols];

	for (int r = 0; r < rows; r++){
	    for (int c = 0; c < cols; c++){
		if(scan.hasNext()){
		    if (scan.next() == "."){
			pasture[r][c] = 0;
		    }
		    if (scan.next() == "*"){
			pasture[r][c] = -1;
		    }
		}
	    }
	}

	r1 = scan.nextInt();
	c1 = scan.nextInt();
	r2 = scan.nextInt();
	c2 = scan.nextInt();

	pasture[r1][c1] = 1;

	for (int seconds = time; seconds > 0; seconds--){
	    adjustPaths(pasture);
	}

	return pasture[r2][c2];
	
    }

    private static void adjustPaths(int[][] grid){
	for (int r = 0; r < grid.length; r++){
	    for (int c = 0; c < grid[0].length; c++){
		int sum = 0;
		if (r-1 > 0 && grid[r-1][c] != -1){
		    sum += grid[r-1][c];
		}
		if (c-1 > 0 && grid[r][c-1] != -1){
		    sum += grid[r][c-1];
		}
		if (r+1 < grid.length && grid[r+1][c] != -1){
		    sum += grid[r+1][c];
		}
		if (c+1 < grid[0].length && grid[r][c+1] != -1){
		    sum += grid[r][c+1];
		}
		grid[r][c] = sum;
	    }
	}		
    }

    private static String stringOf(int[][] grid){
	String ans = "";
	for (int r = 0; r < grid.length; r++){
	    for (int c = 0; c < grid[0].length; c++){
		ans += grid[r][c] + " ";
	    }
	    ans+= "\n";
	}
	return ans;
    }

    public static void main(String[]args){
	System.out.println(USACO.silver("ctravel.1.in"));
    }


}
