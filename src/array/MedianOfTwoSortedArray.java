package array;

import java.util.Arrays;

// http://leetcode.com/2011/03/median-of-two-sorted-arrays.html
public class MedianOfTwoSortedArray {
	
    public double findMedianSortedArrays(int A[], int B[]){
        int aLen = A.length;
        int bLen = B.length;
        if(aLen == 0) return find(B);
        if(bLen == 0) return find(A);
        if(aLen == 1){
            return find(A[0], B);
        }
        if(bLen == 1){
            return find(B[0], A);
        }
        if(aLen == 2){
            return find(A[0], A[1], B);
        }
        if(bLen == 2){
            return find(B[0], B[1], A);
        }
        int aMid = (aLen - 1)/2;
        int bMid = (bLen - 1)/2;
        int k = Math.min(aMid, bMid);
        if(A[aMid] > B[bMid]){
            return findMedianSortedArrays(Arrays.copyOfRange(A, k, aLen), 
                	Arrays.copyOfRange(B, 0, bLen - k));
        } else {
            return findMedianSortedArrays(Arrays.copyOfRange(A, 0, aLen-k), 
            		Arrays.copyOfRange(B, k, bLen));
        }
    }
    
    private double find(int a1, int a2, int[] b) {
    	int bLen = b.length;
    	int m = (bLen -1)/2;
    	int b1 = b[m];
    	int b2 = b[m+1];
    	if(bLen %2 == 0){
    		if(a2<=b1) return (a2+b1)/2.0;
            if(a1<=b1 && a2<=b2) return (b1+a2)/2.0;
            if(a1>=b1 && a2<=b2) return (a1+a2)/2.0;
            if(a1>=b1 && a2>=b2) return (a1+b2)/2.0;
            if(a1>=b1 && a2<=b2) return (a1+b2)/2.0;
    		return (b1+b2)/2.0;
    	} else {
    		int b0 = b[m-1];
    		if(a2<=b0) return b0;
    		if(a2<=b1) return a2;
    		if(a1<=b1 && a2>=b1) return b1;
    		if(a1<=b2) return a1;
    		return b2;
    	}
	}

	private double find(int a, int[] b) {
    	int bLen = b.length;
    	if(bLen == 0) return a;
    	if(bLen == 1) return (a+b[0])/2.0;
    	int m = (bLen -1)/2;
    	if(bLen%2 == 0){
    		if(a<=b[m]) return b[m];
    		if(a>=b[m+1]) return b[m+1];
    		return a;
    	} else {
    		if(a<=b[m-1]) return (b[m] + b[m-1])/2.0;
            if(a>=b[m+1]) return (b[m] + b[m+1])/2.0;
    		return (a+b[m])/2.0;
    	}
	}

	private double find(int[] b) {
    	int bLen = b.length;
    	if(bLen == 0) return 0;
		if(bLen % 2 == 0) return (b[bLen/2 - 1] + b[bLen/2])/2.0;
		return b[bLen/2];
	}
	

    public static void main(String[] args) {
    	int A[] = {1,2};
    	int B[] = {3,4,5,6};
		System.out.println(
				new MedianOfTwoSortedArray().findMedianSortedArrays(A, B));
	}
	
	public double findMedianSortedArrays_(int A[], int B[]) {
    	int m = A.length;
    	int n = B.length;
    	if (m < n){
    		return findMedianSortedArrays(B, A);
    	}
    	if (m > n) {
    		return findMedianSortedArrays(Arrays.copyOfRange(A, n, m-n), B);
    	}
      
        int i = m/2;
        int j = (n+1)/2 -1;
        if(A[i] > B[j] && A[i] < B[j+1]) {
        	return A[i];
        }
        
        if(A[i] < B[j]) {
        	return findMedianSortedArrays(Arrays.copyOfRange(A, j, m), Arrays.copyOfRange(B, 0, n-j));
        } else {
            return findMedianSortedArrays(Arrays.copyOfRange(A, 0, m - j), Arrays.copyOfRange(B, j, n));
        }
    }
    
    double findMedian(int a[]) {
        int i = a.length;
        if (i == 0) {
            return 0;
        }
        if (i%2 == 1) {
            return a[(i-1)/2];
        } else {
            return (a[i/2 - 1] + a[i/2])/2.0;
        }
        
    }


}
