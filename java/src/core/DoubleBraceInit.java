package core;

import java.util.HashSet;
import java.util.Set;

public class DoubleBraceInit {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>()
        {// creating an anonymous inner class
            { // initializing the instances
                add("A");
                add("B");
                add("C");
            }
        };
        System.out.println(set);
    }
}
