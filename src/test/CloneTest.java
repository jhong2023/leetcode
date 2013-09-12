package test;

import java.util.ArrayList;

public class CloneTest {
	static class Node{
		int val;
	}
	
	public static void main(String[] args) {
    	
    	ArrayList<Node> a = new ArrayList<Node>();
    	Node n = new Node();
    	n.val = 1;
    	a.add(n);
    	ArrayList<Node> b = (ArrayList<Node>) a.clone();
    	b.get(0).val = 2;
    	System.out.println(a.get(0).val);
    	System.out.println(b.get(0).val);
    	
    	b.add(new Node());
    	System.out.println(a.size());
    	System.out.println(b.size());
	}

}
