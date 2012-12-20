package array;

import java.util.ArrayList;
import java.util.List;

public class MultipleStrings {
    
    public String multiply(String num1, String num2) {
        char[] a1 = num1.toCharArray();
        char[] a2 = num2.toCharArray();
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for (int i = a1.length - 1; i>=0; i--) {
            if (a1[i] == '0') { continue;}
            List<Integer> tmp = multiply(a1[i], a2);
            if (tmp.size() == 1 && tmp.get(0) == 0) { continue;}
            for (int j = i; j < a1.length - 1; j++) {
                tmp.add(0, 0);
            }
            res = add(res, tmp);
        }
        String out = "";
        for (int i = res.size() -1; i>=0; i--) {
            out += res.get(i);
        }
        return out;
    }

    private List<Integer> add(List<Integer> a1, List<Integer> a2) {
        int i = 0, j = 0;
        int ad = 0;
        List<Integer> res = new ArrayList<Integer>();
        while (i < a1.size() || j < a2.size()) {
            int sum = ad;
            if (i < a1.size()) {sum += a1.get(i); i++;}
            if (j < a2.size()) {sum += a2.get(j); j++;}
            ad = sum/10;
            res.add(sum%10);
        }
        if (ad > 0) {
            res.add(ad);
        }
        return res;        
    }

    private List<Integer> multiply(char c, char[] a2) {
        int ad = 0;
        List<Integer> res = new ArrayList<Integer>();
        for (int i = a2.length - 1; i >= 0; i--) {
            int tmp = (a2[i] - '0') * (c - '0') + ad;
            ad = tmp / 10;
            tmp = tmp % 10;
            res.add(tmp);
        }
        if (ad > 0) res.add(ad);
        return res;
    }

    public static void main(String[] args) {
        MultipleStrings ms = new MultipleStrings();
        System.out.println(ms.multiply("123", "12") + ", " + 123 * 12);
    }

}
