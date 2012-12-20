package array;

public class Search2DMatrix {

    public boolean searchMatrix(int matrix[][], int v) {
        if (matrix.length<1 || matrix[0].length < 1) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i<matrix.length && j>=0) {
            if (matrix[i][j] == v) {
                return true;
            }
            if (matrix[i][j] < v) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

}
