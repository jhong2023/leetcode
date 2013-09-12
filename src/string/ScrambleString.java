package string;

import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

	public static boolean isScramble(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if (s1.equals(s2))
			return true;
		if (len1 != len2 || !isPermutation(s1, s2)) {
			return false;
		}

		for (int i = 1; i < s1.length(); i++) {
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i, len1), s2.substring(i, len2))) {
				return true;
			}
			if (isScramble(s1.substring(0, i), s2.substring(len2 - i, len2))
					&& isScramble(s1.substring(i, len1),
							s2.substring(0, len2 - i))) {
				return true;
			}
		}
		return false;
	}

	static boolean isPermutation(String s1, String s2) {
		Map<Character, Integer> m = new HashMap<Character, Integer>();

		for (char c : s1.toCharArray()) {
			if (!m.containsKey(c)) {
				m.put(c, 1);
			} else {
				m.put(c, m.get(c) + 1);
			}
		}

		for (char c : s2.toCharArray()) {
			if (!m.containsKey(c) || m.get(c) <= 0) {
				return false;
			}
			m.put(c, m.get(c) - 1);
		}
		return true;
	}

	/*
	 * static public boolean isScramble_(String s1, String s2) { if (s1.length()
	 * != s2.length()) return false; if (s1.length() == 0) return true; if
	 * (s1.length() == 1) { return s1.equals(s2); } for (int i = 1; i <
	 * s1.length(); i++) { if (isScramble(s1.substring(0, i), s2.substring(0,
	 * i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i,
	 * s2.length()))) { return true; } if (isScramble(s1.substring(0, i),
	 * s2.substring(s2.length() - i, s2.length())) && isScramble(s1.substring(i,
	 * s1.length()), s2.substring(0, s2.length()-i))) { return true; } } return
	 * false; }
	 * 
	 * static public boolean isScramble(String s1, String s2) { if (s1.length()
	 * != s2.length()) return false; if (s1.length() == 0) return true; char[]
	 * a1 = s1.toCharArray(); char[] a2 = s2.toCharArray(); Arrays.sort(a1);
	 * Arrays.sort(a2); if (s1.length() == 1) { return s1.equals(s2); } if
	 * (!a1.equals(a2)) { return false; } for (int i = 1; i < s1.length(); i++)
	 * { if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
	 * isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()))) {
	 * return true; } if (isScramble(s1.substring(0, i),
	 * s2.substring(s2.length() - i, s2.length())) && isScramble(s1.substring(i,
	 * s1.length()), s2.substring(0, s2.length()-i))) { return true; } } return
	 * false; }
	 */

	public static void main(String[] args) {
		System.out.println(isScramble("ab", "ab"));
	}

}
