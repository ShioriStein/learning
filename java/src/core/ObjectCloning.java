package core;

class Student implements Cloneable {
    String name;
    int id;

    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }
    int getId() {
        return id;
    }
    void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public Student clone() {
        try {
            Student clone = (Student) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

class ClassRoom implements Cloneable {
    String id;
    String classroomName;
    Student headStudent;

    public void setHeadStudent(Student headStudent) {
        this.headStudent = headStudent;
    }

    public Student getHeadStudent() {
        return headStudent;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    @Override
    public ClassRoom clone() {
        try {
            ClassRoom clone = (ClassRoom) super.clone();
            clone.headStudent = headStudent.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }



    @Override
    public String toString() {
        return "ClassRoom{" +
                "id='" + id + '\'' +
                ", classroomName='" + classroomName + '\'' +
                ", headStudent=" + headStudent +
                '}';
    }
}

public class ObjectCloning {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("John");

        ClassRoom c1 = new ClassRoom();
        c1.setClassroomName("test");
        c1.setHeadStudent(s1);

        ClassRoom c2 = c1.clone();
        c2.getHeadStudent().setName("John the second");

        System.out.println(c1);
        System.out.println(c2);
    }
}
