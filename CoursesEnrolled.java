import java.util.ArrayList;

public class CoursesEnrolled {
    public long StudentID;
    public long CourseID;
    public String grade;

    public static ArrayList<CoursesEnrolled> listEnrol = new ArrayList<>();


    public static void displayCoursesEnrolled() {
        for (CoursesEnrolled s : listEnrol) {
            System.out.println("Student ID: " + s.StudentID + "; Course ID: " + s.CourseID + "; Student grade: " + s.grade);
        }
    }

}
