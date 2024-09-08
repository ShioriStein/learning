package core;

public class InnerClass {
    int x = 10;
    public void doSomething() {
        class LocalInnerClass {
            int y = x + 1;
            void doSomething() {
                System.out.println(x);
            }

        }
    }
}
