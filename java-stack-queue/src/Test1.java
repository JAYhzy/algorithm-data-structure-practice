import java.util.*;

public class Test1 {
    public static void main(String[] args) {
//        MyLinkedList myLinkedList = new MyLinkedList();
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(2);
//        myLinkedList.addLast(4);
//        myLinkedList.addLast(2);
////        myLinkedList.printList();
////        System.out.println(myLinkedList.contains(5));
//        myLinkedList.removeAllKey(2);
//        myLinkedList.printList();
//        //myLinkedList.remove(5);
//        List<Integer> list = new ArrayList<>();
//        list.add(1); // 增添元素
//        list.add(2);
//        list.add(3);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i)); // get(i)获取i下标的元素值
//        }
//        System.out.println(list.remove(0));  // remove(i)删除i下标的元素值，返回值是原来i下标的值
//        System.out.println(list.set(0, 77));    // set(i,value)给i下标的元素重新赋值为value,返回值是原来i下标的值
//        System.out.println(list.contains(2)); // 判断该集合中是否有元素2存在
        Queue<Integer> queue = new LinkedList<>(); // 普通队列
        Deque<Integer> deque = new LinkedList<>(); // 双向队列
        deque.offer(1); // 往队列里添加元素，添加成功返回true,失败返回false
        deque.add(575);   // 往队列里添加元素，添加成功返回true,失败抛出异常，所以对于有容量限制的deque，我们一般用offer,（queue同理）
        deque.offer(2);
        deque.offer(3);
        deque.offerFirst(77);
        // 往双向队列的末尾添加元素，和queue的offer作用是一样的，queue的offer添加元素默认从队列的末尾添加元素(单向队列要满足先进先出或者说后进后出）
        deque.offerLast(88);

        System.out.println("==========================");
//        for (int i = 0; i < deque.size(); i++) {  // 这样写for循环是错的，因为随着队列元素不断出队，deque.size()一直在发生着变化
//            System.out.println(deque.poll());
//        }

        System.out.println(deque.poll());
        //System.out.println(deque.size());
    }
}
