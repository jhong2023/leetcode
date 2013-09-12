package hack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersected {
	
	static class Interval {
		  public Interval(int i, int j) {
			  start = i;
			  end = j;
		}
		int start;
		  int end;
	}
	
	static class Node{
		int mid;
		List<Interval> intervals = new ArrayList<Interval>();
		Node left;
		Node right;
	}
	
	Node build(List<Interval> intervals){
		if(intervals == null || intervals.size() == 0) return null;
    	int s = 0;
    	int e = 0;
    	int n = 0;
    	for(Interval inv : intervals){
    		s += inv.start;
    		e += inv.end;
    		n++;
    	}
    	int mid = (s+e)/(2*n);
    	Node root = new Node();
    	root.mid = mid;
    	List<Interval> leftInvs = new ArrayList<Interval>();
    	List<Interval> rightInvs = new ArrayList<Interval>();
    	for(Interval inv : intervals){
    		if(inv.end < mid){
    			leftInvs.add(inv);
    		} else if(inv.start > mid){
    			rightInvs.add(inv);
    		} else {
    			root.intervals.add(inv);
    		}
    	}
    	root.left = build(leftInvs);
    	root.right = build(rightInvs);
    	return root;
	}
	
	boolean isIntersected(Interval inv, Node root){
		if(root == null) return false;
        for(Interval t : root.intervals){
			if(t == inv) continue;
			if(t.end >= inv.start && inv.end >= t.start) return true;
		}
		if(inv.start<=root.mid) {
			return isIntersected(inv, root.left);
		}
		if(inv.end >= root.mid) {
			return isIntersected(inv, root.right);
		}

		return false;
	}

    public void intersected(Interval[] intervals, boolean[] isIntersected) {

    	Node root = build(Arrays.asList(intervals));
    	
    	for(int i = 0; i < intervals.length; i++){
    		isIntersected[i] = isIntersected(intervals[i], root);
    		
    	}
    }
    
    public static void main(String[] args) {
    	IntervalIntersected ii = new IntervalIntersected();
    	//[]
    	Interval[] intervals = {new Interval(7763,7889),new Interval(540,566),new Interval(9108,9172),new Interval(5179,5211),new Interval(2396,2567),new Interval(5782,5912),new Interval(2862,2985),new Interval(4067,4202),new Interval(3929,3931),new Interval(4022,4080)};
    	boolean[] isIntersected = new boolean[intervals.length];
    	ii.intersected(intervals, isIntersected);
	}
}