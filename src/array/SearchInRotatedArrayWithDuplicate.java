package array;

public class SearchInRotatedArrayWithDuplicate {

    public int search(int[] a, int t) {
    	int i = 0;
    	int j = a.length - 1;
    	while(i <= j){
    		// to avoid the duplicate start and end
    		while(i < j && a[i] == a[j]){
                i++;
            }
    		int m = (i+j)/2;
    		if(t == a[m]) return m;
    		if(a[i] <= a[m]){
    			if(t>a[m] || t < a[i]){
    				i = m + 1;
    			} else {
    				j = m - 1;
    			}
    		} else {
    			if(t < a[m] || t > a[j]){
    				j = m - 1;
    			} else {
    				i = m + 1;
    			}
    		}
    	}
    	return -1;
    }

}
