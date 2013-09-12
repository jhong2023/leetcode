package thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {

	public static void main(String[] args) throws InterruptedException {
		Queue<Integer> q = new LinkedList<Integer>();
		System.out.println(q.poll());
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
		System.out.println(queue.poll(2, TimeUnit.SECONDS));
		System.out.println(queue.take());
	}

}
