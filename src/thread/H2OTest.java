package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class H2OTest {
	
	class H2OLock{
		CountDownLatch h = new CountDownLatch(2);
		CountDownLatch o = new CountDownLatch(1);
		public synchronized void callH() throws InterruptedException{
			h.await();
			o.countDown();
			System.out.println("H");
		}
		
		public synchronized void callO() throws InterruptedException{
			o.wait();
			h.countDown();
			System.out.println("O");
		}
	}

	/*
	class H2OLock{
		int o = 0;
		int h = 0;
		public synchronized void callH() throws InterruptedException{
			if(h < 1 || o < 1){
				h++;
				wait();
			}
			if(o>0){
				o--;
				notify();
			}
			System.out.println("H");
		}
		
		public synchronized void callO() throws InterruptedException{
			if(h < 2){
				o++;
				wait();
			}
			h = h-2;
			System.out.println("O");
			notify();
			notify();
		}
	}*/
	
	H2O h2oLock = new H2O();
	
	class HCaller implements Runnable{
		public void run() {
			try {
				h2oLock.h();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class OCaller implements Runnable{
		public void run() {
			try {
				h2oLock.o();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	void test() throws InterruptedException{
		
		
		new Thread(new OCaller()).start();
		Thread.sleep(100);
		new Thread(new HCaller()).start();
		Thread.sleep(100);
		new Thread(new HCaller()).start();
		Thread.sleep(100);
		new Thread(new HCaller()).start();
		Thread.sleep(100);
		new Thread(new HCaller()).start();
		Thread.sleep(100);
		new Thread(new OCaller()).start();
		Thread.sleep(100);
		new Thread(new OCaller()).start();
		Thread.sleep(100);
		new Thread(new HCaller()).start();

	}
	
	public static void main(String[] args) throws InterruptedException {
		new H2OTest().test();
	}
}

class H2O {
	int freeh, freeo, boundh, boundo;
	Lock lock;
	Condition condh, condo;

	public H2O() {
		freeh = freeo = boundh = boundo = 0;
		lock = new ReentrantLock();
		condh = lock.newCondition();
		condo = lock.newCondition();
	}

	public void o() throws InterruptedException {
		lock.lock();
		freeo++;
		try {
			if (freeh >= 2) {
				boundh += 2;
				condh.signal();
				condh.signal();
			} else {
				while (boundo == 0)
					condo.await();
				boundo--;
			}
			freeo--;
			System.out.println("O");
		} finally {
			lock.unlock();
		}
	}

	public void h() throws InterruptedException {
		lock.lock();
		freeh++;
		try {
			if (freeh >= 2 && freeo >= 1) {
				boundo++;
				boundh++;
				condo.signal();
				condh.signal();
			} else {
				while (boundh == 0)
					condh.await();
				boundh--;
			}
			System.out.println("H");
		} finally {
			lock.unlock();
		}
	}
}
