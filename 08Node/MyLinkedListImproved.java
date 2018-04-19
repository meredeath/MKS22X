import java.util.*;
public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T>{
    private Node start;
    private Node end;
    private int size;
    
    private class Node{
	private T data;
	private Node next, prev;

	public Node(T data){this.data=data;}
	
	public T getValue(){return data;}
	public void setValue(T val){data=val;}
	
	public Node getNext(){return next;}
	public void setNext(Node n){next=n;}
	
	public Node getPrev(){return prev;}
	public void setPrev(Node p){prev=p;}
	
	public String toString(){return "Data: "+data;}
    }
    
    private class MyLinkedListIterator implements Iterator<T>{
	MyLinkedListImproved L;
	Node current = null;
	
	public MyLinkedListIterator(MyLinkedListImproved<T> input){
	    L=input;
	    current=input.getStart();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

	public T next(){
	    if(hasNext()){
		Node old = current;
		current=current.getNext();
		return old.getValue();
	    }else{
		System.exit(0);
	    }
	    return null;
	}

	public boolean hasNext(){
	    return current!=null;
	}
    }

    public Iterator<T> iterator(){
	return new MyLinkedListIterator(this);
    }

    public MyLinkedListImproved(){
	start=null;
	end=null;
	size=0;
    }

    public Node getStart(){
	return start;
    }
    public void setStart(Node other){
	start=other;
    }

    public Node getEnd(){
	return end;
    }
    public void setEnd(Node other){
	end=other;
    }

    public String toString(){
	if(end==null){
	    return "[]";
	}
	StringBuilder stringBuilder = new StringBuilder();
	Node current = start;
	while(current!=null){
	    stringBuilder.append("["+current.getValue()+"]-");
	    current=current.getNext();
	}
	return stringBuilder.toString();
    }
    
    public void clear(){
	start=null;
	end=null;
    }

    public int size(){
	return size;
    }

    public T get(int index){
	if(index<0||index>=size){
	    throw new IndexOutOfBoundsException("your index is out of bounds! please choose a new one");
	}
	Node current = start;
	while(index>0){
	    current=current.getNext();
	    index--;
	}
	return current.getValue();
    }

    public T set(int index, T value){
	if(index<0||index>=size){
	    throw new IndexOutOfBoundsException("your index is out of bounds! please choose a new one");
	}
	Node current = start;
	while(index>0){
	    current=current.getNext();
	    index--;
	}
	T old = current.getValue();
	current.setValue(value);
	return old;
    }

    public int indexOf(T value){
	Node current = start;
	int index = 0;
	while(current.getNext()!=null){
	    if(current.getValue().equals(value)){
		return index;
	    }
	    current=current.getNext();
	    index++;
	}
	return -1;
    }

    public boolean add(T newData){
	Node newthang = new Node(newData);
	if(end==null){
	    start=newthang;
	    end=newthang;
	    size++;
	    return true;
	}else{
	    end.setNext(newthang);
	    newthang.setPrev(end);
	    end=newthang;
	    size++;
	    return true;
	}
    }

    public void add(int index, T value){
	if(index<0||index>size){
	    throw new IndexOutOfBoundsException("your index is out of bounds! please choose a new one");
	}
	if(index==size){
	    Node newthang = new Node(value);
	    end.setNext(newthang);
	    newthang.setPrev(end);
	    end=newthang;
	    size++;
	    return;
	}
	int i=index;
	Node before = start;
	while(i>1){
	    before=before.getNext();
	    i--;
	};
	Node after = before.getNext();
	Node added = new Node(value);
	before.setNext(added);
	added.setNext(after);
	added.setPrev(before);
	size++;
    }

    public boolean remove(T value){
	Node current = start;
	int index = 0;
	while(current.getNext()!=null){
	    if(current.getValue().equals(value)){
		if(current==start){
		    start=current.getNext();
		}else{
		    current.getPrev().setNext(current.getNext());
		}
		size--;
		return true;
	    }
	    current=current.getNext();
	    index++;
	}
	return false;
    }

    public T remove(int index){
	if(index<0||index>=size){
	    throw new IndexOutOfBoundsException("your index is out of bounds! please choose a new one");
	}
	if(index==0){
	    T old = start.getValue();
	    start=start.getNext();
	    size--;
	    return old;
	}
	if(index==size-1){
	    //System.out.println(end);
	    T fin = end.getValue();
	    end=end.getPrev();
	    size--;
	    return fin;
	}
	Node current = start;
	int i = index;
	while(i!=0){
	    current=current.getNext();
	    i--;
	}
	T result = current.getValue();
	current.getPrev().setNext(current.getNext());
	size--;
	return result;
    }

    public int max(){
	if(size==0){
	    return -1;
	}
	T cur = start.getValue();
	int index = 0;
	int maxIndex = 0;
	for(T i:this){
	    if(i.compareTo(cur)>0){
		cur=i;
		maxIndex=index;
	    }
	    index++;
	}
	return maxIndex;
    }
    public int min(){
	if(size==0){
	    return -1;
	}
	T cur = start.getValue();
	int index = 0;
	int minIndex = 0;
	for(T i:this){
	    if(i.compareTo(cur)<0){
		cur=i;
		minIndex=index;
	    }
	    index++;
	}
	return minIndex;
    }

    public void extend(MyLinkedListImproved<T> other){
	if(other.size()==0){
	    return;
	}
	end.setNext(other.getStart());
	end=other.getEnd();
	size+=other.size();
	other.setStart(null);
	other.setEnd(null);
    }
}
