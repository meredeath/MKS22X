import java.util.*;
public class Calculator{
    private static Stack st = new Stack();
    public static double eval(String a){
	double ans = 0.0;
	String[] tokens = a.split(" ");
	char[] ops = {'+','-','*','/','%'};
	boolean op = false;
	for(String s:tokens){
	    op=false;
	    for(int i=0;i<ops.length;i++){
		if(s.charAt(0)==ops[i]){
		    op=true;
		    double d1=st.pop();
		    double d2=st.pop();
		    st.push(solve(d2,d1,i));
		}
	    }
	    if(op==false){
		st.push(Double.parseDouble(s));
	    }
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
	c.eval("8 2 + 99 9 - * 2 + 9 -");
    }
}
