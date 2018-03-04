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
	for(int i=0;i<board.length;i++){
	    ans+="\n";
	    for(int g=0;g<board[0].length;g++){
		if(board[i][g]<10){
		    ans+=" "+board[i][g]+" ";
		}else{
		    ans+=board[i][g]+" ";
		}
	    }
	}
	return ans;
    }

    public boolean solve(int startingRow, int startingCol){
	if(startingRow<0 || startingCol<0){
	    throw new IllegalArgumentException("Function parameters cannot be negative");
	}
	if(startingRow>board.length-1 || startingCol>board[0].length-1){
	    throw new IllegalArgumentException("parameters specified are out of bounds of this particular board");
	}
	for(int i=0;i<board.length;i++){
	    for(int g=0;g<board[0].length;g++){
		if(board[i][g]!=0){
		    throw new IllegalStateException("board cannot start with non-zero values");
		}
	    }
	}

	return solveH(startingRow,startingCol,1);
    }
    public boolean solveH(int row, int col, int level){
	if(level==board.length*board[0].length){
	    return true;
	}
	if(move(row,col,level)){
	    if(solveH(row-2,col+1,level+1)||
	       solveH(row-2,col-1,level+1)||
	       solveH(row-1,col+2,level+1)||
	       solveH(row-1,col-2,level+1)||
	       solveH(row+2,col+1,level+1)||
	       solveH(row+2,col-1,level+1)||
	       solveH(row+1,col+2,level+1)||
	       solveH(row+1,col-2,level+1)){
		return true;
	    }else{
		board[row][col]=0;
	    }
	}
	return false;
    }

    public boolean move(int row, int col, int level){
	if(row<0 || col<0){
	    return false;
	}
	if(row>board.length-1 || col>board[0].length-1){
	    return false;
	}
	if(board[row][col]!=0){
	    return false;
	}else{
	    board[row][col]=level;
	    return true;
	}
    }
}
