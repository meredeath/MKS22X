import java.util.*;
public class QuickDriver{
    public static void main(String[] args){
	int[] a = {3, 2, 7, 8, 9, 4, 5, 0, 6, 1};
	//System.out.println(Arrays.toString(a));
	//Quick.swap(a,0,1);
	//System.out.println(Arrays.toString(a));
	//System.out.println(Quick.partition(a,0,a.length-1));
	//System.out.println(Arrays.toString(a));
	//System.out.println(Quick.partition(a,0,7));

	for(int i=0;i<a.length;i++){
	    System.out.println(Quick.quickselect(a,i));
	}
    }
}
