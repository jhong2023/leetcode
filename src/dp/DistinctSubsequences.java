package dp;

public class DistinctSubsequences {
    
    public int numDistinct(String S, String T) {
        if (S == null || T == null) return 0;
        if (S.length() == 0 || T.length() == 0) return 0;
        int[][] t = new int[T.length() ][S.length()];
        t[0][0] = T.charAt(0) == S.charAt(0) ? 1 : 0;
        
        for (int j=1; j<S.length();j++) {
            if (T.charAt(0) == S.charAt(j)) {
                t[0][j] = t[0][j-1] + 1;
            } else {
                t[0][j] = t[0][j-1];
            }
        }
        for (int i=1; i<T.length(); i++) {
                t[i][0] = 0;
        }

        for (int i=1; i<T.length(); i++) {
            for (int j=1; j<S.length();j++) {
                if (T.charAt(i) == S.charAt(j)) {
                    t[i][j] = t[i-1][j-1] + t[i][j-1];
                } else {
                    t[i][j] = t[i][j-1];
                }
            }
        }
        return t[T.length() - 1][S.length() - 1];
    }
	
	
    // Wrong, subsequence is not necessary connected
    public int numDistinct_(String S, String T) {
        if (S == null || T == null) return 0;
        if (S.length() == 0 || T.length() == 0) return 0;
        
        int num = 0;
        for (int i = 0; i < S.length() - T.length() + 1;  i++) {
        	int j = 0;
        	while (j < T.length() && S.charAt(i+j) == T.charAt(j)) {
        		j++;
        	}
        	if (j == T.length()) {
        		num++;
        	}
        }
        return num;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
