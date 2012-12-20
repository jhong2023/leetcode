package array;

import java.util.Stack;

public class LargestRectangleInHistogram {
    
    public int largestRectangleArea_(int[] height) {
        int max = 0;
        for (int i=0; i<height.length;i++) {
            int wide = 1;
            int j = i - 1;
            while (j >= 0 && height[j] >= height[i]) {
                j--;
                wide++;
            }
            j = i + 1;
            while (j < height.length && height[j] >= height[i]) {
                j++;
                wide++;
            }
            int tmp = wide * height[i];
            if (tmp > max) {
                max = tmp;
            }    
        }
        return max;
    }
    
    public int largestRectangleArea(int[] height) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0; 
        for (;i<height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                    int k = stack.pop();
                    int tmp = height[k] * (stack.isEmpty() ? i : (i - stack.peek() -1));
                    if (tmp > max) {
                        max = tmp;
                    }
                }
                stack.push(i);
            }
        }
            
        while (!stack.isEmpty()) {
            int k = stack.pop();
            int tmp = height[k] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
            if (tmp > max) {
                max = tmp;
            }
        }
        
        return max;
    }

    public static void main(String[] args) {
        int[] a = {4,2,0,3,2,5};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(a));
    }

}
