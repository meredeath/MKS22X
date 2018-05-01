import java.util.*;
public class HeapDriver{
    public static void main(String[] args){
	System.out.println("Testing swap================================");
	String[] a = new String[10];
	for(int i=0;i<10;i++){
	    a[i]=i+"";
	}
	System.out.println(Arrays.toString(a));
	MyHeap.swap(0,5,a);
	System.out.println(Arrays.toString(a)+"\n");

	System.out.println("Testing add===================================");
	MyHeap b = new MyHeap(true);
	System.out.println(b);
	b.add("Pizza");
	System.out.println(b.getSize());
	System.out.println(b);
	b.add("Action");
	System.out.println(b);
    }
}
