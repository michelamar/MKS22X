import java.util.*;
import java.io.*;

public class Maze{


    private char[][]maze;
    private boolean animate;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
        int scount = 0;
	int ecount = 0;
        try{
	    int count = 0;
	    String line = "";
	    Scanner sc = new Scanner(new File(filename));
	    while (sc.hasNextLine()){
		line = sc.nextLine();
		count++;
	    }
	    maze = new char[count][line.length()];
	    Scanner sc1 = new Scanner(new File(filename));
	    for(int r = 0; r < count; r++){
		String currentLine = sc1.nextLine();
		for(int c = 0; c < currentLine.length(); c++){
		    maze[r][c] = currentLine.charAt(c);
	   	}
	    }
	}catch (FileNotFoundException e){
	    System.out.println ("Invalid file name or path");
	    System.exit(1);
	}
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		if (maze[r][c] == 'S'){
		    scount++;
		}
		if (maze[r][c] == 'E'){
		    ecount++;
		}
	    }
	}
	if (ecount != 1 || scount != 1){
	    System.out.println("Maze does not have one S and one E");
	    System.exit(0);
    	}
    }
    

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 

            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solve(startr,startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

        //COMPLETE SOLVE

        return false; //so it compiles
    }

    public String toString(){
	String output = "";
	for(int r = 0; r < maze.length; r++){
	    for(int c = 0; c < maze[0].length; c++){
		output+=maze[r][c];
	    }
	output+="\n";
	}	
	return output;
    }

    public static void main(String[]args){
	Maze a = new Maze("test.txt");
	System.out.println(a);
    }


}
