package multithreading;

class A extends Thread {
    public void run() {
        System.out.println("A");
    }
}

class B implements Runnable {
    public void run() {
        System.out.println("B");
    }
}

public class Threading {
    public static void main(String[] args) {
        A testA = new A();
        testA.start();
        Thread testB = new Thread(new B());
        testB.start();
    }
}
