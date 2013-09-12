package hack;

public class ValidNumber {

	// valid: 01, .0, +01, .1, 1e2, 1.0e2, 1.0e-2, ___1.0___
	// Not valid: 1., 1e, e2, .e, 1e0.2, 1e.2

	static boolean isNumber(String num){
		int len = num.length();
		if(len < 1) return false;
		int i = 0;
        while(i<len && num.charAt(i) == ' '){
            i++;
        }
		
		boolean hasDot = false;
		boolean hasE = false;
        boolean hasNum = false;
        boolean hasSign = false;
		while(i<len){
			char c = num.charAt(i);
			if(c >= '0' && c <= '9'){
				hasNum = true;
			} else if(c == '+' || c == '-'){
                if(hasNum || hasDot || hasSign) return false;
                hasSign = true;
			} else if(c == '.'){
				if(hasDot || hasE) return false;
				hasDot = true;
			} else if(c == 'e'){
				if(!hasNum || hasE) return false;
				hasE = true;
                hasNum = false;
                hasSign = false;
                hasDot = false;
			} else{
				break;
			}
			i++;
		}
        
        if(!hasNum){
            return false;
        }
        
        while(i < len && num.charAt(i) == ' '){
            i++;
        }
		
		return i == len;
	}


	public static void main(String[] args) {
		// double i = .000;
		// System.out.println(isNumber("  0.1  "));
		System.out.println(Math.pow(3, 0.1));
	}

}
