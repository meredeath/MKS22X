public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;
    private int steps;
    private int total;
    private boolean astar;

    public Location(int _x, int _y, Location prev,int d,int s,int tot, boolean a){
	x=_x;
	y=_y;
	prev=null;
	distance=d;
	steps=s;
	total=tot;
    }

    public int getX(){
	return x;
    }
    public int getY(){
	return y;
    }
    public Location getPrev(){
	return previous;
    }
    public int getDist(){
	return distance;
    }
    public int getSteps(){
	return steps;
    }
    public int getTotal(){
	return total;
    }

    public void setX(int xhat){
	x=xhat;
    }
    public void setY(int yhat){
	y=yhat;
    }
    public void setPrev(Location previ){
	previous=previ;
    }

    public boolean hasPrev(){
	return previous !=null;
    }

    public int compareTo(Location other){
	if(astar==false){
	    if(distance>other.getDist()){
		return 1;
	    }else if(distance==other.getDist()){
		return 0;
	    }else{
		return -1;
	    }
	}else{
	    if(total>other.getTotal()){
		return 1;
	    }else if(total==other.getTotal()){
		    return 0;
	    }else{
		return -1;
	    }
	}
    }
}
