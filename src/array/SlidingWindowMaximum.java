package array;

import java.util.LinkedList;

public class SlidingWindowMaximum {
    
    static void maxSlidingWindow(int a[], int w) {
        LinkedList<Integer> window = new LinkedList<Integer>();
        int len = a.length;
        int i = 0;
        for (; i < w && i < len; i++) { 
            while (!window.isEmpty() && a[i] > a[window.getLast()]) {
                window.removeLast();
            }
            window.addLast(i);
            System.out.println(a[window.getFirst()]);
        }
        for (; i < len; i++) {
            if (window.getFirst() <= i - w) {
                window.removeFirst();
            }
            
            while (!window.isEmpty() && a[i] > a[window.getLast()]) {
                window.removeLast();
            }
            window.addLast(i);
            System.out.println(a[window.getFirst()]);
        }
    }

    public static void main(String[] args) {
        int a[] = {1,5,2,4,3,1,6,8,9,7,5,8};
        maxSlidingWindow(a, 3);
    }

}
