package java_assignment;
import java.util.Scanner;

class student {

    Scanner scanner = new Scanner(System.in);
    private int student_id;
    private String name;
    private int age;
    private String depart;

    // student(int id,String name,int age,String depart){
    //     student_id = id;
    //     this.name = name;
    //     this.age = age;
    //     this.depart = depart;
    // }
    void addStudent() {
        System.out.print("Enter student id : ");
        student_id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student name : ");
        name = scanner.nextLine();
        System.out.print("Enter student age : ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter student department : ");
        depart = scanner.nextLine();

    }

    void viewRecord() {
        System.out.println("Student name : " + name);
        System.out.println("Student id   : " + student_id);
    }

    int searchId(int id) {
        if (student_id == id) {
            display();
            return 1;
        }
        return 0;
    }

    void display() {
        System.out.println("Student name        : " + name);
        System.out.println("Student id          : " + student_id);
        System.out.println("Student age         : " + age);
        System.out.println("Student department  : " + depart);
    }
}

public class studentManage {

    public static void main(String[] args) {
        int n, fid;
        char choice;
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        student[] stu = new student[100];
        do {
            System.out.println("1 : add new Student" + "\n2 : view existing record" + "\n3 : search by student id" + "\n4 : exit");
            System.out.print("Enter your choice : ");
            n = scanner.nextInt();
            switch (n) {
                case 1:
                    stu[count] = new student();
                    stu[count++].addStudent();
                    break;
                case 2:
                    for (int i = 0; i < count; i++) {
                        stu[i].viewRecord();
                    }
                    break;
                case 3:
                    System.out.print("Enter id for search : ");
                    fid = scanner.nextInt();
                    for (int i = 0; i < count; i++) {
                        int c = stu[i].searchId(fid);
                        if (c == 1) {
                            break;
                        }
                    }
                    break;
                case 4:
                    return;
            }

            System.out.print("Do you want another(y/n)? : ");
            choice = scanner.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}