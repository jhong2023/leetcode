package list;

import java.util.ArrayList;

public class InsertInterval {
    
    public class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
    
  public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        
        ArrayList<Interval> r = new ArrayList<Interval>();
        
        int i = 0;
        while( i < intervals.size()) {
            if (intervals.get(i).start > newInterval.end) {
                r.add(newInterval);
                break;
            }
            
            if(intervals.get(i).end < newInterval.start) {
                r.add(intervals.get(i));
            } else {
            
               if (intervals.get(i).start < newInterval.start){
                   newInterval.start = intervals.get(i).start;
               }
               if (intervals.get(i).end >  newInterval.end) {
                   newInterval.end = intervals.get(i).end;
               }
            }
            
            i++;
        }
        
                
        if (i == intervals.size()) {
            r.add(newInterval);
        } 
        
        while(i < intervals.size()) {
            r.add(intervals.get(i));
            i++;
        }
        
        return r;
    }
    
    public ArrayList<Interval> insert_(ArrayList<Interval> intervals, Interval newInterval) {
        if (newInterval == null) return intervals;
        ArrayList<Interval> newintervals = new ArrayList<Interval>();

        if (intervals == null || intervals.size() == 0) {
            newintervals.add(newInterval); 
            return newintervals;
        }
        int i = 0;
        while (i < intervals.size()) {
            Interval iv = intervals.get(i);
            if (newInterval.end < iv.start) {
                newintervals.add(newInterval);
                break;
            }
            
            if (newInterval.start > iv.end) {
                newintervals.add(iv);
            } else {
                if (newInterval.start > iv.start) {
                    newInterval.start = iv.start;
                } 
                if (newInterval.end < iv.end) {
                    newInterval.end = iv.end;
                }
            }
            
            i++;
        }
        
        if (i == intervals.size()) {
            newintervals.add(newInterval);
        } 
        
        while (i < intervals.size()) {
            newintervals.add(intervals.get(i));
            i++;
        }
        return newintervals;
    }

    public static void main(String[] args) {

    }
    

}
