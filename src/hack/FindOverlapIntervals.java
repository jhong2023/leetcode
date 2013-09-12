package hack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindOverlapIntervals {
	
	class Interval{
		int start;
		int end;
	}
    
	
	// O(n) solution, with maxEnd
    public void intersected(Interval[] intervals, boolean[] isIntersected) {
    	
    	int len = intervals.length;
    	List<Interval> tmp = new ArrayList<Interval>();
    	for(int i = 0; i < len; i++){
    		tmp.add(intervals[i]);
    	}
    	Collections.sort(tmp, new Comparator<Interval>(){
    		public int compare(Interval a, Interval b){
    			return a.start - b.start;
    		}
    	});
    	int i = 0;
    	Map<Interval, Boolean> map = new HashMap<Interval, Boolean>();
    	while(i < len){
    		int j = i+1;
            int maxEnd = tmp.get(i).end;
    		while(j < len && tmp.get(j).start <= maxEnd){
    			map.put(tmp.get(j), true);
                if(tmp.get(j).end > maxEnd){
                    maxEnd = tmp.get(j).end;
                }
    			j++;
    		}
    		if(j > i+1){
    			map.put(tmp.get(i), true);
    		}
            i = Math.max(j-1, i+1);
    	}
    	
        for(int j =0; j < intervals.length; j++ ){
        	if(map.get(intervals[j]) != null && map.get(intervals[j])){
        		isIntersected[j] = true;
        	} else {
        		isIntersected[j] =  false;
        	}
        }
     
     }
    
    public void intersected_(Interval[] intervals, boolean[] isIntersected) {
        for(int j =0; j < intervals.length; j++ ){
            isIntersected[j] = isIntersect(intervals, j);
        }
     }
    
    boolean isIntersect(Interval[] intervals, int i){
    	
        for(int j =0; j < intervals.length; j++ ){
            if(i == j) continue;
            
            if(intervals[i].end >= intervals[j].start 
               && intervals[j].end >= intervals[i].start ){
                return true;
            }
        }
        return false;
    }
    
}
