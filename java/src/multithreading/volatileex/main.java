package multithreading.volatileex;


public class main {

    private static int beforeMainNumber = 0;
    private volatile static int mainNumber = 0;
    private static int afterMainNumber = 0;

    private static class Reader extends Thread {
        int localNumber = mainNumber;
        int localBeforeNumber = beforeMainNumber;
        int localAfterNumber = afterMainNumber;

        @Override
        public void run() {
            while (localNumber < 5) {
                localBeforeNumber = beforeMainNumber;
                localAfterNumber = afterMainNumber;
                if (localNumber != mainNumber) {
                    System.out.println("Get different number " + localNumber + " vs " + mainNumber);

                    System.out.println("BEFORE: " + localBeforeNumber);
                    System.out.println("AFTER: " + localAfterNumber);
                    localNumber = mainNumber;
                }
            }
        }
    }

    private static class Writer extends Thread {
        int localNumber = mainNumber;

        @Override
        public void run() {
            while (localNumber < 5) {
                System.out.println("Assign mainNumber to: " + localNumber);
                beforeMainNumber--;
                mainNumber = ++localNumber;
                afterMainNumber--;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * Working of volatile & synchronize follow happen-before rule of JMM
         * https://www.baeldung.com/java-volatile
         * anything update before volatile will guarantee to be flush and update to memory
         * anything visible to thread when read volatile will be up to date with data in memory
         * */
    }

    public static void main(String[] args) throws InterruptedException {
        new Reader().start();
        new Writer().start();
    }
}
