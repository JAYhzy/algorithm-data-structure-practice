import java.util.*;
public class Main {
    public static void main(String[] args) {
        Set<Character> set = new TreeSet<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine(); // 应该输入的文字
            str = str.toUpperCase(); // 转换为大写
            String tmp = sc.nextLine(); // 实际输入的文字
            tmp = tmp.toLowerCase();
            for (int i = 0; i < tmp.length(); ++i) {
                set.add(tmp.charAt(i)); // 把实际输入的文字放到set储存下来
            }
            List<String> ret = new ArrayList<>();
            ret.add()
            Set<Character> setBroken = new TreeSet<>();
            for (int i = 0; i < str.length(); ++i) {
                // 当键盘是坏掉的 && 该这个坏掉的键盘还是第一次出现时
                if (!set.contains(str.charAt(i)) && !setBroken.contains(str.charAt(i))){
                    // 把坏掉的键盘储存起来
                    setBroken.add(str.charAt(i));
                    System.out.print(str.charAt(i));
                }
            }
        }
    }
}