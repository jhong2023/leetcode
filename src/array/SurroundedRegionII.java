package array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// http://blog.sina.com.cn/s/blog_b9285de20101j1dt.html

public class SurroundedRegionII {

    public void solve(char[][] board) {
        int m = board.length;
        if(m < 3) return;
        int n = board[0].length;
        if(n < 3) return;
        
        for(int i=1;i<m-1;i++){
            for(int j=1;j<n-1;j++){
                if(board[i][j] == 'O'){
                	bfsValidate(board, i, j, m, n);
                }
            }
        }
    }
    
    class Point{
        int x;
        int y;
        public Point(int i, int j){
            x = i;
            y = j;
        }
        
        @Override
        public boolean equals(Object other) {
        	Point o = (Point) other;
        	return this.x == o.x && this.y == o.y;
        }
        
        // Whenever a.equals(b), then a.hashCode() must be same as b.hashCode()
        // http://www.javaranch.com/journal/2002/10/equalhash.html
        @Override
        public int hashCode() {
            return  Integer.valueOf(x).hashCode() + Integer.valueOf(y).hashCode();
        }
    }
    
    boolean bfsValidate(char[][] board, int i, int j, int m, int n){
        Queue<Point> q = new LinkedList<Point>();
        Set<Point> v = new HashSet<Point>();
        q.offer(new Point(i, j));
        while(!q.isEmpty()){
            Point p = q.remove();
            
            // bug
            i = p.x;
            j = p.y;
            
            if(p.x == 0 || p.x == m-1 || p.y == 0 || p.y == n-1){
                return false;
            }
            // Don't forget this
            v.add(p);
            
            
            Point pp  = new Point(i-1, j);
            if(board[i-1][j] == 'O' && !v.contains(pp)){
                q.offer(pp);
            }
            pp  = new Point(i+1, j);
            if(board[i+1][j] == 'O' && !v.contains(pp)){
                q.offer(pp);
            }
            pp  = new Point(i, j - 1);
            if(board[i][j-1] == 'O' && !v.contains(pp)){
                q.offer(pp);
            }
            pp  = new Point(i, j + 1);
            if(board[i][j+1] == 'O' && !v.contains(pp)){
                q.offer(pp);
            }
        }
        for(Point p : v){
            board[p.x][p.y] = 'X';
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String bb[] = {"OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"};
    	char board[][] = new char[bb.length][bb[0].length()];
    	for(int i=0; i<bb.length;i++){
    		for(int j=0;j<bb[i].length();j++){
    			board[i][j] = bb[i].charAt(j);
    		}
    	}

    	int m = board.length;
    	int n = board[0].length;
    	new SurroundedRegionII().solve(board);
        for(int i=0; i<m; i++) {
        	String str = "";
            for (int j=0; j<n; j++) {
            	str += board[i][j];
            }
            System.out.println(str);
        }
	}

}
