package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class InteratorEx {
    public static void deleteWithFor() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            // Add element to list
            list.add("0" + i);
        }

        // traversing the list in the forward direction
        for (int i = 0; i < 5; i++) {
            list.remove(i);
        }
    }

    public static void deleteWithForEach() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            // Add element to list
            list.add("0" + i);
        }

        // traversing the list in the forward direction
        for (String item : list) {
            list.remove(item);
        }
    }

    public static void deleteWithInterator() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            // Add element to list
            list.add("0" + i);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.remove();
        }

        System.out.println(list);
    }

    public static void travelWithIterator() {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            // Add element to list
            list.add("0" + i);
        }

        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }

        System.out.println(list);
    }


    public static void main(String[] args) {
//        deleteWithFor();
//        deleteWithForEach();
        deleteWithInterator();
        travelWithIterator();
    }
}
