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
    
    String LCS_(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[] t = new int[l2+1];
        String[] s = new String[l2+1];
        t[0] = 0;
        s[0] = "";
        
        for(int i=0; i<l1; i++) {
        	for (int j=0; j<l2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                	if(t[j+1] < t[j]){
                		s[i+1] = s[i] + s1.charAt(i);
                	}
                	t[j+1] = t[j] + 1;
                	
                } else {
                	if(t[j+1] < t[j]){
                		t[j+1] = t[j];
                	} else {
                		s[i+1] = s[i];
                	}
                }
            }
        }
        return s[l2];
    }
    
    public static void main(String[] args) {
        String s1 = "ba"; // "XMJYAUZ";
        String s2 = "ab"; //"MZJAWXU";
        System.out.println(new LongestCommonSubSequence().LCS(s1, s2));
        System.out.println(new LongestCommonSubSequence().LCS_(s1, s2));
    }

}
