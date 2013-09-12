package hack;

public class MaximumDistance {
	int max(int a[]){
		int len = a.length;
		if(len <= 1) return 0;
		int b[] = new int[len];
		int n = 1;
		b[0] = 0;
		int max = 0;
		for(int i = 1; i < a.length; i++){
			if(a[i] < a[b[n-1]]){
				b[n] = i;
			} else {
				int tmp = calMax(a, b, i, n);
				max = Math.max(max, tmp);
			}
			
		}
		return max;
	}

	private int calMax(int[] a, int[] b, int i, int n) {
		// TODO Auto-generated method stub
		return 0;
	}
}
