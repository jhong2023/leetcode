package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

    public int ladderLength(String start, String end, HashSet<String> dict) {
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        q.offer(null);
        int i = 1;
        while(!q.isEmpty()) {
            String s = q.remove();
            if (s == null) {
                i++;
                // Must check to avoid dead loop
                if (q.isEmpty()) {
                	break;
                }
                q.offer(null);
                continue;
            }
            if (s.equals(end)) {
                return i;
            }
            
            for(String t : getPossible(s, dict)) {
               q.offer(t);
            }
        }
        return 0;
    }
    
    List<String> getPossible(String s, HashSet<String> dict){
        char[] cc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        ArrayList<String> aa = new ArrayList<String>();
        for (int i = 0; i<s.length(); i++) {
            for (char c : cc) {
                String t = s.substring(0, i) + c + s.substring(i+1);
                if (dict.contains(t)) {
                    aa.add(t);
                    dict.remove(t);
                }
            } 
        }
        return aa;
        
    }
    
    public static void main(String[] args) {
    	HashSet<String> h = new HashSet<String>();
    	String[] ss = {"hot","dog"};
    	for (String s : ss) {
    		h.add(s);
    		
    	}
    	System.out.println(new WordLadder().ladderLength("hot", "dog", h));
		
	}


    

}
