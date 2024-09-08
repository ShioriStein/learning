package core.abstractionex;

interface Shape {
    String color = "black"; //auto public static final
    void draw();
    default void description() {
        System.out.println("Shape Description");
        this.ama();
    }
    static void faq() {
        System.out.println("faq");
    }

    private void ama() {
        System.out.println("ama");
    }
}

interface ObjectShow {
    default void description() {
        System.out.println("ObjectShow Description");
    }
}

interface UltimateShape extends Shape, ObjectShow {

    @Override
    default void description() {
        Shape.super.description();
        ObjectShow.super.description();
    }
}

class Rectangle implements Shape, ObjectShow {

    @Override
    public void draw() {
        System.out.println("Draw " + color + " rectangle");
    }

    @Override
    public void description() {
        Shape.super.description();
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Draw " + color + " circle");
    }
}

class SomethingBlock implements UltimateShape {

    @Override
    public void draw() {
        System.out.println("Draw " + color + " block");
    }
}

public class InterfaceEx {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle();
        rec.draw();

        System.out.println(Shape.color);
        System.out.println(rec.color);
        SomethingBlock sb = new SomethingBlock();
        sb.description();
    }
}
