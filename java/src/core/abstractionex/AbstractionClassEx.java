package core.abstractionex;

abstract class Organic {

}

abstract class Mamal {

}

abstract class Animal extends Mamal {
    private int age;
    abstract void run();
    public void sleepSound() {
        System.out.println("Animal ZZZ");
    }

    Animal(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    abstract void eat();
}

class Dog extends Animal {
    Dog(int age) {
        super(age);
    }

    @Override
    void run() {
        System.out.println("Dog run");
    }

    @Override
    void eat() {
        System.out.println("Dog eat");
    }
}


public class AbstractionClassEx {
    public static void main(String[] args) {
        Animal dog = new Dog(10);
        dog.sleepSound();
        dog.run();
        System.out.println(dog.getAge());
    }
}
