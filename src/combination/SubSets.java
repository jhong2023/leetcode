package combination;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSets {
    
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        for (int s : S) {
            ArrayList<ArrayList<Integer>> addition = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> list : results) {
                ArrayList<Integer> tmp = new ArrayList<Integer>();
                // Don't use list.add(s), it will change the original array
                tmp.add(s);
                tmp.addAll(list);
                addition.add(tmp);
            }
            results.addAll(addition);
        }
        return results;
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            int s = S[i];
            ArrayList<ArrayList<Integer>> addition = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> repeat = null;
            if (i > 0 && S[i] == S[i-1]) {
                repeat.add(S[i]);
                for (ArrayList<Integer> list : results) {
                   if (list.size() > 0 && list.get(list.size() - 1) != S[i]) {
                       ArrayList<Integer> tmp = new ArrayList<Integer>();
                       tmp.addAll(list);
                       tmp.addAll(repeat);
                       addition.add(tmp);
                   }
                }
                addition.add(repeat);
            } else {
                repeat = new ArrayList<Integer>();
                repeat.add(S[i]);
                for (ArrayList<Integer> list : results) {
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.addAll(list);
                    tmp.add(s);
                    addition.add(tmp);
                }
            }
            results.addAll(addition);
        }
        return results;
    }

    public static void main(String[] args) {
       // int S[] = {1,2};
       // new SubSets().subsets(S);
        int  S[] = {1, 1};
        new SubSets().subsetsWithDup(S);
    }

}
