package string;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {

	public ArrayList<Integer> findSubstring(String S, String[] L) {

		HashMap<String, Integer> need = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (need.get(L[i]) == null) {
				need.put(L[i], 1);
			} else {
				need.put(L[i], need.get(L[i]) + 1);
			}
		}

		ArrayList<Integer> res = new ArrayList<Integer>();
		int wordLength = L[0].length();
		for (int i = 0; i <= S.length() - wordLength * L.length; i++) {

			int count = 0;
			int j = i;
			int start = j;
			HashMap<String, Integer> found = new HashMap<String, Integer>();
			for (int k = 0; k < L.length; k++) {
				found.put(L[k], 0);
			}

			while (j <= S.length() - wordLength) {
				String key = S.substring(j, j + wordLength);
				if (need.containsKey(key) && found.get(key) < need.get(key)) {
					found.put(key, found.get(key) + 1);
					count++;
				} else {
					break;
				}
				if (count == L.length) {
					res.add(start);
					break;
				}
				j = j + wordLength;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String s = "aaa";
		String[] dict = { "a", "a" };
		new SubstringWithConcatenationOfAllWords().findSubstring(s, dict);
	}

}
