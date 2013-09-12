package thread;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

import com.sun.corba.se.impl.orbutil.concurrent.ReentrantMutex;

public class ReadWriteLock {
	/*
	AtomicInteger readCount = new AtomicInteger(0);
	AtomicBoolean writing = new AtomicBoolean(false);
	
	void read_lock() { 
		// lock_guard lk(mutex);
		while(writing.get()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		readCount.incrementAndGet();
	}
	
	void read_unlock() { 
		// lock_guard lk(mutex); 
		if (readCount.decrementAndGet() == 0){
			notifyAll();
		}
	}
	
	void write_lock() {
		// lock_guard lk(mutex); 
		while(writing.get() || readCount.intValue() > 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		writing.set(true);
	}
	void write_unlock() { 
		// lock_guard lk(mutex) ; 
		writing.set(false);
		notifyAll();
	}
	*/
	
	void lock(){
		ReentrantLock lock = new ReentrantLock();
		lock.lock();
		lock.tryLock();
		lock.unlock();
		
		ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		ReadLock rlock = rwLock.readLock();
		rlock.lock();
		rlock.unlock();
		WriteLock wlock = rwLock.writeLock();

		ReentrantMutex mutex = new ReentrantMutex();
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			mutex.release();
		}
	}
	
	//private Semaphore writeLock = new Semaphore(1);
	//private Semaphore readLock = new Semaphore(2);
	
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	final Lock readLock = lock.readLock();
	final Lock writeLock = lock.writeLock();
	RWLock rwlock = new RWLock();

	class Reader implements Runnable{
		@Override
		public void run() {
			try {
				// readLock.acquire();
				// readLock.lock();
				rwlock.readlock();
				System.out.println("Read lock acquired:" + Thread.currentThread().getId());
				Thread.sleep(1000);
				System.out.println("Read lock realeased:" + Thread.currentThread().getId());
				//readLock.release();
				// readLock.unlock();
				rwlock.readunlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class Writer implements Runnable{
		@Override
		public void run() {
			try {
				//writeLock.acquire();
				// writeLock.lock();
				rwlock.writelock();
				System.out.println("Write lock acquired:" + Thread.currentThread().getId());
				Thread.sleep(1000);
				System.out.println("Write lock realeased:" + Thread.currentThread().getId());
				//writeLock.release();
				// writeLock.unlock();
				rwlock.writeunlock();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class RWLock{
		boolean writing;
		int reading = 0;
		synchronized void readlock() { 
			while(writing) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			reading++;
		}
		
		synchronized void readunlock() {
			reading--;
			if (reading == 0){
				notifyAll();
			}
		}
		
		synchronized void writelock() {
			while(writing || reading > 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			writing = true;
		}
		synchronized void writeunlock() { 
			writing = false;
			notifyAll();
		}
	}
	
	void testLock(){
		Thread w1 = new Thread(new Writer());
		w1.start();
		Thread r1 = new Thread(new Reader());
		r1.start();
		Thread r2 = new Thread(new Reader());
		r2.start();
		Thread w2 = new Thread(new Writer());
		w2.start();
		Thread r3 = new Thread(new Reader());
		r3.start();
		
	}
	
	public static void main(String[] args) {
		
		new ReadWriteLock().testLock();
	}
}
