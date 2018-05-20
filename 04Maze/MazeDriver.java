import java.io.*;
public class MazeDriver{

    public static void main(String[]args){
	try{
	    Maze f = new Maze("data3.dat");
	    System.out.println(f);

	    f.setAnimate(true);
	    System.out.println(f.solve());
	    System.out.println(f);
	}catch(FileNotFoundException e){
	    System.out.println("your file does not exist!");
	    System.exit(1);
	}
    }
}
