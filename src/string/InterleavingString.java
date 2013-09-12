package string;

public class InterleavingString {
	
	// f(i, j) = (s1[i] == s3[i+j-1] && f(i-1,j) ) || 
    public boolean isInterleave_dp(String s1, String s2, String s3) {
        
	        if(s1 == null || s2 == null || s3 == null) {
	            return false;
	        }
	        int l1 = s1.length();
	        int l2 = s2.length();
	        int l3 = s3.length();
	        if(l1 == 0){
	            return s2.equals(s3);
	        }
	        if(l2 == 0){
	            return s1.equals(s3);
	        }
	        if(l1 + l2 != l3){
	            return false;
	        }
	        
	        boolean a[][] = new boolean[l1 + 1][l2 + 1];
	        a[0][0] = true;
	        int i = 0;
	        while(i < l1 && s1.charAt(i) == s3.charAt(i)){
	            a[i+1][0] = true;
	            i++;
	        }
	        int j = 0;
	        while(j < l2 && s2.charAt(j) == s3.charAt(j)){
	            a[0][j+1] = true;
	            j++;
	        }
	        for(i=1; i<=l1; i++){
	            for(j=1; j<=l2; j++){
	               a[i][j] = (a[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))
	                    || (a[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
	            }
	        }
	        
	        return a[l1][l2];
    }
    
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
