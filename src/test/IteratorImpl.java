package test;

import java.util.Iterator;


public class IteratorImpl{
	
	class Node{
		int i;
		Node next;
	}
	
	class IterImpl implements Iterator<Node>{
		Node cur;
		
		public IterImpl(Node head) {
			cur = head;
		}

		@Override
		public boolean hasNext() {
			return cur.next != null;
		}

		@Override
		public Node next() {
			cur = cur.next;
			return cur;
		}

		@Override
		public void remove() {
		}
	}
	
	class IterImpl2 implements Iterable<Node>{

		@Override
		public Iterator<Node> iterator() {
			IterImpl itr = new IterImpl(new Node());
			return itr;
		}
		
	}
	

	public static void main(String[] args) {

	}

}
