package array;

public class AddBinary {
    
    String addBinary(String s1, String s2) {
        if (s1 == null || s2 == null) return null;
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        StringBuffer res = new StringBuffer();
        int ad = 0;
        while (i>=0 || j>=0) {
            if (i>=0) {
                ad +=  s1.charAt(i) - '0';
                i--;
            }
            if (j>=0) {
                ad += s2.charAt(j)  - '0';
                j--;
            }
            if (ad%2 == 0){
                res.append(0);
            } else {
                res.append(1);
            }
            ad = ad < 2? 0: 1;
        }
        if (ad > 0) {
            res.append(ad);
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
