package math;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class InfixExpressionEvaluation {

	// 1+2*3  
	// 1+2*3+4  => 1 2 3 * + 4 +
	// 1+2*3^2
	int eval(String str) throws Exception{
		Map<Character, Integer> priority = new HashMap<Character, Integer>();
		priority.put('+', 0);
		priority.put('-', 0);
		priority.put('*', 1);
		priority.put('/', 1);
		priority.put('^', 2);
		priority.put('(', -1);
		Stack<Integer> num = new Stack<Integer>();
		Stack<Character> op = new Stack<Character>();
		for(char c : str.toCharArray()){
			if(c>='0' && c<='9'){
				num.push(c - '0');
			} else {
				if(c == '('){
					op.push('(');
					continue;
				}
				if(c == ')'){
					while(!op.isEmpty() && op.peek() != '('){
						num.push(caculate(num.pop(), num.pop(), op.pop()));
					}
					op.pop();
					continue;
				}
				
				while(!op.isEmpty() && priority.get(op.peek()) > priority.get(c)){
					num.push(caculate(num.pop(), num.pop(), op.pop()));
				}
				op.push(c);
			}
		}
		while(!op.isEmpty()){
			num.push(caculate(num.pop(), num.pop(), op.pop()));
		}
		int res = num.pop();
		if(!num.isEmpty()){
			throw new Exception("Invalid expresion.");
		}
		return res;
	}
	private Integer caculate(Integer i1, Integer i2, char c) {
		if(c == '+'){
			return i1 + i2;
		} else if( c == '-'){
			return i2 - i1;
		} else if( c == '*'){
			return i2 * i1;
		} else if(c == '/'){
			return i2 / i1;
		} else {
			return (int) Math.pow(i2, i1);
		}
	}
	
	
	
	
	public static void main(String[] args) throws Exception {
		InfixExpressionEvaluation eval = new InfixExpressionEvaluation();
		// System.out.println(eval.eval("1+2-"));
		System.out.println(eval.eval("1+2*(3+4)"));
		System.out.println(eval.eval("1+2*3^2"));

	}

}
