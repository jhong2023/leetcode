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

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("b", "?*?"));
    }

}
