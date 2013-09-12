package combination;

import java.util.ArrayList;

public class LettleCombinationOfPhoneNumber {

	String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	 public ArrayList<String> letterCombinations(String digits) {
		 return combination(digits, 0, "", new ArrayList<String>());
	 }
	 
	 ArrayList<String> combination(String digits, int i, String prefix, ArrayList<String> res){
		 int len = digits.length();
		 if(i ==  len){
			 res.add(prefix);
			 // return here
			 return res;
		 }
		 for(char c : map[digits.charAt(i) - '0'].toCharArray()){
			 combination(digits, i+1, prefix + c, res);
		 }
		 return res;
	 }
	 
	 public static void main(String[] args) {
		ArrayList<String> res = new LettleCombinationOfPhoneNumber().letterCombinations("23");
		for(String s : res){
			System.out.println(s);
		}
	}

}
