package math;

public class Pow {

    public double pow(double x, int n) {
        if (n==0) return 1.0;
        if (x==1) return 1.0;  // have it for large case
        if (x==-1) return n%2==0 ? 1.0 : -1.0; // have it for large case
        if (x==0) {
            if (n>0) return 0.0;
            if (n<0) {
//                throws new Exception();
            }
        }
        
        if (n<0) {
            return 1.0/pow(x, -n);
        }
        double result = pow(x, n/2);
        if (n%2 == 0) {
            return result * result;
        } else {
            return result * result * x;
        }
   }

    static public double pow_(double x, int n) {
        if (n == 0) return 1.0;
        if (x == 1) return 1.0;
        if (x == -1) return n % 2 == 0 ? 1.0 : -1.0;
        if (x == 0) {
            if (n > 0) return 0.0;
            if (n < 0) {
                ;
            }
        }

        boolean isNegative = false;

        if (n < 0) {
            isNegative = true;
            n = -n;
        }

        double result = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = result * x;
            }

            x = x * x;
            n >>= 1;
        }
        if (isNegative) {
            result = 1.0 / result;
        }
        return result;
    }

}
