package core;
class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String pName) {
        name = pName;
    }

    public int walk(int distance, int time) {
        int speed = distance / time;
        return speed;
    }
}

class Atheletes extends Human {
    public Atheletes(String name, int age) {
        super(name, age);
    }

    public int walk(int distance, int time) {
        int speed = distance / time;
        speed *= 2;
        return speed;
    }

    public int classicWalk(int distance, int time) {
        return super.walk(distance, time);
    }
}



public class Overriding {
    public static void main(String[] args) {

    }
}
