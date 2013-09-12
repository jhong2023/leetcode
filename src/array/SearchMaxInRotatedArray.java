package array;

public class SearchMaxInRotatedArray {

	static int search(int a[]){
		int len = a.length;
		int i = 0;
		int j = len - 1;
		while(i<j){
			if(j-i == 1){
				if(a[i] > a[j]) {
					return a[i];
				}
				return -1;
			}
			int m = (i+j)/2;
			if(a[i] <= a[m]){
				i = m;
			} else {
				j = m;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int a[] = {2,1};
		System.out.println(search(a));
		int b[] = {2,3,1};
		System.out.println(search(b));
		int c[] = {3,1,2};
		System.out.println(search(c));
		int d[] = {4,1,2,3};
		System.out.println(search(d));
		int e[] = {3,4,1,2};
		System.out.println(search(e));
		int f[] = {2,3,4,1};
		System.out.println(search(f));
		int g[] = {1,2,3,4};
		System.out.println(search(g));
	}

}
