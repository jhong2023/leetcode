package dp;

public class UniqPath {
    
	// Comb(m+n-2, m-1)
    public int uniquePaths_(int m, int n) {
        
        if (m < 1 || n < 1) return 0;
        if (m == 1 || n == 1) return 1;
        
    	int t = 1;
		int k = Math.min(m-1, n-1);
		// multiply and divide at same time to avoid over overflow
		for(int i=1; i<=k; i++){
			t = t * (m+n-1-i)/i;
		}
		
		return t;
	}
    
	// DP
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) return 0;
        if (m == 1 || n == 1) return 1;
        
        int[][] t = new int[m][n];
        
        for(int i=0; i<m; i++) {
            t[i][0] = 1;
        }
        
        for(int i=0; i<n; i++) {
            t[0][i] = 1;
        }
        
        for (int i=1; i<m;i++) {
            for (int j=1;j<n;j++) {
                t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }
        
        return t[m-1][n-1];
    }
}
