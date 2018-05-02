import java.util.*;
public class MyHeap{
    private String[] arr;
    private boolean mode;
    private int size;
    
    public MyHeap(){
	arr=new String[10];
	size=0;
	mode=true;
    }
    public MyHeap(boolean b){
	arr=new String[10];
	size=0;
	mode=b;
    }

    public String toString(){
	if(this==null){
	    return"[]";
	}else{
	    return Arrays.toString(arr);
	}
    }

    public int getSize(){
	return size;
    }
    
    public void add(String s){
	if(arr[0]==null){
	    arr[0]=s;
	    size++;
	    return;
	}
	if(mode==true){
	    maxAdd(s);
	}else{
	    return;
	}
    }
    
    public void maxAdd(String s){
	int current = size;
	arr[current]=s;
	size++;
	int parent = (current-1)/2;
	if(arr[current].compareTo(arr[parent])>0){
	    pushUp(current);
	}
    }
    public void pushUp(int cur){
	int current = cur;
	if(current==0){
	    return;
	}
	int parent = (current-1)/2;
	if(arr[current].compareTo(arr[parent])>0){
	    swap(cur,parent,arr);
	    current=parent;
	    pushUp(current);
	}
    }

    public static void swap(int i1,int i2,String[] ar){
	String temp = ar[i1];
	ar[i1]=ar[i2];
	ar[i2]=temp;
    }
}
