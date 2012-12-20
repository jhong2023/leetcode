package math;

public class Divide {
    
    
    
    static int divide(int n, int d) {
        return divide_2((long) n, (long)d);
    }
    
    static int divide_2(long n, long d) {
        if (n < 0) return -1 * divide_2(-n, d);
        if (d < 0) return -1 * divide_2(n, -d);
        if (n < d) return 0;
        int q = 0;
        while(n >= d) {
            int qq = 1;
            long dd = d;
            while (n >= (dd << 1)) {
                dd = dd << 1;
                qq = qq <<1;
            }
            q += qq;
            n = n - dd;
        }
        return q;
    }
    
    static int divide_1(long n, long d) {
        if (n < 0) return -1 * divide_1(-n, d);
        if (d < 0) return -1 * divide_1(n, -d);
        if (n < d) return 0;
        long dd = d + d;
        if (n < dd) return 1;
        int q = divide_1(n, dd);
        return 2*q + divide_1(n - q * dd, d); 
    }
    

    public static void main(String[] args) {
        System.out.println(divide(14, 3));
        System.out.println(divide(10, 3));
    }   

}
