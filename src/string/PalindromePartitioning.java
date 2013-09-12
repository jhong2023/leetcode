package string;

import java.util.ArrayList;

public class PalindromePartitioning {

	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>();
		
		if (s.length() < 1) {
			ArrayList<String> a = new ArrayList<String>();
			r.add(a);
		} else {
			for (int i=1; i<=s.length(); i++) {
				String ss = s.substring(0, i);
				if (isPalindrome(ss)) {
					for (ArrayList<String> aa : partition(s.substring(i))) {
						// for test on leetcode
						aa.add(0, ss);
						r.add(aa);
					}
				}
				
			}
			
		}
		
		return r;
    }

	private boolean isPalindrome(String s) {
		int i = 0; 
		int j = s.length() - 1;
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		
		if (i < j) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(new PalindromePartitioning().partition("ab"));
	}

}
