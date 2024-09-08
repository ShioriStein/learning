package core.OOP;

class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String pName) {
        name = pName;
    }

    public int calculateSalary(int base) {
        return age * base;
    }

    public int calculateSalary(int base, String pName) {
        if (name == "employee1") {
            return base;
        } else {
            return age * base;
        }
    }

    public void sum(int base, long time) {
        System.out.println(name + " " + age + " " + base + " " + time);
    }

    public void sum(long base, int time) {
        System.out.println(name + " " + age + " " + base + " " + time);
    }
}

public class OverLoading {
    public static void main(String[] args) {
        Employee emp1 = new Employee("employee1");
        Employee emp2 = new Employee("employee2", 20);
//        emp2.sum(20, 20);
    }
}
