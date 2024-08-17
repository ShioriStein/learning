package core;

public class Finalize {
    public static void main(String[] args) {
        String ex = new String("test");
        ex = null;
        System.gc();
    }

    @Override
    protected void finalize() {
        System.out.println("finalize run???");
    }
}
