/*Java provides a mechanism, called object serialization where an object can be represented as a sequence of bytes that
includes the object's data as well as information about the object's type and the types of data stored in the object.

After a serialized object has been written into a file, it can be read from the file and deserialized that is, the type
information and bytes that represent the object and its data can be used to recreate the object in memory.

Most impressive is that the entire process is JVM independent, meaning an object can be serialized on one platform and
deserialized on an entirely different platform.*/

/*
Advantages of Serialization
1. To save/persist state of an object.
2. To travel an object across a network.
...
*/

/*Serializable is a marker interface (has no data member and method).
It is used to “mark” java classes so that objects of these classes may get certain capability.*/



import java.io.*;

public class Main {
    public static void main(String[] args) {
        write();
    }

    public static void write() {
        Student student = new Student();
        student.name = "David";
        student.age = 23;
        student.course = "Computer Science";
        student.gpa = 4.7;

        try {

            //When serializing an object to a file, the standard convention in Java is to give the file a .ser extension.
            FileOutputStream fileOut = new FileOutputStream("/tmp/student.ser");

            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(student);
            objectOut.close();

            fileOut.close();

            System.out.println("Serialized object is in /tmp/student.ser");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            read();
        }
    }

    private static void read() {
        Student student;

        try {
            FileInputStream fileIn = new FileInputStream("/tmp/student.ser");

            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            student = (Student) objectIn.readObject();
            objectIn.close();

        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            System.out.println("Student class not found");
            return;
        }

        System.out.println(student);
    }
}
