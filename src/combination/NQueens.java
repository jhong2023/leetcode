package combination;

public class NQueens {
    
    public int totalNQueens(int n) {
        int c[] = new int[n]; // columns index
        for (int i = 0; i < n ; i++) {
               c[i] = -1;
        }
        
        return permutationColumn(c, 0, n);
    }
    
    public int permutationColumn(int[] c, int rIndex, int length ) {
        if (rIndex == length) {
            print(c);
            return 1;
        }
        int count = 0;
        for (int i=0; i < length; i++) {
            if (check(c, rIndex, i)) {
                c[rIndex] = i;
                count += permutationColumn(c, rIndex + 1, length);
            }
        }
        return count;
    }
    
    private boolean check(int[] c, int rIndex, int cIndex) {
        for (int i=0; i < rIndex ; i++) {
            if (c[i] == cIndex 
                    || rIndex - i == cIndex - c[i]
                    || rIndex - i == -(cIndex - c[i])) {
                return false;
            }
        }
        return true;
    }

    void print(int[] c) {
        for (int i : c) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    
    public static void main(String[] args) {
        int n = new NQueens().totalNQueens(8);
        System.out.println(n);

    }

}
