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
		}else{
		    ans+="_";
		}
	    }
	}
	return ans;
    }
    
    private boolean addQueen(int r, int c){
	if(board[r][c]==0){
	    board[r][c]=-1;
	    return true;
	}else{
	    return false;
	}
    }
    
    private boolean removeQueen(int r, int c){
	if(board[r][c]==-1){
	    board[r][c]=0;
	    return true;
	}else{
	    return false;
	}
    }

    /*
    public boolean solve(){
    }

    public int countSolutions(){
    }
    */

    public static void main(String[] args){
	QueenBoard a = new QueenBoard(4);
	System.out.println(a);
	a.addQueen(0,0);
	System.out.println(a);
    }
}
