package array;

public class JumpGameII {
    
    public int jump_(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < A.length - 1; i++) {
            b[i] = Integer.MAX_VALUE;
        }
        b[A.length - 1] = 0;
        for (int i = A.length - 2; i>=0; i--) {
            if (i+A[i] >=A.length - 1) {
                b[i] = 1;
                continue;
            }
            for (int j = A[i]; j > 0; j--) {
                if (b[i] > b[i+j] + 1) {
                    b[i] =  b[i+j] + 1;
                }
            }
        }
        return b[0];
    }
    
    public int jump(int[] A) {
        int[] b = new int[A.length];
        for (int i = 0; i < A.length ; i++ ) {
            int tmp = b[i] + 1;
            for (int j = i + 1; j<=i+A[i] && j < A.length; j++) {
                if (b[j] == 0 || tmp  < b[j]) {
                    b[j] = tmp;
                }
            }
        }
        return b[A.length - 1];
    }
    
    public int jump_3(int[] A) {
        if (A.length <= 1)
            return 0;
        int jumpcount = 0;
        int i = 0;
        int currentmaxEnd = 0;
        while (i < A.length) {
            currentmaxEnd = A[i] + i;
            if (A[i] > 0)
                jumpcount++;
            else
                return 0;
            if (currentmaxEnd >= A.length - 1)
                return jumpcount;
            int max = 0;
            for (int j = i + 1; j <= currentmaxEnd; j++) {
                if (A[j] + j >= max) {
                    max = A[j] + j;
                    i = j;
                }
            }

        }
        return jumpcount;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(new JumpGameII().jump(a));
    }

}
