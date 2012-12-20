package combination;

import java.util.ArrayList;

public class Combinations {
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n<k) {
            return result;
        }
        if (k == 1) {
            for (int i=1; i <=n; i++) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                result.add(a);
            }
            return result;
        }
        for (int i=n; i>=k-1; i--) {
            for (ArrayList<Integer> a: combine(i-1, k-1)) {
                a.add(i);
                result.add(a);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(
        new Combinations().combine(2, 1).size());
        // TODO Auto-generated method stub

    }

}
