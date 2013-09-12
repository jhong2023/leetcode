package array;

import java.util.Arrays;

// http://leetcode.com/2011/01/find-k-th-smallest-element-in-union-of.html
public class KthSmallestInTwoSortedArray {

	static int findKthSmallest(int a[], int b[], int k) {
		System.out.println(a.length + " " + b.length + " " + k);
		if(a.length + b.length < k) {
			return -1;
		}
		if(a.length == 0) {
			return b[k-1];
		}
		if(b.length == 0) {
			return a[k-1];
		}
		if(a.length > k) {
			a = Arrays.copyOfRange(a, 0, k);
		}
		if(b.length > k) {
			b = Arrays.copyOfRange(b, 0, k);
		}
		if(a.length > b.length) {
			return findKthSmallest(b, a, k);
		}
		int m = a.length;
		int n = b.length;
		int i = (int)((double)m / (m+n) * (k-1));
		int j = k - 1 - i;
		if(a[i] > b[j-1] && a[i] < b[j]) {
			return a[i];
		}
		
		return findKthSmallest(Arrays.copyOfRange(a, i+1, a.length), Arrays.copyOf(b, j+1), k-i-1);
	}
	
	
	// From leetcode
	static int findKthSmallest(int A[], int m, int B[], int n, int k) {
		  assert(m >= 0); assert(n >= 0); assert(k > 0); assert(k <= m+n);
		  
		  int i = (int)((double)m / (m+n) * (k-1));
		  int j = (k-1) - i;
		 
		  assert(i >= 0); assert(j >= 0); assert(i <= m); assert(j <= n);
		  // invariant: i + j = k-1
		  // Note: A[-1] = -INF and A[m] = +INF to maintain invariant
		  int Ai_1 = ((i == 0) ? Integer.MIN_VALUE : A[i-1]);
		  int Bj_1 = ((j == 0) ? Integer.MIN_VALUE : B[j-1]);
		  int Ai   = ((i == m) ? Integer.MAX_VALUE : A[i]);
		  int Bj   = ((j == n) ? Integer.MAX_VALUE : B[j]);
		 
		  if (Bj_1 < Ai && Ai < Bj)
		    return Ai;
		  else if (Ai_1 < Bj && Bj < Ai)
		    return Bj;
		 
		  assert((Ai > Bj && Ai_1 > Bj) || 
		         (Ai < Bj && Ai < Bj_1));
		 
		  // if none of the cases above, then it is either:
		  if (Ai < Bj)
		    // exclude Ai and below portion
		    // exclude Bj and above portion
		    return findKthSmallest(Arrays.copyOfRange(A,  i+1, A.length), m-i-1, B, j, k-i-1);
		  else /* Bj < Ai */
		    // exclude Ai and above portion
		    // exclude Bj and below portion
		    return findKthSmallest(A, i, Arrays.copyOfRange(B,  j+1, B.length), n-j-1, k-j-1);
		}
	
	public static void main(String[] args) {
		int b[] = {4};
		int a[] = {1};
		System.out.println( findKthSmallest(a, a.length, b, b.length, 1) );
	}

}
