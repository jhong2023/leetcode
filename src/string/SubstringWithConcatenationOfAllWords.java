package string;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords {
    
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i=0; i<L.length; i++) {
            map.put(L[i], 0);
        }
        
        int wordLength = L[0].length();
        for (int i=0; i<wordLength; i++) {
            
            for (int j=i;j <= S.length() - wordLength; j++) {
                if (map.containsKey(S.substring(j, j + wordLength))) {
                    
                }
            }
            
        }
        return null;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
