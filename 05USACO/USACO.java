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
  
    private static void stomp(int[][] grid, int origRow, int origCol, int amount){
	int highestElevation = 0;

	for (int row = origRow; row < origRow + 2; row++){
	    for (int col = origCol; col < origCol + 2; col++){
		if (row < grid.length && col < grid[0].length){
		    if (grid[row][col] > highestElevation){
			highestElevation = grid[row][col];
		    }
		}
	    }
	}

	int newElevation = highestElevation - amount;

	for (int row = origRow; row < origRow + 2; row++){
	    for (int col = origCol; col < origCol + 2; col++){
		if (row < grid.length && col < grid[0].length){
		    if (grid[row][col] > newElevation){
			grid[row][col] = newElevation;
		    }
		}
	    }
	}
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
	System.out.println(USACO.bronze("makelake.3.in"));
    }


}
