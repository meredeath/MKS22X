public class MyLinkedList{
    private Node start;
    private Node end;
    private int size;
    
    private class Node{
	private int data;
	private Node next, prev;

	public Node(int data){this.data=data;}
	
	public int getValue(){return data;}
	public void setValue(int val){data=val;}
	
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
}
