package list;

public class MergeSort {

	static void merge(int a[]){
		int k = 1;
		int len = a.length;
		int b[] = new int[len];
		while(k < len){
			int left = 0;
			int right = k;
			int end = Math.min(len, 2*k);
			while(right < len){
				merge(a, left, right, end, b);
				left = end;
				right = left + k;
				end = Math.min(len, right + k);
			}
			k = k*2;
		}
		
	}
	
	static void merge(int a[], int left, int right, int end, int[] b){
		
		int i = left;
		int j = right;
		int k = 0;
		while(i < right && j < end){
			if(a[i] < a[j]){
				b[k]  = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}
		while(i < right){
			b[k]  = a[i];
			i++;
			k++;
		}
		while(j < end){
			b[k] = a[j];
			j++;
			k++;
		}
		for(i = 0; i < k; i++){
			a[left + i] = b[i];
		}
	}
	
	// recursive merging
	static void merge(int a[], int i, int j){
		if(i >= j) return;
		if(j - i == 1){
			if(a[i] > a[j]){ 
				int tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
			return;
		}
		int m = (i+j)/2;
		int b[] = new int[a.length];
		merge(a, i, m);
		merge(a, m+1, j);
		merge(a, i, m+1, j+1, b);
	}


	public static void main(String[] args) {
		int[] a = {3,5,2,4,1,8,9,6,7};
		
		merge(a, 0, a.length - 1);
		
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ", ");
		}
	}

}
