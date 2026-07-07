import java.util.Comparator;
import java.util.PriorityQueue;
//class Child implements Comparable<Child>{
//    int age;
//    String name;
//
//    public Child(int age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//
//    @Override
//    public int compareTo(Child o) {
//        // return this.age - o.age;  实现小根堆
//        return o.age - this.age; // 实现大根堆
//    }
//
//    @Override
//    public String toString() {
//        return "Child{" +
//                "age=" + age +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
class Child {
    int age;
    String name;

    public Child(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
class AgeComparator implements Comparator<Child> {

    @Override
    public int compare(Child o1, Child o2) {
        return o1.age - o2.age; // 实现小根堆
        // return o2.ae - o1.age 实现大根堆
    }
}
public class TestPriorityQueue {
    public static void main(String[] args) {
        AgeComparator ageComparator = new AgeComparator();
        // 创建具有默认初始容量的 PriorityQueue ，并根据指定的比较器对其元素进行排序。
        PriorityQueue<Child> priorityQueue = new PriorityQueue<>(ageComparator);
        // 可以看到这里我的Child对象虽然没有实现Comparable接口，但因为我们对Child对象自定义了一个年龄比较器，所以插入元素不会报错
        priorityQueue.offer(new Child(12, "小亮"));
        priorityQueue.offer(new Child(11, "小红"));
        priorityQueue.offer(new Child(8, "小强"));
        System.out.println(priorityQueue);
    }
}
