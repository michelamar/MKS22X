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
	lake = new int[row][col];

	for (int r = 0; r < row; r++){
	    for (int c = 0; c < col; c++){
		lake[r][c] = scan.nextInt();
	    }
	}

	for (int stepsLeft = steps; stepsLeft > 0; stepsLeft--){
	    int origRow = scan.nextInt();
	    int origCol = scan.nextInt();
	    int amount = scan.nextInt();
	    stomp(lake, origRow, origCol, amount);
	}

	finalElevation(lake, elevation);

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
	return sum * grid.length * 12 * grid[0].length * 12;
    }

    public static void main(String[]args){
	System.out.println(USACO.bronze("makelake.1.in"));
    }


}
