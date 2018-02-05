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
	
	int sum = 0;
	while(n>0){
	    if(n==0){
		return 0;
	    }
	    if(n==1){
		return 
    
    /*
    public double sqrt(double n){
    }
    */

    public static void main(String[] args){
	Recursion a = new Recursion();
	System.out.println(a.fact(5));
    }
}