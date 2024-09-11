package multithreading;

class Employee {
    private static volatile Employee instance;

    private String name;
    private int age;

    public static Employee getInstance() {
        if(instance == null) {
            synchronized (Employee.class) { //synchronized block
                if(instance == null) {
                    instance = new Employee();
                }
            }
        }
        return instance;
    }

    private Employee() {}
}

public class DoubleLock {

}
