import java.util.Arrays.*;
import java.util.*;
public class Sorts{
    public static void main(String[] args){
        MyLinkedListImproved<Integer> alist = new MyLinkedListImproved<Integer>();
	for(int i=0;i<10;i++){
	    int temp = (int)(Math.random()*100);
	    alist.add(new Integer(temp));
	}
	System.out.println(alist);
	radixsort(alist);
	System.out.println(alist);
    }
    
    public static String name(){
	return "09.Hu.Meredith";
    }

    public static void selectionSort(int[] data){
	int minIndex=0;
	int min=0;
	for(int i=0;i<data.length;i++){
	    min=data[i];
	    for(int g=i;g<data.length;g++){
		if(data[g]<=min){
		    minIndex=g;
		    min=data[g];
		}
	    }
	    System.out.println(data[minIndex]);
	    System.out.println(min);
	    swap(data,minIndex,i);
	}
	return;
	
    }

    public static void insertionSort(int[] ary){
	int index=1;
	while(index<ary.length){
	    int j=index;
	    while(j>0 && ary[j-1]>ary[j]){
		swap(ary,j,j-1);
		j=j-1;
	    }
	    index++;
	}
    }
    public static void bogoSort(int[] ary){
	while(!isSorted(ary)){
	    for(int i=0;i<ary.length;i++){
		int temp = ary[i];
		int newSpot = (int)(Math.random()*ary.length);
		ary[i]=ary[newSpot];
		ary[newSpot]=temp;
	    }
	}
    }
    public static void bubbleSort(int[] ary){
	for(int i=0;i<ary.length;i++){
	    for(int g=0;g<ary.length-i-1;g++){
		if(ary[g]>=ary[g+1]){
		    swap(ary,g,g+1);
		}
	    }
	    if(isSorted(ary)){
		return;
	    }
	}
    }

    public static void swap(int[] ary, int a, int b){
	int temp=ary[b];
	ary[b]=ary[a];
	ary[a]=temp;
    }

    public static boolean isSorted(int[] ary){
	for(int i=0;i<ary.length-1;i++){
	    if(ary[i]>ary[i+1]){
		return false;
	    }
	}
	return true;
    }

    public static void radixsort(MyLinkedListImproved<Integer> data){
	int max = data.get(data.max());
	int d=(int)Math.log10(max);
	for(int g=1;g<d;g++){
	ArrayList<MyLinkedListImproved<Integer>> buckets = new ArrayList<>();
	for(int k=0;k<10;k++){
	    MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	    buckets.add(a);
	}
	System.out.println(buckets);
	    for(Integer i:data){
		int index = (i%(10*g))/(10*(g-1));
		buckets.get(index).add(i);
		System.out.println(buckets);
	    }
	    MyLinkedListImproved<Integer> nov = new MyLinkedListImproved<Integer>();
	    for(MyLinkedListImproved<Integer> h: buckets){
		nov.extend(h);
	    }
	    System.out.println(nov);
	    data.setStart(nov.getStart());
	    data.setEnd(nov.getEnd());
	}
    }
    
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
	radixsort(data);
    }
}
