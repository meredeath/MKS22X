import java.util.*;
public class QueueFrontier implements Frontier{
    Queue<Location> q = new LinkedList<>();

    public boolean hasNext(){
	return !(q.size()==0);
    }
    public void add(Location L){
	q.add(L);
    }
    public Location next(){
	return q.remove();
    }
}