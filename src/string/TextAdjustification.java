package string;

import java.util.ArrayList;

public class TextAdjustification {

    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> r = new  ArrayList<String>();
        int len = words.length;
        int i = 0;
        while(i < len) {
           int l = words[i].length();
           int j = i + 1;
           while(j < len && l + words[j].length() < L) {
        	   // Don't miss +=
                l += words[j].length() + 1;
                j++;
           }
           if (j == len) {
               r.add(justifyLastLine(words, i, j - 1, L));
           } else {
               r.add(justifyLine(words, i, j - 1, L));
           }
           i = j;
        }
       return r;
   }
   
   String justifyLine(String[] words, int i, int j, int L) {
       int l = 0;
       for(int k=i; k<=j; k++) {
           l+= words[k].length();
       }
       // while cause runtime error without it
       if (i==j) {
    	  return words[i] + space(L-l); 
       }
       
       int n = (L-l)/(j - i);
       
       String s = "";
       int k=i;
       while(k < (L-l)%(j - i) + i) {
           s += words[k] + space(n+1);
           k++;
       }
       while(k < j){
           s += words[k] + space(n);
           k++;
       }
       s += words[k];
       return s;
   }
   
   String space(int n){
       String s = "";
       for(int i = 0; i < n; i++) {
           s += " ";
       }
       return s;
   }
   
   String justifyLastLine(String[] words, int i, int j, int L){
       String s = "";
       int k = i;
       int l = 0;
       for(; k < j; k++) {
           s += words[k] + " ";
           l += words[k].length() + 1;
       }
       l +=  words[k].length();
       
       // must add extra spaces
       s += words[k] + space(L - l) ;
       return s;
   }
   
   public static void main(String[] args) {
	   String[] ss = {"Listen","to","many,","speak","to","a","few."};
	   new TextAdjustification().fullJustify(ss, 6);
   }

}
