import java.util.*;
public class DriverFrontier{
    public static void main(String[] args){
	Maze m = new Maze("maze1.txt");
	//System.out.println(m);
	MazeSolver ms = new MazeSolver("maze1.txt");
	//System.out.println(ms);
	//PriorityQueueFrontier s = new PriorityQueueFrontier();
	//Location start = m.getStart();
	//s.add(start);
	//System.out.println(s);
	//System.out.println("depth: "+ms.solve());
	//System.out.println("breadth: "+ms.solve(1));
	//System.out.println("best: "+ms.solve(2));
	//System.out.println("a-star: "+ms.solve(3));
	ms.solve(3);
	//System.out.println(ms);
    }
}