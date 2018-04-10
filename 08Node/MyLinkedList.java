public class MyLinkedList{
    private Node start;
    private Node end;
    private int size;
    
    private class Node{
	private Integer data;
	private Node next, prev;

	public Node(Integer data){this.data=data;}
	
	public int getValue(){return data;}
	public void setValue(Integer val){data=val;}
	
	public Node getNext(){return next;}
	public void setNext(Node n){next=n;}
	
	public Node getPrev(){return prev;}
	public void setPrev(Node p){prev=p;}
	
	public String toString(){return "Data: "+data;}
    }

    public MyLinkedList(){
	start=null;
	end=null;
	size=0;
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

    public Integer get(int index){
	Node current = start;
	while(index>0){
	    current=current.getNext();
	    index--;
	}
	return current.getValue();
    }

    public Integer set(int index, Integer value){
	Node current = start;
	while(index>0){
	    current=current.getNext();
	    index--;
	}
	Integer old = current.getValue();
	current.setValue(value);
	return old;
    }

    public int indexOf(Integer value){
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

    public boolean add(Integer newData){
	Node newthang = new Node(newData);
	end.setNext(newthang);
	end=newthang;
	return true;
    }

    public void add(int index, Integer value){}
}
