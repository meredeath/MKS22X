public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	if(startingRows<0 || startingCols<0){
	    throw new IllegalArgumentException("Neither parameter can be negative");
	}
	
	board= new int[startingRows][startingCols];
	for(int i=0;i<startingRows;i++){
	    for(int g=0;g<startingCols;g++){
		board[i][g]=0;
	    }
	}
    }

    public String toString(){
	String ans="";
	for(int i=0;i<startingRows;i++){
	    ans+="\n";
	    for(int g=0;g<startingCols;g++){
		ans+=board[i][g]+" ";
	    }
	}
    }
}
