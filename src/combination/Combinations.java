package combination;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	


	List<List<Integer>> combination(int a[]){
	    if(a == null) return null;
	    
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    res.add(new ArrayList<Integer>());

	    for(int i : a){
	        List<List<Integer>> addition = new ArrayList<List<Integer>>();
	        for(List<Integer> tmp : res){
	            List<Integer> newList = new ArrayList<Integer>();
	            for(int j : tmp){
	                newList.add(j);
	            }
	            addition.add(newList);
	        }
	        for(List<Integer> tmp : addition){
	            tmp.add(i);
	            res.add(tmp);
	        }
	    }
	    return res;
	}


    public static void main(String[] args) {
    	int[] a={1,2,3,4};
    	List<List<Integer>> res = new Combinations().combination(a);
    	for(List<Integer> list : res){
    		for(Integer i: list){
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}

    }
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (n<k) {
            return result;
        }
        if (k == 1) {
            for (int i=1; i <=n; i++) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                result.add(a);
            }
            return result;
        }
        for (int i=n; i>=k-1; i--) {
            for (ArrayList<Integer> a: combine(i-1, k-1)) {
                a.add(i);
                result.add(a);
            }
        }
        return result;
    }

    
    public ArrayList<ArrayList<Integer>> combine_(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        combine(n, k, new ArrayList<Integer>(), res);
        return res;
        
    }
    
    public void combine(int n, int k, ArrayList<Integer> pre, ArrayList<ArrayList<Integer>> res) {
        if(k == 0){
            res.add(pre);
            return;
        }
        if(n < 1){
            return;
        }
        
        ArrayList<Integer> newPre = new ArrayList<Integer>();
        newPre.add(n);
        newPre.addAll(pre);
        combine(n-1, k-1, newPre, res);
        combine(n-1, k, pre, res);
    }


}
