package string;

public class WildcardMatching {
    
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (p.length() == 0) {
            return s.length() == 0;
        }
        
        if (p.charAt(0) != '*') {
            if (s.length() == 0) {
                return false;
            }
            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        } else {
            if (s.length() == 0) {
                return isMatch(s, p.substring(1));
            } else {
                return isMatch(s, p.substring(1))
                    || isMatch(s.substring(1), p.substring(1))
                    || isMatch(s.substring(1), p);
            }
        }
    }
    
    public boolean isMatch_dp(String s, String p) {
        if (s ==  null || p == null) return false;
        int sl = s.length();
        int pl = p.length();
        boolean a[][] = new boolean[pl+1][sl+1];
        a[0][0] = true;
        for(int i=1; i<=sl;i++){
            a[0][i] = false;
        }
        for(int i=1; i<=pl;i++){
            if(p.charAt(i-1) == '*' && i > 1) {
                a[i][0] = a[i-2][0];
            } else {
                a[i][0] = false;
            }
        }
        for(int i=1; i <= pl; i++) {
            for(int j=1; j <= sl; j++) {
            	if(i == 1 && p.charAt(0) == '*'){
            		a[i][j] = true;
            	} else if(p.charAt(i-1) == '*' && i != 1) {
                    a[i][j] = a[i-2][j] || a[i-1][j] || 
                        (a[i][j-1] && (p.charAt(i-2) == '?' || p.charAt(i-2) == s.charAt(j-1)));
                } else {
                    a[i][j] = a[i-1][j-1]
                            && (p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1));
                    
                }
                         
            }
        }
        return a[pl][sl];
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("b", "?*?"));
    }

}
