package array;

public class JumpGame {
    
    public boolean canJump(int[] A) {
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
    
    

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
