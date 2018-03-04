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
		    ans+="Q ";
		}else{
		    ans+="_ ";
		}
		    /*
		}else if(board[i][g]==0){
		    ans+="0";
		}else{
		    ans+=board[i][g]+"";
		}
		    */
	    }
	}
	return ans;
    }
    
    private boolean addQueen(int r, int c){
	if(board[r][c]==0){
	    board[r][c]=-1;
	    threaten(r,c);
	    return true;
	}else{
	    return false;
	}
    }

    private void threaten(int r, int c){
	for(int row=r-1;row>-1;row--){
	    board[row][c]++;
	}
	for(int row=r+1;row<board.length;row++){
	    board[row][c]++;
	}
	for(int col=c-1;col>-1;col--){
	    board[r][col]++;
	}
	for(int col=c+1;col<board.length;col++){
	    board[r][col]++;
	}
	int row=r-1;
	int col=c-1;
	while(row>-1 && col>-1){
	    board[row][col]++;
	    row--;
	    col--;
	}
	int rsw=r+1;
	int csw=c-1;
	while(rsw<board.length && csw>-1){
	    board[rsw][csw]++;
	    rsw++;
	    csw--;
	}
	int rse=r+1;
	int cse=c+1;
	while(rse<board.length && cse<board.length){
	    board[rse][cse]++;
	    rse++;
	    cse++;
	}
	int rne=r-1;
	int cne=c+1;
	while(rne>-1 && cne<board.length){
	    board[rne][cne]++;
	    rne--;
	    cne++;
	}
    }

    private void unthreaten(int r, int c){
	for(int row=r-1;row>-1;row--){
	    board[row][c]--;
	}
	for(int row=r+1;row<board.length;row++){
	    board[row][c]--;
	}
	for(int col=c-1;col>-1;col--){
	    board[r][col]--;
	}
	for(int col=c+1;col<board.length;col++){
	    board[r][col]--;
	}
	int row=r-1;
	int col=c-1;
	while(row>-1 && col>-1){
	    board[row][col]--;
	    row--;
	    col--;
	}
	int rsw=r+1;
	int csw=c-1;
	while(rsw<board.length && csw>-1){
	    board[rsw][csw]--;
	    rsw++;
	    csw--;
	}
	int rse=r+1;
	int cse=c+1;
	while(rse<board.length && cse<board.length){
	    board[rse][cse]--;
	    rse++;
	    cse++;
	}
	int rne=r-1;
	int cne=c+1;
	while(rne>-1 && cne<board.length){
	    board[rne][cne]--;
	    rne--;
	    cne++;
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

    public boolean solve(){
	for(int i=0;i<board.length;i++){
	    for(int g=0;g<board.length;g++){
		if(board[i][g]!=0){
		    throw new IllegalStateException("The board cannot start with any nonzero numbers");
		}
	    }
	}
	return this.solve(0);
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

    public int countSolutions(){
	for(int i=0;i<board.length;i++){
	    for(int g=0;g<board.length;g++){
		if(board[i][g]!=0){
		    throw new IllegalStateException("The board cannot start with any nonzero numbers");
		}
	    }
	}
	if(countSolutions(0)==-1){
	    System.out.println("0 solutions exist for this board size");
	    return -1;
	}else{
	    return countSolutions(0);
	}
    }
    public int countSolutions(int R){
	int sols=0;
	if(R==board.length){
	    sols++;
	    return sols;
	}
	for(int i=0;i<board.length;i++){
	    if(addQueen(i,R)){
		countSolutions(R+1);
		removeQueen(i,R);
	    }
	}
	return sols;
    }

    public static void main(String[] args){
	QueenBoard a = new QueenBoard(5);
	System.out.println(a);
	//a.addQueen(3,0);
	//a.addQueen(0,1);
	//a.addQueen(2,2);
	//System.out.println(a);
	//a.removeQueen(2,2);
	//System.out.println(a);
	//System.out.println(a.solve());
	//System.out.println(a);
	System.out.println(a.countSolutions());
    }
}
