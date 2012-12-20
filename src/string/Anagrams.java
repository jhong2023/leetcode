package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagrams {

    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> values = null;
            if (map.containsKey(key)) {
                values = map.get(key);
            } else {
                values = new ArrayList<String>();
            }
            values.add(s);
            map.put(key, values);
        }
        ArrayList<String> result = new ArrayList<String>();
        for (List<String> v : map.values()) {
            if (v.size() > 1) {
                result.addAll(v);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"a", "a"};
        new Anagrams().anagrams(strs);
    }

}
