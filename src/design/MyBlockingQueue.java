package design;


// http://www.docjar.com/html/api/java/util/concurrent/LinkedBlockingQueue.java.html

public class MyBlockingQueue<E> {
	int capacity;
	int size;
	Node<E> last, head;

	class Node<E>{

		public Node(E e) {
		}
		E element;
		Node<E> next;
	}
	
	public MyBlockingQueue(int capacity) {
		this.capacity = capacity;
		last = head = new Node<E>(null);
	}
	
	public synchronized E dequeue(){
		Node<E> first = head.next;
		while(first == null){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		E e = first.element;
		head.next = head; // help GC
		head = first;
		first.element = null;
		size--;
		notifyAll();
		return e;
	}
	
	public synchronized void enqueue(E e){
		while(size == capacity){
			try {
				wait();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		Node<E> n = new Node<E>(e);
		if(last == null){
			last = n;
			head = n;
		} else {
			last.next = n;
			last = last.next;
		}
		size++;
		notifyAll();
	}

}
