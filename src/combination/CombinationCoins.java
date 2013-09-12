package combination;

public class CombinationCoins {

	// find(10) = find(0) + find(5) + find(7) + find(8) + find(9);
	static int find(int n, int[] a, int k){
		if(n < 0) return 0;
		if(n == 0) return 1;
		int res = 0;
		for(int i = k; i < a.length; i++){
			res += find(n-a[i], a, i);
		}
		return res;
	}
	static int minCoin_dp(int n, int[] a){
		if(n <= 0) return 0;
		if(a.length == 0) return -1;
		int dp[] = new int[n+1];
		dp[0] = 0;
		for(int i = 0; i < a.length; i++){
			if(a[i] <= n){
				dp[a[i]] = 1;
			}
		}
		for(int i=1; i <= n; i++){
			for(int j = 0; j < a.length; j++){
				int k = i-a[j];
				if(k > 0){
					if(dp[k] == 0) continue;
					if(dp[i] == 0){
						dp[i] = dp[k] + 1;
					} else {
						dp[i] = Math.min(dp[i], dp[k] + 1);
					}
				}
			}
		}
		return dp[n];
	}
	static int minConin(int n, int[] a, int k){
		if(k == a.length) return -1;
		if(n == a[k]) return 1;
		int res = minConin(n, a, k+1);
		if(n > a[k]){
			int tmp = minConin(n - a[k], a, k);
			if(tmp != -1){
				tmp = tmp+1;
				if(res == -1){
					res = tmp;
				} else {
					res = Math.min(res, tmp);
				}
			}
		}
		return res;
	}
	
	
	// dp(i, j) = dp(i, j - a[i]) + d(i-1, j)
	static int find_dp(int n, int[] a){
		if(n < 0) return 0;
		if(n == 0) return 1;
		int[][] t = new int[a.length][n+1];
		for(int i=0; i<a.length;i++){
			t[i][0] = 1;
		}
		for(int i=0; i<a.length;i++){
			for(int j=1; j<=n; j++){
				t[i][j] = (j >= a[i]? t[i][j-a[i]] : 0) + (i>0 ? t[i-1][j] : 0);
			}
		}
		return t[a.length-1][n];
	}

	public static void main(String[] args) {
		int a[] = {5,  2};
		System.out.println(find(11, a, 0));
		System.out.println(find_dp(11, a));
		System.out.println(minConin(6, a, 0));
		System.out.println(minCoin_dp(3, a));
	}

}
