package array;

import java.util.HashSet;

public class FirstMissingPositive {

    public int firstMissingPositive_(int[] A) {
        HashSet<Integer> set = new HashSet<Integer>();
        int missing = 1;
        for (int a : A) {
            if (a == missing) {
                a++;
                while (set.contains(a)) {
                    set.remove(a);
                    a++;
                }
                missing = a;
            } else if (a > missing) {
                set.add(a);
            }
        }
        return missing;
    }

    public int firstMissingPositive(int[] A) {
        int len = A.length;
        for (int i=0; i<len;i++) {
            while (A[i] > 0 && A[i] <= len && A[i] != A[A[i]-1]) {
                int tmp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
            }
        }
        for (int i=0;i<len;i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        
        return len + 1;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
