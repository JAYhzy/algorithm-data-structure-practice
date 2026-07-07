import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(); // LinkedList对Queue中的抽象方法进行了重写
        queue.offer(1);
        queue.offer(2); // 入队，入队顺序1、2、3，出队顺序还是1、2、3，先进先出
        queue.offer(3);

        System.out.println(queue.peek()); // 打印当前的队首元素，但不出队
        System.out.println("peek()操作后的队首元素：" + queue.peek()); // 你会发现当前的队首元素还是1

        queue.poll(); // 出队
        System.out.println("poll操作后的队首元素：" + queue.poll()); // poll出队后，队首元素发生了变化
    }
}
