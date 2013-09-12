package math;

public class Sqrt {
	
	// leetcode
	// (y + x/y)/2 = y => x = y^2
	 public static int sqrt(int x) {
	    	double x0 = x / 2.0;
			double x1 = (x0 + x / x0) / 2.0;
			while (Math.abs(x1 - x0) > 0.00001) {
				System.out.println(x0 + " " + x1 );
				x0 = x1;
				x1 = (x0 + x / x0) / 2.0;
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

    static int sqrt_binarysearch(int n){
    	int i = 0;
    	int j = n+1;
    	// here is j - i > 1
    	while(j - i > 1){
    		int m = (i+j)/2;
    		if(n>= m*m) i = m;
    		else j = m;
    	}
    	return i;
    }
    
    static double sqrt(double x, double d) {
        if (x <= 0) return 0;
        double i = 0;
        double j = x + 1;
        while (Math.abs(i-j) > d){
        	double m = (i+j)/2;
        	if(m*m < x){
        		i = m;
        	} else {
        		j = m;
        	}
        	System.out.println(i+" "+j);
        }
        return i;
    }
    
    public static void main(String[] args) {
        System.out.println(sqrt(0.0000001, 0.2));
    }

}
