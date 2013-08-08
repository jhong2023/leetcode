package math;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    
    static HashMap<Character, Character>pairMap = new HashMap<Character, Character>();
    static {
        pairMap.put('(', ')');
        pairMap.put('[', ']');
        pairMap.put('{', '}');
    }

    static public boolean isValid(String s) {
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
