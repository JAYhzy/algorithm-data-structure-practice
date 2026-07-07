/**
 * 双向链表
 */
public class MyLinkedList {
    class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

    // 双向链表的打印
    public void printList() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {

        if (index < 0 || index > size()) {
            System.out.println("index下标不合法！！！");
        }

        if (index == 0) {
            addFirst(data);
        }
        ListNode node = new ListNode(data);
        ListNode cur = searchIndex(index); // cur拿到了index下标的结点
        if (size() == index) {
            addLast(data);
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }

    // 跳转到指定下标所对应的结点
    public ListNode searchIndex(int index) {
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //查找是否包含关键字key是否在双向链表当中
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) return true;
            cur = cur.next;
        }
        return false; // 如果程序能走到这里，说明当前链表中没有包含关键字key
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        if (head == last && head.val == key) {
            head = head.next;
            return;
        }
        if (head.val == key) {
            head = head.next;
        }
        if (last.val == key) {
            last.prev.next = last.next;
            last = last.prev;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                return;
            } else {
                cur = cur.next;
            }
        }
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        if (head == last && head.val == key) {
            head = head.next;
            return;
        }
        while (head.val == key) {
            head = head.next;
            if (head == null) return;
        }

        if (last.val == key) {
            last.prev.next = last.next;
            last = last.prev;
        }

        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                cur.prev.next = cur.next;
                cur.next.prev = cur.prev;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            ++count;
        }
        return count;
    }
    public void clear() {
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.prev = null;
            cur.next = null;
            cur = tmp;
        }
        head = null;
    }
}