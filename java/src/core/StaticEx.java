package core;

class StaticExClass {
    int i;
    static int j;
    {
        System.out.println(" Instance Block 1. Value of i = "+i);
    }
    static{
        System.out.println(" Static Block 1. Value of j = "+j);
        method_2();
    }
    {
        i = 5;
    }
    static{
        j = 10;
    }
    StaticExClass(){
        System.out.println(" constructor running ");
    }
    public static void main(String[] args){
        StaticExClass ib = new StaticExClass();
    }
    public void method_1(){
        System.out.println(" Instance method. ");
    }
    static{
        System.out.println(" Static Block 2. Value of j = "+j);
    }
    {
        System.out.println(" Instance Block 2. Value of i = "+i);
        method_1();
    }
    public static void method_2(){
        System.out.println(" Static method. ");
    }
}

public class StaticEx {
    public static void main(String[] args) {
        StaticExClass tc = new StaticExClass();
    }
}
