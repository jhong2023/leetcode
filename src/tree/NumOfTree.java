package tree;

public class NumOfTree {
    public static int numTrees(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int res = 0;
        for(int i = n-1; i >= n/2; i--){
            int tmp = numTrees(i)*numTrees(n-i-1);
            if(2*i + 1 != n){
                tmp = tmp * 2;
            }
            res += tmp;
        }
        return res;
    }
    
    public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}
