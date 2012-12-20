package array;

import java.util.Arrays;

public class MedianSortedArrays {
    
    public double findMedianSortedArrays(int A[], int B[]) {
        return GetMedian(A, A.length, B, B.length, (A.length + B.length + 1)/2);
    }
    
    double GetMedian(int a[], int n, int b[], int m, int k) {
        if (n <= 0) return b[k-1];
        if (m <= 0) return a[k-1];

        if (b[m/2] >= a[n/2]) {
            if ((n/2 + 1 + m/2) >= k) {
                return GetMedian(a, n, b, m/2, k);
            } else {
                return GetMedian(Arrays.copyOfRange(a, n/2 + 1, a.length), n - (n/2 + 1), b, m, k - (n/2 + 1));
            }
        } else {
            if ((m/2 + 1 + n/2) >= k)
                return GetMedian(b, m, a, n/2, k);
            else
                return GetMedian(Arrays.copyOfRange(b, m/2 + 1, b.length), m - (m/2 + 1), a, n, k - (m/2 + 1));
        }
    }

    public double findMedianSortedArrays_(int A[], int B[]) {
       return findKth(A, A.length -1, B, B.length - 1, (A.length + B.length)/2);
    }
    
    double findKth(int a[], int m, int b[], int n, int k) {
         if (m==-1 && n==-1) return -1;
         if (m > n) return findKth(b, n, a, m, k);
         if (m == 0) return b[k-1];
         if (k == 1) return min(a[0], b[0]);
         int pa = min(k/2, m);
         int pb = k - pa;
         if (a[pa-1] < b[pb-1]) {
             return findKth(Arrays.copyOfRange(a, pa, a.length), m-pa, b, n, k - pa);
         }
         return findKth(a, m, Arrays.copyOfRange(b, pb, b.length), n-pb, k-pb);
    }
    
    private int min(int i, int j) {
        return i < j? i : j;
    }

    public static void main(String[] args) {
        int[] A = {2};
        int[] B = {};
        System.out.println(new MedianSortedArrays().findMedianSortedArrays(A, B));
    }

}
