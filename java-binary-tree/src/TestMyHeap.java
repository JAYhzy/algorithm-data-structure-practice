/**
 * PriorityQueue，方法测试
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
class Student /*implements Comparable<Student> */{
    private int age;


    public Student(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

//    @Override
//    public int compareTo(Student o) {
//        // return this.age - o.age; // 生成的堆是小根堆
//        return o.age - this.age;  // 生成大根堆
//    }
}
class ageComparator implements Comparator<Student>{
    @Override
    public int compare(Student o1, Student o2) {
        // return o1.getAge() - o2.getAge();  // 小根堆
        return o2.getAge() - o1.getAge();  // 大根堆，至于为什么这样一变化就成了
    }

}
public class TestMyHeap {
    public static void main(String[] args) {
//        Student[] students = new Student[12];
//        students[0] = new Student(12);
        ageComparator ageComparator = new ageComparator();
        // PriorityQueue中放置的元素必须要能够比较大小，因为PriorityQueue源码中用到了Comparable中的compareTo或Comparator中的compare方法
        // 如果在Priority对象的实例化过程中不传自定义的比较器的话，PriorityQueue采用他默认的比较方法Comparable接口中的compareTo方法，
        // 所以才要求priorityQueue中的放置的是能够比较大小的元素（实现了Compareble接口的元素，或者实现了Comparator接口的元素）
        PriorityQueue<Student> priorityQueue1 = new PriorityQueue<>(ageComparator);
        priorityQueue1.offer(new Student(12));
        priorityQueue1.offer(new Student(3));
        priorityQueue1.offer(new Student(45));
        System.out.println(priorityQueue1);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) { // Integer类型——匿名内部类实现Comparator接口中，重写compareTo方法
                return o2 - o1;
            }
        });// 默认是小根堆
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(3);
        priorityQueue.offer(4);
        System.out.println(priorityQueue);
    }
    public static void main1(String[] args) {
        MyHeap myHeap = new MyHeap();
        System.out.println(myHeap.isFull());
        System.out.println(myHeap.isEmpty());
        int[] arrays = {1, 2, 3, 4, 5};
        myHeap.createHeap(arrays);
        myHeap.offerHeap(0);
        myHeap.pollHeap();

        System.out.println(myHeap.usedSize);
        System.out.println(myHeap.isEmpty());
        System.out.println(myHeap.peekHeap());
        System.out.println();
    }
}
