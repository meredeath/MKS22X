import java.util.*;
import java.io.*;
public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	File f = new File(filename);
	Scanner scan = new Scanner(f);
	ArrayList<String> stuff = new ArrayList<>();
	while(scan.hasNextLine()){
	    String s = scan.nextLine();
	    stuff.add(s);
	}
	//System.out.println(stuff);

	int r,c,e,n;
	String r1=stuff.get(0);
	String[] ins = r1.split(" ");
	r=Integer.parseInt(ins[0]);
	c=Integer.parseInt(ins[1]);
	e=Integer.parseInt(ins[2]);
	n=Integer.parseInt(ins[3]);
	int[][] ground= new int[r][c];
	for(int i=1;i<c+1;i++){
	    String s = stuff.get(i);
	    String[] row = s.split(" ");
	    for(int g=0;g<s.length();i++){
		ground[i][0]=Integer.parseInt(row[g]);
	    }
	}
	System.out.println(Arrays.toString(ins));
	return 0;
    }

    public static int silver(String filename){
	return 0;
    }

    public static void main(String[] args){
	try{
	    USACO.bronze("test1.txt");
	    //find ~/.mozilla/firefox -iname \"*lock\" -delete
	}catch(FileNotFoundException e){
	    System.out.println("your file does not exist!");
	    System.exit(1);
	}
    }
}
