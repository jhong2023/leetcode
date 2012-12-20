package dp;

public class LongestCommonSubSequence {

    String LCS(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] t = new int[l1+1][l2+1];
        for(int i=1; i<=l1; i++) {
            for (int j=1; j<=l2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    t[i][j] = t[i-1][j-1] + 1;
                }
                
                if(t[i][j] < t[i-1][j]) {
                    t[i][j] = t[i-1][j];
                } 
                
                if(t[i][j] < t[i][j-1]) {
                    t[i][j] = t[i][j-1];
                }
            }
        }
        int i = l1;
        int j = l2;
        System.out.println(t[i][j]);
        StringBuffer buf = new StringBuffer();
        while(i>0 && j>0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                buf.append(s1.charAt(i-1));
                i--;
                j--;
            } else if (t[i][j] == t[i][j-1]) {
                j--;
            } else {
                i--;
            }
        }
        return buf.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "XMJYAUZ";
        String s2 = "MZJAWXU";
        System.out.println(new LongestCommonSubSequence().LCS(s1, s2));
    }

}
