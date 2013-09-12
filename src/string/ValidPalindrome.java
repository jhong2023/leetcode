package string;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if (s == null) return false;
        int i = 0;
        int j = s.length() -1;
        while(i<j){
            if(!isAlphaNumeric(s.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphaNumeric(s.charAt(j))){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    static boolean isAlphaNumeric(char c){
    	if(c>='a' && c<='z'){
    		return true;
    	}
    	if(c>='0' && c<='9'){
    		return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	String s = "A man, a plan, a canal: Panama";
    	s = s.toLowerCase();
		System.out.println(isPalindrome(s));
	}

}
