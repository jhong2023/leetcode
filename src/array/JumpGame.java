package array;

public class JumpGame {
    
    public boolean canJump_1(int[] A) {
        if (A.length < 1) return false;
        
        return canJump(A, 0);
    }
    
    public boolean canJump(int[] A, int i) {
        if (i >= A.length -1) return true;
        for (int j = A[i]; j > 0; j --) {
            if (canJump(A, i+j)) {
                return true;
            }
            A[i+j] = 0;
        }
        return false;
    }
    
    
    public boolean canJump(int[] A) {
        if (A == null) {
            return true;
        }
        if (A.length <= 1) {
            return true;
        }
        int max = 0;
        int i = 0;
        while(max < A.length && i <= max) {
            if (A[i] + i > max) {
                max = A[i] + i;
            }
            i++;
        }
        if (max >= A.length - 1) {
            return true;
        }
        return false;
    }
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
