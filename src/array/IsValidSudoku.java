package array;

public class IsValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int a[] = new int[9];
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                a[j] = 0;
            }
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(a[board[i][j] - '1'] == 1){
                    return false;
                }
                a[board[i][j] - '1'] = 1;
            }
        }
        
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                a[j] = 0;
            }
            for(int j=0; j<9; j++){
                if(board[j][i] == '.'){
                    continue;
                }
                if(a[board[j][i] - '1'] == 1){
                    return false;
                }
                a[board[j][i] - '1'] = 1;
            }
        }

        for(int m=0; m < 3; m++){
            for(int n=0; n < 3; n++){
                 for(int j=0; j<9; j++){
                    a[j] = 0;
                 }
                for(int i=m*3; i<m*3+3; i++){
                    for(int j=n*3; j<n*3+3; j++){
                    	if(board[i][j] == '.'){
                            continue;
                        }
                        if(a[board[i][j] - '1'] == 1){
                            return false;
                        }
                        a[board[i][j] - '1'] = 1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
    	char b[][] = 
    		   {{'5','.','.','.','.','.','.','.','.'}, 
    			{'3','.','.','.','.','.','.','.','.'},
    			{'1','.','.','.','.','.','.','.','.'}, 
    			{'.','.','.','.','.','.','.','.','.'}, 
    			{'.','.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','9','.','.','.'},
    			{'.','.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','.','.','.','.'},
    			{'.','.','.','.','.','.','.','.','.'}};
    	System.out.println( new IsValidSudoku().isValidSudoku(b));
	}
}
