package array;

public class PlusOne {
    
    public int[] plusOne(int[] digits) {
        int i = digits.length -1;
        for (; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }
        
        if (i < 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int j=0;j<digits.length;j++) {
                res[j+1] = digits[j];
            }
            return res;
        }
        return digits;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
