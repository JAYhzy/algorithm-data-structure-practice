/**
 * OJ做题
 *//*


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main1 {
    public static void main22(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; ++i) {
            String studentID = in.next();
            String name = in.next();
            int grade = in.nextInt();
            Student student = new Student(studentID, name, grade);
            students[i] = student;
        }
        scoreComparator scoreComparator1 = new scoreComparator();
        Arrays.sort(students, scoreComparator1); // sort只能对给定长度的数组排序
        System.out.println(students[students.length - 1]);
    }
    public static void main4(String[] args) {
        Scanner in = new Scanner(System.in);
        String str1 = in.next();
        String str2 = in.next();
        int a1 = str1.charAt(0) - '0', b1 = str1.charAt(2) - '0';
        int a2 = str2.charAt(0) - '0', b2 = str2.charAt(2) - '0';
        int a = a1 * b2 + a2 * b1, b = b1 * b2;
        int k = gcd(a, b);
        if (b / k == 1) {
            System.out.println(a / k);
        }

        else {
            System.out.println(a / k + "/" + b / k);
        }

    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    public static void main1(String[] args) {
*/
/*        Scanner in = new Scanner(System.in);
        Student[] students0 = new Student[50];
        Student[] students1 = new Student[50];
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            int sex = in.nextInt();
            String name = in.nextLine();
            Student student = new Student(sex, name);
            if (sex == 0) {
                students0[i] = student;
            }
            else {
                students1[i] = student;
            }
        }*//*

        Scanner in = new Scanner(System.in);
        Student[] students = new Student[50];
        int n = in.nextInt();
        for (int i = 0; i < n; ++i) {
            int sex = in.nextInt();
            String name = in.nextLine();
            Student student = new Student(sex, name);
            students[i] = student;
        }
        for (int i = 0; i < n / 2; ++i) {
            for (int j = n - 1; j > i; --j) {
                if (students[i].sex != students[j].sex && students[j].flag != 1) {
                    students[j].flag = 1;
                    System.out.printf("%s %s\n", students[i].name, students[j].name);
                    break;
                }
            }
        }
    }
    public static void main23(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        double sum = 0;
        Student[] students = new Student[n];
        for (int i = 0; i < n; ++i) {
            String studentID = in.next();
            String name = in.next();
            int grade = in.nextInt();
            sum += grade;
            Student student = new Student(studentID, name, grade);
            students[i] = student;
        }
        // scoreComparator scoreComparator1 = new scoreComparator();
        // Arrays.sort(students, scoreComparator1); // sort只能对给定长度的数组排序
        // System.out.println(students[students.length - 1]);
        double aver = sum / n;
        System.out.printf("%.2f\n", aver);
        for (int i = 0; i < n; i++) {
            if (students[i].grade < aver) {
                System.out.println(students[i].name + " " + students[i].studnetID);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Staff[] staffs = new Staff[n];
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int basePay = in.nextInt();
            int floatPay = in.nextInt();
            int paid = in.nextInt();
            Staff staff = new Staff(name, basePay, floatPay, paid);
            staffs[i] = staff;
        }
        for (int i = 0; i < n; i++) {
            double truePay = staffs[i].basePay + staffs[i].floatPay - staffs[i].paid;
            System.out.printf("%s %.2f\n", staffs[i].name, truePay);

        }
    }
}
class Staff {
    String name;
    int basePay; // 基本工资
    int floatPay; // 浮动工资
    int paid; // 支出

    public Staff(String name, int basePay, int floatPay, int paid) {
        this.name = name;
        this.basePay = basePay;
        this.floatPay = floatPay;
        this.paid = paid;
    }
}
class Student {
    int sex;
    int flag;
    String name;

    public Student(int sex, String name) {
        this.sex = sex;
        this.name = name;
    }
}
class Student1 {
    String studnetID;
    String name;
    int grade;


    public Student1(String studnetID, String name, int grade) {
        this.studnetID = studnetID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.name + " " + this.studnetID + " " +
                grade;
    }
}
class scoreComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.grade - o2.grade;
    }
}
*/
