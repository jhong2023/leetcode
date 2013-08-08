package array;

import java.util.ArrayList;

public class GrayCode {
    
    public ArrayList<Integer> grayCode(int n) {
        if (n <= 0) {
            return null;
        }
        ArrayList<Integer> codes = new ArrayList<Integer>();
        if (n == 1) {
            codes.add(0);
            codes.add(1);
            return codes;
        }
        ArrayList<Integer> subCodes = grayCode(n-1);
        codes.addAll(subCodes);
        int pre = 1 << (n - 1);
        for (int i = subCodes.size() - 1; i >= 0; i--) {
            codes.add(pre + subCodes.get(i));
        }
        return codes;
    }
    
    // i ^ (i >> 1)
    public ArrayList<Integer> grayCode_(int n) {
        ArrayList<Integer> codes = new ArrayList<Integer>();
        int k = 1 << n;
        for (int i=0; i < k; i++) {
            codes.add(i ^ (i >> 1));
        }
        return codes;
    }
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
