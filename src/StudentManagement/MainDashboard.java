package StudentManagement;

import javax.swing.*;
import java.awt.*;

public class MainDashboard extends JFrame {
    private Student student;
    private Course selectedCourse;
    private Exam exam;

    // Constructor
    public MainDashboard() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Failed to apply theme.");
        }

        getContentPane().setBackground(new Color(230, 240, 250));

        JLabel headingLabel = new JLabel("Student Management System", JLabel.CENTER);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headingLabel.setForeground(new Color(139, 69, 19));
        add(headingLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10)); // Increased to 5 rows
        buttonPanel.setBackground(new Color(255, 218, 185));

        JButton registerButton = createStyledButton("Register Student");
        JButton courseButton = createStyledButton("Select Course");
        JButton examButton = createStyledButton("Enter Exam Results");
        JButton certificateButton = createStyledButton("Generate Certificate");
        JButton viewStudentButton = createStyledButton("View Student Info"); // New button

        registerButton.addActionListener(e -> registerStudent());
        courseButton.addActionListener(e -> selectCourse());
        examButton.addActionListener(e -> enterExamResults());
        certificateButton.addActionListener(e -> generateCertificate());
        viewStudentButton.addActionListener(e -> viewStudentInfo()); // Action handler

        buttonPanel.add(registerButton);
        buttonPanel.add(courseButton);
        buttonPanel.add(examButton);
        buttonPanel.add(certificateButton);
        buttonPanel.add(viewStudentButton); // Add new button

        add(buttonPanel, BorderLayout.CENTER);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(255, 160, 122));
        button.setForeground(Color.BLACK);
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(200, 40));
        button.setFocusPainted(false);
        return button;
    }

    private void registerStudent() {
        String name = JOptionPane.showInputDialog("Enter Student Name:");
        if (name == null || name.trim().isEmpty()) return;

        int rollNo;
        try {
            rollNo = Integer.parseInt(JOptionPane.showInputDialog("Enter Roll Number:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Roll Number!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int age;
        try {
            age = Integer.parseInt(JOptionPane.showInputDialog("Enter Age:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Age!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String email = JOptionPane.showInputDialog("Enter Email:");
        if (email == null || email.trim().isEmpty()) return;

        student = new Student(1, rollNo, name, age, email);
        JOptionPane.showMessageDialog(null, "Student Registered Successfully!");
    }

    private void selectCourse() {
        if (student == null) {
            JOptionPane.showMessageDialog(null, "Please register a student first!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String courseName = JOptionPane.showInputDialog("Enter Course Name:");
        int duration;
        try {
            duration = Integer.parseInt(JOptionPane.showInputDialog("Enter Duration in Months:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Duration!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        selectedCourse = new Course(101, courseName, duration);
        Course.enrollCourse(selectedCourse);
        JOptionPane.showMessageDialog(null, "Course Selected Successfully!");
    }

    private void enterExamResults() {
        if (student == null) {
            JOptionPane.showMessageDialog(null, "Please register a student first!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        exam = new Exam(student.getRollNo());

        for (int i = 1; i <= 5; i++) {
            int marks;
            try {
                marks = Integer.parseInt(JOptionPane.showInputDialog("Enter marks for Subject " + i + ":"));
                exam.addMarks(marks);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid Marks! Enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                i--;
            }
        }

        exam.displayResults();
    }

    private void generateCertificate() {
        if (student != null && selectedCourse != null && exam != null) {
            Certificate certificate = new Certificate(
                    student.getName(),
                    student.getRollNo(),
                    selectedCourse.getCourseName(),
                    exam.getPercentage(),
                    exam.getGrade()
            );
            certificate.generateCertificate();
        } else {
            JOptionPane.showMessageDialog(null, "Please complete registration, course selection, and exams first!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // 🔍 NEW: View Student Info
    private void viewStudentInfo() {
        if (student != null) {
            String info = "Student Details:\n"
                        + "Name: " + student.getName() + "\n"
                        + "Roll No: " + student.getRollNo() + "\n"
                        + "Age: " + student.getAge() + "\n"
                        + "Email: " + student.getEmail();
            JOptionPane.showMessageDialog(null, info, "Student Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No student registered yet!", "Information", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        MainDashboard dashboard = new MainDashboard();
        dashboard.setVisible(true);
    }
}
