package string;

public class MinimumWindowSubstring {
    
    public String minWindow(String S, String T) {
        
        return "";
    }
    
    public String minWindow_(String S, String T) {
        int[][] t = new int[T.length()][S.length()];
        t[0][0] = S.charAt(0) == T.charAt(0)?1 : 0;
        for (int i=1; i<S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                t[0][i] = 1;
            } else if (t[0][i-1] != 0) {
                t[0][i] = t[0][i-1] + 1;
            }
        }
        
        for (int i=1; i < T.length(); i++) {
            for (int j=i;j < S.length();j++) {
                if (S.charAt(j) == T.charAt(i) && t[i-1][j-1] != 0) {
                    t[i][j] = t[i-1][j];
                } else if (t[i][j-1] != 0) {
                    t[i][j] = t[i][j-1] + 1;
                }
            }
        }
        
        if (t[T.length()-1][S.length()-1] == 0) return "";
        
        int minWindow = t[T.length()-1][S.length()-1];
        int minIndex = S.length() - 1;
        for (int i=S.length() - 2; i >= 0; i--) {
            if (t[T.length()-1][i] == 0) {
                break;
            }
            if (t[T.length()-1][i] < minWindow) {
                minWindow = t[T.length()-1][i];
                minIndex = i;
            }
        }
        return S.substring(minIndex - minWindow + 1, minIndex + 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
