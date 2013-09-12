package array;

public class ColorSort {
	
    public void sortColors(int[] a) {
        int len = a.length;
        int i = 0;
        int j = len - 1;
        // sort 0
        while(i < j){
            while(i < j && a[i] == 0){
                i++;
            }
            while(i < j && a[j] > 0){
                j--;
            }
            if(i < j){
                swap(a, i, j);
                i++;
                j--;
            }
        }
        j = len - 1;
        // sort 2
        while(i < j){
        	// must be < 2 not ==1
            while(i < j && a[i] < 2){
                i++;
            }
            while(i < j && a[j] == 2){
                j--;
            }
            if(i < j){
                swap(a, i, j);
                i++;
                j--;
            }
        }
    }
    
    void swap(int a[], int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public void sortColors_(int[] A) {
        int i=0;
        int j=A.length - 1;
        while(i < j) {
            while(i < j && A[i] != 2){
                i++;
            }
            while(i < j && A[j] == 2){
            	j--;
            }
            if(i < j) {
	            int tmp = A[i];
	            A[i] = A[j];
	            A[j] = tmp;
	            i++;
	            j--;
            }
        }
        
        i=0;
        while(i < j) {
            while(i < j && A[i] == 0){
                i++;
            }
            while(i < j && A[j] != 0){
            	j--;
            }
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
        }
        
    }
}
