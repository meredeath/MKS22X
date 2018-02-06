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
    
    //a tail-recursive square-rooting function that calculates to 0.001 accuracy
    public double sqrt(double n){
	if(n==0){
	    System.out.println("0 doesn't have a square root you imbecile! You nearly broke the damn function!");
	    return 0;
	}
	double guess = 1;
	guess = (n/guess + guess)/2;
	return help(n, guess);
    }

    //the helper function for the square rooting function
    public double help(double n, double guess){
	guess = (n/guess + guess)/2;
	if(guess/Math.sqrt(n)-1 < 0.001){
	    return guess;
	}
	return help(n, guess);
    }

    public static void main(String[] args){
	//making new instance of Recusion object
	Recursion a = new Recursion();

	//testing factorial
	System.out.println("factorial tests: ");
	System.out.println(a.fact(5));
	System.out.println(a.fact(0));
	System.out.println(a.fact(1));
	System.out.println(a.fact(2));
	System.out.println(a.fact(10));
	System.out.println(a.fact(20));//lmao the int overflowed
	System.out.println();

	//testing fibonacci
	System.out.println("fibonacci tests: ");
	System.out.println(a.fib(0));
	System.out.println(a.fib(1));
	System.out.println(a.fib(2));
	System.out.println(a.fib(3));
	System.out.println(a.fib(4));
	System.out.println(a.fib(5));
	System.out.println(a.fib(10));
	System.out.println();

	//testing square root
	System.out.println("square root tests: ");
	System.out.println(a.sqrt(100.0));
	System.out.println(a.sqrt(4.0));
	System.out.println(a.sqrt(1.0));
	System.out.println(a.sqrt(0.0));
	System.out.println(a.sqrt(2.0));
	System.out.println(a.sqrt(3.0));
	System.out.println(a.sqrt(5000000));
    }
}
