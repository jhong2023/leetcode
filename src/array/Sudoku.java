package array;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

    public void solveSudoku(char[][] board) {
    	solveSudoku(board, 0, 0);
    }
    
    boolean solveSudoku(char[][] board, int i, int j) {
    	if (i==8 && j==9) {
    		output(board);
    		System.out.println();
    		return true;
    	}
    	if(j==9) {
    		i++;
    		j=0;
    	}
    
    	if(board[i][j] != '.') {
    		return solveSudoku(board, i, j+1);
    	}

    	boolean b = false;
		for (char a : findPossible(board, i, j)) {
			board[i][j] = a;
			b = solveSudoku(board, i, j + 1);
			board[i][j] = '.';
			if (b) {
				return true;
			}
		}
		return false;
    }

	private List<Character> findPossible(char[][] board, int i, int j) {
		List<Character> possibleChars = new ArrayList<Character>();
		for(int k=1; k<=9; k++) {
			if (isAvailable(board, i, j, k)) {
				possibleChars.add((char) (k+'0'));
			}
		}
		return possibleChars;
	}
	
	boolean isAvailable(char[][] board, int i, int j, int k){
		for(int m=0; m<9; m++){
			if(board[m][j] - '0' == k) {
				return false;
			}
		}
		for(int m=0; m<9; m++){
			int t = board[i][m] - '0';
			if(t == k) {
				return false;
			}
		}
		int x = i/3 * 3;
		int y = j/3 * 3;
		for(int m=x; m<x+3; m++) {
			for(int n=y; n<y+3; n++){
				if(board[m][n] - '0' == k){
					return false;
				}
			}
		}
		return true;
	}
	
    
    void output(char[][] board) {
    	for(int i=0; i<9; i++) {
    		String str= "";
			for(int j=0; j<9; j++){
				str += board[i][j] + " ";
			}
			System.out.println(str);
		}
    }
	
	public static void main(String[] args) {
		char board[][] = new char[9][9];
		
		String ss = "..9748...7.........2.1.9.....7...24..64.1.59..98...3.....8.3.2.........6...2759..";
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++){
				board[i][j] = ss.charAt(i*9 + j);
			}
		}
		new Sudoku().solveSudoku(board);
	}

}
