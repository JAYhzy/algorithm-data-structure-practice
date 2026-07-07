/**
 * OJ做题
 */
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
    public static void main6(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        Stack<Character> tmp = new Stack<>();
        int flag = 0;
        for (int i = 0; i < str.length(); i++) {
            tmp.push(str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            if (tmp.pop() != str.charAt(i)) flag = 1;
        }
        if (flag == 1) System.out.println("false");
        else {
            System.out.println("true");
            System.out.println(str);
        }
    }
    public static void main3(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] ret = new String[n];
        for (int i = 0; i < n; i++) {
            ret[i] = in.next();
        }
        int a1 = ret[0].charAt(0) - '0', b1 = ret[0].charAt(2) - '0';
        for (int i = 1; i < n; i++) {
            int a2 = ret[i].charAt(0) - '0', b2 = ret[i].charAt(2) - '0';
            int a = a1 * b2 + a2 * b1, b = b1 * b2;
            a1 = a / gcd(a, b);
            b1 = b / gcd(a, b);
        }
        int integer = a1 / b1;
        int a11 = a1 - integer * b1;
        if (integer != 0) System.out.print(integer + " ");
        System.out.print(a11 + "/" + b1);
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    public static void main2(String[] args) {
        Random r = new Random(); // 实例化一个Random类
        int num = r.nextInt(101); // 用Random类中的nextInt(int n)方法生成一个【0，n)的随机数
        Scanner in = new Scanner(System.in);
        System.out.println("请输入最多能猜几次：");
        int max = in.nextInt();  // max代表用户最多能猜多少次
        System.out.println("随机数已经产生，猜猜看，你一共有" + max + "次猜的机会！");
        int flag = 0; // 如果在5次内猜对了就把flag置为1,作为标志
        for (int i = 1; i <= max; i++) {
            System.out.println("请输入你第" + i + "次猜的结果：");
            int n = in.nextInt(); // 输入自己本次所猜的数
            if (n < 0) {
                System.out.println("Game Over"); // 在到达
                return;
            }
            if (n > num) {
                System.out.println("Too big");  // 猜大了
            }
            else if (n < num) {
                System.out.println("Too small"); // 猜小了
            }
            else { // 此时说明猜对了
                flag = 1;
                if (i <= 1) System.out.println("Bingo!");
                else if (i <= 3) System.out.println("Lucky You!");
                else System.out.println("Good Guess！");
            }
        }
        if (flag == 0) System.out.println("Game Over");
    }
}
