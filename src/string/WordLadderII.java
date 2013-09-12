package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordLadderII {

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
              
        if(start == null || end == null || start.length() != end.length()){
            return null;
        }
        
        LinkedList<String> q = new LinkedList<String>();
        Map<String, List<String>> path = new HashMap<String,List<String>>();
        path.put(start, null);
        q.add(start);
        q.add(null);
        
        while(!q.isEmpty()){
            String s = q.remove();
            if(s == null){
                if(q.isEmpty()){
                    break;
                }
                q.add(null);
                continue;
            }
            if(s.equals(end)){
                return getPath(end, path);
            } 
            for(String ss : getOneChangeWords(s, dict)){
                if(!path.containsKey(ss)){
                    q.add(ss);
                    List<String> list = new ArrayList<String>();
                    list.add(s);
                    path.put(ss, list);
                } else if(path.get(ss) != null){
                	List<String> list = path.get(ss);
                	list.add(s);
                	path.put(ss, list);
                }
            }
        }
        return null;
    }
    
    ArrayList<ArrayList<String>> getPath(String end, Map<String, List<String>> path){
    	return getPath(end, path, new ArrayList<String>());
    }
    
    ArrayList<ArrayList<String>> getPath(String child, Map<String, List<String>> path, ArrayList<String> pre){
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	pre.add(child);
        if(path.get(child) == null) {
        	res.add(pre);
        	return res;
        }
        for(String s : path.get(child)){
        	ArrayList<String> tmp = new ArrayList<String>();
        	tmp.addAll(pre);
        	res.addAll(getPath(s, path, tmp));
        }
       
        return res;
    }
    
    List<String> getOneChangeWords(String s, HashSet<String> dict){
        List<String> res = new ArrayList<String>();
        int len = s.length();
        
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            for(int j = 0; j < 26; j++){
                if(c != 'a' + j){
                    String tmp = s.substring(0, i) + (char) ('a'+j) + s.substring(i+1, len);
                    if(dict.contains(tmp)){
                        res.add(tmp);
                    }
                }
            }
            
        }
        Collections.reverse(res);
        return res;
        
    }
    
    // "a", "c", ["a","b","c"]
    public static void main(String[] args) {
    	WordLadderII wl = new WordLadderII();
    	HashSet<String> set = new HashSet<String>();
    	String ss[] = {"hot", "dot", "dog"}; //{"a", "b", "c"};
    	set.addAll(Arrays.asList(ss));
    	for(List<String> res : wl.findLadders("hot", "dog", set)){
    		for(String s : res){
    			System.out.println(s);
    		}
    	}
    	
    	
	}
}