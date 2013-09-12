package string;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        
        HashMap<Character, Character> map = new  HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for(Character c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
                continue;
            }
            
            if(st.isEmpty() || c != map.get(st.pop())) {
                return false;
            }
            
        }
        
        if(st.isEmpty()) {
            return true;
        }
        return false;
    }
    
    static HashMap<Character, Character>pairMap = new HashMap<Character, Character>();
    static {
        pairMap.put('(', ')');
        pairMap.put('[', ']');
        pairMap.put('{', '}');
    }

    static public boolean isValid_(String s) {
        if (s == null || s.isEmpty()) return false;
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (!stack.isEmpty() && pairMap.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

}
