package combination;

import java.util.ArrayList;
import java.util.List;

public class PermulateString {

    public List<String> permulate(String s) {
        List<String> result = new ArrayList<String>();
        if (s.length() == 1) {
            result.add(s);
            return result;
        }
        List<String> perms = permulate(s.substring(1));
        String start = s.substring(0, 1);
        for (String sub : perms) {
            for (int i = 0; i < s.length(); i++) {
                result.add(sub.substring(0, i) + start + sub.substring(i) );
            }
        }
        return result;
    }


    public ArrayList<ArrayList<Integer>> permulate(List<Integer> intList) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (intList.size() == 1) {
            ArrayList<Integer> t = new ArrayList<Integer>();
            t.add(intList.get(0));
            result.add(t);
            return result;
        }
        
        ArrayList<ArrayList<Integer>> perms = permulate(intList.subList(1, intList.size()));
        for (ArrayList<Integer> p : perms) {
            for (int i=0; i<=p.size(); i++) {
                ArrayList<Integer> t = new ArrayList<Integer>();
                t.addAll(p.subList(0, i));
                t.add(intList.get(0));
                t.addAll(p.subList(i, p.size()));
                result.add(t);
            }
        }
        return result;
    }
}
