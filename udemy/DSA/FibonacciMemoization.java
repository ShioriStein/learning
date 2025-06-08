package udemy.DSA;

public class FibonacciMemoization {
    static int counter = 0;
    public static int fibonacci(int n) {
        counter++;
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(50));
        System.out.println(counter);
    }
}
