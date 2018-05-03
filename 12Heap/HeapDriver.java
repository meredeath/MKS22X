import java.util.*;
public class HeapDriver{
    public static void main(String[] args){
	System.out.println("Testing swap================================");
	String[] c = new String[10];
	for(int i=0;i<10;i++){
	    c[i]=i+"";
	}
	System.out.println(Arrays.toString(c));
	MyHeap.swap(0,5,c);
	System.out.println(Arrays.toString(c)+"\n");

	System.out.println("Testing maxAdd===================================");
	MyHeap b = new MyHeap(true);
	b.add("a");
	b.add("b");
	System.out.println(b);
	b.add("x");
	System.out.println(b);
	b.add("c");
	System.out.println(b);
	b.add("d");
	System.out.println(b);
	b.add("e");
	System.out.println(b);
	b.add("f");
	System.out.println(b);
	b.add("g");
	System.out.println(b);

	System.out.println("\nTesting minAdd===================================");
	MyHeap a = new MyHeap(false);
	a.add("a");
	a.add("b");
	System.out.println(a);
	a.add("x");
	System.out.println(a);
	a.add("c");
	System.out.println(a);
	a.add("d");
	System.out.println(a);
	a.add("e");
	System.out.println(a);
	a.add("f");
	System.out.println(a);
	a.add("g");
	System.out.println(a);

	System.out.println("\nTesting remove===================================");
	/*
	System.out.println(b);
	System.out.println(b.remove());
	System.out.println(b);
	System.out.println(b.remove());
	System.out.println(b);
	System.out.println(b.remove());
	System.out.println(b);
	System.out.println(b.remove());
	System.out.println(b);
	System.out.println(b.remove());
	System.out.println(b);
	*/

	System.out.println(a);
	System.out.println(a.remove());
	System.out.println(a);
	System.out.println(a.remove());
	System.out.println(a);
	System.out.println(a.remove());
	System.out.println(a);
	System.out.println(a.remove());
	System.out.println(a);
	System.out.println(a.remove());
	System.out.println(a);
    }
}
