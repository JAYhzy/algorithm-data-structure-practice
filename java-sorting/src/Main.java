import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        String[] strs = new String[4];
        strs[0] = ip.substring(0, 8);
        strs[1] = ip.substring(8, 16);
        strs[2] = ip.substring(16, 24);
        strs[3] = ip.substring(24, 32);
        for (int i = 0; i < strs.length; ++i) {
            long num = Integer.parseInt(strs[i]);
            System.out.println(num);
        }
        int k = (int) Math.pow(2, 3);
        System.out.println(k);
    }
    public static boolean prime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tmp = new int[n];
        int k = 0;
        for (int i = 2; i <= n; i++) {
            if (prime(i)) {
                tmp[k++] = i;
            }
        }
        int sum = 0;
        for (int i = k - 1; i > k - 11; --i) {
            System.out.print(tmp[i] + " ");
            sum += tmp[i];
        }
        System.out.println();
        System.out.println("sum = " + sum);
    }
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char ch = scanner.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) count++;
        }
        System.out.println(count);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            int[] arrays = new int[num];
            for (int j = 0; j < num; j++) {
                arrays[j] = sc.nextInt();
            }
            int count = 0;
            for (int j = 0; j < num; j++) {
                for (int k = j + 1; k < num; k++) {
                    if (arrays[j] > arrays[k]) count++;
                }
            }
            System.out.println(count);
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrays = new int[1000];
        int k = 0;
        while (n != 0) {
            arrays[k++] = n % 2;
            n /= 2;
        }
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (arrays[i] == 1) count++;
        }
        System.out.println(count);
    }
}
