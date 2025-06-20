package StudentManagement;

import javax.swing.*;

public class Certificate {
    private String studentName;
    private int rollNo;
    private String courseName;
    private double percentage;
    private String grade;

    // Constructor
    public Certificate(String studentName, int rollNo, String courseName, double percentage, String grade) {
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.courseName = courseName;
        this.percentage = percentage;
        this.grade = grade;
    }

    // Method to generate and display certificate
    public void generateCertificate() {
        String certificateText = "<html><body>"
                + "<h2>Certificate of Completion</h2>"
                + "<p>Congratulations, " + studentName + "!</p>"
                + "<p>Roll No: " + rollNo + "</p>"
                + "<p>You have successfully completed the course: " + courseName + "</p>"
                + "<p>Percentage: " + percentage + "%</p>"
                + "<p>Grade: " + grade + "</p>"
                + "<p>Issued on: " + java.time.LocalDate.now() + "</p>"
                + "</body></html>";

        JOptionPane.showMessageDialog(null, certificateText, "Certificate", JOptionPane.INFORMATION_MESSAGE);
    }
}
