package dp;


// test case:
// 0, 100, 301
public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0) return 0;
        if(s.charAt(0) == '0') return 0;
        if(len == 1) return 1;
        
        int a[] = new int[len];
        a[0] = 1;
        for(int i = 1; i < len; i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '0' || s.charAt(i-1) > '2'){
                    return 0;
                }
                a[i] = i == 1? 1 : a[i-2];
            } else {
                a[i] = a[i-1];
                if(s.charAt(i-1) != '0' && value(s.charAt(i-1), s.charAt(i)) <= 26){
                    a[i] += (i == 1? 1 : a[i-2]);
                }
            }
        }
        return a[len-1];
    }
    
    int value(char c1, char c2){
        return (c1-'0') * 10 + (c2 - '0');
    }
}
