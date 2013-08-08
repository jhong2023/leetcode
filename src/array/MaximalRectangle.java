package array;

public class MaximalRectangle {
    
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m==0) return 0;
        // be careful, not matrix.length
        int n = matrix[0].length;
        if(n==0) return 0;
        
        int a[] = new int[n];
        for (int i=0; i < n; i++) {
        	a[i] = 0;
        }
        
        int max = 0;
        
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if(matrix[i][j] == '1') {
                	a[j] = a[j] + 1;
                } else {
                	a[j] = 0;
                }
            }
            int tmp = maxHistogram(a);
            if(tmp > max) {
            	max = tmp;
            }
        }
        return max;
        
    }

    private int maxHistogram(int[] a) {
    	int max = 0;
    	for(int i=0; i<a.length; i++){
    		if(a[i] != 0) {
    			int j = i - 1;
    			while(j>=0 && a[j] >= a[i]) {
    				j--;
    			}
    			int k = i + 1;
    			while(k<a.length && a[k] >= a[i]){
    				k++;
    			}
    			int t =  (k-j-1) * a[i];
    			if(t > max) {
    				max = t;
    			}
    		}
    	}
		return max;
	}

    public static void main(String[] args) {
		char cc[][] = {{'0','0','0'}, {'0','0','0'}, {'0','0','0'}, {'0','0','0'}};
		new MaximalRectangle().maximalRectangle(cc);
	}


}
