package combination;

import java.util.ArrayList;

public class GenerateParentheses {
    
    public ArrayList<String> generateParenthesis(int n) {
        return generateParenthesis(n, 0);
    }
    
    ArrayList<String> generateParenthesis(int m, int n) {
        ArrayList<String> result = new ArrayList<String>();
        if (m > 0) {
            for (String s : generateParenthesis(m - 1, n +1 )) {
                result.add("(" + s);
            }
        }
        if (n > 0) {
            for (String s : generateParenthesis(m - 1, n +1 )) {
                result.add(")" + s);
            }
        }
        if (m == 0 && n == 0) {
            result.add("");
        }
        return result;
    }
}
