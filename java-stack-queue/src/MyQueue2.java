/**
 * 用单链表实现的队列，为了入队和出队的时间复杂度都是O(1),我们还在单链表中设置了一个对尾结点的引用last，同时还有保证我们都是尾插入队，头删出队
 * 为什么呢？因为单链表只有后驱，没有前驱（即只知道后一个是谁，但不知道前一个是谁）如果我们要尾删出队——就必须找到该结点的前一个是谁，就需要遍历链表O(N)时间复杂度
 * 而如果头删，我们直接更改当前头结点的指向就好了，时间复杂度自然是O(1)
 * 那为啥要尾插入队呢？我们如果从尾巴插入，是不是只要将当前的的尾巴结点指向新插入的结点就行了，此时新插入的结点就变成了新的尾巴结点，时间复杂度也是O(1)
 */
public class MyQueue2 {
    class ListNode{
        public int val;
        public ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode last;
    // 入队，从尾入，从头出
    public void offer(int x) {
        ListNode node = new ListNode(x);
        if (empty()) { // 如果此时队列为空，新插入的结点就是头结点和尾巴结点
            head = node;
            last = node;
        }
        else {
            last.next = node;
        }
        last = node;
    }
    // 出队
    public int poll() {
        if (empty()) {
            throw new NullPointerException("当前队列为空，你的操作不合法！");
        }
        int tmp = head.val; // 先保留一下头节点的值，然后再更改指向
        head = head.next;
        return tmp;
    }
    // 只是获取将要出队的元素的值,不删除元素
    public int peek() {
        return head.val;
    }
    // 判断当前队列是否为空
    public boolean empty() {
        if (head == null) {
            return true;
        }
        return false;
    }
}
