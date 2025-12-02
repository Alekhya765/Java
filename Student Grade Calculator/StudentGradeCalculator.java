import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private String name;
    private double grade;

    // Constructor
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

// GradeCalculator class
class GradeCalculator {
    private ArrayList<Student> students;

    // Constructor
    public GradeCalculator() {
        students = new ArrayList<>();
    }

    // Method to add a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Method to calculate the average grade
    public double calculateAverageGrade() {
        double total = 0;
        for (Student student : students) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    // Method to display all students and their grades
    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Grade: " + student.getGrade());
        }
    }
}

// Main class
public class StudentGradeCalculator {
    public static void main(String[] args) {
        GradeCalculator gradeCalculator = new GradeCalculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Grade Calculator:");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    Student student = new Student(name, grade);
                    gradeCalculator.addStudent(student);
                    break;
                case 2:
                    gradeCalculator.displayStudents();
                    break;
                case 3:
                    double averageGrade = gradeCalculator.calculateAverageGrade();
                    System.out.println("Average Grade: " + averageGrade);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
