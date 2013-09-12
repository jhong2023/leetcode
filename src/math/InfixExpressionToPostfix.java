package math;

import java.util.Stack;

public class InfixExpressionToPostfix {

	double caculate(String[] ops){
		if(ops == null || ops.length < 3) {
			return 0;
		}
		Stack<Double> s = new Stack<Double>();
		for(int i=0; i<ops.length; i++){
			if(isOperator(ops[i])){
				s.push(cal(s.pop(), s.pop(), ops[i]));
			} else {
				s.push(Double.parseDouble(ops[i]));
			}
		}
		double res = s.pop();
		if(!s.isEmpty()) return 0;
		return res;
	}
	
	private Double cal(Double pop, Double pop2, String string) {
		return null;
	}

	boolean isOperator(String s){
		return s.equals("+") || s.equals("-") || s.equals("*")  || s.equals("/"); 
	}

}
