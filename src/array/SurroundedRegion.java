package array;

public class SurroundedRegion {
	
    public void solve(char[][] board) {
        int m = board.length;
        if(m <= 0) return;
        int n = board[0].length;
        if(n <= 0) return;
        for(int i=0; i<m; i++){
            dfs(board, i, 0);
            // n-1 not n
            dfs(board, i, n-1);
        }
        
        for(int j=0; j<n; j++){
            dfs(board, 0, j);
            // m-1 not m
            dfs(board, m-1, j);     
        }
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    
    void dfs(char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j] != 'O'){
            return;
        }
        board[i][j] = '#';
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }
    
    //////////////////////

	  public void solve_(char[][] board) {
	        int m = board.length;
	        if (m < 3) {return;}
	        int n = board[0].length;
	        if (n < 3) {return;}
	        
	        for(int i=1; i<m-1; i++) {
	            for (int j=1; j<n-1; j++) {
	                if(board[i][j] == 'O'){
	                	if(checkDFS(board, i, j)) {
	                		board[i][j] = 'X';
	                	}else{
	                		board[i][j] = 'V';
	                	}
	            	}
	            }
	        }
	        
	        for(int i=1; i<m-1; i++) {
	            for (int j=1; j<n-1; j++) {
	                if(board[i][j] == 'V'){
	                	board[i][j] = 'O';
	                }
	            }
	        }
	    }
	    
	    boolean checkDFS(char[][] board, int i, int j) {
	    	int m = board.length;
	    	int n = board[0].length;
	    	if(board[i][j] == 'X'  || board[i][j] == '#') {
	    		return true;
	    	}

	    	if(i == 0 || i == m-1 || j==0 || j==n-1 || board[i][j] == 'V'){
	    		return false;
	    	}
	    	
	    	char tmp = board[i][j];
	    	board[i][j] = '#';
	    	boolean r = checkDFS(board, i, j-1)
	    			&& checkDFS(board, i, j+1)
	    			&& checkDFS(board, i-1, j) 
	    			&& checkDFS(board, i+1, j);
	    	
	    	board[i][j] = tmp;
			return r;
	    
	    }

    public static void main(String[] args) {
    	
    	char board[][] = {
    			{'O','X','X','O','X'},
    			{'X','O','O','X','O'},
    			{'O','O','X','O','X'},
    			{'O','X','O','O','O'},
    			{'X','X','O','X','O'}};
    	int m = board.length;
    	int n = board[0].length;
    	new SurroundedRegion().solve(board);
        for(int i=0; i<m; i++) {
        	String str = "";
            for (int j=0; j<n; j++) {
            	str += board[i][j];
            }
            System.out.println(str);
        }
	}

}
