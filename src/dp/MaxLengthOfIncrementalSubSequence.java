package dp;


public class MaxLengthOfIncrementalSubSequence {
	
	int getMax(int a[]){
		int len = a.length;
		int b[] = new int[len];
		int n = 0;
		for(int i = 0; i < len; i++){
			if(n == 0 || a[i] > b[n-1]){
				b[n] = a[i];
				n++;
			} else {
				int j = binarySearchInsert(b, 0, n-1, a[i]);
				b[j] = a[i];
			}
		}
		return n;
	}
	
	int binarySearchInsert(int[] a, int i, int j, int t){
		while(i < j){
			int m = (i+j)/2;
			if(t > a[m] && t <= a[m+1]) {
				return m + 1;
			}
			if(t < a[m]) {
				j = m - 1;
			} else {
				i = m + 1;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {
		int a[] = {7, 2, 3, 1, 5, 8, 9, 6};
		System.out.println(new MaxLengthOfIncrementalSubSequence().getMax(a));
	}

}
