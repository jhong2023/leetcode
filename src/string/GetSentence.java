package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetSentence {
	
	class Trie{
		boolean isWord;
		Trie children[] = new Trie[26];
	}
	
	Trie buildTrie(Set<String> dictionary){
		Trie t = new Trie();
		for(String s : dictionary) {
			if(s.length() > 0){
				insertToTrie(t, s);
			}
		}
		return t;
	}
	
	void insertToTrie(Trie t, String s){
		if(s.length() == 0){
			t.isWord = true;
			return;
		}
		for(char c : s.toCharArray()){
			if(t.children[c-'a'] == null) {
				t.children[c-'a'] = new Trie();
			}
			insertToTrie(t.children[c-'a'], s.substring(1));
		}
	}
	
	String getSentence(String text, Set<String> dictionary){
		Trie t = buildTrie(dictionary);
		return getSentence(t, text, 0);
	}
	
	String getSentence(Trie t, String text, int k) {
		if(k == text.length()){
			return "";
		}
		for(int i : getIndices(t, text, k)){
			String res = getSentence(t, text, i);
			if(res != null) {
				return text.substring(k, i) + ", " + res;
			}
		}
		return null;
	}

	private List<Integer> getIndices(Trie t, String text, int k) {
		List<Integer>  res = new ArrayList<Integer>();
		if(t.isWord){
			res.add(k);
		}
		
		// must check k
		if(k == text.length()) {
			return res;
		}
		if(t.children[text.charAt(k) - 'a'] != null){
			res.addAll(getIndices(t.children[text.charAt(k) - 'a'], text, k+1));
		}
		return res;
	}

	public static void main(String[] args) {
		String text =  "iamastudentfromwaterloo";
		String ss[] = {"from", "waterloo", "hi", "am", "yes", "i", "a", "student"};
		Set<String> dictionary = new HashSet<String>();
		for(String s : ss) {
			dictionary.add(s);
		}
		System.out.println(new GetSentence().getSentence(text, dictionary));
	}

}
