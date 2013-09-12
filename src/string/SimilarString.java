package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimilarString {

	    List<String> similar(List<String> d, String q){
	        List<String> res = new ArrayList<String>();
	        if(q == null || d == null){
	            return res;
	        }
	        int len = q.length();
	        for(String s : d){
	            if (s == null || s.length() < len - 1 || s.length() > len + 1) {
	                continue;
	            }
	            if(isDistanceWithinOne(s,  q, 0)){
	                res.add(s);
	            }
	        }
	        return res;
	    }
	    
	    boolean isDistanceWithinOne(String s1, String s2, int distance){
	        if(s1.length() == 0){
	            return s2.length() + distance <= 1;
	        }
	        if(s2.length() == 0){
	            return s1.length() + distance <= 1;
	        }
	        char c1 = s1.charAt(0);
	        char c2 = s2.charAt(0);
	        if(c1 != c2){
	            if(distance == 1){
	                return false;
	            }
	            return isDistanceWithinOne(s1.substring(1), s2, 1) 
	                || isDistanceWithinOne(s1, s2.substring(1), 1)
	                || isDistanceWithinOne(s1.substring(1), s2.substring(1), 1);
	        }
	        return isDistanceWithinOne(s1.substring(1), s2.substring(1), 0)
	                || isDistanceWithinOne(s1.substring(1), s2, 1) 
	                || isDistanceWithinOne(s1, s2.substring(1), 1);
	    }

	    public static void main(String[] args) {
			String q = "a";
	        String ss[] = {"", "a",  "b", "ab", "abc", "acb", "cab", "cabd"};
	        List<String> d = Arrays.asList(ss);
	        for(String s : new SimilarString().similar(d, q)){
	            System.out.println(s);
	        }
		}



}
