//import java.io.*;
import java.util.*;
public class DriverMerge{
    public static void main(String[] args){
	int[] a = {4,1,5,8};
	int[] b = {4,3,2,1};
	int[] c = {1,3,5,7,2,4,6,8};
	//System.out.println(Arrays.toString(a));
	Merge.mergesort(a);
	System.out.println(Arrays.toString(a));
	Merge.mergesort(b);
	System.out.println(Arrays.toString(b));
	Merge.mergesort(c);
	System.out.println(Arrays.toString(c));
    }
}
