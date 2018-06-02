import java.util.*;
public class Sorts{
    public static void main(String[] args){
	System.out.println("Testing heapsort======================================");
	int[] a = new int[10];
	for(int i=0;i<10;i++){
	    int temp=(int)(Math.random()*100);
	    a[i]=temp;
	}
	System.out.println(Arrays.toString(a));
	Sorts.heapsort(a);
	System.out.println(Arrays.toString(a));
    }
    public static void heapify(int[] a, int lim){
	for(int i=lim;i>=0;i--){
	    pushDown(i,a,lim);
	}
    }
    
    public static void heapsort(int[] arr){
	Sorts.heapify(arr,arr.length-1);
	int[] sorted = new int[arr.length];
	int lim = arr.length-1;
	int lim2=arr.length;
	for(int i=0;i<arr.length;i++){
	    sorted[i]=Sorts.remove(arr,lim2-1);
	    lim2--;
	    heapify(arr,lim);
	    lim--;
	}
	for(int i=0;i<arr.length;i++){
	    arr[i]=sorted[i];
	}
    }
    public static int remove(int[] arr,int end){
	int fin = arr[0];
	arr[0]=arr[end];
	arr[end]=0;
	return fin;
    }

    public static void pushDown(int cur,int[] arr,int lim){
	int current = cur;
	int c1 = (current*2)+1;
	int c2 = (current*2)+2;
	if(c2<lim && arr[c2]<arr[c1] && arr[c2]<arr[current]){
	    swap(current,c2,arr);
	    pushDown(c2,arr,lim);
	}else if(c1<lim && arr[c1]<arr[current]){
	    swap(current,c1,arr);
	    pushDown(c1,arr,lim);
	}else{
	    return;
	}
    }
    public static void swap(int i1, int i2, int[] ar){
	int temp = ar[i1];
	ar[i1]=ar[i2];
	ar[i2]=temp;
    }
}
