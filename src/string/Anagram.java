package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public ArrayList<String> anagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(String s : strs){
            char c[] = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            if(map.get(key) == null){
                ArrayList<String> list = new ArrayList<String>();
                list.add(s);
                map.put(key, list);
            } else {
                map.get(key).add(s);
            }
        }
        
        ArrayList<String> res = new ArrayList<String>();
        
        for(String key : map.keySet()){
            if(map.get(key).size() > 1){
                res.addAll(map.get(key));
            }
        }
        return res;
    }
}
