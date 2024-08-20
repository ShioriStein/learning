package core;

class ParentClass {
    ParentClass() {
        System.out.println("ParentClass()");
    }
}

class ChildClass extends ParentClass {
    ChildClass() {
        System.out.println("ChildClass()");
    }

    ChildClass(int i) {
        super();
//        this();
        System.out.println("ChildClass(i)");
    }
}

public class SuperAndThis {
    public static void main(String[] args) {
        ChildClass child = new ChildClass(5);
    }
}
