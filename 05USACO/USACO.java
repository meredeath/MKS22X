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
	if(r<3||r>100){
	    throw new IllegalArgumentException("the number of rows you have provided is not allowed");
	}
	c=Integer.parseInt(ins[1]);
	if(c<3||c>100){
	    throw new IllegalArgumentException("the number of rows you have provided is not allowed");
	}
	e=Integer.parseInt(ins[2]);
	n=Integer.parseInt(ins[3]);
	stuff.remove(0);
	//System.out.println(stuff);
	int[][] ground= new int[r][c];
	for(int i=0;i<r;i++){
	    String s = stuff.get(i);
	    String[] row = s.split(" ");
	    for(int g=0;g<row.length-1;g++){
		ground[i][g]=Integer.parseInt(row[g]);
	    }
	}
	/*
	for(int i=0;i<ground.length;i++){
	    System.out.println(Arrays.toString(ground[i]));
	}
	*/
	for(int i=0;i<ground.length;i++){
	    stuff.remove(0);
	}
	//System.out.println(stuff);
	for(int k=0;k<ground.length;k++){
	    System.out.println(Arrays.toString(ground[k]));
	}
	for(int p=0;p<stuff.size();p++){
	    String[] dir = stuff.get(0).split(" ");
	    int R_s = Integer.parseInt(dir[0]);
	    if(R_s<1||R_s>r-2){
		throw new IllegalArgumentException("row coordinate of directions is wrong");
	    }
	    int C_s = Integer.parseInt(dir[1]);
	    if(C_s<1||C_s>c-2){
		throw new IllegalArgumentException("column coordinate of directions is wrong");
	    }
	    int D_s = Integer.parseInt(dir[2]);
	    if(D_s<1||D_s>40){
		throw new IllegalArgumentException("depth direction is wrong");
	    }
	    stomp(ground, R_s, C_s, D_s);
	    stuff.remove(0);
	    for(int i=0;i<ground.length;i++){
		System.out.println(Arrays.toString(ground[i]));
	    }
	}
	return 0;
    }

    private static void stomp(int[][] lake, int r, int c, int d){
	int row = r-1;
	int col = c-1;
	int maxr = row;
	int maxc = col;
	for(int i=0;i<3;i++){
	    for(int g=0;g<3;g++){
		if(lake[i][g]>lake[maxr][maxc]){
		    maxr=i;
		    maxc=g;
		}
	    }
	}
	int fin = lake[maxr][maxc]-d;
	for(int i=r;i<r+3;i++){
	    for(int g=c;g<c+3;g++){
		if(lake[i][g]>=fin){
		    lake[i][g]=fin;
		}
	    }
	}
	//System.out.println(lake[maxr][maxc]);
	return;
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
