package string;

import junit.framework.Assert;


public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {

        if (p == null && s == null)
            return true;
        if (p == null || s == null)
            return false;
        if (p.length() == 0)
            return s.length() == 0;
        if (s.length() == 0) {
            if (p.length() == 0)
                return true;
            if (p.length() == 1)
                return false;
            if (p.charAt(1) == '*') {
                return isMatch(s, p.substring(2));
            }
            return false;
        }

        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
                if (isMatch(s.substring(1), p)
                        || isMatch(s.substring(1), p.substring(2))) {
                    return true;
                }
            }

            return isMatch(s, p.substring(2));
        }

        if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }

    public void testIsMatch() {
        Assert.assertEquals(false, isMatch("aa", "a"));
        Assert.assertEquals(true, isMatch("aa", "aa"));
        Assert.assertEquals(false, isMatch("aaa", "aa"));
        Assert.assertEquals(true, isMatch("aa", "a*"));
        Assert.assertEquals(true, isMatch("aa", ".*"));
        Assert.assertEquals(true, isMatch("ab", ".*"));
        Assert.assertEquals(true, isMatch("aab", "c*a*b"));
        Assert.assertEquals(true, isMatch("a", "ab*"));
    }
}
