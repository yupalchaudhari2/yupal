package java_assignment;
import java.util.Scanner;

class Student {

    private int studentId;
    private String name;

    Student(int id, String name) {
        studentId = id;
        this.name = name;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class Grade {

    private int studentId;
    private int courseId;
    private char grade;

    Grade(int studentId, int courseId, char grade) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public char getGrade() {
        return grade;
    }
}

class GradingSystem {

    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;

    public GradingSystem(int maxStudents, int maxGrades) {
        students = new Student[maxStudents];
        grades = new Grade[maxGrades];
        courseCredits = new int[]{2, 2, 3, 4, 5};
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student student) {
        students[studentCount] = student;
        studentCount++;
    }

    public void addGrade(Grade grade) {
        grades[gradeCount] = grade;
        gradeCount++;
    }

    public int gtop(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }

    public double calculateGPA(int studentId) {
        int tp = 0;
        int tc = 0;
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId() == studentId) {
                int courseId = grades[i].getCourseId();
                int credits = courseCredits[courseId];
                tc += credits;
                tp += gtop(grades[i].getGrade()) * credits;
            }
        }

        return (double) tp / tc;
    }

    public void printGradeReport(int studentId) {
        System.out.println("Grade Report for Student ID: " + studentId);
        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId() == studentId) {
                System.out.println("Course ID: " + grades[i].getCourseId() + ", Grade: " + grades[i].getGrade());
            }
        }
        double gpa = calculateGPA(studentId);
        System.out.println("GPA: " + gpa);
    }
}

public class gradeSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradingSystem gradingSystem = new GradingSystem(100, 100);
        Student students[] = new Student[100];
        Grade grades[] = new Grade[100];
        String name;
        int id, n, i = 0, g = 0, courseId;
        char grade;

        while (true) {
            System.out.println("1 : Add Student");
            System.out.println("2 : Add Grade");
            System.out.println("3 : Print Grade Report");
            System.out.println("4 : Exit");
            System.out.print("Enter your choice : ");
            n = scanner.nextInt();

            switch (n) {
                case 1:
                    System.out.print("Enter student id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter student name: ");
                    name = scanner.next();
                    students[i] = new Student(id, name);
                    gradingSystem.addStudent(students[i]);
                    i++;
                    break;
                case 2:
                    System.out.print("Enter student id: ");
                    id = scanner.nextInt();
                    System.out.print("Enter course id: ");
                    courseId = scanner.nextInt();
                    System.out.print("Enter grade (A/B/C/D/F): ");
                    grade = scanner.next().charAt(0);
                    grades[g] = new Grade(id, courseId, grade);
                    gradingSystem.addGrade(grades[g]);
                    g++;
                    break;
                case 3:
                    System.out.print("Enter student id: ");
                    id = scanner.nextInt();
                    gradingSystem.printGradeReport(id);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}