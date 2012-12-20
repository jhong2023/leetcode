package dp;

public class EditDistance {
    
    public int minDistance_(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int d[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            d[i][0] = i;
        }
        for (int j=0; j <= len2; j++) {
            d[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j=1; j <= len2; j++) {
              if (word1.charAt(i-1) == word2.charAt(j-1)) {
                  d[i][j] = d[i-1][j-1] ;
              } else {
                  d[i][j] = d[i-1][j-1] + 1;
              }
              
              if (d[i][j] > d[i-1][j] + 1) {
                  d[i][j] = d[i-1][j] + 1;
              }
              
              if (d[i][j] > d[i][j-1] + 1) {
                  d[i][j] = d[i][j-1] + 1;
              }
           }
        }
        return d[len1][len2];
    }
    
    public int minDistance(String word1, String word2) {
        if (word1.length() == 0) return word2.length();
        if (word2.length() == 0) return word1.length();
        int min = Integer.MAX_VALUE;
        if (word1.charAt(0) == word2.charAt(0)) {
            min = minDistance(word1.substring(1), word2.substring(1));
        } else {
            min = minDistance(word1.substring(1), word2.substring(1)) + 1;
        }
        
        int d1 = minDistance(word1.substring(1), word2) + 1;
        if (min > d1) {
            min = d1;
        }
        int d2 = minDistance(word1, word2.substring(1)) + 1;
        if (min > d2) {
            min = d2;
        }
        return min;
    }

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("prosperity", "properties") == ed.minDistance_("prosperity", "properties"));

    }

}
