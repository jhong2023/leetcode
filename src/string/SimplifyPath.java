package string;

import java.util.Stack;

/*
 Test case:
	 "/"
	 "/home/../../.."
	 "/./"
	 "/../"
	 "/.hidden"
	 "/."
	 "/.."
	 "///eHx/.."
 */

public class SimplifyPath {

    public String simplifyPath(String path) {
        if(path == null) return null;
        Stack<String> s = new Stack<String>();
        int len = path.length();
        int i = 0;
        String tmp = null;
        while(i < len){
            if(path.charAt(i) == '/') {
               if(tmp != null){
                   if(tmp.equals("..")){
                       if(!s.isEmpty()) {
                           s.pop();
                       }
                   } else if(tmp.length() > 0 && !tmp.equals(".")){
                       s.push(tmp);
                   }
               }
               tmp = "";
            } else {
               tmp += path.charAt(i); 
            }
            i++;
        }
        
        if(tmp != null){
           if(tmp.equals("..")){
               if(!s.isEmpty()) {
                   s.pop();
               }
           } else if(tmp.length() > 0 && !tmp.equals(".")){
               s.push(tmp);
           }
       }
        
        String res = "";
        while(!s.isEmpty()){
            res = "/" + s.pop() + res;
        }
        if(res.length() == 0){
            res = "/";
        }
        return res;
    }

}
