package string;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    
    static class WordDict {
        Map<Character, WordDict> childeren;
        boolean isWord;
        int count;
        public WordDict(Character c) {
            this.childeren = new HashMap<Character, WordDict>();
            this.count = 1;
        }
    }
    
    static void insertWord(String w, WordDict dict) {
        if (w.length() == 0) {
            dict.isWord = true;
            return;
        }
        Character c = w.charAt(0);
        WordDict curDict;
        if (!dict.childeren.containsKey(c)) {
            curDict = new WordDict(c);
            dict.childeren.put(c, curDict);
        } else {
            dict.count++;
            curDict = dict.childeren.get(c);
        }
        insertWord(w.substring(1), curDict);
    }
    
    String searchDict(String w, WordDict dict, int size) {
        if (w.length() == 0) {
            return "";
        }
        Character c = w.charAt(0);
        if (dict.count == size) {
            return c + searchDict(w.substring(1), dict.childeren.get(c), size);
        } else {
            return "";
        }
    }
    
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        WordDict dict = new WordDict(null);
        for (String str : strs) {
            insertWord(str, dict);
        }
        return searchDict(strs[0], dict, strs.length);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
