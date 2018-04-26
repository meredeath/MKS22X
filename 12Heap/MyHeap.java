import java.util.*;
public class MyHeap{
    private String[] arr;
    private boolean mode;
    private int size;
    
    public MyHeap(){
	arr=new String[10];
	size=10;
	mode=true;
    }
    public MyHeap(boolean b){
	arr=new String[10];
	size=10;
	mode=b;
    }

    public String toString(){
	if(this==null){
	    return"[]";
	}else{
	    return Arrays.toString(arr);
	}
    }
    
    public void add(String s){
	if(arr[0]==null){
	    arr[0]=s;
	    return;
	}else{
	    return;
	}
    }
    public void maxAdd(String s){
	/*
	int current = 0;
	while(arr[current]!=null){
	    current++;
	}
	int parent=(current-1)/2;
	if(arr[current]>arr[parent]){
	    swap(current,parent,arr);
	}
	*/	
    }

    public static void swap(int i1,int i2,String[] ar){
	String temp = ar[i1];
	ar[i1]=ar[i2];
	ar[i2]=temp;
    }
}
