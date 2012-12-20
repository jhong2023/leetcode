package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsUniq {

    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<Integer> intList = new ArrayList<Integer>();
        Arrays.sort(num);
        for (int i=0; i<num.length;i++) {
            intList.add(num[i]);
        }
        ArrayList<ArrayList<Integer>> result = permuteUnique(intList);
        return result;
        
    }
    
    public ArrayList<ArrayList<Integer>> permuteUnique(List<Integer> intList) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (intList.size() == 1) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            t.add(intList.get(0));
            result.add(t);
            return result;
        }
        
        
        for (int i=0; i<intList.size(); i++) {
            if (i != 0 && intList.get(i).intValue() == intList.get(i-1).intValue() ) {
                continue;
            }
            List<Integer> subList = new ArrayList<Integer>();
            if (i>0) {
                subList.addAll(intList.subList(0, i));
            }
            if (i+1 < intList.size()) {
                subList.addAll(intList.subList(i+1, intList.size()));
            }
            for (ArrayList<Integer> p : permuteUnique(subList)) {
                p.add(0, intList.get(i));
                result.add(p);
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
