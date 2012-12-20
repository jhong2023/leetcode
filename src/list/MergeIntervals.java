package list;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeIntervals {
    
    public class Interval {
            int start;
            int end;
            Interval() { start = 0; end = 0; }
            Interval(int s, int e) { start = s; end = e; }
    }
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
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
        
    }

}
