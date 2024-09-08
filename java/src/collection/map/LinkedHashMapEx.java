package collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        Map<String, String> m1 = new LinkedHashMap<>();
        m1.put("Zara", "8");
        m1.put("Mahnaz", "31");
        m1.put("Ayan", "12");
        m1.put("Daisy", "14");

        System.out.println(" Map Elements");
        System.out.print("\t" + m1);

        m1.remove("Daisy");
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);

        for (String key : m1.keySet()) {
            System.out.println("\t" + key + " = " + m1.get(key));
        }

        for (Map.Entry<String, String> entry : m1.entrySet()) {
            System.out.println("\t" + entry.getKey() + " = " + entry.getValue());
        }
    }
}
