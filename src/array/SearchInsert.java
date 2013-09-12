package array;

public class SearchInsert {

    public int searchInsert(int[] A, int target) {
        return searchInsert(A, target, 0, A.length - 1);
   }
   
   int searchInsert(int[] A, int target, int i, int j){
       if(i==j) {
           if(A[i] >= target) {
               return i;
           } else{
               return i+1;
           }
       }
       if(j - i == 1 && A[i] < target && A[j] >= target){
           return j;
       }
       
       int m = (i+j)/2;
       if(A[m] == target) return m;
       if(A[m] < target){
           return searchInsert(A, target, m+1, j);
       } else {
           return searchInsert(A, target, 0, m);
       }
       
   }

}
