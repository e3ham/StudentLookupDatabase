import java.util.ArrayList;

public class Student extends CoursesEnrolled{

    public long SID;
    public String name;
    public String program;
    public String address;

    public static ArrayList<Student> listStudents = new ArrayList<>();

    public static void displayStudent() {
        for (Student s : listStudents) {
            System.out.println("ID: " + s.SID + "; Name: " + s.name + "; Program: " + s.program + "; Address: " + s.address);
        }
    }

}
