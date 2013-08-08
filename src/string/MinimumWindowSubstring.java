package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumWindowSubstring {
    
	 public static String minWindow_(String S, String T) {
		 	Map<Character, Integer> needToFound = new HashMap<Character, Integer>();
		 	Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
		 	int sLen = S.length();
		 	int tLen = T.length();
		 	if(tLen > sLen) return "";
		 	for(char c : T.toCharArray()){
		 		if(needToFound.containsKey(c)){
		 			needToFound.put(c, needToFound.get(c) + 1);
		 		} else {
		 			needToFound.put(c, 1);
		 		}
		 	}
		 	
		 	int found = 0;
		 	int min = Integer.MAX_VALUE;
		 	int minBegin = 0;
		 	for(int begin = 0, end = 0; end<sLen; end++){
		 		char c = S.charAt(end);
		 		if(!needToFound.containsKey(c)){
		 			continue;
		 		}
		 		if(!hasFound.containsKey(c)){
		 			// 1 not 0
		 			hasFound.put(c, 1);
		 		} else {
		 			hasFound.put(c, hasFound.get(c) + 1);
		 		}
		 		if(hasFound.get(c) <= needToFound.get(c)) {
		 			found++;
		 		}
		 		if(found == tLen){
		 			char cc = S.charAt(begin);
		 			while(!hasFound.containsKey(cc) || hasFound.get(cc) > needToFound.get(cc)){
		 				if(hasFound.containsKey(cc)){
		 					hasFound.put(cc, hasFound.get(cc) - 1);
		 				}
		 				// increase begin and update cc
		 				begin++;
		 				cc = S.charAt(begin);
		 			}
		 			if(end - begin < min) {
		 				min = end - begin;
		 				minBegin = begin;
		 			}
		 		}
		 	}
		 	
		 	if(min == Integer.MAX_VALUE) return "";
		 	return S.substring(minBegin, minBegin+min+1);
	   }
	 
	 public static String minWindow(String S, String T) {
		 Map<Character, LinkedList<Integer>> map = new HashMap<Character, LinkedList<Integer>>();
		 for(char c : T.toCharArray()){
			 map.put(c, new LinkedList<Integer>());
		 }
		 for(int i=0; i<S.length(); i++){
			 char c = S.charAt(i);
			 if(map.containsKey(c)){
				 LinkedList<Integer> aa = map.get(c);
				 aa.add(i);
				 map.put(c, aa);
			 }
		 }
		 PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		 int index = 0;
		 int max  = Integer.MIN_VALUE;
		 int min = Integer.MAX_VALUE;
		 for(char c : T.toCharArray()){
			 LinkedList<Integer> aa = map.get(c);
			 int a = aa.poll();
			 if(a>max){
				 max=a;
			 }
			 if(a<min){
				 min=a;
			 }
			 q.add(a);
		 }
		 
		 return "";
		 
		// int min = 
	 }
    
    public static void main(String[] args) {
    	// System.out.println(minWindow("aaabdabcefaecbef", "abc"));
    	// System.out.println(minWindow("ab", "b"));
    	System.out.println(minWindow("bdab", "ab"));
    }

	 // Only for sub sequence, like "abc" in "ababac"
    public String minWindow_dp(String S, String T) {
        int[][] t = new int[T.length()][S.length()];
        t[0][0] = S.charAt(0) == T.charAt(0)?1 : 0;
        for (int i=1; i<S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                t[0][i] = 1;
            } else if (t[0][i-1] != 0) {
                t[0][i] = t[0][i-1] + 1;
            }
        }
        
        for (int i=1; i < T.length(); i++) {
            for (int j=i;j < S.length();j++) {
                if (S.charAt(j) == T.charAt(i) && t[i-1][j-1] != 0) {
                    t[i][j] = t[i-1][j];
                } else if (t[i][j-1] != 0) {
                    t[i][j] = t[i][j-1] + 1;
                }
            }
        }
        
        if (t[T.length()-1][S.length()-1] == 0) return "";
        
        int minWindow = t[T.length()-1][S.length()-1];
        int minIndex = S.length() - 1;
        for (int i=S.length() - 2; i >= 0; i--) {
            if (t[T.length()-1][i] == 0) {
                break;
            }
            if (t[T.length()-1][i] < minWindow) {
                minWindow = t[T.length()-1][i];
                minIndex = i;
            }
        }
        return S.substring(minIndex - minWindow + 1, minIndex + 1);
    }
}
