import java.util.*;
public class MyDeque<E>{
    private int size;
    private int front,back;
    private E[] arr;

    @SuppressWarnings("unchecked")
    public MyDeque(){
	size=0;
	front=0;
	back=9;
	arr= new Object[10];
    }

    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity<0){
	    throw new IllegalArgumentException("hey! you can't have a negative sized deque!");
	}
	size=0;
	front=0;
	back=initialCapacity-1;
	arr=new Object[initialCapacity];
    }

    public int size(){
	return size;
    }

    public void resize(){
	Object[] ar = new Object[size*2];
	for(int i=start;i<arr.length;i++){
	    ar[i]=i;
	} 
    }

    public void addFirst(E e){
	if(e==null){
	    throw new NullPointerException("you can't add null...");
	}
    }
    public void addLast(E e){
	if(e==null){
	    throw new NullPointerException("you can't add null...");
	}
    }
    
    public E removeFirst(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	return arr[0];
    }
    public E removeLast(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	return arr[0];
    }

    public E getFirst(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	return arr[0];
    }
    public E getLast(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	return arr[0];
    }
}
