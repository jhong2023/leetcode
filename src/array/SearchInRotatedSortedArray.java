package array;

public class SearchInRotatedSortedArray {

    public static int isInA(int target, int[] A)
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
