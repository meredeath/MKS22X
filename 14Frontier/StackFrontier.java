import java.util.*;
public class StackFrontier implements Frontier{
    private Stack<Location> s = new Stack<>();

    public boolean hasNext(){
	return !s.empty();
    }
    public void add(Location L){
	s.push(L);
    }

    public Location next(){
	return s.pop();
    }
}