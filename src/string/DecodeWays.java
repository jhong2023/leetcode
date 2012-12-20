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
    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        
        int pre = 1;
        int num = 1;
        for (int i=1; i < s.length(); i++) {
            int t = num;
            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '0' || s.charAt(i-1) - '0' > 2) {
                    return 0;
                }
                num = pre;
            } else if (s.charAt(i-1) != '0' && (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0') <= 26) {
                num = num + pre;
            }
            pre = t;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("2726"));
    }

}
