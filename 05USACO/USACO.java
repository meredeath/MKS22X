import java.util.*;
import java.io.*;
public class USACO{

    public static int bronze(String filename){
	File f = new File(filename);
	if(!f.exists()){
	    throw new FileNotFoundException("hey!! your file does not exist!");
	}
	
	return 0;
    }

    public static int silver(String filename){
	return 0;
    }

    public static void main(String[] args){
    
    }
}
