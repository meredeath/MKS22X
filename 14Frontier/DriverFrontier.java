import java.util.*;
public class DriverFrontier{
    public static void main(String[] args){
	Maze m = new Maze("maze1.txt");
	System.out.println(m);
	MazeSolver ms = new MazeSolver("maze1.txt");
	System.out.println(ms);
	System.out.println(ms.solve(3));
	System.out.println(ms);
    }
}