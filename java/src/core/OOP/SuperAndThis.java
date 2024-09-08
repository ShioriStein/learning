package core.OOP;

class ParentClass {
    int commonParent = 1;
    ParentClass() {
        System.out.println("ParentClass()");
    }

    void print() {
        System.out.println("ParentClass.print()");
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

    void print() {
        System.out.println("ChildClass.print()");
    }

    void parentPrint() {
        super.print();
    }
}

public class SuperAndThis {
    public static void main(String[] args) {
        ChildClass child = new ChildClass(5);
        child.parentPrint();
    }
}
