package StudentManagement;

import java.util.ArrayList;

public class Course {
    private int courseId;
    private String courseName;
    private int duration; // in months
    private static ArrayList<Course> selectedCourses = new ArrayList<>();

    // Constructor
    public Course(int courseId, String courseName, int duration) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getter method for course name
    public String getCourseName() {
        return courseName;
    }

    // Method to display course details
    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
    }

    // Method to enroll in a course
    public static void enrollCourse(Course course) {
        selectedCourses.add(course);
        System.out.println(course.courseName + " has been added to your course list.");
    }

    // Method to display all enrolled courses
    public static void displayEnrolledCourses() {
        System.out.println("\nEnrolled Courses:");
        for (Course course : selectedCourses) {
            course.displayCourseInfo();
        }
    }
}
