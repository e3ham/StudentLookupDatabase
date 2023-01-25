import java.util.ArrayList;
import java.util.Scanner;

public class SQL {

    static Scanner in = new Scanner(System.in);

    Student array[] = new Student[20];

    public static void createStudent(String name) {
        Student student = new Student();
        student.name = name;
        System.out.println("Enter student ID: ");
        student.SID = in.nextLong();
        System.out.println("Enter program of study: ");
        student.program = in.next();
        System.out.println("Enter address:");
        student.address = in.next();
        Student.listStudents.add(student);
    }

    public static void createCourse(String courseName) {
        Course course = new Course();
        course.name = courseName;
        System.out.println("Enter course ID: ");
        course.CID = in.nextLong();
        System.out.println("Enter course credits: ");
        course.credits = in.nextInt();
        Course.listCourses.add(course);
    }

    public static void coursesEnrolled(long ID) {
        for (Student s : Student.listStudents) {
            if (s.SID == ID) {
                CoursesEnrolled newEnrol = new CoursesEnrolled();
                System.out.println("Which course is this student enrolled in (use course ID): ");
                long CourseEnrolID = in.nextLong();
                for (Course c : Course.listCourses) {
                    if (c.CID == CourseEnrolID) {
                        System.out.println("What grade did this student receive? : ");
                        String studentGrade = in.next();
                        newEnrol.CourseID = CourseEnrolID;
                        newEnrol.StudentID = ID;
                        newEnrol.grade = studentGrade;
                        CoursesEnrolled.listEnrol.add(newEnrol);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {

        int i = 1;

        ArrayList<String> grades = new ArrayList<>();

        boolean value = false;

        int choice;

        System.out.println(
                "Choose an option:\n1. Create student data\n2. Create course data\n3. Enter course enrollment information\n4. Display Student Table Information\n5. Display Course Table Information\n6. Query\n7. Exit");
        choice = in.nextInt();

        do {

            if (value == true) {
                System.out.println(
                        "\nChoose an option:\n1. Create student data\n2. Create course data\n3. Enter course enrollment information\n4. Display Student Table Information\n5. Display Course Table Information\n6. Query\n7. Exit");
                choice = in.nextInt();
            }

            switch (choice) {
                case 1:
                    System.out.println("Enter student name: ");
                    String name = in.next();
                    createStudent(name);
                    value = true;
                    break;
                case 2:
                    System.out.println("Enter course name: ");
                    String courseName = in.next();
                    createCourse(courseName);
                    value = true;
                    break;
                case 3:
                    System.out.println("Which student is this information for (use Student ID): ");
                    long studentID = in.nextLong();
                    coursesEnrolled(studentID);
                    value = true;
                    break;
                case 4:
                    Student.displayStudent();
                    value = true;
                    break;
                case 5:
                    Course.displayCourses();
                    value = true;
                    break;
                case 6:
                    boolean gradeTrigger = false;
                    System.out.println(
                            "This option allows you to search through the database in order to find students whose grade and classes matches their enrolment file.\n");
                    System.out.println("Enter course to search through: ");
                    String courseSearch = in.next();

                    while (gradeTrigger == false) {
                        System.out.println("Enter grade criteria #" + i + " (ENTER 'DONE' TO EXIT):");
                        i++;
                        String gradeSearch = in.next();
                        if (gradeSearch.equalsIgnoreCase("DONE")) {
                            gradeTrigger = true;
                            continue;
                        } else {
                            grades.add(gradeSearch);
                        }
                    }
                    for (Course c : Course.listCourses) {
                        System.out.println("ZERO");
                        if (c.name.equals(courseSearch)) {
                            System.out.println("FIRST");
                            for (CoursesEnrolled enrol : CoursesEnrolled.listEnrol) {
                                System.out.println("SECOND");
                                if (enrol.CourseID == c.CID) {
                                    System.out.println("THIRD");
                                    if (grades.contains(enrol.grade)) {
                                        System.out.println("FOURTH");
                                        for (Student s : Student.listStudents) {
                                            if (enrol.StudentID == s.SID) {
                                                System.out.println("Name: " + s.name + " and student ID: " + s.SID);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Program terminated.");
                    return;
            }
        } while (choice != 7);

    }

}
