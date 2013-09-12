package string;

import java.util.HashMap;
import java.util.Map;

//http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-partitioning/

public class PalindromePartitioningMinCut {

	public int minCut_dp(String s) {
		int length = s.length();
		// length + 1
		int[] dp = new int[length + 1];
		boolean[][] parlin = new boolean[length][length];

		for (int i = length; i >= 0; i--) {
			dp[i] = length - i;
		}

		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				if (s.charAt(i) == s.charAt(j)
						&& (j - i < 2 || parlin[i + 1][j - 1])) {
					parlin[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}

		return dp[0] - 1;
	}



	public int minCut(String s) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		return minCut_BF(s, map);

	}

	public int minCut_BF(String s, Map<String, Integer> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}

		// This condition is very important, don't miss isPalindrome(s)
		if (s.length() < 1 || isPalindrome(s, 0, s.length())) {
			return 0;
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i < s.length(); i++) {
			if (isPalindrome(s, 0, i)) {
				int t = minCut(s.substring(i));
				if (t < min) {
					min = t;
				}
			}
		}
		map.put(s, min + 1);
		return min + 1;
	}

	private boolean isPalindrome(String s, int i, int j) {
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}

		if (i < j) {
			return false;
		} else {
			return true;
		}
	}
	
	
	////////// 
	// n^2 complexity
	
	public static void main(String[] args) {
		PalindromePartitioningMinCut p = new PalindromePartitioningMinCut();
		p.minCut_dppp("aa");
	}
	
    public int minCut_dppp(String s) {
        if(s == null) return 0;
        int len = s.length();
        int a[] = new int[len+1];
        boolean m[][] = new boolean[len][len];
        for(int i=0; i < len; i++){
            a[i] = 1000;
        }
        
        a[len-1] = 0;
        for(int i = len-1; i >= 0; i--){
            for(int j = i; j <len; j++){
                if(i == j){
                    m[i][j] = true;
                } else {
                    m[i][j] = s.charAt(i) == s.charAt(j) && (i+1 >= j-1 || m[i+1][j-1]);
                }
                
                if(m[i][j]){
                    // be super careful
                	if(j == len-1) {
                		a[i] = 0;
                	} else {
                		a[i] = Math.min(a[i], a[j+1] + 1);
                	}
                }
            }
            
        }
        return a[0];
    }
	
    public int minCut_dpp(String s) {
        if(s == null) return 0;
        int len = s.length();
        int a[] = new int[len+1];
        for(int i=0; i < len; i++){
            a[i] = 1000;
        }
        
        a[0] = 0;
        for(int i = 1; i < len; i++){
            for(int j = 0; j <=i; j++){
                if(isP(s, j, i)){
                	// be super careful
                	if(j == 0) {
                		a[i] = 0;
                	} else {
                		a[i] = Math.min(a[i], a[j-1] + 1);
                	}
                }
            }
            
        }
        return a[len-1];
    }
    
    private boolean isP(String s, int i, int j) {
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}

		if (i < j) {
			return false;
		} else {
			return true;
		}
	}

}
