package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	
	// most simple and bug free
    public int lengthOfLongestSubstring_best(String s) {
        if( s == null) return 0;
        
        Map<Character, Integer> m = new HashMap<Character, Integer>();
        int len = s.length();
        
        int max = 0;
        int start = -1;
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(m.get(c) != null && m.get(c) > start){
                start = m.get(c);  
            } else {
                max = Math.max(i - start, max);
            }
            m.put(c, i);
        }
        
        return max;
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int len = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                int t = i - map.get(c);
                // Don't use len++
                len = t > len ? len+1 : t;
            } else {
                len++;
            }
            // Mistake it put inside of else
            if(len > max) {
                max = len;
            }
            map.put(c, i);
        }
        
        return max;
    }

    public int lengthOfLongestSubstring_(String s) {

        String str = s;
        if (str == null)
            return -1;
        if (str.length() < 2)
            return str.length();
        int a[] = new int[26];
        for (int i = 0; i < 26; i++) {
            a[i] = -1;
        }
        int b[] = new int[str.length()];
        a[str.charAt(0) - 'a'] = 0;
        b[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            b[i] = b[i - 1] + 1;
            if (a[c - 'a'] != -1) {
                if (i - a[c - 'a'] < b[i]) {
                    b[i] = i - a[c-'a'];
                }
            }
            a[c - 'a'] = i;
        }

        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (b[i] > max) {
                max = b[i];
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
//		System.out.println(lengthOfLongestSubstring("abcabcde")); // 5
		System.out.println(lengthOfLongestSubstring("zbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwltwjwnnvbwjckdmeouuzhyvhg")); // 13

	}
}
