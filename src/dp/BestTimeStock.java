package dp;

public class BestTimeStock {

	
/*
 Test case:
 1, 1   0
 1, 2    1
 2, 1    0
 1,2,3   2
 2,3,1
 1,2,1,2
 2,1,2,1
 1,2,2,1
 1,1,1
 
 */
	    public int maxProfit(int[] a) {
	        int len = a.length;
	        if(len < 2) return 0;
	        
	        int b[] = new int[len];
	        int low = a[0];
	        b[0] = 0;
	        for(int i = 1; i < len; i++){
	        	if(a[i] < low) {
	        		low = a[i];
	        		b[i] = b[i-1];
	        	} else if(a[i] - low > b[i-1]){
	        		b[i] = a[i] - low;
	        	} else {
	        		// not a[i-1]
	        		b[i] = b[i-1];
	        	}
	        }
	        
	        int max = b[len-1];
	        int high = a[len-1];
	        for(int i=len-2; i>0;i--){
	        	if(a[i] > high){
	        		high = a[i];
	        	} else if(high - a[i] + b[i-1] > max){
	        		max = high - a[i] + b[i-1];
	        	}
	        }
	        return max;
	    }
	    
	    
	    int maxProfit_1(int a[], int i, int j){
	        if (j - i < 1) {
	            return 0;
	        }
	        
	        int max = 0;
	    	int low = a[i];
	    	for (int k = i; k <= j; k++) {
	    		if (a[k] < low) {
	    			low = a[k];
	    		} else if (a[k] - low > max) {
	    			max = a[k] - low;
	    		}
	    	}
	    	return max;
	    }
	    
	    public static void main(String[] args) {
	    	int a[] = {3,3};
	    	System.out.println(
			new BestTimeStock().maxProfit(a));
		}
}
