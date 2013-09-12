package array;

public class SearchInRotatedSortedArray {
	
	
    public int search(int[] a, int t) {
        int i = 0;
        int j = a.length - 1;
        
        while (i <= j) {
            int m = (i+j)/2;
            if (a[m] == t) {
                return m;
            }
            
            // Notice: here include equal
            if(a[i] <= a[m]) {
                if (t > a[m] || t < a[i]) {
                    i = m + 1;
                } else {
                    j = m - 1;
                }
            } else {
                if (t < a[m] || t > a[j]) {
                    j = m -1;
                } else {
                    i = m + 1;
                }
            }
            
        }
        
        return -1;
        
    }

}
