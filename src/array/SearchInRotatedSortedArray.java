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

    public static int isInA_(int target, int[] A)
    {
        int i = 0;
        int j = A.length - 1;
        while(i <= j) {
            int mid = (i+j)/2;
            if (A[mid] == target) {
                return mid;
            }
            
            if (target < A[mid]) {
                if ( A[mid] < A[j] ) {
                    j = mid - 1;
                } else if (target >= A[i]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if (A[i] < A[mid]) {
                    i = mid + 1;
                } else if (target <= A[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
       }

       return -1;
    }

}
