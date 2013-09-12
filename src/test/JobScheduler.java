package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JobScheduler {
	
	public boolean jobSchedule(Map<Integer, List<Integer>> deps, int n,
			int[] result) {
		if (n < 1) return false;
		if (n == 1) {
			result[0] = 1;
			return true;
		}
		
		int d[] = new int[n+1];
		for (int i = 0; i <= n; i++) {
			d[i] = 0;
		}
		Map<Integer, List<Integer>> rmap = new HashMap<Integer, List<Integer>>();
        if (deps != null) {
			for (Integer i : deps.keySet()) {
                d[i] = deps.get(i) == null ? 0 : deps.get(i).size();
                for(Integer j : deps.get(i)){
                	if(!rmap.containsKey(j)) rmap.put(j, new ArrayList<Integer>());
                	rmap.get(j).add(i);
                }
			}
		}
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++){
        	if(d[i] == 0){
        		q.add(i);
        	}
        }
        int j = 0;
        // q is not empty
        while(!q.isEmpty()){
        	Integer tmp = q.remove();
        	result[j] = tmp;
        	j++;
        	// check null
        	if (rmap.get(tmp) != null){
	        	for(Integer t : rmap.get(tmp)){
	        		d[t]--;
	        		if(d[t] == 0){
	        			q.add(t);
	        		}
	        	}
        	}
        }
		return j == n;
	}

	public boolean jobSchedule_(Map<Integer, List<Integer>> deps, int n,
			int[] result) {

		if (n < 1) return false;
		if (n == 1) {
			result[0] = 1;
			return true;
		}

		int d[] = new int[n+1];
		for (int i = 0; i <= n; i++) {
			d[i] = 0;
		}
        
        if (deps != null) {
			for (Integer i : deps.keySet()) {
                d[i] = deps.get(i) == null ? 0 : deps.get(i).size();
			}
		}

		int k = 0;
		while (true) {
			int i = 1;
			while (i <= n && d[i] != 0) {
				i++;
			}
			// break on i > n
			if (i > n)	break;

			result[k] = i;
			// rest d[i]
			d[i] = -1;
			k++;
			for (int j = 1; j <= n; j++) {
				// using existing deps
				if (deps.containsKey(j) && deps.get(j).contains(i)) {
					d[j]--;
				}
			}
		}

		return k == n;
	}
	
	public static void main(String[] args) {
		
		JobScheduler js = new JobScheduler();
		int res[] = new int[2];
		js.jobSchedule(new HashMap<Integer, List<Integer>>(), 2, res);
		for(int i : res){
			System.out.print(i + " ");
		}
	}

}
