import java.util.*;
public class RunningMedian{
    public int minSize;
    public int maxSize;
    public MyHeap<Double> smside, lgside;
    
    //constructs a running median
    public RunningMedian(){
	smside = new MyHeap<>();
	lgside = new MyHeap<>(false);
    }

    //gets the median of this data structure
    public double getMedian(){
	if(size()==0){
	    throw new NoSuchElementException("no data, no median :(");
	}
	if(smside.size()>lgside.size()){
	    return smside.peek();
	}
	if(lgside.size()>smside.size()){
	    return lgside.size();
	}
	return (smside.peek()+lgside.peek())/2;
    }

    //add to the data
    public void add(double i){
	if(size()==0){
	    smside.add(i);
	}
	if(size()==1){
	    if(i>smside.peek()){
		lgside.add(i);
	    }else{
		lgside.add(smside.peek());
		smside.add(i);
	    }
	}
	if(i<smside.peek()){
	    smside.add(i);
	}
	if(i>lgside.peek()){
	    lgside.add(i);
	}
	rebalance();
    }
    public void rebalance(){
	if(smside.size()-lgside.size()==2){
	    lgside.add(smside.remove());
	}
	if(lgside.size()-smside.size()==2){
	    smside.add(lgside.remove());
	}
    }

    //returns the size of the data so far
    public int size(){
	return smside.size()+lgside.size();
    }

    public String toString(){
	return smside +"-"+ lgside;
    }

    public static void main(String[] args){
	RunningMedian a = new RunningMedian();
	for(int i=0;i<20;i++){
	    double temp = Math.random()*100;
	    a.add(temp);
	}
	System.out.println(a);
	System.out.println(a.getMedian());
	System.out.println(a.size());
    }
}
