package array;

public class BestTimeToBuyAndSellStock {

    int maxProfit(int a[]){
        if (a == null || a.length < 2) {
            return 0;
        }
        
    	int max = 0;
    	int low = a[0];
    	for (int i = 1; i < a.length; i++) {
    		if (a[i] < low) {
    			low = a[i];
    		} else if (a[i] - low > max) {
    			max = a[i] - low;
    		}
    	}
    	return max;
    }
    
    int maxProfitMultiTimes(int a[]){
    	if (a == null || a.length < 2) {
            return 0;
        }
    	int max = 0;
    	for (int i = 1; i < a.length; i++) {
    		if (a[i] > a[i-1]) {
    			max +=  a[i] - a[i-1];
    		}
    	}
    	return max;
    }

}
