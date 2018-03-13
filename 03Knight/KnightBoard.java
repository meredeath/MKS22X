public class KnightBoard{
    private int[][] board;

    public KnightBoard(int startingRows, int startingCols){
	if(startingRows<0 || startingCols<0){
	    throw new IllegalArgumentException("Neither parameter can be negative");
	}
	
	board= new int[startingRows][startingCols];
	
	/*
	MEREDITH for future reference, int arrays are initialized at 0

	for(int i=0;i<startingRows;i++){
	    for(int g=0;g<startingCols;g++){
		board[i][g]=0;
	    }
	}
	*/
    }

    public void clear(){
	for(int i=0;i<board.length;i++){
	    for(int g=0;g<board[0].length;g++){
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
	board[startingRow][startingCol]=1;
	return solveH(startingRow,startingCol,1);
    }
    public boolean solveH(int row, int col, int level){
	int[][] moves = {{-2,1},{-2,-1},{-1,2},{-1,-2},{2,1},{2,-1},{1,2},{1,-2}};
	if(level==board.length*board[0].length){
	    return true;
	}
	for(int i=0;i<8;i++){
	    if(move(row+moves[i][0],col+moves[i][1],level+1)){
		if(solveH(row+moves[i][0],col+moves[i][1],level+1)){
		    return true;
		}else{
		    board[row+moves[i][0]][col+moves[i][1]]=0;
		}
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
	}
	board[row][col]=level;
	return true;
    }

    public int countSolutions(int row, int col){
	if(row<0 || col<0){
	    throw new IllegalArgumentException("Function parameters cannot be negative");
	}
	if(row>board.length-1 || col>board[0].length-1){
	    throw new IllegalArgumentException("parameters specified are out of bounds of this particular board");
	}
	for(int i=0;i<board.length;i++){
	    for(int g=0;g<board[0].length;g++){
		if(board[i][g]!=0){
		    throw new IllegalStateException("board cannot start with non-zero values");
		}
	    }
	}
	return countHelp(row, col, 0);
    }
    public int countHelp(int row, int col, int level){
	boolean solved = true;
	int[][] moves = {{-2,1},{-2,-1},{-1,2},{-1,-2},{2,1},{2,-1},{1,2},{1,-2}};
	if(solved){
	    return 1;
	}
	for(int i=0;i<8;i++){
	    if(move(row+moves[i][0],col+moves[i][1],level+1)){
		sols+=countHelp(row+moves[i][0],col+moves[i][1]);
		}else{
		    board[row+moves[i][0]][col+moves[i][1]]=0;
		}
	    }
	return sols;
    }
}
