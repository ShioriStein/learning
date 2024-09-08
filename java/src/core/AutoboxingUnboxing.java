package core;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingUnboxing {
    public static void main(String[] args) {
        long time1;
        long time2;

        List<Integer> listValues = new ArrayList<>();
        int[] arrValues = new int[100000];
        for(int i = 0; i < 100_000; i++) {
            arrValues[i] = i;
            listValues.add(i);
        }

        time1 = System.currentTimeMillis();
        for(int i = 0; i < 100_000; i++) {
            listValues.set(i, listValues.get(i) * 10);
        }
        time2 = System.currentTimeMillis();

        System.out.println("Total time need for Autoboxing: " + (time2 - time1));

        time1 = System.currentTimeMillis();
        for(int i = 0; i < 100_000; i++) {
            arrValues[i] = arrValues[i] * 10;
        }
        time2 = System.currentTimeMillis();

        System.out.println("Total time need for primitive: " + (time2 - time1));
    }
}
