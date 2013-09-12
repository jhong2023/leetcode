package hack;

import java.util.HashMap;
import java.util.Map;

public class MiniumWindow {
	
	int findMiniumWindow(String s, String t){
		Map<Character, Integer> needed = new HashMap<Character, Integer>();
		Map<Character, Integer> founded = new HashMap<Character, Integer>();
		for(char c : t.toCharArray()){
			if(needed.containsKey(c)){
				needed.put(c, needed.get(c)+1);
			} else {
				needed.put(c, 1);
			}
		}
		
		int start = 0;
		int minW = Integer.MAX_VALUE;
		int toFound = t.length();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(!needed.containsKey(c)){
				continue;
			}
			if(founded.containsKey(c)){
				founded.put(c, founded.get(c) + 1);
			} else {
				founded.put(c, 1);
			}
			if(toFound > 0){
				toFound--;
			} else {
				int j = start;
				while(j < i){
					c = s.charAt(j);
					if(!founded.containsKey(c)){
						j++;
						continue;
					}
					if(founded.get(c) > needed.get(c)){
						founded.put(c, founded.get(c) - 1);
						j++;
					} else {
						start = j;
						break;
					}
				}
			}
			
			if(toFound == 0){
				minW = Math.min(minW, i - start + 1);
			}
		}
		return minW;
	}
	
	public static void main(String[] args) {
		System.out.println(new MiniumWindow().findMiniumWindow("DDUEFFTT", "DEF"));
	}

}
