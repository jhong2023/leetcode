package hack;

import java.util.ArrayList;

public class SpiraxArray {

    public ArrayList<Integer> spiralOrder(int[][] mx) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int m = mx.length;
        if(m == 0) return res;
        int n = mx[0].length;
        if(n == 0) return res;
        
        int k = 0;
        int bound = Math.min((m+1)/2, (n+1)/2);
        while(k < bound){
            for(int i=k; i<n-k; i++){
                res.add(mx[k][i]);
            }
            for(int i=k+1; i<m-k; i++){
                res.add(mx[i][n-k-1]);
            }
            if(m-k-1 > k){
                for(int i=n-k-2; i>=k; i--){
                    res.add(mx[m-k-1][i]);
                }
            }
            if(k < n-k-1){
                for(int i=m-k-2; i>k; i--){
                    res.add(mx[i][k]);
                }
            }
            k++;
        }
        return res;
    }
    

}
