package multithreading;

class ShareMemory {
    public synchronized void printDate(String threadName) {
        for (int i = 0; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
        }
    }

    public void printDataStatementBlock(String threadName) {
        System.out.println(threadName + ": starting to do something");
        synchronized (this) {
            for (int i = 0; i <= 5; i++) {
                System.out.println(threadName + ": " + i);
            }
        }
        System.out.println(threadName + ": finish to do something");
    }
}

class WorkingThread extends Thread {
    private ShareMemory shareMemory;
    private String mThreadName;

    public WorkingThread(ShareMemory shareMemory, String threadName) {
        this.shareMemory = shareMemory;
        mThreadName = threadName;
    }

    @Override
    public void run() {
//        shareMemory.printDate(mThreadName);
        shareMemory.printDataStatementBlock(mThreadName);
    }
}

public class SynchronizedEx {
    public static void main(String[] args) {
        ShareMemory shareMemory = new ShareMemory();
        WorkingThread wt1 = new WorkingThread(shareMemory, new String("Thread 1"));
        WorkingThread wt2 = new WorkingThread(shareMemory, new String("Thread 2"));
        WorkingThread wt3 = new WorkingThread(shareMemory, new String("Thread 3"));

        wt1.start();
        wt2.start();
        wt3.start();
    }
}
