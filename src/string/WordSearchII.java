package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {

	List<String> search(char board[][], Set<String> dict){
		List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                DFS(board, dict, i, j, "", res);
            }
        }
        return res;
	}
	
    private void DFS(char[][] board, Set<String> dict, int i, int j, String prefix, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') return;
        prefix = prefix + board[i][j];
        if (dict.contains(prefix)) {
           res.add(prefix);
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        DFS(board, dict, i + 1, j, prefix, res);
        DFS(board, dict, i - 1, j, prefix, res);
        DFS(board, dict, i, j + 1, prefix, res);
        DFS(board, dict, i, j - 1, prefix, res);
        board[i][j] = tmp;
    }
    
    public class Trie{
		boolean isWord;
		Trie children[] = new Trie[26];
	}
	
	Trie buildTrie(List<String> dictionary){
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
		char c = s.charAt(0);
		if(t.children[c-'a'] == null) {
			t.children[c-'a'] = new Trie();
		}
		insertToTrie(t.children[c-'a'], s.substring(1));
	}
	
	List<String> searchWithTrie(char board[][], Trie dict){
		List<String> res = new ArrayList<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
            	DFSWithTrie(board, dict, i, j, "", res);
            }
        }
        return res;
	}
	
    private void DFSWithTrie(char[][] board, Trie dict, int i, int j, String prefix, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#') return;
        if(dict.children[board[i][j] - 'a'] == null){
        	return;
        }
        dict = dict.children[board[i][j] - 'a'];
        prefix = prefix + board[i][j];
        if(dict.isWord){
        	res.add(prefix);
        }
        
        char tmp = board[i][j];
        board[i][j] = '#';
        DFSWithTrie(board, dict, i + 1, j, prefix, res);
        DFSWithTrie(board, dict, i - 1, j, prefix, res);
        DFSWithTrie(board, dict, i, j + 1, prefix, res);
        DFSWithTrie(board, dict, i, j - 1, prefix, res);
        board[i][j] = tmp;
    }
    
    public static void main(String[] args) {
		char board[][] = {
				{'a','b','c'},
				{'d','a','e'},
				{'h','b','i'}
		};
		
		Set<String> dict = new HashSet<String>();
		String ss[] = {"ababi", "a", "da", "dada", "eic", "abhdabcei"};
		List<String> list = Arrays
				.asList(ss);
		dict.addAll(list);
		
		WordSearchII ws = new WordSearchII();
		Trie trie = ws.buildTrie(list);
		List<String> res = ws.searchWithTrie(board, trie);
		
		for(String s : res){
			System.out.println(s);
		}
		
		System.out.println("--------");
		res = ws.search(board, dict);
		for(String s : res){
			System.out.println(s);
		}
	}

}
