package core;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class LambdaEx2 {
    static int outerStaticNum;
    int outerNum;

    void doSomething4() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 1;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from -> {
            outerStaticNum = 1;
            return String.valueOf(from);
        });
        stringConverter1.convert(2);
        stringConverter2.convert(2);
    }

}

public class LambdaExpression {
    public static void doSomething1() {
        final int num = 1;
        Converter<Integer, String> stringConverter = (from -> String.valueOf(from + num));
        stringConverter.convert(2);
    }

    public static void doSomething2() {
        int num = 1;
        Converter<Integer, String> stringConverter = (from -> String.valueOf(from + num));
        stringConverter.convert(2);
    }

    public static void doSomething3() {
        int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);

        stringConverter.convert(2); // 3
        //this num = 3 will cause error
        //Vì mọi biến sử dụng trong local scope lambda phải final hoặc effective
        // num = 3;
    }

    public static void main(String[] args) {
        doSomething1();
        doSomething2();
        doSomething3();
        LambdaEx2 ex2 = new LambdaEx2();
        ex2.doSomething4();
        System.out.println(ex2.outerStaticNum);
        System.out.println(ex2.outerNum);
    }
}
