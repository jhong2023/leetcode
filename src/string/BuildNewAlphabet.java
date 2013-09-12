package string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BuildNewAlphabet {
	List<Character> build(String[] words, int N) {
		int graph[][] = new int[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				graph[i][j] = 0;
			}
		}
		buildGraph(words, graph);
		int degree[] = new int[N];
		for(int i=0; i<N; i++){
			degree[i] = 0;
		}
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(graph[i][j] == 1){
					degree[j]++;
				}
			}
		}
		List<Character> res = new ArrayList<Character>();
		Queue<Integer> zeroDedgree = new LinkedList<Integer>();
		for(int i=0; i<N; i++){
			if(degree[i] == 0){
				zeroDedgree.add(i);
			}
		}
		while(!zeroDedgree.isEmpty()){
			int n = zeroDedgree.remove();
			res.add((char) ('a' + n));
			for(int j=0;j<N;j++){
				if(graph[n][j] == 1){
					degree[j]--;
					if(degree[j] == 0){
						zeroDedgree.add(j);
					}
				}
			}
		}
		return res;
	}

	private void buildGraph(String[] words, int[][] graph) {
		for(int i=0; i<words.length -1; i++){
			String str1 = words[i];
			String str2 = words[i+1];
			int j = 0;
			while(j<str1.length() && j<str2.length() && str1.charAt(j) == str2.charAt(j)){
				j++;
			}
			if(j<str1.length() && j<str2.length()){
				graph[str1.charAt(j) - 'a'][str2.charAt(j) - 'a'] = 1;
			}
		}
	}
	
	public static void main(String[] args) {
		String[] words = {"cab","bca", "bac", "abc"};
		String s = "";
		for(char c : new BuildNewAlphabet().build(words, 3)){
			s += c;
		}
		System.out.println(s);
	}
	

}
