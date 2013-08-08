package math;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum3 {

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if (len < 3) return result;
        Arrays.sort(num);
        for (int i =0; i < len-2; i++ ) {
            if (i > 0 && num[i] == num[i-1])  {                  
                    continue;  
            } 
            int s = i+1;
            int e = len - 1;
            int sum = -num[i];
            while (s<e) {
            	// eliminate duplicate result
                if (s>i+1 && num[s] == num[s-1]) {
                    s++;
                    continue;
                }
                if (e<len-1 && num[e] == num[e+1]) {
                    e--;
                    continue;
                }
                if (num[s] + num[e] == sum) {
                    ArrayList<Integer> triple = new ArrayList<Integer>();
                    triple.add(num[i]);
                    triple.add(num[s]);
                    triple.add(num[e]);
                    result.add(triple);
                    // don't break here
                    s++;
                    e--;
                    continue;
                }
                if (num[s] + num[e] < sum) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        return result;
    }
}
