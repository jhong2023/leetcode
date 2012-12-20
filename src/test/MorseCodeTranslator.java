package test;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeTranslator {
    
    static String[] MORSE_TABLE = {   
                  ".-",
                  "-...",
                  "-.-.",
                  "-..",
                  ".",
                  "..-.",
                  "--.",
                  "...."};
    
    class MorseNode{
        Character c;
        Character v;
        Map<Character, MorseNode> children = new HashMap<Character, MorseNode>();
    }
    
    static String WORD_DELIMETER = "      "; // 6 space
    
    String encode(String str) {
        StringBuffer result = new StringBuffer();
        boolean inSpace = true;
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (!inSpace) {
                    inSpace = true;
                    result.append(WORD_DELIMETER);
                }
            } else {
                inSpace =false;
                result.append(MORSE_TABLE[c - 'A']);
                result.append(" ");
            }
        }
        return result.toString().trim();
    }
    
    public static void main(String[] args) {
        MorseCodeTranslator t = new MorseCodeTranslator();
        System.out.println(t.encode(" AE BD E "));
    }

}
