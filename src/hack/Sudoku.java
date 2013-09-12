package hack;

public class Sudoku {
	    public boolean isValidSudoku(int[] arr) {
	        for(int i = 0; i < 81; i++){
	            if(arr[i] < 1 || arr[i] > 9) return false;
	            if(!isValidNumber(arr, i, arr[i])) return false;
	        }
	        return true;
	    }
	    
	    boolean isValidNumber(int[] arr, int k, int n){
	        int i = k/9;
	        int j = k - 9*i;
	        for(int s = i*9; s < (i+1)*9; s++){
	            int t = s;
	            if(t == k) continue;
	            if(arr[t] == n) return false;
	        }
	        for(int s = 0; s < 9; s++){
	            int t = s*9 +j;
	            if(t == k) continue;
	            if(arr[t] == n) return false;
	        }  
	        int q = i/3;
	        int p = j/3;
	        for(int x = 0; x < 3; x++){
	            for(int y=0; y <  3; y++){
	            	// must be 3*q
	                int t = (3*q+x)*9 + p*3+y;
	                if(t == k) continue;
	                if(arr[t] == n) return false;
	            }
	        }
	        return true;
	        
	    }
}
