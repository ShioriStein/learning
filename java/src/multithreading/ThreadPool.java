package multithreading;

import java.util.concurrent.*;

class Ax extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName() + " - " + "A");
    }
}

class Bx implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName() + " - " + "B");
    }
}

public class ThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        Executor executor = Executors.newSingleThreadExecutor();
//        executor.execute(() -> System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName()));

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future = executorService.submit(() -> System.out.println(Thread.currentThread().getId() + " - " + Thread.currentThread().getName()));
        future.get();
        executorService.shutdown();
    }
}
