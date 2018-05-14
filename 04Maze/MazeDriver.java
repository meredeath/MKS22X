import java.io.*;
public class MazeDriver{

    public static void main(String[]args){
	try{
	    Maze f = new Maze("Maze1.txt");
	    System.out.println(f);
	}catch(FileNotFoundException e){
	    System.out.println("your file does not exist!");
	    System.exit(1);
	}
    }
}
