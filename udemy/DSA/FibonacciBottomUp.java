package udemy.DSA;

public class FibonacciBottomUp {
    static int counter = 0;
    public static int fibonacci(int n) {
        int[] numArray = new int[n + 1];
        numArray[0] = 0;
        numArray[1] = 1;
        for(int i = 2; i <= n; i++) {
            counter++;
            numArray[i] = numArray[i - 1] + numArray[i - 2];
        }

        return numArray[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(50));
        System.out.println(counter);
    }
}
