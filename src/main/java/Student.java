import java.io.Serializable;

public class Student implements Serializable {
    String name;
    int age;
    String course;
    double gpa;

    @Override
    public String toString() {
        return name + " is " + age + " years old, studying " + course + " and has a GPA of " + gpa;
    }
}
