package math;

public class Sqrt {
	
	// leetcode
	 public static int sqrt(int x) {
	    	double x0 = x / 2.0;
			double x1 = (x0 + x / x0) / 2.0;
			System.out.println(x0 + " " + x1 + " " + (x0/2 + 1));
			while (Math.abs(x1 - x0) > 0.00001) {
				x0 = x1;
				x1 = (x0 + x / x0) / 2.0;
				System.out.println(x0 + " " + x1 );
			}
	        return (int) x1;
	    }
    
//    double sqrt(double n) {
//        double i = 1;
//        double j = n;
//        while (i < j) {
//            double m = (i+j)/2.0;
//            if (Math.abs(n - m*m) > 0.000001) {
//                i = m;
//            } else {
//                return m;
//            }
//        }
//    }

    static double sqrt(double x, double precision) {
        if (x <= 0) return 0;
        double r = x;
        while (x - x/r > precision)
        r = (r + x/r) / 2;
        return r;
    }
    
    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }

}
