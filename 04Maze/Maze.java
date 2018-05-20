import java.util.*;
import java.io.*;
public class Maze{

    private char[][]maze;
    private boolean animate;//false by default
    private int step;

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
    public int solve(){

	//find the location of the S.
	int sr=0;
	int sc=0;
	for(int i=0;i<maze.length;i++){
	    for(int g=0;g<maze[0].length;g++){
		if(maze[i][g]=='S'){
		    sr=i;
		    sc=g;
		}
	    }
	}
	
	//erase the S
	maze[sr][sc]='@';

	//and start solving at the location of the s.
	if(solve(sr,sc,0)){
	    return step;
	}else{
	    return -1;
	}
    }

    private boolean solve(int row, int col, int steps){
	if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
	if(maze[row][col]=='E'){
	    step=steps;
	    return true;
	}
	int[][] coors = {{-1,0},{0,1},{1,0},{0,-1}};
	for(int i=0;i<4;i++){
	    if(canMove(row+coors[i][0],col+coors[i][1])){
		maze[row+coors[i][0]][col+coors[i][1]]='@';
		return solve(row+coors[i][0],col+coors[i][1],steps+1);
	    }else{
		maze[row][col]='.';
	    }
	}
	return false;
    }

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
    private int solve(int row, int col){
	int len = 0;
        if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
	if(maze[row][col]=='E'){
	    return len;
	}else{
	    maze[row][col]='@';
	}
	int[][] coors = {{-1,0},{0,1},{1,0},{0,-1}};
        //COMPLETE SOLVE
	for(int i=0;i<4;i++){
	    if(canMove(row+coors[i][0],col+coors[i][1])){
		if(solve(row+coors[i][0],col+coors[i][1])>0){
		    len++;
		    return solve(row+coors[i][0],col+coors[i][1]);
		}
	    }
	}
	maze[row][col]='.';
        return -1;
    }
    */

    private boolean canMove(int row, int col){
	if(row<1||col<1){
	    return false;
	}
	if(row>maze.length-2||col>maze[0].length-2){
	    return false;
	}
	if(maze[row][col]==' '){
	    return true;
	}
	return false;
    }
}
