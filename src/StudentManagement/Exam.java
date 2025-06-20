package StudentManagement;

import java.util.ArrayList;

public class Exam {
    private int studentId;
    private ArrayList<Integer> marks = new ArrayList<>();
    private static final int SUBJECT_COUNT = 5; // Fixed number of subjects

    // Constructor
    public Exam(int studentId) {
        this.studentId = studentId;
    }

    // Method to add marks for each subject
    public void addMarks(int mark) {
        if (marks.size() < SUBJECT_COUNT) {
            marks.add(mark);
        } else {
            System.out.println("All subjects' marks have already been entered.");
        }
    }

    // Method to calculate total marks
    public int getTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate percentage
    public double getPercentage() {
        return (double) getTotalMarks() / SUBJECT_COUNT;
    }

    // Method to determine grade
    public String getGrade() {
        double percentage = getPercentage();

        if (percentage >= 90) return "Outstanding";
        else if (percentage >= 80) return "Excellent";
        else if (percentage >= 70) return "Very Good";
        else if (percentage >= 60) return "Good";
        else if (percentage >= 50) return "Pass";
        else return "Needs Improvement";
    }

    // Method to display marks, percentage, and grade
    public void displayResults() {
        System.out.println("\nExam Results:");
        for (int i = 0; i < marks.size(); i++) {
            System.out.println("Subject " + (i + 1) + ": " + marks.get(i) + " marks");
        }
        System.out.println("Total Marks: " + getTotalMarks());
        System.out.println("Percentage: " + getPercentage() + "%");
        System.out.println("Grade: " + getGrade());
    }
}
