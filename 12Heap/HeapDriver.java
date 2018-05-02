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
	//System.out.println("Pizza".compareTo("Action"));
	MyHeap b = new MyHeap(true);
	//System.out.println(b);
	b.add("a");
	//System.out.println(b.getSize());
	//System.out.println(b);
	b.add("b");
	System.out.println(b);
	//System.out.println(b.getSize());
	b.add("x");
	System.out.println(b);
	//b.add("a");
	//System.out.println(b);
	//b.add("c");
	//System.out.println(b);
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
    }
}
