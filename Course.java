import java.util.ArrayList;

public class Course {

    public long CID;
    public String name;
    public int credits;

    public static ArrayList<Course> listCourses = new ArrayList<>();

    public static void displayCourses() {
        for (Course s : listCourses) {
            System.out.println("Course ID: " + s.CID + "; Name: " + s.name + "; Number of credits: " + s.credits);
        }
    }
    
}
