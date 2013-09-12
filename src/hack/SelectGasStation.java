package hack;

public class SelectGasStation {
    public int selectGasStation(int[] a, int[] g) {
        int len = a.length;
        if(len == 0) return 0;
        int[] c = new int[2*len];
        for(int i=0;i<len;i++){
            c[i] = a[i] - g[i];
        }
        for(int i=len;i<2*len;i++){
            c[i] = c[i-len];   
        }
        
        int start = 0;
        int sum = 0;
        for(int i=0;i<2*len;i++){
            // c[i] not a[i]
            sum += c[i];
            if(sum < 0){
                sum = 0;
                start = i+1;
            }
            if(i - start == len - 1){
                // %len
                return start%len;
            }
        }
        return -1;
        
    }
}
