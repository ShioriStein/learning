package core.OOP;

class Dog extends Animal {
    static void downNe(Object obj) {
        if (obj instanceof Dog) {
            System.out.println("Inside Dog::downNe");
        } else {
            System.out.println("obj is not instance of a dog");
        }

        Dog dog = (Dog) obj;// downcasting
        System.out.println("downcasting is ok"); //error at run time
    }
}

public class InstanceOf {
    public static void main(String[] args) {
        InstanceOf instanceOf = new InstanceOf();
        //Kiểm tra kiểu wrapper
        String str = "test ne";
        System.out.println(str instanceof String);

        Integer num = 10;
        System.out.println(num instanceof Integer);

        //Một đối tượng có kiểu của lớp con thì cũng có kiểu của lớp cha
        Cat cat = new Cat();
        System.out.println(cat instanceof Cat);
        System.out.println(cat instanceof Animal);

        //null
        Cat cat2 = null;
        System.out.println(cat2 instanceof Cat);

        //Down casting với instanceOf
        Animal animalD = new Dog();
        Dog.downNe(animalD);

        Object obj = new Cat();
        Dog.downNe(obj);

    }
}
