import java.util.*;
public class Merge{
    public static void mergesort(int[] data){
	if(data.length<1){
	    throw new IllegalArgumentException();
	}
	int[] temp = new int[data.length-1];
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[] data, int[] temp, int lo, int hi){
	if(lo>=hi){
	    return;
	}
	//System.out.println(Arrays.toString(temp));
	for(int n:data){
	    temp[n]=data[n];
	}
	//System.out.println(Arrays.toString(data));
	//System.out.println(Arrays.toString(temp));
	int mid = (hi+lo)/2;
	//msort(temp, data, lo, mid);
	//msort(temp, data, mid+1, hi);
    }
    private static void merge(int[] data, int[] temp, int hi, int mid, int lo){
	return;
    }
}
