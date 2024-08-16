package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListInteractSpeed {
    static List<Integer> insertArrayList(int element) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < element; i++) {
            list.add(Integer.valueOf(i));
        }
        return list;
    }

    static List<Integer> insertArrayListOdd(int element) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < element / 2; i += 2) {
            list.add(Integer.valueOf(i));
        }
        for (int i = 1; i < element / 2; i += 2) {
            list.add(i, Integer.valueOf(i));
        }
        return list;
    }

    static void deleteOddElementArrayList(List<Integer> list) {
        list.removeIf(e -> e % 2 == 0);
    }

    static List<Integer> deleteElementArrayList(List<Integer> list, int element) {
        list.remove(element);
        return list;
    }

    static List<Integer> insertLinkedList(int element) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < element; i++) {
            list.add(Integer.valueOf(i));
        }
        return list;
    }

    static List<Integer> insertLinkedListOdd(int element) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < element / 2; i += 2) {
            list.add(Integer.valueOf(i));
        }
        for (int i = 1; i < element / 2; i += 2) {
            list.add(i, Integer.valueOf(i));
        }
        return list;
    }

    static List<Integer> deleteElementLinkedList(List<Integer> list, int element) {
        list.remove(element);
        return list;
    }

    static void deleteOddElementLinkedList(List<Integer> list) {
        list.removeIf(e -> e % 2 == 0);
    }

    public static void main(String[] args) {
        long currentTime = System.nanoTime();
        List<Integer> listAL = insertArrayList(100000);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        List<Integer> listLL = insertLinkedList(100000);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        List<Integer> listALOdd = insertArrayListOdd(100000);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        List<Integer> listLLOdd = insertLinkedListOdd(100000);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        deleteElementArrayList(listAL, 9999);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        deleteElementLinkedList(listLL, 9999);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        deleteOddElementArrayList(listLL);
        System.out.println(System.nanoTime() - currentTime);

        currentTime = System.nanoTime();
        deleteOddElementLinkedList(listLL);
        System.out.println(System.nanoTime() - currentTime);
    }

}
