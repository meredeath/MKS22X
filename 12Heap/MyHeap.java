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

    public int size(){
	return size;
    }

    public void resize(){
	String[] newone = new String[arr.length*2];
	for (int i=0;i<arr.length;i++){
	    newone[i]=arr[i];
	}
	arr = newone;
    }
    
    public void add(String s){
	if(arr[0]==null){
	    arr[0]=s;
	    size++;
	    return;
	}
	if(size>=arr.length){
	    resize();
	}
	int current = size;
	arr[current]=s;
	size++;
	int parent = (current-1)/2;
	pushUp(current);
    }

    public void pushDown(int cur){
	int current = cur;
	int c1 = (current*2)+1;
	int c2 = (current*2)+2;
	if(arr[c1]==null || arr[c2]==null){
	    return;
	}
	if(mode==true){
	    if(arr[current].compareTo(arr[c1])<0){
		swap(cur,c1,arr);
		pushDown(c1);
	    }else if(arr[current].compareTo(arr[c2])<0){
		swap(cur,c2,arr);
		pushDown(c2);
	    }
	}else{
	    if(arr[current].compareTo(arr[c1])>0){
		swap(cur,c1,arr);
		current=c1;
		pushDown(current);
	    }else if(arr[current].compareTo(arr[c2])>0){
		swap(cur,c2,arr);
		pushDown(c2);
	    }
	}
    }

    public void pushUp(int cur){
	int current = cur;
	if(current==0){
	    return;
	}
	int parent = (current-1)/2;
	if(mode==true){
	    if(arr[current].compareTo(arr[parent])>0){
		swap(cur,parent,arr);
		current=parent;
		pushUp(current);
	    }
	}else{
	    if(arr[current].compareTo(arr[parent])<0){
		swap(cur,parent,arr);
		current=parent;
		pushUp(current);
	    }
	}
    }

    public static void swap(int i1,int i2,String[] ar){
	String temp = ar[i1];
	ar[i1]=ar[i2];
	ar[i2]=temp;
    }

    public String peek(){
	return arr[0];
    }

    public String remove(){
	String ans = arr[0];
	arr[0]=arr[size-1];
	arr[size-1]=null;
	size--;
	pushDown(0);
	System.out.println("output: "+ans);
	return ans;
    }
}
