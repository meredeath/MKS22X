import java.util.*;
public class Stack{
    public LinkedList<Double> stack;
    
    public Stack(){
	stack = new LinkedList<Double>();
    }

    public void push(Double i){
	stack.push(i);
    }
    public Double pop(){
	return stack.pop();
    }
    public String toString(){
	return stack.toString();
    }
}