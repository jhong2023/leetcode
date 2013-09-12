package math;

public class Atoi {
    public int atoi(String str) {
        int len = str.length();
        if(len == 0) return 0;
        int i = 0;
        boolean negative = false;
        while(i < len && str.charAt(i) ==' '){
            i++;
        }
        if(str.charAt(i) == '+'){
            i++;
        } else if (str.charAt(i) == '-'){
            i++;
            negative = true;
        }
        
        int res = 0;
        while(i<len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res = res * 10 + (str.charAt(i) - '0');
            i++;
        }
        
        int exp = 0;
        if(i<len && str.charAt(i) == 'e'){
            i++;
            boolean negativeE = false;
            if(str.charAt(i) == '+'){
                i++;
            } else if (str.charAt(i) == '-'){
                i++;
                negativeE = true;
            }
            while(i<len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                exp = exp * 10 + (str.charAt(i) - '0');
                i++;
            }
            if(negativeE){
                exp = -1*exp;
            }
        }
        
        if(exp != 0){
            res = (int) Math.pow(res, exp);
        }
        
        if(negative){
            res = -1*res;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		int a = 214748364 * 10 + 8 ;
		if(a<0) a = -1*a;
		System.out.println(a);
	}
}
