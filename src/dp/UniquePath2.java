package dp;

public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m < 1 || n < 1) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        
        int[][] t = new int[m][n];
        
        t[0][0] = 1;
        for(int i=1; i<m; i++) {
            if (obstacleGrid[i][0] == 1) {
                t[i][0] = 0;
            } else {
                t[i][0] = t[i-1][0];
            }
        }
        
        for(int i=1; i<n; i++) {
            if (obstacleGrid[0][i] == 1) {
                t[0][i] = 0;
            } else {
                t[0][i] = t[0][i-1];
            }
        }
        
        for (int i=1; i<m;i++) {
            for (int j=1;j<n;j++) {
                if (obstacleGrid[i][j] == 1) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = t[i-1][j] + t[i][j-1];
                }
            }
        }
        
        return t[m-1][n-1];
    }

    public static void main(String[] args) {
    	int ob[][] = {{0,0}};
    	new UniquePath2().uniquePathsWithObstacles(ob);

    }

}
