package tree;

public class UniqueBinarySearchTree {

    public int numTrees(int n) {
        if(n <= 2) return n;
        int sum = 0;
        sum += 2*numTrees(n-1);
        for(int i=1; i<=(n-1)/2; i++){
            if(i == n-1-i){
                sum += numTrees(i)*numTrees(n-1-i);
            }else{
                sum += 2*numTrees(i)*numTrees(n-1-i);
            }
        }
        return sum;
        
    }
    
    
    public static int numTrees_new(int n) {
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        int res = 0;
        for(int i = n-1; i >= n/2; i--){
            int tmp = numTrees_new(i)*numTrees_new(n-i-1);
            if(2*i + 1 != n){
                tmp = tmp * 2;
            }
            res += tmp;
        }
        return res;
    }
    

}
