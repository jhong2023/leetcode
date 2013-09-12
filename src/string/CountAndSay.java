package string;

public class CountAndSay {

    public String countAndSay(int n) {
        String str = "1";
        int i=1;
        while(i<n) {
           str = countSay(str);
           i++;
        }
        return str;
     }
     
     public String countSay(String s){
         String r = "";
         int len = s.length();
         int i = 0;
         while(i<len){
             int j = 1;
             char c = s.charAt(i);
             i++;
             while(i<len && c == s.charAt(i)){
                 i++;
                 j++;
             }
             r += j + "" + c;
         }
         return r;
     }

}
