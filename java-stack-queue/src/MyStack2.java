import java.util.LinkedList;
import java.util.Queue;

/**
 思路：入队时入的是非空的那个队列，如果两个队列都为空，就入qu1队列
 思路：出队时候，先把当前不为空的那个队列的size - 1个元素放到另一个为空的队列中，在弹出该队列中的最后一个元素
 */
// 力扣上的题目
// 用队列来实现栈，一直有测试样例过不去，就是当：
//["MyStack","push","push","push","top","pop","top","pop","top","empty","pop","empty"]
 //       [[],[1],[2],[3],[],[],[],[],[],[],[],[]]
/**
 * 有问题的代码
 */
public class MyStack2 {
    Queue<Integer> s1; // 这里不能newQueue,他是一个抽象的接口
    Queue<Integer> s2;
    public MyStack2() {
        s1 = new LinkedList<>();
        s2 = new LinkedList<>();
    }

    /**
     入栈
     */
    // public void push(int x) {
    //     if (empty()) {
    //         s1.offer(x);
    //     }
    //     if (s1.isEmpty()) {
    //         s2.offer(x);
    //     }
    //     else {
    //         s1.offer(x);
    //     }
    // }
    public void push(int x) {
        if(!s1.isEmpty()) {
            s1.offer(x);
        }else if(!s2.isEmpty()) {
            s2.offer(x);
        }else{
            s1.offer(x);
        }
    }
    /**
     出栈
     */
    public int pop() {
        if (empty()) return -1;
        if (s1.isEmpty()) {
            int size = s2.size() - 1;
            for (int i = 0; i < size; i++) {
                s1.offer(s2.poll());
            }
            return s2.poll();
        }
        else {
            int size = s1.size() - 1;
            for (int i = 0; i < size; i++) {
                s2.offer(s1.poll());
            }
            return s1.poll();
        }
    }

    public int top() {
        if (empty()) return -1;
        if (s1.isEmpty()) {
            int size = s2.size() - 1;
            for (int i = 0; i < size; i++) {
                s1.offer(s2.poll());
            }
            return s2.peek();
        }
        else {
            int size = s1.size() - 1;
            for (int i = 0; i < size; i++) {
                s2.offer(s1.poll());
            }
            return s1.peek();
        }
    }

    public boolean empty() {
        if (s1.isEmpty() && s2.isEmpty()) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */






/*
正确的代码
class MyStack2 {
    private Queue<Integer> qu1;
    private Queue<Integer> qu2;

    public MyStack2() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }

    */
/**
     入到不为空的队列当中
     如果都为空 放到qu1当中
     *//*

    public void push(int x) {
        if(!qu1.isEmpty()) {
            qu1.offer(x);
        }else if(!qu2.isEmpty()) {
            qu2.offer(x);
        }else{
            qu1.offer(x);
        }
    }

    public int pop() {
        //1、先要判断 当前 “栈” 是否为空
        if(empty()) {
            return -1;
        }

        if(!qu1.isEmpty()) {
            //出这个不为空的队列，出size-1
            int size = qu1.size();
            for(int i = 0;i < size-1;i++) {
                // int tmp = qu1.poll();
                // qu2.offer(tmp);
                qu2.offer(qu1.poll());
            }
            return qu1.poll();
        } else {
            //出这个不为空的队列，出size-1
            int size = qu2.size();
            for(int i = 0;i < size-1;i++) {
                qu1.offer(qu2.poll());
            }
            return qu2.poll();
        }
    }

    public int top() {
        //1、先要判断 当前 “栈” 是否为空
        if(empty()) {
            return -1;
        }

        if(!qu1.isEmpty()) {
            int size = qu1.size();
            int tmp = -1;
            for(int i = 0;i < size;i++) {
                tmp = qu1.poll();
                qu2.offer(tmp);
            }
            return tmp;
        } else {
            int size = qu2.size();
            int tmp = -1;
            for(int i = 0;i < size ;i++) {
                tmp = qu2.poll();
                qu1.offer(tmp);
            }
            return tmp;
        }
    }

    public boolean empty() {
        if(qu1.isEmpty() && qu2.isEmpty()) {
            return true;
        }
        return false;
    }
}*/
