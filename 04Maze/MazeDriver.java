public class MazeDriver{

    public static void main(String[]args){
        Maze f;
        f = new Maze("mazetest.txt");//true animates the maze.

	/*
        f.setAnimate(true);
        f.solve();
	*/
	
        System.out.println(f);
    }
}
