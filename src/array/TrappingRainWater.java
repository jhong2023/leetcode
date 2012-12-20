package array;

public class TrappingRainWater {
    
    public int trap(int[] A) {
        if (A.length < 3) return 0;
        int[] b = new int[A.length];
        b[0] = 0;
        int max = 0;
        for (int i=1;i<A.length;i++) {
            if (A[i-1] > max) {
                max = A[i-1];
            } 
            b[i] = max;
        }
        int total = 0;
        max = A[A.length - 1];
        for (int i=A.length -2; i>0; i--) {
            if (A[i+1] > max) {
                max = A[i+1];
            }
            int t = max < b[i]? max : b[i];
            if (t > A[i]) {
                total += (t-A[i]);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
