package dp;

import java.util.Stack;

public class LongestValidParentheses {
	
	// better solution with stack
	public static int longestValidParentheses_(String s) {
	      Stack<Integer> stack = new Stack<Integer>();
	      int len = 0;
	      int maxLen = 0;
	      int startIndex = s.length();
	      for(int i = 0; i < s.length(); ++i) {
	          if(s.charAt(i) == '(') {
	              stack.push(i);
	              continue;
	          }
	          
	          if(stack.isEmpty()) {
	              startIndex = s.length();
	          } else {
	              startIndex = Math.min(stack.peek(), startIndex);
	              stack.pop();
	              
	              if(stack.isEmpty()) {
	                  len = i - startIndex + 1;
	              } else {
	                  len = i - stack.peek();
	              }
	              maxLen = Math.max(maxLen, len);
	          }
	      }
	      return maxLen;
	  }
	
	
	   public int longestValidParentheses(String s) {
	        int max = 0;
	        int len = s.length();
	        int a[] = new int[len];
	        int i = 0;
	        for(; i < len; i++){
	            a[i] = validLength(s, i);
	        }
	        i = 0;
	        int tmp = 0;
	        while(i < len){
	            if(a[i] == 0){
	                tmp = 0;
	                i++;
	            } else {
	                tmp += a[i];
	                i = i + a[i];
	            }
	            if(tmp > max){
	                max = tmp;
	            }
	        }
	        return max;
	    }
	    
	    int validLength(String s, int i){
	        int max= 0;
	        int count = 0;
	        while(i < s.length()){
	            char c = s.charAt(i);
	            if(c == '('){
	                count++;
	                // increase max
	                max++;
	            } else {
	                count--;
	                if(count <= 0){
	                    break;
	                }
	            }
	            i++;
	        }
	        if(i == s.length()){
	            return 0;
	        }
	        return max*2;
	    }
	    
	    public static void main(String[] args) {
			System.out.println(
	    	new LongestValidParentheses().longestValidParentheses("())(()())")
	    	);
		}
}
