package combination;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {

	// No duplicate:	[1,1], 1	[[1],[1]]	[[1]]

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> res = combinationSum2(num, 0, target);
    	if(res == null){
    		res = new ArrayList<ArrayList<Integer>>();
    	}
    	return res;
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int i, int target) {
    	if(target < 0 ) return null;
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(target == 0) {
    		res.add(new ArrayList<Integer>());
    		return res;
    	}
    	if(i == num.length) return null;
    	
    	ArrayList<ArrayList<Integer>> tmpRes;
    	
    	// avoid duplicate
        int j = i + 1;
        while(j < num.length && num[i] == num[j]){
            j++;
        }
        tmpRes = combinationSum2(num, j, target);
        if(tmpRes != null) res.addAll(tmpRes);
    	
    	
    	tmpRes = combinationSum2(num, i+1, target - num[i]);
    	if(tmpRes != null) {
    		for(ArrayList<Integer> list : tmpRes){
    			list.add(0, num[i]);
    			res.add(list);
    		}
    	}
    	
    	if(res.size() == 0){
    		return null;
    	} else {
    		return res;
    	}
    }
    
    public static void main(String[] args) {
		CombinationSumII s = new CombinationSumII();
		int num[] = {2, 2,5};
		s.combinationSum2(num, 5);
	}
}
