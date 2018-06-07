import java.util.*;
public class PriorityQueueFrontier implements Frontier{
    MyHeap<Location> h;
    public PriorityQueueFrontier(){
	h = new MyHeap<>(false);
    }
    public boolean hasNext(){
	return h.size()==0;
    }
    public void add(Location L){
	h.add(L);
    }
    public Location next(){
	return h.remove();
    }
}