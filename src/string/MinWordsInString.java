package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinWordsInString {
    
    static class WordDict {
        Character c;
        Map<Character, WordDict> childeren;
        boolean isWord;
        public WordDict(Character c) {
            this.c = c;
            this.childeren = new HashMap<Character, WordDict>();
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
            curDict = dict.childeren.get(c);
        }
        insertWord(w.substring(1), curDict);
    }
    
    static int splitWords(String str, WordDict dict) {
        int[] r = new int[str.length()];
        for (int i=str.length() -1 ; i>=0;i--) {
            List<Integer> indexs = new ArrayList<Integer>();
            for(Integer idx : findWordIndexs(dict, str, i, indexs)) {
                if (idx == str.length() - 1) {
                    r[i] = 1;
                } else if (r[idx + 1] != 0 && 
                        (r[i] == 0 || r[i] > r[idx + 1] + 1)) {
                    r[i] = r[idx + 1] + 1;
                }
            }
        }
        
        return r[0];
    }

    static private List<Integer> findWordIndexs(WordDict dict, String str, int i, List<Integer> result) {
        if (i == str.length()) return result;
        Character c = str.charAt(i);
        if (dict.childeren.containsKey(c)) {
            WordDict child = dict.childeren.get(c);
            if (child.isWord) {
                result.add(i);
            }
            findWordIndexs(child, str, i+1, result);
        }
        return result;
    }

    public static void main(String[] args) {
   
        WordDict dict = new WordDict(null);
        insertWord("forever", dict);
        insertWord("carrot", dict);
        insertWord("for", dict);
        insertWord("ever", dict);
        insertWord("car", dict);
        insertWord("rot", dict);
        
        System.out.println(splitWords("forevercarrot", dict));
        
    }

}
