package array;

public class QuickSort {
	// http://www.algolist.net/Algorithms/Sorting/Quicksort
	void divide(int a[], int start, int end) {
		System.out.println(start + " " + end);
		print(a);
		if (start >= end)
			return;
		int pivot = a[(start + end) / 2];
		int i = start;
		int j = end;
		while (i <= j) {
			while (a[i] < pivot)
				i++;
			while (a[j] > pivot)
				j--;
			if (i <= j) {
				swap(a, i, j);
				i++;
				j--;
			}
		}
		divide(a, start, i - 1);
		divide(a, i, end);
	}

	private void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub

	}

	private void print(int[] a) {
		// TODO Auto-generated method stub

	}

}
