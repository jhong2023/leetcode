package array;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    
    static void maxSlidingWindow(int a[], int w) {
    	LinkedList<Integer> q = new LinkedList<Integer>();
    	for (int i=0; i<a.length; i++) {
    		if(!q.isEmpty() && i - q.getFirst() == w) {
    			q.remove();
    		}
    		while(!q.isEmpty() && a[q.getLast()] <= a[i]) {
    			q.removeLast();
    		}
    		q.offer(i);
    		System.out.println(a[q.getFirst()]);
    	}
    }
    
    public static void main(String[] args) {
        int a[] = {1,5,2,4,3,1,6,8,9,7,5,8};
        maxSlidingWindow(a, 3);
    }

}
