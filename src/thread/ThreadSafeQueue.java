package thread;

public class ThreadSafeQueue {
    
    Node front;
    Node rear;
    int size;
    int capacity;
    
    class Node {
        int val;
        Node next;     
        Node(int val) {
            this.val = val;
        }
    }
    
    synchronized void enqueue(int val) {
        Node n = new Node(val);
        if (front == null) {
            front = n;
            rear = n;
        }
        rear.next = n;
        rear = n;
        notifyAll();
    }
    
    synchronized Node dequeue() {
        while (front == null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Node tmp = front;
        front = front.next;
        return tmp;
    }
    
    public static void main(String[] args) throws InterruptedException {
        final ThreadSafeQueue q = new ThreadSafeQueue();
        
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    q.enqueue(i);
                    i++;
                    try {
                        Thread.sleep(60);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(q.dequeue().val);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        t1.start();
        Thread.sleep(50);
        t2.start();
        int i = 0;
        while (true) {
            i--;
            q.enqueue(i);
            Thread.sleep(40);
        }
    }

}
