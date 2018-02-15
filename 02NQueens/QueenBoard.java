public class QueenBoard{

    private int[][] board;

    public QueenBoard(int size){
	board = new int[size][size];
	for(int i=0;i<size;i++){
	    for(int g=0;g<size;g++){
		board[i][g]=0;
	    }
	}
    }

    public String toString(){
	String ans = "";
	for(int i=0;i<board[0].length;i++){
	    ans+="\n";
	    for(int g=0;g<board[0].length;g++){
		if(board[i][g]==-1){
		    ans+="Q";
		    /*
		}else{
		    ans+="_";
		}
		    */
		}else if(board[i][g]==0){
		    ans+="0";
		}else{
		    ans+=board[i][g]+"";
		}
	    }
	}
	return ans;
    }
    
    private boolean addQueen(int r, int c){
	if(board[r][c]==0){
	    threaten(r,c);
	    board[r][c]=-1;
	    return true;
	}else{
	    return false;
	}
    }

    private void threaten(int r, int c){
	int cols = board.length-c;
	for(int cur =cols;cur<board.length;cur++){
	    board[r][cur]++;
	}
	for(int cur=c-1;cur>-1;cur--){
	    board[r][cur]++;
	}
	/*
	int col = c+1;
	for(int row = r+1;row<cols;row++){
		board[row][col]++;
		col++;
	}
	int four = c+1;
	for(int row = r+1;row>0;row--){
	    board[row][four]++;
	    four--;
	}
	*/
	
    }

    private void unthreaten(int r, int c){
	int cols = board.length-c;
	for(int cur =c+1;cur<cols;cur++){
	    board[r][cur]--;
	}
	int col = c+1;
	for(int row = r+1;row<cols;row++){
		board[row][col]--;
		col++;
	}
    }
    
    private boolean removeQueen(int r, int c){
	if(board[r][c]==-1){
	    board[r][c]=0;
	    unthreaten(r,c);
	    return true;
	}else{
	    return false;
	}
    }

    public boolean solve(int R){
	if(R==board.length){
	    return true;
	}
	for(int i=0;i<board.length;i++){
	    if(addQueen(i,R)){
		if(solve(R+1)){
		    return true;
		}
	    }
	    removeQueen(i,R);
	}
	return false;
    }

    /*
    public int countSolutions(){
    }
    */

    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	System.out.println(a);
	a.addQueen(2,2);
	System.out.println(a);
	//a.removeQueen(2,2);
	//System.out.println(a);
	//System.out.println(a.solve(0));
	//System.out.println(a);
    }
}
