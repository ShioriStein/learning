package core;

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
}

public class OverLoading {
    public static void main(String[] args) {
        Employee emp1 = new Employee("employee1");
        Employee emp2 = new Employee("employee2", 20);
    }
}
