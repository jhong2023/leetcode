package array;
/*
 Must reverse the last part of array
 1, 3, 2  => 2, 1, 3 
 1, 2, 3
 */
public class NextPermutation {

    public void nextPermutation(int[] num) {
        int len = num.length;
        if(len <= 1) return;
        
        int i = len -2;
        while(i >= 0 && num[i] >= num[i+1]) {
             i--;
        }
        
        int j = len - 1;
        if(i != -1){
            while(j >= 0 && num[j] <= num[i]) {
                 j--;
            }
            
            int tmp = num[i];
            num[i] = num[j];
            num[j] = tmp;
        }
        
        int m = 0;
        int n = len - 1;
        
        if(i != -1){
            m = i+1;
        }
        // reverse last part
        while(m < n) {
              int tmp = num[m];
              num[m] = num[n];
              num[n] = tmp;
              m++;
              n--;
        }
    }

}
