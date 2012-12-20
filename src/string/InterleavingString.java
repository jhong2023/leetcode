package string;

public class InterleavingString {
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) return false;
        if (s3.length() != s1.length() + s2.length()) return false;
        if (s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        
        int i = 0;
        int j = 0;
        while (i < s1.length() && j<s2.length()) {
            if (s1.charAt(i) == s3.charAt(i+j) && s2.charAt(j) == s3.charAt(i+j)) {
                return isInterleave(s1.substring(i+1), s2.substring(j), s3.substring(i+j+j))
                        || isInterleave(s1.substring(i), s2.substring(j+1), s3.substring(i+j+1));
            } else if (s1.charAt(i) == s3.charAt(i+j)) {
                i++;
            }  else if (s2.charAt(j) == s3.charAt(i+j)) {
                j++;
            } else {
                return false;
            }
        }
        
        while (i < s1.length()) {
            if (s1.charAt(i) != s3.charAt(i+j)) {
                return false;
            }
            i++;
        }
        
        while (j < s2.length()) {
            if (s2.charAt(j) != s3.charAt(i+j)) {
                return false;
            }
            j++;
        }
        
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave("aa", "ab", "aaba"));
    }

}
