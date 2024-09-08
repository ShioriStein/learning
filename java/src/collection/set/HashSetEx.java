package collection.set;

import java.util.HashSet;
import java.util.Set;

class Student {
    String name;
    int id;

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + "]";
    }
}

public class HashSetEx {


    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        Student student1 = new Student(1, "myname1");
        Student student2 = new Student(2, "myname2");
        Student student3 = new Student(3, "myname3");
        Student student4 = new Student(4, "myname4");
        Student student5 = new Student(5, "myname5");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student2);
        students.add(student3);
        students.add(student3);
        students.add(null);
        students.add(null);
        students.add(null);

        // Show set student
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
