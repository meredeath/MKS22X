import java.util.*;
public class MyLinkedListImproved<T> implements Iterable<T>{
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
	
	public MyLinkedListIterator(MyLinkedListImproved input){
	    L=input;
	    current=input.getStart();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}

	public T next(){
	    if(hasNext()){
		current=current.getNext();
	    }else{
		System.exit(0);
	    }
	    return current.getValue();
	}

	public boolean hasNext(){
	    return current!=L.getEnd();
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

    public Node getEnd(){
	return end;
    }

    public String toString(){
	return "["+start+
	    "]<->["+end+"], size "+size;
    }

    public void clear(){
	start=null;
	end=null;
    }

    public int size(){
	return size;
    }

    public T get(int index){
	if(index<0||index>size){
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
	if(index<0||index>size){
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
	    if(current.getValue()==value){
		return index;
	    }
	    current=current.getNext();
	    index++;
	}
	return -1;
    }

    public boolean add(T newData){
	Node newthang = new Node(newData);
	end.setNext(newthang);
	newthang.setPrev(end);
	end=newthang;
	size++;
	return true;
    }

    public void add(int index, T value){
	if(index<0||index>size){
	    throw new IndexOutOfBoundsException("your index is out of bounds! please choose a new one");
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
	size++;
    }

    public boolean remove(T value){
	Node current = start;
	int index = 0;
	while(current.getNext()!=null){
	    if(current.getValue()==value){
		current.getPrev().setNext(current.getNext());
		size--;
		return true;
	    }
	    current=current.getNext();
	    index++;
	}
	return false;
    }

    public T remove(int index){
	if(index<0||index>size){
	    throw new IndexOutOfBoundsException("your index is out of bounds! please choose a new one");
	}
	Node current = start;
	int i = index;
	while(i>0){
	    current=current.getNext();
	    index--;
	}
	current.getPrev().setNext(current.getNext());
	size--;
	return current.getValue();
    }
}
