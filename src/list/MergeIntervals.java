package list;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeIntervals {
    
    static public class Interval {
            int start;
            int end;
            Interval() { start = 0; end = 0; }
            Interval(int s, int e) { start = s; end = e; }
    }
    
    // best solution: O(n)
    public ArrayList<Interval> merge_(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals == null || intervals.size() < 1) return result;
        if (intervals.size() == 1) return intervals;
        
        

        PriorityQueue<Integer> starts = new PriorityQueue<Integer>();
        PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
        
        for (Interval v : intervals) {
            starts.add(v.start);
            ends.add(v.end);
        }
        int start = starts.poll();
        int end = ends.poll();
        while (!starts.isEmpty()) {
            if (starts.peek() > end) {
                result.add(new Interval(start, end));
                start = starts.poll();
                end = ends.poll();
            } else {
                starts.poll();
                end = ends.poll();
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<MergeIntervals.Interval>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(5, 6));
		
		ArrayList<Interval> res = new MergeIntervals().merge(intervals);
		System.out.println(res.size());
        
    }
	
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<Interval>();
        if (intervals == null) return null;
        for(Interval inv : intervals){
            res = insert(res, inv);
        }
        return res;
    }
    
    ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval inv){
        ArrayList<Interval> res = new ArrayList<Interval>();
        int i = 0;
        for(; i < intervals.size(); i++){
            if(inv.start > intervals.get(i).end){
                // i++; what's this for??????
                res.add(intervals.get(i));
            } else if (inv.end < intervals.get(i).start){
                break;
            } else {
                inv.start = Math.min(inv.start, intervals.get(i).start);
                inv.end = Math.max(inv.end, intervals.get(i).end);
            }
        }
        res.add(inv);
        for(;i < intervals.size(); i++){
            res.add(intervals.get(i));
        }
        return res;
    }

}
