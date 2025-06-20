package StudentManagement;

public class Student {
    private int id;
    private int rollNo;
    private String name;
    private int age;
    private String email;

    // Constructor
    public Student(int id, int rollNo, String name, int age, String email) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter methods
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    // Method to display student details
    public void displayStudentInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
}

