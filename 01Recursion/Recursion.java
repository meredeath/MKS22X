public class Recursion{

    //a function that calculates factorial, recursively. (except no one would ever do that while while loops still exist.
    public int fact(int n){
	if(n==0){
	    return 1;
	}
	return n * fact(n-1);
    }

    //a function that calculates a number in the fibonacci sequence whose index in the sequence is n, in linear time
    public int fib(int n){
	int fib1 = 0;
	int fib2 = 1;
	int sum = 0;
	while(n>1){
	    if(n==0){
		sum=0;
		n--;
	    }
	    if(n==1){
		sum=1;
		n--;
	    }
	    sum = fib1+fib2;
	    int temp = fib1;
	    fib1 = fib2;
	    fib2 = temp + fib1;
	    n--;
	}
	return sum;
    }
    
    /*
    public double sqrt(double n){
    }
    */

    public static void main(String[] args){
	Recursion a = new Recursion();
	System.out.println(a.fact(5));
	System.out.println(a.fib(0));
	System.out.println(a.fib(1));
	System.out.println(a.fib(2));
	System.out.println(a.fib(3));
	System.out.println(a.fib(4));
	System.out.println(a.fib(5));
	System.out.println(a.fib(10));
    }
}
