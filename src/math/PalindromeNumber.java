package math;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber {

    static public boolean isPalindrome(int x) {
    	if(x < 0) return false;
    	int t = x;
    	List<Integer> a = new ArrayList<Integer>();
    	while(t > 0) {
    		a.add(t%10);
    		t = t / 10;
    	}
    	
    	int i = 0;
    	int j = a.size() - 1;
    	while(i < j) {
    		if(a.get(i) != a.get(j)) {
    			return false;
    		}
    		i++;
    		j--;
    	}
    	
    	return true;
    }
    
    public static void main(String[] args) {
		System.out.println(isPalindrome(-2147483648));
	}
}
