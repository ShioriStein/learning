package core.OOP;
class Human {
    private static String title = "Humankind";
    String name;
    int age;
    public int height = 160;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Human(String pName) {
        name = pName;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Human.title = title;
    }

    public int walk(int distance, int time) {
        int speed = distance / time;
        return speed;
    }

    public void jump() {
        System.out.println("Human Jumping...");
    }
}

class Atheletes extends Human {
    public int height = 190;
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

    public void jump() {
        System.out.println("Atheletes Jumping...");
    }
}



public class Overriding {
    public static void main(String[] args) {
        Atheletes atheletes = new Atheletes("Athelles", 30);
        System.out.println(atheletes.getTitle());
        System.out.println(Atheletes.getTitle());

        Human human = new Atheletes("Athelles", 30);
        System.out.println(human.height);
        System.out.println(human.height);
        human.jump();
    }
}
