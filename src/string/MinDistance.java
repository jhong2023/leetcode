package string;

public class MinDistance {

    public int minDistance(String w1, String w2) {
        int l1 = w1.length();
        int l2 = w2.length();
        if(l1 == 0){
            return l2;
        }
        if(l2 == 0){
            return l1;
        }
        
        int a[][] = new int[l1+1][l2+1];
        // l2 not l1
        for(int i=0;i<=l2;i++) {
            a[0][i] = i;
        }
        // l1 not l2
        for(int i=0;i<=l1;i++) {
            a[i][0] = i;
        }
        
        for(int i=1;i<=l1;i++) {
            for(int j=1;j<=l2;j++){
            	// i-1, j-1
                if(w1.charAt(i-1) == w2.charAt(j-1)) {
                    a[i][j]=a[i-1][j-1];
                } else{
                    a[i][j] = Math.min(Math.min(a[i-1][j-1], a[i][j-1]), a[i-1][j]) + 1;
                }
            }
        }
        
        return a[l1][l2];
    }
    
    public static void main(String[] args) {
		new MinDistance().minDistance("q", "qg");
	}

}
