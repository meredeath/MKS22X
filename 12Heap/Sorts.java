public class Sorts{
    public static void main(String[] args){
	System.out.println("Testing heapsort======================================");
	int[] a = new int[10];
	for(int i=0;i<10;i++){
	    int temp=(int)(Math.random()*100);
	    a[i]=temp;
	}
	System.out.println(a);
	for(int k=0;k<a.length;k++){
	    Sorts.pushDown(k,a);
	}
	System.out.println(a);
    }
    public void heapify(int[] a){
	
    }
    
    public static void heapsort(String[] arr){
	return;
    }
    public static void pushDown(int cur,int[] arr){
	int current = cur;
	int c1 = (current*2)+1;
	int c2 = (current*2)+2;
	if(arr[c1]==0 && arr[c1]==0){
	    return;
	}else{
	    if(c1<arr.length && arr[current]>arr[c1]){
		swap(current,c1,arr);
		pushDown(c1,arr);
	    }else if(c2<arr.length && arr[current]>arr[c2]){
		swap(current,c2,arr);
		pushDown(c2,arr);
	    }
	}
    }
    public static void swap(int i1, int i2, int[] ar){
	int temp = ar[i1];
	ar[i1]=ar[i2];
	ar[i2]=temp;
    }
}
