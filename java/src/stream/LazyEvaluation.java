package stream;

import java.util.Arrays;

public class LazyEvaluation {
    public static void main(String[] args) {
        int[] arrayOfNum = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Arrays.stream(arrayOfNum).filter((num) -> {
            System.out.println(num);
            return (num % 2) == 0;
        }).count();
    }
}
