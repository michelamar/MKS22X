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
	Scanner header = new Scanner(scan.nextLine());
	int rows = header.nextInt();
	int cols = header.nextInt();
	time = header.nextInt();

	pasture = new int[rows][cols];
	int[][]pastureTemp = new int[rows][cols];

	for (int r = 0; r < rows; r++){
	    String row = scan.nextLine();
	    for (int c = 0; c < cols; c++){
		if(row.charAt(c) == '*'){
		    pasture[r][c]= -1;
		}
		else{
		    pasture[r][c] = 0;
		}
	    }
	}
	//System.out.println(stringOf(pasture));

	Scanner startAndEnd = new Scanner(scan.nextLine());
	r1 = startAndEnd.nextInt()-1;
	c1 = startAndEnd.nextInt()-1;
	r2 = startAndEnd.nextInt()-1;
	c2 = startAndEnd.nextInt()-1;

	pasture[r1][c1] = 1;

	for (int seconds = 0; seconds < time; seconds++){
	    adjustPaths(pasture, pastureTemp);
	    //System.out.println(stringOf(pasture));
	}

	return pasture[r2][c2];
	
    }

    private static void adjustPaths(int[][] pasture, int[][] pastureTemp){
	for(int r=0; r<pastureTemp.length; r++){
	    for(int c=0; c<pastureTemp[0].length; c++){
		if(pasture[r][c]==-1){
		    pastureTemp[r][c]=-1;
		}else{
		    int up;
		    int down;
		    int left;
		    int right;
		    if(r-1<0 || pasture[r-1][c] == -1){
			up = 0;
		    }else{
			up = pasture[r-1][c];
		    }
		    if(r+1>=pasture.length || pasture[r + 1][c] == -1){
			down = 0;
		    }else{
			down = pasture[r+1][c];
		    }
		    if(c-1<0 || pasture[r][c-1] == -1){
			left = 0;
		    }else{
			left = pasture[r][c-1];
		    }
		    if(c+1 >= pasture[0].length || pasture[r][c+1] == -1){
			right = 0;
		    }else{
			right = pasture[r][c+1];
		    }
		    pastureTemp[r][c]=up+down+left+right;
		}
	    }
	}
	for(int r=0; r<pasture.length; r++){
	    for(int c=0; c<pasture[0].length; c++){
		pasture[r][c]=pastureTemp[r][c];
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
