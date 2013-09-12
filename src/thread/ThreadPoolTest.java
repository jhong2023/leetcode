package thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable{
    
    int[] a;
    int index = 0;
    
    ThreadPoolTest(int[] a) {
        this.a = a;
    }
    
    int fun(int i) {
        return i+1;
    }
    
    @Override
    public void run() {
        int i;
        while((i = getIndex()) < a.length) {
           // System.out.println(Thread.currentThread().getName() + " " + i);
            a[i] = fun(a[i]);
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    synchronized int getIndex() {
        return (index++);
    }

    static int coreThreadCount = 10; 
    static int maxThreadCount = 10;
    public static void main(String[] args) throws InterruptedException {
       int size = 1000000;
       int[] a = new int[size];
       for (int i=0; i<size; i++) {
           a[i] = i;
       }
       
       LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
       ThreadPoolExecutor tpe = new ThreadPoolExecutor(coreThreadCount, maxThreadCount,
               Long.MAX_VALUE, TimeUnit.SECONDS, queue);
       ThreadPoolTest m = new ThreadPoolTest(a);
       while(true) {
          tpe.execute(m);
          // System.out.println(queue.size());
       }
    }
}
