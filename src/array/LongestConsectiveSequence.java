package array;

import java.util.HashSet;
import java.util.Set;

public class LongestConsectiveSequence {

	  // duplicate
    static public int longestConsecutive(int[] num) {
        int len = num.length;
        if(len == 0) return 0;
        // Can't use integer array, out of memory
        // int a[] = new int[Integer.MAX_VALUE];
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i<len; i++){
            set.add(num[i]);
        }
        int max = 1;
        for(int i = 0; i<len; i++){
            if(!set.contains(num[i])){
                continue;
            }
            int m = num[i];
            int tmp = 0;
            while (set.contains(m)){
            	set.remove(m);
                m--;
                tmp++;
            }
            m = num[i] + 1;
            while(set.contains(m)){
                set.remove(m);
                m++;
                tmp++;
            }
            if(tmp > max){
                max = tmp;
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
		int[] a = {0};
		System.out.println(
		longestConsecutive(a));
	}

}
