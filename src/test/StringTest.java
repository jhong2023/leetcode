package test;

import java.util.Arrays;


public class StringTest {
	
    public static void main(String[] args) {
//        String s = " aaa bb    dfd";
//        String[] strs = s.split("[ a]+");
//        String out = "";
//        for (int i = 0; i < strs.length; i++) {
//            out += strs[i] + ",";
//        }
//        System.out.println(out); // ,bb,dfd,
    	
    	int[] a = new int[10];
    	for(int i=0; i< 10; i++){
    		//System.out.println(a[i]);
    	}
    	
    	int b[] = {};
    	len(b);
    }
    
    static void len(int[] a){
    	System.out.println(a.length);
    	String s = "cab";
    	char c[] = s.toCharArray();
    	Arrays.sort(c);
    	s = new String(c);
    	System.out.println(s);
    }

}
