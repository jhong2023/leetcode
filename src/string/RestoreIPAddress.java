package string;

import java.util.ArrayList;

public class RestoreIPAddress {

    public ArrayList<String> restoreIpAddresses(String s) {
        return restore(s, 4);
    }
    
    ArrayList<String> restore(String s, int k){
        ArrayList<String> r = new  ArrayList<String>();
        int len = s.length();
        if(len < k || len > 3*k) return r;
        if(k == 1){
            if(Integer.parseInt(s) <= 255 && 
                (len == 1 || Integer.parseInt(s)>= Math.pow(10, len-1))){
                r.add(s);
            }
            return r;
        }
        for(String t : restore(s.substring(1), k - 1)){
            r.add(s.substring(0,1) + "." + t);
        }
        
        // must check length, 9
        if(len > 1 && Integer.parseInt(s.substring(0,2)) > 9){
            for(String t : restore(s.substring(2), k - 1)){
                r.add(s.substring(0,2) + "." + t);
            }
        }
        
        // must check length and 255, 99
        if(len > 2 && Integer.parseInt(s.substring(0,3)) > 99 && Integer.parseInt(s.substring(0,3)) <= 255) {
            for(String t : restore(s.substring(3), k - 1)){
                r.add(s.substring(0,3) + "." + t);
            }
        }
        return r;
    }

}
