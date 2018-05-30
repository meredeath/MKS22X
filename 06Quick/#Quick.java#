import java.util.*;
public class Quick{
    public static int partition(int[] data, int start, int end){
	//select a random pivot
	int pi = (int)(Math.random() * (end - start) + start);
	int v = data[pi];

	//move the pivot to the front
	swap(data,start,pi);

	//swap sides around pivot
	//when small and large pass each other, stop
	int i=start+1;
	while(i<=end){
	    if(data[i]<v){
		swap(data,i,start);
		start++;
		i++;
	    }else if(data[i]>v){
		swap(data,i,end);
		end--;
	    }else{
		i++;
	    }
	}
	return end;
    }

    public static int quickselect(int[] data, int k){
	//return the value that is the kth smallest value of the array. 
	//use your partition method to help you accomplish this.
	return quickselect(data,0,data.length-1,k);
    }
    public static int quickselect(int[] data, int start, int end, int k){
	int piv = partition(data,start,end);
	if(piv==k){
	    return data[piv];
	}else if(piv>k){
	    return quickselect(data,start,piv-1,k);
	}else{
	    return quickselect(data,piv+1,end,k);
	}
    }

    public static void quicksort(int[] ary){
	quickhelp(ary,0,ary.length-1);
    }
    public static void quickhelp(int[] data, int start, int end){
	if(start>=end){
	    return;
	}
	int piv = partition(data,start,end);
	quickhelp(data,start,piv-1);
	quickhelp(data,piv+1,end);
    }

    //checks if array is sorted
    public static boolean isSorted(int[] ary){
	for(int i=0;i<ary.length-2;i++){
	    if(ary[i]>ary[i+1]){
		return false;
	    }
	}
	return true;
    }

    public static void swap(int[] data, int i, int j){
	int temp=data[i];
	data[i]=data[j];
	data[j]=temp;
    }

}
