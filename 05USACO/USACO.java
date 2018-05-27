import java.util.*;
import java.io.*;
import java.lang.*;
public class USACO{

    public static int bronze(String filename) throws FileNotFoundException{
	//scanning in the file into an ArrayList of Strings, with every line corresponding to an element in the ArrayList
	File f = new File(filename);
	Scanner scan = new Scanner(f);
	ArrayList<String> stuff = new ArrayList<>();
	while(scan.hasNextLine()){
	    String s = scan.nextLine();
	    stuff.add(s);
	}

	//making variables for the row number, column number, final elevation and number of directions
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
	//removing the vars from the ArrayList, now that we have extracted the data we need
	stuff.remove(0);

	//parsing the data for the actual lake
	int[][] ground= new int[r][c];
	for(int i=0;i<r;i++){
	    String s = stuff.get(i);
	    String[] row = s.split(" ");
	    for(int g=0;g<row.length;g++){
		ground[i][g]=Integer.parseInt(row[g]);
	    }
	}
	//removing the strings that were part of the lake
	for(int i=0;i<ground.length;i++){
	    stuff.remove(0);
	}

	//parsing data of directions to stomp lake
	for(int p=0;p<n;p++){
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

	    //calling function to do the stomping
	    //for loop calls the function for every direction that is given
	    stomp(ground, R_s, C_s, D_s);
	    stuff.remove(0);
	}

	//finding total aggregated depths
	int total = 0;
	for(int i=0;i<ground.length;i++){
	    for(int g=0;g<ground[0].length;g++){
		if(ground[i][g]<=e){
		    total+=(e-ground[i][g]);
		}
	    }
	}
	return total*72*72;
    }

    //this function stomps the lake at the row, column and depth you give it
    private static void stomp(int[][] lake, int r, int c, int d){
	int row = r-1;
	int col = c-1;
	int maxr = row;
	int maxc = col;
	int rbound = Math.min(row+3,lake.length);
	int cbound = Math.min(col+3,lake[0].length);
	//get the highest elevation first
	for(int i=row;i<rbound;i++){
	    for(int g=col;g<cbound;g++){
		if(lake[i][g]>lake[maxr][maxc]){
		    maxr=i;
		    maxc=g;
		}
	    }
	}
	//stomp to what elevation?
	int fin = lake[maxr][maxc]-d;
	//actually get your stomp on
	for(int i=row;i<rbound;i++){
	    for(int g=col;g<cbound;g++){
		if(lake[i][g]>=fin){
		    lake[i][g]=fin;
		}
	    }
	}
    }
    
    public static int silver(String filename) throws FileNotFoundException{
	//http://tjsct.wikidot.com/usaco-mar08-silver
	
	//scanning in the file into an ArrayList of Strings, with every line corresponding to an element in the ArrayList
	File f = new File(filename);
	Scanner scan = new Scanner(f);
	ArrayList<String> stuff = new ArrayList<>();
	while(scan.hasNextLine()){
	    String s = scan.nextLine();
	    stuff.add(s);
	}

	//making variables for the row number, column number, final elevation and number of directions
	int n,m,t;
	String r1=stuff.get(0);
	String[] ins = r1.split(" ");
	n=Integer.parseInt(ins[0]);
	if(n<2||n>100){
	    throw new IllegalArgumentException("the number of rows you have provided is not allowed");
	}
	m=Integer.parseInt(ins[1]);
	if(m<3||m>100){
	    throw new IllegalArgumentException("the number of rows you have provided is not allowed");
	}
	t=Integer.parseInt(ins[2]);

	//removing the vars from the ArrayList, now that we have extracted the data we need
	stuff.remove(0);

	//System.out.println(stuff);
	//parsing the data for the actual map
	char[][] ground= new char[n][m];
	for(int i=0;i<n;i++){
	    String s = stuff.get(i);
	    for(int g=0;g<s.length();g++){
		ground[i][g]=s.charAt(g);
	    }
	}

	//removing the strings that were part of the map
	for(int i=0;i<ground.length;i++){
	    stuff.remove(0);
	}

	//parsing data of R1,C1 and R2,C2
	String[] dir = stuff.get(0).split(" ");
	int R1 = Integer.parseInt(dir[0]);
	if(R1<0||R1>n){
	    throw new IllegalArgumentException("R1 is invalid!");
	}
	int C1 = Integer.parseInt(dir[1]);
	if(C1<0||C1>m){
	    throw new IllegalArgumentException("C1 is invalid!");
	}
	int R2 = Integer.parseInt(dir[2]);
	if(R2<0||R2>n){
	    throw new IllegalArgumentException("R2 is invalid!");
	}
	int C2 = Integer.parseInt(dir[3]);
	if(C2<0||C2>m){
	    throw new IllegalArgumentException("C2 is invalid!");
	}

	//actually doing it
	int sols=0; //total solutions
	return solve(ground,R1,C1,R2,C2,0,t);
    }
    private static int solve(char[][] map, int row, int col, int frow, int fcol, int steps, int time){
	int sols=0;
	if(steps>time){
	    return 0;
	}
	int[][] coors = {{-1,0},{0,1},{1,0},{0,-1}};
	for(int i=0;i<4;i++){
	    if(canMove(row-1+coors[i][0],col-1+coors[i][1],map)){
		if(row+coors[i][0]==frow&&col+coors[i][1]==fcol){
		    if(steps==time){
			return 1;
		    }else{
			return 0;
		    }
		}else{
		    map[row][col]='#';
		    sols+=solve(map,row+coors[i][0],col+coors[i][1],frow,fcol,steps+1,time);
		}
	    }
	}
	map[row][col]='#';
	return 0;
    }

    private static boolean canMove(int row, int col,char[][] map){
	if(row<1||col<1){
	    return false;
	}
	if(row>map.length-1||col>map[0].length-1){
	    return false;
	}
	if(map[row][col]=='.'){
	    return true;
	}
	return false;
    }

    public static void main(String[] args){
	try{
	    //System.out.println(USACO.bronze("test1.txt"));
	    //find ~/.mozilla/firefox -iname \"*lock\" -delete
	    USACO.silver("silvertest.txt");
	}catch(FileNotFoundException e){
	    System.out.println("your file does not exist!");
	    System.exit(1);
	}
    }
}
