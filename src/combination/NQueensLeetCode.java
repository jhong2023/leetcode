package combination;

import java.util.ArrayList;

public class NQueensLeetCode {

    public ArrayList<String[]> solveNQueens(int n) {
        int q[] = new int[n];
        for (int i = 0; i < n; i++) {
            q[i] = -1;
        }
        
        ArrayList<String[]> list = new ArrayList<String[]>();
        search(q, 0, n, list);
        
        return list;
    }
    
    
    void search(int q[], int i, int n, ArrayList<String[]> list) {
        if (i == n) {
            String[] ss = new String[n];
            for (int x = 0; x < n; x++) {
                String s = "";
                for (int y = 0; y < n; y++) {
                    if (q[x] == y) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                ss[x] = s;
            }
            list.add(ss);
        }
        
        for (int j=0; j<n; j++) {
            if (canPlace(q, i, j, n)) {
                q[i] = j;
                search(q, i+1, n, list);
                q[i] = -1;
            }
        }
    }
    
    boolean canPlace(int q[], int i, int j, int n) {
        for(int k = 0; k <= i; k++) {
            if (q[k] == j || q[k]-j == k-i || q[k]-j == i-k) {
                return false;
            }
        }
        
        return true; 
    }

}
