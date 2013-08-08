package combination;

import java.util.ArrayList;
import java.util.Arrays;

/*
input		expected	
[1], 2	     [[1,1]]
[1,2], 3	[[1,1,1],[1,2]]
 */

public class CombinationSum {
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (target == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        if (target < 0) {
            return result;
        }
        for (int i = 0; i < candidates.length; i++) {
            for (ArrayList<Integer> a : 
                combinationSum(Arrays.copyOfRange(candidates, i, candidates.length), target - candidates[i])) {
                a.add(0, candidates[i]);
                result.add(a);
            }
        }
        return result;
        
    }

    public static void main(String[] args) {
        int a[] = {1};
        ArrayList<ArrayList<Integer>> cb = new CombinationSum().combinationSum(a, 2);
        System.out.println(cb.size());
    }

}
