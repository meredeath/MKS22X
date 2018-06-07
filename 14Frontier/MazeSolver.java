public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    private boolean astar;
    
    public MazeSolver(String mazeText){
	animate=false;
	astar=false;
	maze = new Maze(mazeText);
    }
    
    //Default to BFS
    public boolean solve(){ return solve(0); }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    //2: Best-First Search
    //3: A-Star Search
    public boolean solve(int mode){
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	if(mode==0){
	    frontier = new QueueFrontier();
	}else if(mode==1){
	    frontier=new StackFrontier();
	}else if (mode==2){
	    frontier = new PriorityQueueFrontier();
	}else{
	    frontier = new PriorityQueueFrontier();
	    astar=true;
	}
	boolean done = false;
	frontier.add(maze.getStart());
	while(!done && !frontier.hasNext()){
	    Location cur = frontier.next();
	    maze.set(cur.getX(),cur.getY(),'.');
	    Location[] neighbors = maze.getNeighbors(cur,astar);
	    for(int i=0;i<neighbors.length;i++){
		if(neighbors[i]!=null){
		    if(maze.get(neighbors[i].getX(),neighbors[i].getY())=='E'){
			Location path = neighbors[i];
			while(path.hasPrev()){
			    path = path.getPrev();
			    maze.set(path.getX(),path.getY(),'@');
			}
			done=true;
			return true;
		    }else{
			frontier.add(neighbors[i]);
			maze.set(neighbors[i].getX(),neighbors[i].getY(),'*');
		    }
		}
	    }
	    if(animate){
		System.out.println(maze.toStringColor());
	    }
	}
	return false;
    }

    public void setAStar(boolean b){
	astar=b;
    }

    public String toString(){
	return maze.toString();
    }
}
