package math;

import java.util.Arrays;

public class Sum3Closest {

	static public int threeSumClosest(int[] a, int target) {
		int len = a.length;
		int res = a[0] + a[1] + a[2];

		Arrays.sort(a);

		for (int i = 0; i < len - 2; i++) {
			int s = i + 1;
			int e = len - 1;
			while (s < e) {
				int tmp = a[i] + a[s] + a[e];
				if (Math.abs(tmp - target) < Math.abs(res - target)) {
					res = tmp;
				}
				// not res here
				if (res - target == 0) {
					return res;
				}

				if (tmp < target) {
					s++;
				} else {
					e--;
				}

			}
		}
		return res;
	}

	public static void main(String[] args) {
		int a[] = { 0, 5, -1, -2, 4, -1, 0, -3, 4, -5 };
		threeSumClosest(a, 1);
	}

}
