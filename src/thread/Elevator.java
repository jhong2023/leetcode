package thread;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

	int curFloor = 0;
	boolean lock = false;
	FloorList floors;
	Thread workerThread;

	public Elevator() {
		floors = new FloorList();
		workerThread = new Thread(new Worker());
		try {
			workerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void start() {
		workerThread.start();
	}

	class Worker implements Runnable {
		public void run() {
			while (true) {
				if (lock)
					break;
				floors.getFloors();
			}
		}
	}

	class FloorList {
		List<Integer> floors = new ArrayList<Integer>();

		public synchronized void addFloor(int n) {
			floors.add(n);
			notifyAll();
		}

		public synchronized int getFloors() {
			while (floors.isEmpty()) {
				if (lock)
					return -1;
				try {
					System.out.println("Wait..");
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			int tmp = floors.get(0);
			System.out.println("Get floor: " + tmp);
			floors.remove(0);
			return tmp;
		}

		public synchronized void lock() {
			notifyAll();
		}
	}

	public void lock() {
		lock = true;
		floors.lock();
	}

	public static void main(String[] args) throws InterruptedException {
		Elevator e = new Elevator();
		e.start();
		System.out.println("1111");
		Thread.sleep(1000);
		e.floors.addFloor(1);
		e.floors.addFloor(2);
		Thread.sleep(1000);
		e.lock();
		Thread.sleep(1000);
		e.floors.addFloor(3);
	}

}
