package hack;

import java.util.Stack;

public class Skyline {

	static int largestBlock(int h[], int w[]){
		int len = h.length;
		int max = 0;
		for(int i=0; i<len; i++){
			int width = w[i];
			int j = i-1;
			while(j>=0 && h[j] >= h[i]){
				width += w[j];
				j--;
			}
			j = i+1;
			while(j<len && h[j] >= h[i]){
				width += w[j];
				j++;
			}
			int tmp = h[i]*width;
			if(tmp > max){
				max = tmp;
			}
		}
		return max;
	}
	
	static int largestBlock_dp(int h[], int w[]){
		int len = h.length;
		int max = 0;
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> ws = new Stack<Integer>();
		for(int i=0; i<len; i++){
			if(s.isEmpty() || h[i] <= s.peek()){
				s.push(i);
				
				continue;
			}
			while(!s.isEmpty() && s.peek() > h[i]){
			}
			
		}
		return max;
		
	}
	
	public static void main(String[] args) {
		int[] h = {7, 20, 5, 3, 10};
		int[] w = {5, 1, 3, 6, 2};
		System.out.println(largestBlock(h, w));
	}
}
