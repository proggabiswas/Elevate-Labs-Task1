package TASK2;

import java.util.ArrayList;
import java.util.Scanner;

// Student class
class Student {
    private int id;
    private String name;
    private int age;
    private String course;
    private int marks;

    public Student(int id, String name, int age, String course, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public int getId() { 
        return id; 
    }
    public void setName(String name) { 
        this.name = name; 
    }
    public void setAge(int age) { 
        this.age = age; 
    }
    public void setCourse(String course) { 
        this.course = course; 
    }
    public void setMarks(int marks) { 
        this.marks = marks; 
    }
    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course + ", Marks: " + marks);
    }
}

// Main Management System
public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== Student Record Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        System.out.print("Enter Marks: ");
        int marks = scanner.nextInt();

        students.add(new Student(id, name, age, course, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                s.displayInfo();
            }
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = scanner.nextInt();
        for (Student s : students) {
            if (s.getId() == id) {
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Student s : students) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                s.setName(scanner.nextLine());
                System.out.print("Enter new age: ");
                s.setAge(scanner.nextInt());
                scanner.nextLine();
                System.out.print("Enter new course: ");
                s.setCourse(scanner.nextLine());

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        for (Student s : students) {
            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student deleted successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
