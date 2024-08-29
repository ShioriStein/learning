package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListOverLoadMethods {
    public static void main(String[] args) {
        List<String> a = new ArrayList();

        //add(Element e)
        a.add("A");
        a.add("B");

        //add(int index, Element e)
        a.add(1,"Á");
        a.add(2,"À");

        //addAll(Collection <extends ? Element > c)
        a.addAll(List.of("C", "D", "E"));

        //addAll(int index, Collection <extends ? Element > c)
        a.addAll(6, List.of("Đ", "Đ?"));


        System.out.println(a);
    }
}
