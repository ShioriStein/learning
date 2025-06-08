package udemy.DSA;

public class Fibonacci {
    static int counter = 0;
    static Integer[] array = new Integer[100];
    public static int fibonacci(int n) {
        counter++;
        if (array[n] != null) {
            return array[n];
        }
        if(n == 0 || n == 1) {
            return n;
        }

        array[n] = fibonacci(n - 1) + fibonacci(n - 2);
        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(50));
        System.out.println(counter);
    }
}
