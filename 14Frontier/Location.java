public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;
    private int steps;

    public Location(int _x, int _y, Location prev,int d,int s){
	x=_x;
	y=_y;
	prev=null;
	distance=d;
	steps=s;
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
	if(distance>other.getDist()){
	    return 1;
	}else if(distance==other.getDist()){
	    return 0;
	}else{
	    return -1;
	}
    }
}
