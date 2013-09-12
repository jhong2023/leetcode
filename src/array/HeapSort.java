package array;

public class HeapSort {

	void adjustUp(int a[], int n){
		int i = n;
		while(i > 0 && a[i] > a[i/2]){
			swap(a, i, i/2);
			i = i/2;
		}
	}
	
	void adjustDown(int a[], int i, int n){
		int j = 2 * i;
		if(j >= n){
			return;
		}
		if(j+1 < n && a[j+1] > a[j]){
			j = j + 1;
		}
		if(a[i] < a[j]){
			swap(a, i, j);
			adjustDown(a, j, n);
		}
	}
	
	private void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	void sort(int a[]){
		int len = a.length;
		for(int i=1; i<len; i++){
			adjustUp(a, i);
		}
		for(int i=0; i<len-1; i++){
			swap(a, 0, len-i-1);
			adjustDown(a, 0, len-i-1);
		}
	}
	
	// 3,2,1  1,2,3
	public static void main(String[] args) {
		int a[] = {3,1,6,2,4,5};
		new HeapSort().sort(a);
		for(int i : a){
			System.out.print(i);
		}
	}

}
