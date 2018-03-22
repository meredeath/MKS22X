import java.util.*;
public class Merge{
    public static void mergesort(int[] data){
	if(data.length<1){
	    throw new IllegalArgumentException();
	}
	int[] temp = new int[data.length];
	for(int i=0;i<data.length;i++){
	    temp[i]=data[i];
	}
	msort(data,temp,0,data.length-1);
    }
    private static void msort(int[] data, int[] temp, int lo, int hi){
	if(lo>=hi){
	    return;
	}	
	//System.out.println(Arrays.toString(temp));
	//System.out.println(Arrays.toString(data));
	//System.out.println(Arrays.toString(temp));
	int mid = (hi+lo)/2;
	msort(temp, data, lo, mid);
	msort(temp, data, mid+1, hi);
	merge(data, temp, lo, mid, hi);
    }
    private static void merge(int[] data, int[] temp, int lo, int mid, int hi){
	int i1=lo;
	int i2=mid+1;
	int index = lo;
	/*
	//hardcoded other cases in previous version
	if(i1==i2){
	    return;
	}
	if(i2-i1==1){
	    if(temp[i1]<=temp[i1+1]){
		data[index]=temp[i1];
		data[index+1]=temp[i1+1];
		System.out.println(Arrays.toString(data));
		return;
	    }else{
		data[index]=temp[i1+1];
		data[index+1]=temp[i1];
		System.out.println(Arrays.toString(data));
		return;
	    }
	}
	*/
	while(i1<=mid || i2<=hi){
	    if(i1>mid){
		data[index]=temp[i2];
		i2++;
	    }else if(i2>hi){
		data[index]=temp[i1];
		i1++;
	    }else if(temp[i1]<=temp[i2]){
		data[index]=temp[i1];
		i1++;
	    }else{
		data[index]=temp[i2];
		i2++;
	    }
	    index++;
	}
    }
}
