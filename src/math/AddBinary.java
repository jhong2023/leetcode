package math;

public class AddBinary {
    public String addBinary(String a, String b) {
        if(a == null || b == null) return null;
        int lenA = a.length();
        if(lenA == 0) return b;
        int lenB = b.length();
        if(lenB == 0) return a;
        
        int i = lenA - 1;
        int j = lenB - 1;
        int carrier = 0;
        StringBuffer res = new StringBuffer();
        while(i >= 0 || j>= 0){
            int tmp = carrier;
            if( i >= 0){
                tmp += a.charAt(i) - '0';
                // decrease i, not increase
                i--;
            }
            if(j >= 0){
                tmp += b.charAt(j)  - '0';
                // decrease j, not increase
                j--;
            }

            if(tmp%2 == 1){
                res.append("1");
            } else {
                res.append("0");
            }
            
            if(tmp >= 2){
                carrier = 1;
            } else {
                carrier = 0;
            }
            
        }
        if(carrier == 1){
           res.append("1"); 
        }
        
        return res.reverse().toString();
        
    }
}
