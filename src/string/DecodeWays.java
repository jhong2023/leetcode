package string;

public class DecodeWays {
    
//    public int numDecodings(String s) {
//        if (s.length() == 0) return 0;
//        if (s.charAt(0) == '0') return 0;
//        if (s.length() == 1) return 1;
//        
//        int num = numDecodings(s.substring(1));
//        if ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26) {
//            if (s.length() == 2) {
//                num += 1;
//            } else {
//                num += numDecodings(s.substring(2));
//            }
//        }
//        return num;
//    }
//    
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) return 0;
//        
//        int[] cache = new int[s.length()];
//        for (int i = 0; i<s.length();i++) {
//            cache[i] = -1;
//        }
//        
//        int r = numDecodings(s, cache);
//        for (int i=0; i < cache.length;i++) {
//            System.out.print(cache[i] + " ");
//        }
//        System.out.println();
//        return r;
//    }
//    
//    public int numDecodings(String s, int[] cache) {
//        if (s.length() == 0) return 0;
//        if (cache[s.length() - 1] != -1) {
//            return cache[s.length() - 1];
//        }
//        
//        if (s.charAt(0) == '0') {
//            cache[s.length() - 1] = 0;
//            return 0;
//        }
//        if (s.length() == 1) {
//            cache[0] = 1;
//            return 1;
//        }
//        
//        int num = numDecodings(s.substring(1), cache);
//        if ((s.charAt(0) - '0') * 10 + (s.charAt(1) - '0') <= 26) {
//            if (s.length() == 2) {
//                num += 1;
//            } else {
//                num += numDecodings(s.substring(2), cache);
//            }
//        }
//        cache[s.length() - 1] = num;
//        return num;
//    }
	
//    public int numDecodings(String s) {
//        if(s == null || s.length() == 0) {
//            return 0;
//        }
//        return numDecodings_(s);
//    }
//    
//	public int numDecodings_(String s) {
//	    int l = s.length();
//	    
//	    if(l == 0) {
//	        return 1;
//	    }
//	    
//	    if(s.charAt(0) == '0') {
//	            return 0;
//	    }
//	    
//	    if(l == 1) {
//	        return 1;
//	    }
//	    
//	    int t = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
//	    if (t <= 26) {
//	        return numDecodings_(s.substring(1)) + numDecodings_(s.substring(2));
//	    } else {
//	        return numDecodings_(s.substring(1));
//	    }
//	}
    
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) return 0;
//        if (s.charAt(0) == '0') return 0;
//        
//        int pre = 1;
//        int num = 1;
//        for (int i=1; i < s.length(); i++) {
//            int t = num;
//            if (s.charAt(i) == '0') {
//                if (s.charAt(i-1) == '0' || s.charAt(i-1) - '0' > 2) {
//                    return 0;
//                }
//                num = pre;
//            } else if (s.charAt(i-1) != '0' && (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
//                num = num + pre;
//            }
//            pre = t;
//        }
//        return num;
//    }
    
    public int numDecodings(String s) {
           if(s == null || s.length() == 0) {
               return 0;
           }
           
           if(s.charAt(0) == '0') {
               return 0;
           }
           // f(i) = f(i-1) + f(i-2)
           // f(0) = 1  s[0] != 0
           //      = 0  s[0] == 0
           // f(1) = 2  S[0]*10 + f[1] <= 26
           
           int pre = 1;
           // n start with 1
           int n = 1;
           
           for(int i=1; i<s.length(); i++){
               int t1 = s.charAt(i-1) - '0';
               int t2 = s.charAt(i) - '0';
           
               int tmp = n;
               if(t2 == 0) {
                   n = 0;
               }
               if(t1 > 0 && t1*10 + t2 <= 26) {
                   n +=  pre;
               }
               pre = tmp;
           }
           
           return n;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("10"));
    }

}
