import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
        animate=false;

	ArrayList<char[]> things = new ArrayList<>();
	/*
	if(!new File(filename).exists()){
	    throw new FileNotFoundException("the file you inputted does not exist!");
	}
	*/
	File maz = new File(filename);
	Scanner scan = new Scanner(maz);
	while(scan.hasNextLine()){
	    String line = scan.nextLine();
	    char[] r = new char[line.length()];
	    for(int i=0;i<line.length();i++){
		r[i]=line.charAt(i);
	    }
	    things.add(r);
	}
	int countE=0;
	int countS=0;
	maze=new char[things.size()][things.get(0).length];
	for(int i=0;i<things.size();i++){
	    for(int g=0;g<things.get(0).length;g++){
		maze[i][g]=things.get(i)[g];
		if(things.get(i)[g]==('E')){
		    countE++;
		}
		if(things.get(i)[g]==('S')){
		    countS++;
		}
	    }
	}
	if(countE!=1||countS!=1){
	    throw new IllegalStateException("exception: maze can only have one start or one end");
	}
    }

    public String toString(){
	String output = "";
	for(int i=0;i<maze.length;i++){
	    for(int g=0;g<maze[0].length;g++){
		output+=maze[i][g];
	    }
	    output+="\n";
	}
	return output;
    }

    private void wait(int millis){
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



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    /*
    public int solve(){

            //find the location of the S. 


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);

    }
    */

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    */
    /*
    private int solve(int row, int col){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

        return -1; //so it compiles
    }
    */

}
