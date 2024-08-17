package core;

public class Array {
    public static void main(String[] args) {
        int[] n1 = new int[0];
        boolean[] n2 = new boolean[-200]; //Error at run time when JVM allocate memory for this variable.
//        double[] n3 = new double[2241423798]; //Number too big for integer so at compile-time it will cause error
        char[] ch = new char[20];
    }
}