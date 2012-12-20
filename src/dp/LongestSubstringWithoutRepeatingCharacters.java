package dp;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

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
}
