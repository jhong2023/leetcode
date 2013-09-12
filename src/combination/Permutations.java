package combination;

import java.util.ArrayList;

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int len = num.length;
        if(len == 0) {
            return res;
        }
        if(len == 1) {
            ArrayList<Integer> aa = new ArrayList<Integer>();
            aa.add(num[0]);
            res.add(aa);
            return res;
        }
        for(int i = 0; i < len; i++) {
            int a[] = new int[len-1];
            int k = 0;
            for(int j = 0; j < len; j++) {
                if(i != j){
                	//It's J, not K
                    a[k] = num[j];
                    k++;
                }
            }
            
            
            for(ArrayList<Integer> aa : permute(a)){
                aa.add(0, num[i]);
                res.add(aa);
            }
        }
        return res;
    }

}
