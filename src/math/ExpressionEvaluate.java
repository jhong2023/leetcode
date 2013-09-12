package math;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionEvaluate {
	
	// reverse calculation to accommodate "-"
    public int evaluate(String expr) {
        Pattern p = Pattern.compile("(\\d+)");
        Matcher m = p.matcher(expr);
        List<Integer> nums = new ArrayList<Integer>();
        while(m.find()){
            nums.add(Integer.parseInt(m.group()));
        }
        
        p = Pattern.compile("([*\\+-])");
        m = p.matcher(expr);
        List<Character> ops = new ArrayList<Character>();
        while(m.find()){
            ops.add(m.group().charAt(0));
        }
        return cal(nums, ops.size() - 1, ops);
    }
    
    int cal(List<Integer> nums, int i, List<Character> ops){
        if(i < 0) return nums.get(0);
        char op = ops.get(i);
        if(op == '*' || op == '/'){
            int tmp;
            if(op == '*'){
               tmp = nums.get(i) * nums.get(i+1);
            } else {
               tmp = nums.get(i) / nums.get(i+1); 
            }
            nums.set(i, tmp);
            return cal(nums, i-1, ops);
        } else {
            if(op == '+'){
                return  cal(nums, i-1, ops) + nums.get(i+1);
            } else {
                return  cal(nums, i-1, ops) - nums.get(i+1);
            }
        }
    }

    void parse_expression(){
    	String expr = "7+13*4*5+2-4";
		Pattern r = Pattern.compile("(\\d+)");
		Matcher m = r.matcher(expr);
		while(m.find()){
			System.out.println(m.group());
		}
    }
    
    void split_expression(){
    	String expr = "7+13*4*5+2-4";
		String[] ss = expr.split("[*\\+-]");
		for(String s : ss){
			System.out.println(s);
		}
    }
    
    
    // Not valid:  +1,  1+, 1+(2+3, 1+(2+)3
    boolean validate(String expression){
    	String expr = expression.trim();
    	boolean expectNum = true;
    	int numOfParentheses = 0;
    	int i = 0;
    	while(i < expr.length()){
    		if(expr.charAt(i) == '('){
    			if(!expectNum) return false;
				numOfParentheses++;
				i++;
			} else if (expr.charAt(i) == ')'){
				if(expectNum || numOfParentheses < 1) return false;
				numOfParentheses--;
				i++;
			} else if(expectNum){
    			if(!isDigit(expr.charAt(i))){
    				return false;
    			}
    			i++;
    			while(i < expr.length() && isDigit(expr.charAt(i))){
    				i++;
    			}
    			expectNum = false;
    		} else {
    			
    			if(!isOperator(expr.charAt(i))){
    				return false;
    			}
    			
    			i++;
    			expectNum = true;
    		}
    	}
    	return expectNum == false && numOfParentheses == 0;
    }
    
    boolean isDigit(char c){
    	return c <= '9' && c >= '0';
    }
    
    boolean isOperator(char c){
    	return c == '+' || c == '-' || c == '*' || c == '/';
    }
	
	public static void main(String[] args) {
		// String expr = "7+4*5+2-14";
		String expr = "1-2-3";
		ExpressionEvaluate ee = new ExpressionEvaluate();
		// System.out.println(ee.evaluate(expr));
		
		System.out.println(ee.validate("+1"));
		System.out.println(ee.validate("2+1*2"));
		System.out.println(ee.validate("2(+)1"));
		System.out.println(ee.validate("(2+)1"));
		System.out.println(ee.validate("((2+1))"));
		System.out.println(ee.validate("((2+1)"));
		System.out.println(ee.validate("((2+1)+2)"));
		System.out.println(ee.validate("(1)"));
		System.out.println(ee.validate("(+)"));
	}

}
