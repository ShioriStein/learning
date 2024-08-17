package exception;

public class MultiCatch {
    public static void main(String[] args) {
        try {
            int n = 1000, x = 0;
            int arr[] = new int[n];
            for (int i = 0; i <= n; i++) {
                arr[i] = i / x;
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("1st block = ArrayIndexOutOfBoundsException");
        } catch (ArithmeticException exception) {
            System.out.println("2nd block = ArithmeticException");
        } catch (Exception exception) {
            System.out.println("3rd block = Exception");
        } finally {
            //It is always run
            //Except when: using System.exit() in the above statement
            // Or fatal errors like stack overflow
            System.out.println("4th block = finally block, always run");
        }
    }
}
