import java.util.*;
public class MyDeque<E>{
    private int size;
    private int front,back;
    private Object[] arr;

    public MyDeque(){
	arr=new Object[10];
	size=0;
	front=0;
	back=arr.length-1;
    }

    public MyDeque(int initialCapacity){
	if(initialCapacity<0){
	    throw new IllegalArgumentException("hey! you can't have a negative sized deque!");
	}
	arr=new Object[initialCapacity];
	size=0;
	front=0;
	back=arr.length-1;
    }
    public String toString(){
	return Arrays.toString(arr);
    }

    public int size(){
	return size;
    }

    public void resize(){
	Object[] ar = new Object[size*2];
	for(int i=0;i<=back;i++){
	    ar[i]=arr[i];
	}
	int index=0;
	if((back+size+1)<ar.length){
	    System.out.println(back+size+1);
	    System.out.println(ar.length);
	    for(int g=back+size+1;g<ar.length;g++){
		ar[g]=arr[front+index];
		index++;
	    }
	    front=back+size+1;
	}
	arr=ar;
	//System.out.println(front);
	//System.out.println(back);
    }

    @SuppressWarnings("unchecked")
    public void addFirst(E e){
	//System.out.println(front);
	//System.out.println(back);
	if(e==null){
	    throw new NullPointerException("you can't add null...");
	}
	if(size==arr.length){
	    resize();
	}
	if(front==0){
	    front=arr.length-1;
	    arr[front]=e;
	    size++;
	}else{
	    front--;
	    arr[front]=e;
	    size++;
	}
    }
    @SuppressWarnings("unchecked")
    public void addLast(E e){
	if(e==null){
	    throw new NullPointerException("you can't add null...");
	}
	if(size==arr.length){
	    resize();
	}
	if(back==arr.length-1){
	    back=0;
	    arr[0]=e;
	    size++;
	}else{
	    back++;
	    arr[back]=e;
	    size++;
	}
    }
    
    @SuppressWarnings("unchecked")
    public E removeFirst(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	E temp = (E)arr[front];
	arr[front]=null;
	if(front==arr.length-1){
	    front=0;
	}else{
	    front++;
	}
	size--;
	return temp;
    }
    @SuppressWarnings("unchecked")
    public E removeLast(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	E temp = (E)arr[back];
	arr[back]=null;
	if(back==0){
	    back=arr.length-1;
	}else{
	    back--;
	}
	size--;
	return temp;
    }

    @SuppressWarnings("unchecked")
    public E getFirst(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	return (E)arr[front];
    }
    @SuppressWarnings("unchecked")
    public E getLast(){
	if(size==0){
	    throw new NoSuchElementException("there is nothing to remove");
	}
	return (E)arr[back];
    }

    public static void main(String[] args){
	MyDeque<Integer> a = new MyDeque<>();
	System.out.println(a);
	System.out.println(a.size());
	for(int i=0;i<5;i++){
	    a.addFirst(new Integer(i));
	}
	System.out.println(a.size());
	System.out.println(a);
	for(int i=0;i<5;i++){
	    a.addLast(new Integer(i*3));
	}
	System.out.println(a.size());
	System.out.println(a);
	a.addLast(new Integer(234));
	System.out.println(a.size());
	System.out.println(a);
    }
}
