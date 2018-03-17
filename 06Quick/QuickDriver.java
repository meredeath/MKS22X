public class QuickDriver{
    public static void main(String[] args){
	int[] a = {3, 2, 7, 8, 9, 4, 5, 0, 6, 1};
	Quick.swap(a,0,1);
	System.out.println(a[0]);
	System.out.println(a[1]);
	//System.out.println(Quick.partition(a,0,a.length-1));
    }
}
