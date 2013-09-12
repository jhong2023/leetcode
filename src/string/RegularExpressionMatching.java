package string;

import junit.framework.Assert;

// http://leetcode.com/2011/09/regular-expression-matching.html
public class RegularExpressionMatching {
	
    public boolean isMatch_dpp(String s, String p) {
        if(s == null || p == null) return false;
        int slen = s.length();
        int plen = p.length();
        if(slen == 0 && plen == 0) return true;

        
        boolean a[][] = new boolean[slen+1][plen+1];
        a[0][0] = true;
        for(int j = 2; j <= plen; j++){
            if(p.charAt(j-1) == '*'){
                a[0][j] = a[0][j-2];
            }
        }
        // <=, i-1, j-1
        for(int i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
            	
                if(j > 1 && p.charAt(j-1) == '*'){
                    a[i][j] = a[i][j-2] 
                        || (match(s.charAt(i-1), p.charAt(j-2)) && (a[i][j-1] || a[i-1][j]));
                }
            
                if(!a[i][j] && match(s.charAt(i-1), p.charAt(j-1))){
                    a[i][j] = a[i-1][j-1];
                }
            }
        }
        return a[slen][plen];
    }

    
    public boolean match(char s, char p){
        return s == p || p == '.';
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
            }
        }
        for(int i=1; i <= pl; i++) {
            for(int j=1; j <= sl; j++) {
                if(i != 1 && p.charAt(i-1) == '*' ) {
                    a[i][j] = a[i-2][j] || a[i-1][j] || 
                        (a[i][j-1] && (p.charAt(i-2) == '.' || p.charAt(i-2) == s.charAt(j-1)));
                } else {
                    a[i][j] = a[i-1][j-1]
                            && (p.charAt(i-1) == '.' || p.charAt(i-1) == s.charAt(j-1));
                    
                }
                         
            }
        }
        return a[pl][sl];
    }
    
    // wrote on 9/1
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        int slen = s.length();
        int plen = p.length();
        if(slen == 0 && plen == 0) return true;
        
        if(plen > 1 && p.charAt(1) == '*'){
            if(isMatch(s, p.substring(2))) return true;
            if(slen > 0 && matchHead(s, p)){
                if(isMatch(s.substring(1), p)) return true;
                if(isMatch(s.substring(1), p.substring(2))) return true;
            }
        }
        if(slen > 0 && plen > 0 && matchHead(s, p)){
            if(isMatch(s.substring(1), p.substring(1))){
                return true;
            }
        }
        return false;
    }
    
    public boolean matchHead(String s, String p){
        return s.charAt(0) == p.charAt(0) || p.charAt(0) == '.';
    }
	/*
    public boolean isMatch(String s, String p) {

        if (p == null && s == null)
            return true;
        if (p == null || s == null)
            return false;
        if (p.length() == 0)
            return s.length() == 0;
        if (s.length() == 0) {
            if (p.length() == 0)
                return true;
            if (p.length() == 1)
                return false;
            if (p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            }
            return false;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                if (isMatch(s.substring(1), p)
                        || isMatch(s.substring(1), p.substring(2))) {
                    return true;
                }
            }

            return isMatch(s, p.substring(2));
        }

        if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
    */
    

    public void testIsMatch() {
        Assert.assertEquals(false, isMatch("aa", "a"));
        Assert.assertEquals(true, isMatch("aa", "aa"));
        Assert.assertEquals(false, isMatch("aaa", "aa"));
        Assert.assertEquals(true, isMatch("aa", "a*"));
        Assert.assertEquals(true, isMatch("aa", ".*"));
        Assert.assertEquals(true, isMatch("ab", ".*"));
        Assert.assertEquals(true, isMatch("aab", "c*a*b"));
        Assert.assertEquals(true, isMatch("a", "ab*"));
    }
}
