package multithreading;

public class DeadLockEx implements Runnable {
    private Object obj1;
    private Object obj2;

    public DeadLockEx(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " acquiring lock on " + obj1);
        synchronized (obj1) {
            System.out.println(threadName + " acquired lock on " + obj1);
            work();
            System.out.println(threadName + " acquiring lock on " + obj2);
            synchronized (obj2) {
                System.out.println(threadName + " acquired lock on " + obj2);
                work();
            }
            System.out.println(threadName + " released lock on " + obj2);
        }
        System.out.println(threadName + " released lock on " + obj1);
    }

    private void work() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Object lock3 = new Object();

        Thread deadLock = new Thread(new DeadLockEx(lock1, lock2), "t1");
        Thread deadLock2 = new Thread(new DeadLockEx(lock2, lock3), "t2");
        Thread deadLock3 = new Thread(new DeadLockEx(lock3, lock1), "t3");

        deadLock.start();
        deadLock2.start();
        deadLock3.start();
    }
}
