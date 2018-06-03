import java.util.*;
public class Calculator{
    private static Stack st = new Stack();
    public static double eval(String a){
	double ans = 0.0;
	String[] tokens = a.split(" ");
	System.out.println(Arrays.toString(tokens));
	char[] ops = {'+','-','*','/','%'};
	for(String s:tokens){
	    for(int i=0;i<ops.length;i++){
		if(s.charAt(0)==ops[i]){
		    double d1=st.pop();
		    double d2=st.pop();
		    st.push(solve(d1,d2,i));
		    System.out.println(st);
		}
	    }
	    st.push(Double.parseDouble(s));
	}
	return st.pop();
    }

    public static double solve(double first, double second, int index){
	if(index==0){
	    return first+second;
	}else if(index==1){
	    return first-second;
	}else if(index==2){
	    return first*second;
	}else if(index==3){
	    return first/second;
	}else{
	    return first%second;
	}
    }

    public static void main(String[] args){
	Calculator c = new Calculator();
	c.eval("10 2.0 +");
	c.eval("11 3 - 4 + 2.5 *");
    }
}
