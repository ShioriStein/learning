package core.OOP;

class Animal {
    public void eat() {
        System.out.println("Animal Eating");
    }

    public void sleep() {
        System.out.println("Animal Sleeping");
    }
}

class Cat extends Animal {
    public void eat() {
        System.out.println("Cat Eating");
    }
    public void sleep() {
        System.out.println("Cat Sleeping");
    }

    public void mew() {
        System.out.println("Mew");
    }
}

public class UpcastingAndDowncasting {
    public static void main(String[] args) {
        Animal a = new Cat(); //Upcasting
        a.eat();
        a.sleep();
        Cat c = (Cat) a; //Down casting
        c.eat();
        c.sleep();
        c.mew();

    }
}
