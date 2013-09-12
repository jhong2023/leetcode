package hack;

import java.util.Stack;

public class LargeRectangleHistogram {

	static int max(int[] h){
		int len = h.length;
		if(len == 0) return 0;
		Stack<Integer> s = new Stack<Integer>();
		int max = 0;
		int i=0; 
		for(;i<len; i++){
			// h[s.peek()]
			while(!s.isEmpty() && h[i] < h[s.peek()]){
				int j = s.pop();
				int tmp = h[j] * (s.isEmpty()?i : i - s.peek() - 1);
				if(tmp > max) max = tmp;
			}
			s.push(i);
		}
		while(!s.isEmpty()){
			int j = s.pop();
			int tmp = h[j] * (s.isEmpty()?i : i - s.peek() - 1);
			if(tmp > max) max = tmp;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] a = {4,2};
		System.out.println(max(a));
	}

}
