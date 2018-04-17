public class ImprovedDriver{
    public static void main(String[] args){
	MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
	for(int i=0;i<10;i++){
	    a.add(Integer.valueOf(i));
	}
	System.out.println(a);
	for(Integer i: a){
	    System.out.println(i);
	}
	System.out.println(a);
	System.out.println(a.min());
	System.out.println(a.max());

	MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
	for(int i=0;i<10;i+=2){
	    b.add(Integer.valueOf(i));
	}
	System.out.println(b);
	a.extend(b);
	System.out.println(a);
	System.out.println(b);
    }
}