package string;

public class LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        return longestPalindrome(s, 0, s.length() -1 );        
    }
    
    public String longestPalindrome(String s, int i, int j) {
        if(isPalindromeString(s, i, j)) {
            return s.substring(i, j+1);
        }
        String s1 = longestPalindrome(s, i+1, j);
        String s2 = longestPalindrome(s, i, j-1);
        return s1.length() > s2.length() ? s1 : s2;
    }
    
    private boolean isPalindromeString(String s, int i, int j) {
        while(i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
    
    
    String expandAroundCenter(String s, int c1, int c2) {
        int l = c1, r = c2;
        int n = s.length();
        while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
          l--;
          r++;
        }
        return s.substring(l+1, r);
      }
       
       String longestPalindrome_(String s) {
        int n = s.length();
        if (n == 0) return "";
        String longest = s.substring(0, 1); 
        for (int i = 0; i < n-1; i++) {
          String p1 = expandAroundCenter(s, i, i);
          if (p1.length() > longest.length())
            longest = p1;
       
          String p2 = expandAroundCenter(s, i, i+1);
          if (p2.length() > longest.length())
            longest = p2;
        }
        return longest;
      }
       
       
       
       
       

    public static void main(String[] args) {

    }

}
